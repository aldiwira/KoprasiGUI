/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import controller.*;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aldi Wirawan
 */
public class AnggotaService {
    Anggota anggota = new Anggota();
    connector con = new connector();
    private static Connection koneksi;
    private DefaultTableModel model;
    
    public static void connector(){
        if(koneksi == null){
            try {
                String url = "jdbc:mysql://localhost:3306/pbo";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = (Connection) DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println("Error Koneksi!"+ex.getMessage());
            }
        }
    }
    public static int insertQueryGetId(String query){
        connector();
        int num = 0;
        int result = -1;
        
        try {
            Statement stmt = koneksi.createStatement();
            num = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                result = rs.getInt(1);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        }
        return result;
    }
    public static boolean executeQuery(String query){
        connector();
        boolean result = false;
        try {
            Statement stmt = koneksi.createStatement();
            stmt.executeQuery(query);
            result = true;
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ResultSet selectQuery(String query){
        connector();
        ResultSet rs = null;
        try {
            Statement stmt = koneksi.createStatement();
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
}
