package com.homework.dao.clientDao;

import com.homework.entyti.Clients;

import java.util.List;

public interface ClientDao {

    void createTable();

    Clients addClient(Clients clients);

    List<Clients> getAll();

    void createRandomClients();

}
