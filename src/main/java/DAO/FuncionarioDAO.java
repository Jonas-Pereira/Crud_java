/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controller.Funcionario_controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    Connection conn;
    PreparedStatement pstm;
    
    
    public void cadastrarFuncionario(Funcionario_controller objfuncionarioCT) throws ClassNotFoundException{
         
        String sql = "insert into funcionario (nome_funcionario, endereco_funcionario, email) values (?,?,?)";
        
        conn = new ConexaoDAO().canectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionarioCT.getNome_funcionario());
            pstm.setString(2, objfuncionarioCT.getEndereco_funcionario());
            pstm.setString(3, objfuncionarioCT.getEmail());
            
            pstm.execute();
            pstm.close();
            
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO"+erro);
        }
    }  
    
    public void deletarFuncionario (Funcionario_controller objfuncionarioCT) throws ClassNotFoundException{
   
    String sql = "DELETE FROM funcionario WHERE id = ?";
    
    conn = new ConexaoDAO().canectaBD();
    
    try {
        pstm = conn.prepareStatement(sql);
      
        pstm.setInt(1, objfuncionarioCT.getId());
        
        pstm.execute();
        pstm.close();
        
    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "FuncionarioDAO (deletarFuncionario): " + erro);
    }
        
    }
    
    public void atualizarFuncionario (Funcionario_controller objfuncionarioCT) throws ClassNotFoundException{
        String sql = "UPDATE funcionario SET nome_funcionario = ?, endereco_funcionario = ?, email =? WHERE id = ?";
        conn = new ConexaoDAO().canectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            
            
            pstm.setString(1, objfuncionarioCT.getNome_funcionario());
            pstm.setString(2, objfuncionarioCT.getEndereco_funcionario());
            pstm.setString(3, objfuncionarioCT.getEmail());
            pstm.setInt(4, objfuncionarioCT.getId());

            pstm.executeUpdate();
            pstm.close();

        } catch (SQLException e) {
        }
    }
   
    public List<Funcionario_controller> listarFuncionarios() throws ClassNotFoundException {
        String sql = "SELECT * FROM funcionario";
        conn = new ConexaoDAO().canectaBD();
        List<Funcionario_controller> listaFuncionarios = new ArrayList<>();

        try {
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Funcionario_controller objFuncionarioCT = new Funcionario_controller();
                objFuncionarioCT.setId(rs.getInt("id"));
                objFuncionarioCT.setNome_funcionario(rs.getString("nome_funcionario"));
                objFuncionarioCT.setEndereco_funcionario(rs.getString("endereco_funcionario"));
                objFuncionarioCT.setEmail(rs.getString("email"));

                listaFuncionarios.add(objFuncionarioCT);
            }

            rs.close();
            pstm.close();
        } catch (SQLException e) {

        }

        return listaFuncionarios;
}
        
}
