package com.homework;

import com.homework.dao.clientDao.ClientDao;
import com.homework.dao.clientDao.ClientDaoImp;
import com.homework.dao.goodsDao.GoodsDao;
import com.homework.dao.goodsDao.GoodsDaoImp;
import com.homework.dao.ordersDao.OrdersDao;
import com.homework.dao.ordersDao.OrdersDaoImp;
import com.homework.entyti.Clients;
import com.homework.storage.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


import static com.homework.utils.Utils.*;

public class App {


    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConnectionFactory.getConnection()) {

            ClientDao dao = new ClientDaoImp(conn);
            GoodsDao dao1 = new GoodsDaoImp(conn);
            OrdersDao dao2 = new OrdersDaoImp(conn);
            dao.createTable();
            dao1.createTable();
            dao2.createTable();

            dao.createRandomClients();
            dao.addClient(new Clients(getRandomName(), "099-00-00-00", "Varshava,Nogi street 22", "Adm_1@gmail.com.ua"));

            printinEntity(dao.getAll());

            dao1.createRandomGoods();
            dao1.addGood("Boll", "Nike", "No",
                    0.5, 55.99, true);

            printinEntity(dao1.getAll());

            dao2.createRandomOrders();

            dao2.addOrder(getRandomString(40), new Date(getRandomTimestamp().getTime()));
            printinEntity(dao2.getAll());

        }
    }

}