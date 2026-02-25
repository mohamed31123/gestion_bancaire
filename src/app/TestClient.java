package app;

import entities.Client;
import service.ClientService;

public class TestClient {

    public static void main(String[] args) throws Exception {
        //Test Client : 
        ClientService cs = new ClientService();
        //creer un objet client : 
        Client c = new Client();

        // Appel correct de la méthode via l'objet
        cs.ajouterClient("mohamed", "m.eddinari5197@uca.ac.ma", "+212613205033");
        cs.ajouterClient("ali", "ali@gmail", "+212613224433");
        cs.ajouterClient("akram", "akram@gmail", "+21261235033");
        cs.ajouterClient("bilal", "bilal@gmail", "+2126132033");
        cs.ajouterClient("maryam", "maryam@gmail", "+212613205033");
        cs.ajouterClient("rimi", "rimi@gmail", "+212613205033");
        cs.ajouterClient("taha", "taha@gmail", "+212613232333");
        //supprimer des Client ont changee la bank 
        cs.supprimerClient(5);
        cs.supprimerClient(6);
        

        // Modifier l'objet
        c.setEmail("Mouhammed@gmail.com");
        
    
        //lister toutes les clinets : 
        cs.getAllClients();
        //trouver un client a partir de son id : 
        cs.getClientById(1);
        //
        cs.modifierClient(1, "Ilyass", "ilyass@gmail.com","+21267963776" );
    }
}