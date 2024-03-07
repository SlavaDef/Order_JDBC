package com.homework.dao.goodsDao;

import com.homework.entyti.Clients;
import com.homework.entyti.Goods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.homework.constats.Constats.*;

public class GoodsDaoImp implements GoodsDao {


    private final Connection conn;

    private final String table;


    public GoodsDaoImp(Connection conn) {
        this.conn = conn;
        table = "goods";
    }

    @Override
    public void createTable() {
        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS " + table);
            st.execute(CREATE_GOODS_SQL);
            st.execute("ALTER TABLE " + table + " AUTO_INCREMENT=500");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Goods addGood(String good_name, String good_brand, String characteristics, int good_weight,
                         Long good_price, boolean availability) {
        try {
            try (PreparedStatement st = conn.prepareStatement(INIT_GOODS_SQL)) {
                st.setString(1, good_name);
                st.setString(2, good_brand);
                st.setString(3, characteristics);
                st.setInt(4, good_weight);
                st.setLong(5, good_price);
                st.setBoolean(6, availability);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("A new good has been aded");
        return new Goods(good_name, good_brand, characteristics, good_weight, good_price, availability);
    }

    @Override
    public List<Goods> getAll() {
        List<Goods> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    while (rs.next()) {
                        Goods goods = new Goods();

                        goods.setGood_id(rs.getLong(1));
                        goods.setGood_name(rs.getString(2));
                        goods.setGood_brand(rs.getString(3));
                        goods.setCharacteristics(rs.getString(4));
                        goods.setGood_weight(rs.getInt(5));
                        goods.setGood_price(rs.getLong(6));
                        goods.setAvailability(rs.getBoolean(7));

                        res.add(goods);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void createRandomGoods() {
        addGood("Toster", "Lg", "Some characteristics", 8,
                215L, true);
        addGood("Vacuum cleaner", "SAMSUNG", "Some characteristics", 12,
                855L, true);
        addGood("Table", "Brain", "Some characteristics", 6,
                88L, false);
    }
}
