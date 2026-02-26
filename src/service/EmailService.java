package service;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailService {
    
    private String monEmail = "m.eddinari5197@uca.ac.ma";  // Remplacez par VOTRE email
    private String monMotDePasse = "mysk czzj cjxz sivh"; // Remplacez par VOTRE mot de passe
    
    public boolean envoyerEmail(String destinataire, String sujet, String message) {
        
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(monEmail, monMotDePasse);
            }
        });
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(monEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinataire));
            msg.setSubject(sujet);
            msg.setText(message);
            
            Transport.send(msg);
            System.out.println("✅ Email envoyé à " + destinataire);
            return true;
            
        } catch (MessagingException e) {
            System.out.println("❌ Erreur envoi email: " + e.getMessage());
            return false;
        }
    }
}