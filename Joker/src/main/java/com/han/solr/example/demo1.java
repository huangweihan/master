package com.han.solr.example;

import com.han.solr.example.pojo.Item;
import com.han.solr.example.pojo.Item2;
import com.han.solr.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 附录：删除全部数据(solr客户端->索引库->documents type 选择 XML->输入(
 *  <delete><query>*:*</query></delete>
 *  <commit/>
 * ))
 */
public class demo1 {

    private HttpSolrClient solrClient = null;

    @Before
    public void init(){
        // 创建连接
        String url = "http://localhost:8080/solr/dbyl_core";
        solrClient = new HttpSolrClient(url);
    }

    @After
    public void destroy(){
        try {
            // 提交修改
            solrClient.commit();
            // 连接关闭
            solrClient.close();
        } catch (IOException | SolrServerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addDocument(){
        // 创建document对象
        SolrInputDocument document = new SolrInputDocument();
        // 添加field
        document.setField("id", 1);
        document.setField("area", "天涯");
        // 提交
        try {
            solrClient.add(document);
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteDocument(){
        try {
            // 根据id修改
            solrClient.deleteById("1");
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void simpleQuery(){
        // 条件构建器
        SolrQuery query = new SolrQuery();
        // 设置查询条件
        query.setQuery("winner:公司");
        // 每页记录数
        query.setRows(10);
        // 起始页
        query.setStart(0);
        // 设置过滤条件
        //query.setFilterQueries("id:200");
        // 设置结果显示域
        //query.setFields("id", "area");
        // 设置默认搜索域
        //query.set("id");
        // 排序条件
        query.setSort("id", SolrQuery.ORDER.desc);
        // 高亮显示
        // 开启高亮显示
        query.setHighlight(true);
        //标记，高亮关键字前缀
        query.setHighlightSimplePre("<font color='red'>");
        //标记，高亮关键字后缀
        query.setHighlightSimplePost("</font>");
        // 高亮显示字段
        query.addHighlightField("winner");
        try {
            // 执行查询
            QueryResponse response = solrClient.query(query);
            // 获取查询结果
            SolrDocumentList solrDocuments = response.getResults();
            // 获取总记录数
            long numFound = solrDocuments.getNumFound();
            System.out.println("numFound = " + numFound);
            // 结果遍历
            // 反射
            List<Item> itemList = SolrUtils.solrDocument2List(solrDocuments, Item.class);
            // 注解
            List<Item2> itemList2 = response.getBeans(Item2.class);

            //高亮集合
            /**
             * Map<String, Map<String, List<String>>>
             *      第一个Map的key表示id,value表示id对应的document值
             *      第二个Map的key表示字段名称,value是该文档高亮的字段
             */
            Map<String, Map<String, List<String>>> highlightingMap = response.getHighlighting();
            System.out.println("highlightingMap = " + highlightingMap);
            List<Item> items = new ArrayList<>();
            if (itemList != null){
                for (Item item : itemList) {
                    item.setArea(highlightingMap.get(item.getId()).get("winner").get(0));
                    items.add(item);
                }
            }
            // 最终结果打印
            for (Item item : items) {
                System.out.println(item);
            }
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }
}
