package service;

import dao.RemboursementDAO;
import entities.Remboursements;
import java.util.List;

public class RembService {

    private final RemboursementDAO dao;
    private EmailService emailService;  // AJOUT SIMPLE

    public RembService() {
        dao = new RemboursementDAO();
        emailService = new EmailService();  // AJOUT SIMPLE
    }

    // Ajouter un remboursement
    public void ajouter(Remboursements r) throws Exception{
        try {
            dao.insert(r);
            System.out.println("Remboursement ajouté !");
            
            // ===== ENVOI EMAIL SIMPLE =====
            emailService.envoyerEmail(
                "client@gmail.com",  // Remplacez par l'email du client
                "Confirmation remboursement",
                "Votre remboursement de " + r.getMontant() + " DH a été enregistré."
            );
            // ==============================
            
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout !");
            e.printStackTrace();
        }
    }

    // Modifier un remboursement
    public void modifier(Remboursements r) throws Exception {
        try {
            dao.update(r);
            System.out.println("Remboursement modifié !");
            
            // ===== ENVOI EMAIL SIMPLE =====
            emailService.envoyerEmail(
                "client@gmail.com",
                "Modification remboursement",
                "Votre remboursement a été modifié. Nouveau montant: " + r.getMontant() + " DH"
            );
            // ==============================
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la modification !");
            e.printStackTrace();
        }
    }

    // Supprimer un remboursement
    public void supprimer(int id) throws Exception {
        try {
            dao.delete(id);
            System.out.println("Remboursement supprimé !");
            
            // ===== ENVOI EMAIL SIMPLE =====
            emailService.envoyerEmail(
                "client@gmail.com",
                "Suppression remboursement",
                "Votre remboursement a été supprimé."
            );
            // ==============================
            
        } catch (Exception e) {
            System.out.println("Erreur lors de la suppression !");
            e.printStackTrace();
        }
    }

    // Lister tous les remboursements
    public void lister() {
        try {
            List<Remboursements> list = dao.findAll();
            for (Remboursements r : list) {
                System.out.println("ID: " + r.getId() +
                                   ", Montant: " + r.getMontant() +
                                   ", Date: " + r.getDateRemboursement() +
                                   ", Prêt ID: " + r.getPretId());
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération !");
            e.printStackTrace();
        }
    }
}