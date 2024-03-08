package com.homework.entyti;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
public class Orders {

    private Long order_id;

    private String order_info;

    private Date order_date;

    public Orders(String order_info, Date order_date) {
        this.order_info = order_info;
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Orders" +
                "order_id=" + order_id +
                ", order_info='" + order_info + '\'' +
                ", order_date=" + order_date;
    }
}
