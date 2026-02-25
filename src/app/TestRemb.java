/*
 * To change this license header, choose LiceSnse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package app;
import entities.Remboursements;
import java.sql.Date;
import java.time.LocalDate;
import service.RembService;
/**
 *
 * @author CODE212 Student
 */
public class TestRemb {
    public static void main(String args[]) throws Exception{
   
        RembService rs = new RembService();
         LocalDate ld = LocalDate.of(2023, 2, 15);
         
        
             Date sqlDate = Date.valueOf(ld);
   

        
        
        Remboursements rb = new Remboursements(2000.00, sqlDate, 1);
        Remboursements rb1 = new Remboursements(1000.00, sqlDate, 2);
        Remboursements rb2 = new Remboursements(1500.00, sqlDate, 3);
        Remboursements rb3 = new Remboursements(2500.00, sqlDate, 4);
        Remboursements rb4 = new Remboursements(3000.00, sqlDate, 5);

        

        //l'ajout des remboursement
        rs.ajouter(rb);
        rs.ajouter(rb1);
        rs.ajouter(rb2);
        rs.ajouter(rb3);
        rs.ajouter(rb4);
        
        //update d'une remboursement
        rb1.setMontant(3700.0);
        rs.modifier(rb1);
        rb2.setMontant(1700.00);
        rs.modifier(rb2);
        
        //la supression d'une remboursement
        rs.supprimer(3);
        rs.supprimer(2);
        
        //findAll()
        rs.lister();

        
        
        
    }
    
}
