package com.homework.entyti;

import java.util.Date;

public class Orders {

    private Long order_id;

    private String info;

    private Date date;

    public Orders() {
    }

    public Orders(Long order_id, String info, Date date) {
        this.order_id = order_id;
        this.info = info;
        this.date = date;
    }

    public Long getId() {
        return order_id;
    }

    public void setId(Long order_id) {
        this.order_id = order_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + order_id +
                ", info='" + info + '\'' +
                ", date=" + date +
                '}';
    }
}
