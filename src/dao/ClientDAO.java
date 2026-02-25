package dao;

import entities.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Connexion;

public class ClientDAO implements IDao<Client> {

    @Override
    public Client findById(int id) throws Exception {
        String sql = "SELECT * FROM client WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance()
                .getConnection()
                .prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Client(
                            rs.getInt("id"),
                            rs.getString("nom"),
                            rs.getString("email"),
                            rs.getString("telephone")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Client> findAll() throws Exception {
        String sql = "SELECT * FROM client";
        List<Client> list = new ArrayList<>();

        try (PreparedStatement ps = Connexion.getInstance()
                .getConnection()
                .prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Client(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("email"),
                        rs.getString("telephone")
                ));
            }
        }

        return list;
    }

    @Override
    public int insert(Client c) throws Exception {

        String sql = "INSERT INTO client(nom, email, telephone) VALUES(?, ?, ?)";

        try (PreparedStatement ps = Connexion.getInstance()
                .getConnection()
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getNom());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelephone());

            int rows = ps.executeUpdate();

            if (rows == 1) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) {
                        int id = keys.getInt(1);
                        c.setId(id);
                        return id;
                    }
                }
            }
        }

        return -1; // insertion échouée
    }
    @Override
    public boolean update(Client c ) throws Exception {
        String sql = "UPDATE client SET nom=?, email = ?, telephone = ?";
        
        try(PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)){
            ps.setString(1, c.getNom());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getTelephone());
            
            return ps.executeUpdate() == 1;
            
        }
        }
    
     @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM client WHERE id=?";

        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}