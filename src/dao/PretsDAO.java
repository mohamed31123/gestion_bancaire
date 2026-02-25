package dao;

import entities.Prets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.Connexion;

public class PretsDAO implements IDao<Prets> {

    @Override
    public Prets findById(int id) throws Exception {
        String sql = "SELECT * FROM prets WHERE id_pret=?";
        try (PreparedStatement ps = Connexion.getInstance()
                .getConnection()
                .prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Prets(
                            rs.getInt("id_client"),
                            rs.getInt("id_pret"),
                            rs.getDouble("montant_total"),
                            rs.getDouble("taux_interet"),
                            rs.getInt("duree_mois"),
                            rs.getDate("date_pret")
                            
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Prets> findAll() throws Exception {
        String sql = "SELECT * FROM prets";
        List<Prets> list = new ArrayList<>();

        try (PreparedStatement ps = Connexion.getInstance()
                .getConnection()
                .prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Prets(
                        rs.getInt("id_client"),
                            rs.getInt("id_pret"),
                            rs.getDouble("montant_total"),
                            rs.getDouble("taux_interet"),
                            rs.getInt("duree_mois"),
                            rs.getDate("date_pret")
                ));
            }
        }

        return list;
    }

    @Override
public int insert(Prets p) throws Exception {

    String sql = "INSERT INTO prets(montant_total, date_pret, duree_mois, id_client, taux_interet) VALUES(?, ?, ?, ?, ?)";

    try (PreparedStatement ps = Connexion.getInstance()
            .getConnection()
            .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setDouble(1, p.getMontant_total());

        // Conversion util.Date → sql.Date
        java.sql.Date sqlDate = new java.sql.Date(p.getDate_pret().getTime());
        ps.setDate(2, sqlDate);

        ps.setInt(3, p.getDuree_mois());
        ps.setInt(4, p.getId_client());
        ps.setDouble(5, p.getTaux_interet());

        int rows = ps.executeUpdate();

        if (rows == 1) {
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int id = keys.getInt(1);
                    p.setId_pret(id);
                    return id;
                }
            }
        }
    }

    return -1;
}
   @Override
public boolean update(Prets p) throws Exception {

    String sql = "UPDATE prets  SET montant_total=?, date_pret=?, duree_mois=?, id_client=?, taux_interet=? WHERE id_pret=?";

    try (PreparedStatement ps = Connexion.getInstance()
            .getConnection()
            .prepareStatement(sql)) {

        ps.setDouble(1, p.getMontant_total());
        ps.setDate(2, new java.sql.Date(p.getDate_pret().getTime()));
        ps.setInt(3, p.getDuree_mois());
        ps.setInt(4, p.getId_client());
        ps.setDouble(5, p.getTaux_interet());
        ps.setInt(6, p.getId_pret());

        return ps.executeUpdate() == 1;
    }
}

    @Override
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM prets WHERE id_pret=?";

        try (PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }
}
