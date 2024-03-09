package com.homework.dao.clientDao;

import com.homework.entyti.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.homework.constats.Constats.CREATE_CLIENTS_SQL;
import static com.homework.constats.Constats.INIT_CLIENT_SQL;
import static com.homework.utils.Utils.getRandomName;

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

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Clients addClient(Clients clients) {
        try {
            try (PreparedStatement st = conn.prepareStatement(INIT_CLIENT_SQL)) {
                st.setString(1, clients.getFullName());
                st.setString(2, clients.getPhone());
                st.setString(3, clients.getAddress());
                st.setString(4, clients.getEmail());
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("A new client has been aded");
        return new Clients(clients.getFullName(), clients.getPhone(),clients.getAddress(), clients.getEmail());
    }

    public void createRandomClients() {
        addClient(new Clients(getRandomName(), "099-882-31-11", "Kyiv, Banderu street 7",
                "Jon@gmail.com.ua"));
        addClient(new Clients(getRandomName(), "055-444-22-66", "Kyiv, St.Lt street 19",
                "Bob_M@gmail.com.ua"));
        addClient(new Clients(getRandomName(), "099-456-34-24", "New Yourk,Some street 15",
                "KeiJ@gmail.com.ua"));
    }

    @Override
    public List<Clients> getAll() {

        List<Clients> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    while (rs.next()) {
                        Clients clients = new Clients();

                        clients.setClient_id(rs.getLong(1));
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
