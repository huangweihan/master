package com.han.solr.example.pojo;

public class Item {
    private String id;
    private String area;
    private String toptype;
    private String city;
    private String subtype;
    private String winner;
    private String bidopentime;
    private String publishtime;
    private String title;
    private String buyer;
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
        return "Item{" +
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
