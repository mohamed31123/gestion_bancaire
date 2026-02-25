/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author CODE212 Student
 */
public class Client {
    private int id ;
    private String nom ;
    private String email ;
    private String telephone ;

    
    public Client() {
    } 

    public Client(String nom,String email, String telephone) {
        this.nom = nom;
        this.email = email ;
        this.telephone = telephone;
    }
    
    
    

    public Client(int id, String nom ,String email , String telephone) {
        this.id = id;
        this.nom = nom;
        this.email = email ;
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + " ,"+ email+", telephone=" + telephone + '}';
    }
    
    

    
    
    
}
