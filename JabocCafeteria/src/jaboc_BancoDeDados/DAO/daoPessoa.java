/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados;

import jaboc_BancoDeDados.Conexao.Conexao;
import jaboc_Classes.Conta;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author guilh
 */
public class daoPessoa {
    
    private static void insertPessoa(Conta conta, Connection conexao) throws SQLException{
        
        String insertP = "INSERT INTO jaboc_servidor.Pessoa (cpf, nome, endereco, telefone) VALUES ('"+
        conta.getTitular().getCpf() + "', '"+ conta.getTitular().getNome() + "', '"+ conta.getTitular().getEndereco()+
        "', '"+ conta.getTitular().getTelefone()+ "');";
        
        conexao.createStatement().executeUpdate(insertP);
        
    }
    
    //Talvez esse método não seja necessário.
    public ResultSet selectPessoa(String argCpf) throws SQLException{
        
        Connection conexao = Conexao.conectar();
        
        String selectP = "SELECT nome, cpf, endereco, telefone FROM jaboc_servidor.Pessoa WHERE cpf = '"+ argCpf +"'";
        ResultSet resultSelect = conexao.createStatement().executeQuery(selectP);
        
        conexao.close();
        return resultSelect;
    }
    
    public boolean existePessoa(String argCpf, Connection conexao) throws SQLException{
        
        String selectP = "SELECT cpf FROM jaboc_servidor.Pessoa WHERE cpf = '"+ argCpf +"'";
        ResultSet resultSelect = conexao.createStatement().executeQuery(selectP);
        
        return resultSelect != null;
    }
    
    public boolean deletePessoa(String argCpf, Connection conexao) throws SQLException{
        
        String deletP = "DELETE FROM jaboc_servidor.Pessoa WHERE cpf = '"+ argCpf+ "';";
        
        //O método executeUpdate retorna o n°de linhas afetadas pela querry.
        return conexao.createStatement().executeUpdate(deletP) != 0;
    }
    
    public boolean updatePessoa(Conta conta, String argCpf, Connection conexao) throws SQLException{
        
        String updateP = "UPDATE jaboc_servidor.Pessoa SET cpf = '"+ conta.getTitular().getCpf() + " ', nome = '"+
        conta.getTitular().getNome() +"' , endereco = '"+ conta.getTitular().getEndereco() + "', telefone = '"+ conta.getTitular().getTelefone() + 
                "' WHERE cpf = '"+ argCpf+ "';";
        
        return conexao.createStatement().executeUpdate(updateP) != 0;
    }
}
