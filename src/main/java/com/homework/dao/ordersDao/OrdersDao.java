package com.homework.dao.ordersDao;

import com.homework.entyti.Orders;

import java.util.List;

public interface OrdersDao {

    void createTable();

    Orders addClient();

    List<Orders> getAll();

}
