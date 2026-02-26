package service;

import dao.ClientDAO;
import entities.Client;

import java.util.List;

public class ClientService {

    private ClientDAO clientDAO = new ClientDAO();
    private EmailService emailService = new EmailService();

    // ================== CREATE ==================

    public Client ajouterClient(String nom, String email, String telephone) throws Exception {

        if (nom == null || nom.isEmpty()) {
            throw new Exception("Le nom est obligatoire");
        }

        if (email == null || !email.contains("@")) {
            throw new Exception("Email invalide");
        }

        Client client = new Client();
        client.setNom(nom);
        client.setEmail(email);
        client.setTelephone(telephone);
        
        int id = clientDAO.insert(client);

        if (id != -1) {
            // ENVOYER EMAIL DE CONFIRMATION
            String sujet = "Bienvenue chez nous !";
            String contenu = "Bonjour " + nom + ",\n\n"
                    + "Votre inscription a été réussie.\n"
                    + "Voici vos informations :\n"
                    + "Nom : " + nom + "\n"
                    + "Email : " + email + "\n"
                    + "Téléphone : " + telephone + "\n\n"
                    + "Cordialement,\n"
                    + "Votre équipe de gestion des prêts";
            
            emailService.envoyerEmail(email, sujet, contenu);
        }

        return client; // CORRECTION: Cette ligne était mal placée
    }

    // ================== READ ==================

    public Client getClientById(int id) throws Exception {
        Client c = clientDAO.findById(id);

        if (c == null) {
            throw new Exception("Client introuvable avec id = " + id);
        }

        return c;
    }

    public List<Client> getAllClients() throws Exception {
        return clientDAO.findAll();
    }

    // ================== UPDATE ==================

    public boolean modifierClient(int id, String nom, String email, String telephone) throws Exception {

        Client existing = clientDAO.findById(id);

        if (existing == null) {
            throw new Exception("Impossible de modifier : client introuvable");
        }

        existing.setNom(nom);
        existing.setEmail(email);
        existing.setTelephone(telephone);

        return clientDAO.update(existing);
    }

    // ================== DELETE ==================

    public boolean supprimerClient(int id) throws Exception {

        Client existing = clientDAO.findById(id);

        if (existing == null) {
            throw new Exception("Impossible de supprimer : client introuvable");
        }

        return clientDAO.delete(id);
    }
}