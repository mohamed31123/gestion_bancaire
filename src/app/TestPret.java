/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import service.PretService;
import entities.Prets;
import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author CODE212 Student
 */
public class TestPret {

    public static void main(String args[]) throws Exception {
        PretService ps = new PretService();

        LocalDate ld = LocalDate.of(2026, 2, 21);
        LocalDate ld1 = LocalDate.of(2020, 1, 19);

        // convertir en java.sql.Date
        Date sqlDate = Date.valueOf(ld);
        Date sqlDate1 = Date.valueOf(ld1);

       // utiliser dans le constructeur
        //creer un objet de type Pret 
        Prets p = new Prets(1, 10000.00, 0.20, 12, sqlDate);
        Prets p1 = new Prets(1, 10000.00, 0.20, 12, sqlDate);
        Prets p2 = new Prets(1, 10000.00, 0.20, 12, sqlDate);
        Prets p3 = new Prets(1, 10000.00, 0.20, 12, sqlDate);
        Prets p4 = new Prets(1, 10000.00, 0.20, 12, sqlDate);

        //tester nos fonctions :
        ps.ajouterPret(p);
        ps.ajouterPret(p1);
        ps.ajouterPret(p2);
        ps.ajouterPret(p3);
        ps.ajouterPret(p4);
        //Chercher le pret passant par id :
        ps.chercherPret(1);
        //lister toutes les prets : 
        ps.afficherPrets();
        //modifier le pret: 
        p1.setMontant_total(150000.00);
        ps.modifierPret(p1);
        
        p2.setDate_pret(sqlDate1);
        ps.modifierPret(p2);
        
        //supprimer un pret 
        ps.supprimerPret(3);
        
        //

    }
}
