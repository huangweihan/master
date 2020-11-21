package com.han.solr.example.pojo;

import org.apache.solr.client.solrj.beans.Field;

// solr开发从查询结果集中获取对象数据---注解
@SuppressWarnings("all")
public class Item2 {
    @Field("id")
    private String id;
    @Field("area")
    private String area;
    @Field("toptype")
    private String toptype;
    @Field("city")
    private String city;
    @Field("subtype")
    private String subtype;
    @Field("winner")
    private String winner;
    @Field("bidopentime")
    private String bidopentime;
    @Field("publishtime")
    private String publishtime;
    @Field("title")
    private String title;
    @Field("buyer")
    private String buyer;
    @Field("budget")
    private String budget;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getToptype() {
        return toptype;
    }

    public void setToptype(String toptype) {
        this.toptype = toptype;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getBidopentime() {
        return bidopentime;
    }

    public void setBidopentime(String bidopentime) {
        this.bidopentime = bidopentime;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Item2{" +
                "id='" + id + '\'' +
                ", area='" + area + '\'' +
                ", toptype='" + toptype + '\'' +
                ", city='" + city + '\'' +
                ", subtype='" + subtype + '\'' +
                ", winner='" + winner + '\'' +
                ", bidopentime='" + bidopentime + '\'' +
                ", publishtime='" + publishtime + '\'' +
                ", title='" + title + '\'' +
                ", buyer='" + buyer + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }
}
