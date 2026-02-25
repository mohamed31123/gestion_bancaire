package test;

import service.EmailService;

public class TestEmail {
    public static void main(String[] args) {
        
        System.out.println("=== TEST ENVOI EMAIL ===");
        
        // Créer le service email
        EmailService es = new EmailService();
        
        // Essayer d'envoyer un email
        boolean resultat = es.envoyerEmail(
            "m.eddinari5197@uca.ac.ma",  
            "Test JavaMail", 
            "Bonjour, ceci est un test pour vérifier que JavaMail fonctionne correctement !"
        );
        
        // Afficher le résultat
        if (resultat) {
            System.out.println("✅ SUCCÈS : L'email a été envoyé !");
        } else {
            System.out.println("❌ ÉCHEC : L'email n'a pas pu être envoyé.");
        }
    }
}