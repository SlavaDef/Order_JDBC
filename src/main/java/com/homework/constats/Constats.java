package com.homework.constats;

public class Constats {

    public static final String CREATE_CLIENTS_SQL ="CREATE TABLE clients (client_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "fullName VARCHAR(50) NOT NULL, phone VARCHAR(50) NOT NULL, " +
            "address VARCHAR(100) NOT NULL , " +
            "email VARCHAR(100) NOT NULL )";


    public static final String INIT_CLIENT_SQL = "INSERT INTO clients " +
            "(fullName, phone, address, email)" +
            " VALUES(?, ?, ?, ?)";

    public static final String CREATE_GOODS_SQL = "CREATE TABLE goods (good_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "good_name VARCHAR(50) NOT NULL, good_brand VARCHAR(50) NOT NULL, " +
            "characteristics VARCHAR(200) NOT NULL, " +
            "good_weight DOUBLE NOT NULL, " +
            "good_price DOUBLE NOT NULL, " +
            "availability BOOLEAN NOT NULL )";

    public static final String INIT_GOODS_SQL = "INSERT INTO goods " +
            "(good_name, good_brand, characteristics, good_weight, good_price, availability)" +
            " VALUES(?, ?, ?, ?, ?, ?)";

    public static final String CREATE_ORDERS_SQL = "CREATE TABLE orders (order_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "order_info VARCHAR(255) NOT NULL, " +
            "order_date DATE )";

    public static final String INIT_ORDERS_SQL = "INSERT INTO orders " +
            "(order_info, order_date)" +
            " VALUES(?, ?)";
}
