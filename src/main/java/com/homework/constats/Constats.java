package com.homework.constats;

public class Constats {

    public static final String CREATE_CLIENTS_SQL ="CREATE TABLE clients (client_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "fullName VARCHAR(50) NOT NULL, phone VARCHAR(50) NOT NULL, " +
            "address VARCHAR(100) NOT NULL , " +
            "email VARCHAR(100) NOT NULL )";


    public static final String INIT_CLIENT_SQL = "INSERT INTO clients " +
            "(fullName, phone, address, email)" +
            " VALUES(?, ?, ?, ?)";
}
