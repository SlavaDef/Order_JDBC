package com.homework.dao.clientDao;

import com.homework.entyti.Clients;

import java.util.List;

public interface ClientDao {

    void createTable();

    Clients addClient(String fullName, String phone, String address,String email);

    List<Clients> getAll();

    void createRandomClients();

}
