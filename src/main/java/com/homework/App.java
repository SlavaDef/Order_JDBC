package com.homework;

import com.homework.dao.clientDao.ClientDao;
import com.homework.dao.clientDao.ClientDaoImp;
import com.homework.entyti.Clients;
import com.homework.storage.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = ConnectionFactory.getConnection()) {

            ClientDao dao = new ClientDaoImp(conn);
            dao.createTable();
            dao.createRandomClients();
             dao.addClient("Admin", "099-00-00-00", "Varshava,Nogi street 22", "Adm_1@gmail.com.ua");

            List<Clients> list = dao.getAll();
            for (Clients cl : list) {
                System.out.println(cl);


            }

        }
    }

}