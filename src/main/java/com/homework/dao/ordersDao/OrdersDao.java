package com.homework.dao.ordersDao;

import com.homework.entyti.Orders;

import java.sql.Date;
import java.util.List;

public interface OrdersDao {

    void createTable();

    Orders addOrder(String order_info, Date order_date);

    List<Orders> getAll();

    void createRandomOrders();

}
