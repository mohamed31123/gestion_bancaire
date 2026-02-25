package dao;

import entities.Remboursements;
import util.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RemboursementDAO implements IDao<Remboursements> {

    @Override
    public Remboursements findById(int id) throws Exception {
        String sql = "SELECT * FROM remboursement WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Remboursements(
                    rs.getInt("id"),
                    rs.getDouble("montant"),
                    rs.getDate(" new java.sql.Date(r.getDateRemboursement().getTime())"),
                    rs.getInt("pretId")
                );
            }
        }
        return null;
    }

    @Override
    public List<Remboursements> findAll() throws Exception {
        List<Remboursements> list = new ArrayList<>();
        String sql = "SELECT * FROM remboursement";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Remboursements(
                    rs.getInt("id"),
                    rs.getDouble("montant"),
                    rs.getDate(" new java.sql.Date(r.getDateRemboursement().getTime())"),
                    rs.getInt("pretId")
                ));
            }
        }
        return list;
    }

    @Override
public int insert(Remboursements r) throws Exception {
    String sql = "INSERT INTO remboursement(montant, dateRemb, pretId) VALUES(?,?,?)";
    try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        ps.setDouble(1, r.getMontant());
        ps.setDate(2, new java.sql.Date(r.getDateRemboursement().getTime())); // <-- important
        ps.setInt(3, r.getPretId());

        int rows = ps.executeUpdate();

        if (rows == 1) {
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                int id = keys.getInt(1);
                r.setId(id);
                return id;
            }
        }
    }
    return -1;
}

    @Override
    public boolean update(Remboursements r) throws Exception {
        String sql = "UPDATE remboursement SET montant=?, dateRemb=?, pretId=? WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setDouble(1, r.getMontant());
            ps.setDate(2, new java.sql.Date(r.getDateRemboursement().getTime()));
            ps.setInt(3, r.getPretId());
            ps.setInt(4, r.getId());
            return ps.executeUpdate() == 1;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM remboursement WHERE id=?";
        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}