/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Aldi Wirawan
 */
public final class connector {
    private static Connection koneksi;

    public connector() {
        this.getConnection();
    }
    
    public Connection getConnection(){
        if(koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/pbo";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, user, password);
                return koneksi;
            } catch (SQLException ex) {
                Logger.getLogger(connector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
