/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO_Funcionario;

import jaboc_BancoDeDados.Conexao;
import java.sql.*;
/**
 *
 * @author guilh
 */


public class Select {
    
    public static void main(String[] args) throws SQLException{
        
        ResultSet rs = selectFuncionario("127.209.576-23");
        while(rs.next()){
            System.out.println(rs.getString("cpf"));
            System.out.println(rs.getString("nome"));
            System.out.println(rs.getString("endereco"));
            System.out.println(rs.getString("telefone"));
        }
    }
    
    public static ResultSet selectAll_Funcionarios() throws SQLException{
        Connection conexao = Conexao.conectar();
        
        ResultSet todosFuncionarios = conexao.createStatement().executeQuery("SELECT C.cpfFuncionario, P.nome, P.endereco, P.telefone, C.cargo, C.salario FROM jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE C.cpfFuncionario = P.cpf;");
        
        conexao.close();
        return todosFuncionarios;
    }
    
    public static ResultSet selectFuncionario(String parametro) throws SQLException{
        Connection conexao = Conexao.conectar();
        
        ResultSet funcionario = conexao.createStatement().executeQuery("SELECT * FROM jaboc_servidor.Pessoa WHERE cpf = '"+ parametro + "';");
        
        conexao.close();
        return funcionario;
    }
}
