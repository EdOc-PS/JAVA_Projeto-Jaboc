/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados;

import java.sql.*;

/**
 *
 * @author guilh
 */
public class Conexao {
    public static void main(String[] args) throws SQLException{
        Connection conexao = null;
        
        try{
            //Está inicializando a classe do Postgres SQL.
            Class.forName("org.postgresql.Driver");
            //Conectando-se ao banco de dados do IFMG.
            conexao = DriverManager.getConnection("jdbc:postgresql://200.18.128.54:5432/", "aula", "aula");
            System.out.println("Conexão realizada!");
        }
        //Esse catch é para caso a classe do Driver JDBC não seja encontrada.
        catch(ClassNotFoundException err){
            System.out.println("Driver não encontrado!");
        }
        //Esse catch é para caso dê algum erro na conexão.
        catch (SQLException err) {
            System.out.println("Não foi possível realizar a conexão - Causa do erro: "+ err.getMessage());
        }
        //Esse finally será executado independemente do Try e do Catch, e serve para fechar a conexão.
        finally{
            if(conexao != null){
                conexao.close();
            }
        }
    }
}
