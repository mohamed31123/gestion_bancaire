
package entities ;

import java.sql.Date;



public class Remboursements {
    private int id;
    private double montant;
    private java.sql.Date dateRemb ;
    private int pretId;

    public Remboursements() {
    }
    


public Remboursements(double montant, java.sql.Date dateRemb, int pretId) {
    this.montant = montant;
    this.dateRemb = dateRemb;
    this.pretId = pretId;
}

    public Remboursements(int id, double montant, Date dateRemb, int pretId) {
        this.id = id;
        this.montant = montant;
        this.dateRemb = dateRemb;
        this.pretId = pretId;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateRemboursement() {
        return dateRemb;
    }

    public void setDateRemboursement(Date dateRemboursement) {
        this.dateRemb = dateRemboursement;
    }

    public int getPretId() {
        return pretId;
    }

    public void setPretId(int pretId) {
        this.pretId = pretId;
    }
    
    
}