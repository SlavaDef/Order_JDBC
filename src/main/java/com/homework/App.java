package com.homework;

import com.homework.dao.clientDao.ClientDao;
import com.homework.dao.clientDao.ClientDaoImp;
import com.homework.dao.goodsDao.GoodsDao;
import com.homework.dao.goodsDao.GoodsDaoImp;
import com.homework.dao.ordersDao.OrdersDao;
import com.homework.dao.ordersDao.OrdersDaoImp;
import com.homework.entyti.Clients;
import com.homework.entyti.Goods;
import com.homework.entyti.Orders;
import com.homework.storage.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static com.homework.utils.Utils.*;

public class App {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConnectionFactory.getConnection()) {

            ClientDao dao = new ClientDaoImp(conn);
            dao.createTable();
            dao.createRandomClients();
            dao.addClient(getRandomName(), "099-00-00-00", "Varshava,Nogi street 22", "Adm_1@gmail.com.ua");

            List<Clients> list = dao.getAll();
            for (Clients cl : list) {
                System.out.println(cl);
            }
            GoodsDao dao1 = new GoodsDaoImp(conn);
            dao1.createTable();
            dao1.createRandomGoods();
            dao1.addGood("Boll","Nike","No",
                    0.5, 55.99,true);

            List<Goods> list1 = dao1.getAll();
            for (Goods go : list1) {
                System.out.println(go);
            }

            OrdersDao dao2 = new OrdersDaoImp(conn);
            dao2.createTable();
            dao2.createRandomOrders();

            dao2.addOrder(getRandomString(40),new Date(getRandomTimestamp().getTime()));

            List<Orders> list2 = dao2.getAll();
            for (Orders ord : list2) {
                System.out.println(ord);
            }

        }
    }

}