package com.han.solr.utils;

import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class SolrUtils {

    private static Logger logger = LoggerFactory.getLogger(SolrUtils.class);

    /**
     * solr开发从查询结果集中获取对象数据
     * 单个转换
     * @param document  SolrDocument
     * @param clzz      对象class
     * @param <T>       对象类型
     * @return          对象
     */
    public static <T> T solrDocument2Entity(SolrDocument document, Class<T> clzz) {
        if (null != document) {
            try {
                // 创建实例对象
                Object obj = clzz.newInstance();
                // 实例对象-方法对象
                Method method;
                // 实例对象-属性类型
                Class<?> fieldType;
                // 遍历 域名称
                for (String fieldName : document.getFieldNames()) {
                    // 注意getDeclaredFields不能获取到父类的域对象
                    Field[] fields = clzz.getDeclaredFields();                        //获取类中所有属性
                    for (Field field : fields) {
                        //如果实体属性名和查询返回集中的字段名一致,填充对应的set方法
                        if(field.getName().equals(fieldName)){
                            //获取到的属性名
                            field = clzz.getDeclaredField(fieldName);
                            //属性类型
                            fieldType = field.getType();
                            //构造set方法名
                            String dynamicSetMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                            // 获取方法
                            method = clzz.getMethod(dynamicSetMethodName, fieldType);
                            // 获取SolrDocument中的值
                            Object fieldValue = document.getFieldValue(fieldName);
                            // 判断fieldValue类型
                            if (fieldType.equals(Integer.TYPE)) {
                                fieldType = Integer.class;
                            } else if (fieldType.equals(Float.TYPE)) {
                                fieldType = Float.class;
                            } else if (fieldType.equals(Double.TYPE)) {
                                fieldType = Double.class;
                            } else if (fieldType.equals(Boolean.TYPE)) {
                                fieldType = Boolean.class;
                            } else if (fieldType.equals(Short.TYPE)) {
                                fieldType = Short.class;
                            } else if (fieldType.equals(Long.TYPE)) {
                                fieldType = Long.class;
                            }
                            // 执行set方法赋值
                            method.invoke(obj, fieldType.cast(fieldValue));
                        }
                    }

                }
                // obj -> T
                return clzz.cast(obj);
            } catch (ClassCastException e) {
                logger.error("请检查schema.xml中的各个field的数据类型与PO类的是否一致.",e);
                e.printStackTrace();
            } catch (SecurityException | InvocationTargetException | InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                logger.error("请检查schema中的field是否不存在于PO类中.", e);
                e.printStackTrace();
            }
        }
        logger.warn("solrDocument is null");
        return null;
    }

    /**
     * solr开发从查询结果集中获取对象数据
     * 批量转换
     * @param documents  SolrDocumentList
     * @param clzz       对象class
     * @param <T>        对象类型
     * @return           集合对象
     */
    public static <T> List<T> solrDocument2List(SolrDocumentList documents, Class<T> clzz) {
        if (null != documents && documents.size() > 0) {
            List<T> lists = new ArrayList<T>();
            for (SolrDocument sd : documents) {
                Object obj = solrDocument2Entity(sd, clzz);
                if (null!=obj) {
                    lists.add(clzz.cast(obj));
                }
            }
            return lists;
        }
        logger.warn("即将要转换的solrDocumentList为null或者size为0.");
        return null;
    }
}
