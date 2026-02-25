/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.DriverManager;

import java.sql.* ;



/**
 *
 * @author X1 YOGA
 */
public final class Connexion {
    private static Connexion instance ;
    private final Connection conn     ;
    
    private static final String url = "jdbc:mysql://localhost:3306/prets_remboursements";
    private static final String user = "root";
    private static final String pwd = "";
     
    private Connexion() throws SQLException {
        conn = DriverManager.getConnection(url, user, pwd);
        conn.setAutoCommit(true);
    }
    
    /**
     *
     * @return
     */
    public static synchronized Connexion getInstance() throws SQLException {
        if(instance == null || instance.conn.isClosed()){
            instance = new Connexion() ;
        }
        return instance ;
        
    }
    public Connection getConnection(){
        return conn ;
    }
    
    
}
