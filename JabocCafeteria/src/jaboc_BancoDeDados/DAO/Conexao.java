/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import java.sql.*;

/**
 *
 * @author guilh
 */
public class Conexao {    
    
    public static Connection conectar() throws SQLException{
        Connection conexao = null;
        
        try{
            Class.forName("org.postgresql.Driver");           
            conexao = DriverManager.getConnection("jdbc:postgresql://200.18.128.54:5432/Jaboc", "aula", "aula");           
        }
        catch(ClassNotFoundException err){
            System.out.println("Driver não encontrado!");
        }
        catch (SQLException err) {
            System.out.println("Não foi possível realizar a conexão - Causa do erro: "+ err.getMessage());
        }
        return conexao;
    }      
}
