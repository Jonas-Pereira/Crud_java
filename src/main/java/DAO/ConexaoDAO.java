/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author Jonas
 */
public class ConexaoDAO {
    
     public static void main(String[] args) {
       
    }
    
    public Connection canectaBD() throws ClassNotFoundException{
        
        Connection conn=null;
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancoteste", "root", "");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,erro.getMessage());
        }
        
        return conn;
    
    }       
}
