package com.homework.dao.clientDao;

import com.homework.entyti.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.homework.constats.Constats.CREATE_CLIENTS_SQL;
import static com.homework.constats.Constats.INIT_CLIENT_SQL;

public class ClientDaoImp implements ClientDao {

    private final Connection conn;

    private final String table;


    public ClientDaoImp(Connection conn) {
        this.conn = conn;
        table = "clients";
    }

    @Override
    public void createTable() {
        try (Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS " + table);
            st.execute(CREATE_CLIENTS_SQL);
            //  st.execute("ALTER TABLE " + table + " AUTO_INCREMENT=50");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Clients addClient(String fullName, String phone, String address, String email) {
        try {
            try (PreparedStatement st = conn.prepareStatement(INIT_CLIENT_SQL)) {
                st.setString(1, fullName);
                st.setString(2, phone);
                st.setString(3, address);
                st.setString(4, email);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("A new client has been aded");
        return new Clients(fullName, phone, address, email);
    }

    public void createRandomClients() {
        addClient("Jon Doe", "099-882-31-11", "Kyiv, Banderu street 7", "Jon@gmail.com.ua");
        addClient("Bob Marli", "055-444-22-66", "Kyiv, St.Lt street 19", "Bob_M@gmail.com.ua");
        addClient("Nicolas Keidj", "099-456-34-24", "New Yourk,Some street 15", "KeiJ@gmail.com.ua");
    }

    @Override
    public List<Clients> getAll() {

        List<Clients> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    while (rs.next()) {
                        Clients clients = new Clients();

                        clients.setId(rs.getLong(1));
                        clients.setFullName(rs.getString(2));
                        clients.setPhone(rs.getString(3));
                        clients.setAddress(rs.getString(4));
                        clients.setEmail(rs.getString(5));


                        res.add(clients);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
