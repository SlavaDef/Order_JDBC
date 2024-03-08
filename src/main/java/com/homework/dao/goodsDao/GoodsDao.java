package com.homework.dao.goodsDao;

import com.homework.entyti.Goods;

import java.util.List;

public interface GoodsDao {

    void createTable();

    Goods addGood(String good_name, String good_brand, String characteristics, double good_weight,
                    double good_price, boolean availability);

    List<Goods> getAll();

    void createRandomGoods();
}
