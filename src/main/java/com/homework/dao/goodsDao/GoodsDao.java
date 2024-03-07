package com.homework.dao.goodsDao;

import com.homework.entyti.Goods;

import java.util.List;

public interface GoodsDao {

    void createTable();

    Goods addClient();

    List<Goods> getAll();
}
