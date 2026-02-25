/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
/**
 *
 * @author CODE212 Student
 */

public class Prets {
    private int id_client ;
    private int id_pret   ;
    private double montant_total ;
    private double taux_interet ;
    private int duree_mois      ;
    private Date date_pret ;

    public Prets() {
    }

    public Prets(int id_pret , int id_client, double montant_total, double taux_interet, int duree_mois, Date date_pret) {
       this.id_pret = id_pret;
        this.id_client = id_client;
        
        this.montant_total = montant_total;
        this.taux_interet = taux_interet;
        this.duree_mois = duree_mois;
        this.date_pret = date_pret;
    }
    
    
    
    

    public Prets(int id_client, double montant_total,
            double taux_interet, int duree_mois, Date date_pret) {
        this.id_client = id_client;
        this.montant_total = montant_total;
        this.taux_interet = taux_interet;
        this.duree_mois = duree_mois;
        this.date_pret = date_pret;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_pret() {
        return id_pret;
    }

    public void setId_pret(int id_pret) {
        this.id_pret = id_pret;
    }

    public double getMontant_total() {
        return montant_total;
    }

    public void setMontant_total(double montant_total) {
        this.montant_total = montant_total;
    }

    public double getTaux_interet() {
        return taux_interet;
    }

    public void setTaux_interet(double taux_interet) {
        this.taux_interet = taux_interet;
    }

    public int getDuree_mois() {
        return duree_mois;
    }

    public void setDuree_mois(int duree_mois) {
        this.duree_mois = duree_mois;
    }

    public Date getDate_pret() {
        return date_pret;
    }

    public void setDate_pret(Date date_pret) {
        this.date_pret = date_pret;
    }

    @Override
    public String toString() {
        return "Prets{" + "id_client=" + id_client + ", id_pret=" + id_pret + ", montant_total=" 
                + montant_total + ", taux_interet=" + taux_interet + ", duree_mois=" + duree_mois + 
                ", date_pret=" + date_pret + '}';
    }

    public void setId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
}

