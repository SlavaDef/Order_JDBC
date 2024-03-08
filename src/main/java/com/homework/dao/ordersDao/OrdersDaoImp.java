package com.homework.dao.ordersDao;


import com.homework.entyti.Goods;
import com.homework.entyti.Orders;

import java.sql.*;
//import java.util.*;
//import java.util.Date;

import java.util.ArrayList;
import java.util.List;


import static com.homework.constats.Constats.*;
import static com.homework.utils.Utils.getRandomTimestamp;

public class OrdersDaoImp implements OrdersDao {

    private final Connection conn;
    private final String table;

    public OrdersDaoImp(Connection conn) {
        this.conn = conn;
        table = "orders";
    }

    @Override
    public void createTable() {

        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS " + table);
            st.execute(CREATE_ORDERS_SQL);
            st.execute("ALTER TABLE " + table + " AUTO_INCREMENT=980");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public Orders addOrder(String order_info, Date order_date) {
        try {
            try (PreparedStatement st = conn.prepareStatement(INIT_ORDERS_SQL)) {
                st.setString(1, order_info);
                st.setDate(2, order_date);

                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Date of order is " + order_date);
        return new Orders(order_info, order_date);
    }

    @Override
    public List<Orders> getAll() {
        List<Orders> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    while (rs.next()) {
                        Orders orders = new Orders();

                        orders.setOrder_id(rs.getLong(1));
                        orders.setOrder_info(rs.getString(2));
                        orders.setOrder_date(rs.getDate(3));

                        res.add(orders);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void createRandomOrders() {
        addOrder("Some info",  new Date(getRandomTimestamp().getTime()));
        addOrder("Some info", new Date(getRandomTimestamp().getTime()));
        addOrder("Some info", new Date(getRandomTimestamp().getTime()));

    }


}
