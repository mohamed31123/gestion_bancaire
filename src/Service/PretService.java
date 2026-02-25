package service;

import dao.PretsDAO;
import entities.Client;
import entities.Prets;

import java.util.List;

public class PretService {

    private PretsDAO pretsDAO = new PretsDAO();
    private EmailService emailService = new EmailService(); // AJOUT 1: Déclaration EmailService

    // Ajouter un prêt
    public int ajouterPret(Prets p) throws Exception {
        int id = pretsDAO.insert(p); // CORRECTION: il manquait "int id = "
        
        // ===== AJOUT 2: ENVOI EMAIL APRÈS AJOUT =====
        if (id != -1) {
            try {
                // Récupérer les infos du client
                ClientService clientService = new ClientService();
                Client client = clientService.getClientById(p.getId_client());
                
                if (client != null && client.getEmail() != null) {
                    String sujet = "Confirmation de votre prêt";
                    String contenu = "Bonjour " + client.getNom() + ",\n\n"
                            + "Votre prêt a été enregistré avec succès.\n"
                            + "Détails du prêt :\n"
                            + "Montant : " + p.getMontant_total() + " DH\n"
                            + "Taux d'intérêt : " + p.getTaux_interet() + "%\n"
                            + "Durée : " + p.getDuree_mois() + " mois\n"
                            + "Date : " + p.getDate_pret() + "\n\n"
                            + "Merci de votre confiance !";
                    
                    emailService.envoyerEmail(client.getEmail(), sujet, contenu);
                    System.out.println("Email envoyé à " + client.getEmail());
                }
            } catch (Exception e) {
                System.out.println("Erreur envoi email: " + e.getMessage());
            }
        }
        // ===== FIN AJOUT 2 =====
        
        return id;
    }

    // Chercher un prêt par id
    public Prets chercherPret(int id) throws Exception {
        return pretsDAO.findById(id);
    }

    // Afficher tous les prêts
    public List<Prets> afficherPrets() throws Exception {
        return pretsDAO.findAll();
    }

    // Modifier un prêt
    public boolean modifierPret(Prets p) throws Exception {
        boolean modifie = pretsDAO.update(p);
        
        // ===== AJOUT 3: ENVOI EMAIL APRÈS MODIFICATION =====
        if (modifie) {
            try {
                ClientService clientService = new ClientService();
                Client client = clientService.getClientById(p.getId_client());
                
                if (client != null && client.getEmail() != null) {
                    String sujet = "Modification de votre prêt";
                    String contenu = "Bonjour " + client.getNom() + ",\n\n"
                            + "Votre prêt a été modifié.\n"
                            + "Nouveaux détails :\n"
                            + "Montant : " + p.getMontant_total() + " DH\n"
                            + "Taux d'intérêt : " + p.getTaux_interet() + "%\n"
                            + "Durée : " + p.getDuree_mois() + " mois\n"
                            + "Date : " + p.getDate_pret() + "\n\n"
                            + "Cordialement";
                    
                    emailService.envoyerEmail(client.getEmail(), sujet, contenu);
                    System.out.println("Email envoyé à " + client.getEmail());
                }
            } catch (Exception e) {
                System.out.println("Erreur envoi email: " + e.getMessage());
            }
        }
        // ===== FIN AJOUT 3 =====
        
        return modifie;
    }

    // Supprimer un prêt
    public boolean supprimerPret(int id) throws Exception {
        // Récupérer le prêt avant suppression pour avoir les infos client
        Prets pret = pretsDAO.findById(id);
        
        boolean supprime = pretsDAO.delete(id);
        
        // ===== AJOUT 4: ENVOI EMAIL APRÈS SUPPRESSION =====
        if (supprime && pret != null) {
            try {
                ClientService clientService = new ClientService();
                Client client = clientService.getClientById(pret.getId_client());
                
                if (client != null && client.getEmail() != null) {
                    String sujet = "Suppression de votre prêt";
                    String contenu = "Bonjour " + client.getNom() + ",\n\n"
                            + "Votre prêt a été supprimé de notre système.\n"
                            + "Prêt concerné :\n"
                            + "Montant : " + pret.getMontant_total() + " DH\n"
                            + "Date : " + pret.getDate_pret() + "\n\n"
                            + "Pour plus d'informations, contactez-nous.";
                    
                    emailService.envoyerEmail(client.getEmail(), sujet, contenu);
                    System.out.println("Email envoyé à " + client.getEmail());
                }
            } catch (Exception e) {
                System.out.println("Erreur envoi email: " + e.getMessage());
            }
        }
        // ===== FIN AJOUT 4 =====
        
        return supprime;
    }
}