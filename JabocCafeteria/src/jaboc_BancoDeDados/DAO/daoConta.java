/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import java.sql.*;
import java.sql.SQLException;
import jaboc_Classes.Conta;
import jaboc_Classes.Conta_Cliente;
import jaboc_Classes.Conta_Funcionario;

/**
 *
 * @author guilh
 */
public class daoConta {
       
    public static boolean insertConta(Conta conta) throws SQLException{
        Connection conexao = Conexao.conectar();
        
        try{
            daoPessoa.insertPessoa(conta, conexao);
            
            if(conta instanceof Conta_Funcionario){
                Conta_Funcionario contaF = (Conta_Funcionario) conta;

                conexao.createStatement().executeUpdate("INSERT INTO jaboc_servidor.Conta_Funcionario (cpfFuncionario, cargo, senhaFuncionario, salario) VALUES ('"+ 
                contaF.getTitular().getCpf() + "', '"+ contaF.getCargoFuncionario() + "', '"+ contaF.getSenha()+ "', '"+ contaF.getSalario()+ "');");

            }else {      
                Conta_Cliente contaC = (Conta_Cliente) conta;

                conexao.createStatement().executeUpdate("INSERT INTO jaboc_servidor.Conta_Cliente (cpfCliente, senhaCliente) VALUES ('"+
                contaC.getTitular().getCpf() + "', '"+ contaC.getSenha()+ "');");
            }
                return true;                   
        }catch(SQLException error){
            System.out.println("Pessoa já existe!");           
        }finally{
            conexao.close();
        }
        return false;
    }    
    
    public static boolean insertFuncionario_emContaCliente(Conta_Cliente contaC) throws SQLException{
        
        Connection conexao = Conexao.conectar();
        
        String insertF = "INSERT INTO jaboc_servidor.Conta_Cliente (cpfCliente, senhaCliente) VALUES ('"+ contaC.getTitular().getCpf()+
       "', '"+ contaC.getSenha() +"');";
        
        return conexao.createStatement().executeUpdate(insertF) != 0;
    
    }
    
    public static boolean login_ContaCliente(String cpf, String senha) throws SQLException{
        
        Connection conexao = Conexao.conectar();
        String selectLoginC = "SELECT P.nome, C.senhaCliente FROM jaboc_servidor.Pessoa P, jaboc_servidor.Conta_Cliente C WHERE P.cpf = C.cpfCliente AND cpfCliente = '"+ cpf +"';";

        ResultSet rsLoginC = conexao.createStatement().executeQuery(selectLoginC);
        conexao.close();
        
        if(rsLoginC.next()){
            if(rsLoginC.getString("senhaCliente").equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean login_ContaFuncionario(String cpf, String senha) throws SQLException{
        
        Connection conexao = Conexao.conectar();
        String selectionLoginF = "SELECT senhaFuncionario FROM jaboc_servidor.Conta_Funcionario WHERE cpfFuncionario = '"+ cpf +"';";
        
        
        ResultSet rsLoginF = conexao.createStatement().executeQuery(selectionLoginF);
        conexao.close();
        
        if(rsLoginF.next()){
            if(rsLoginF.getString("senhaFuncionario").equals(senha)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeFuncionario(String cpf) throws SQLException{
        
        Connection conexao = Conexao.conectar();
        
        String selectF = "SELECT cpfFuncionario FROM jaboc_servidor.Conta_Funcionario WHERE cpfFuncionario = '"+ cpf+ "';";
        
        ResultSet selectFuncionario = conexao.createStatement().executeQuery(selectF);
        conexao.close();
        return selectFuncionario.next();
    }
    
    public static boolean existeCliente(String cpf) throws SQLException{
        Connection conexao = Conexao.conectar();
        
        String selectC = "SELECT cpfCliente FROM jaboc_servidor.Conta_Cliente WHERE cpfCliente = '"+ cpf +"';";
        
        ResultSet selectCliente = conexao.createStatement().executeQuery(selectC);
        conexao.close();
        
        return selectCliente.next();
    }   
    
    public static boolean delete_ContaFuncionario(String cpf) throws SQLException{
        
        Connection conexao = Conexao.conectar();
             
        if(existeFuncionario(cpf)){
            daoPessoa.deletePessoa(cpf, conexao);
            String deleteContaF = "DELETE FROM jaboc_servidor.Conta_Funcionario WHERE cpfFuncionario = '"+ cpf +"';";
            
            conexao.createStatement().executeUpdate(deleteContaF);
            conexao.close();
            return true;
        }else{
            conexao.close();
            return false;
        } 
    }
}
