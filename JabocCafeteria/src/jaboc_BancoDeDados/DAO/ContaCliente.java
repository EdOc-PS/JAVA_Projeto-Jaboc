/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import jaboc_BancoDeDados.ComandosSQL;
import java.sql.*;
/**
 *
 * @author guilh
 */
public class ContaCliente implements ComandosSQL{
    
    @Override
    public ResultSet selectTodos(){
        
        String comandoSelect = "SELECT C.cpfCliente, C.senhaClente, C.gastoTotal, P.nome, P.endereco, P.telefone FROM "
                    + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE  P.cpf = C.cpfCliente;";
        
         ResultSet resultadosSelect = null;
        
        try{
            
            Connection conexao = this.conectar();
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
            System.out.println("Erro no selectTodos() da ContaCliente: "+ error.getMessage());   
        }
        
        return resultadosSelect;
    }
    
    @Override
    public <T> ResultSet selectEspecifico(T cpfCliente){
         
        String comandoSelect = "SELECT C.cpfCliente, C.senhaClente, C.gastoTotal, P.nome, P.endereco, P.telefone FROM "
                    + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE cpfCliente = '"+ cpfCliente+ "' AND P.cpf = C.cpfCliente;";
        
         ResultSet resultadoSelect = null;
        
        try{
            
            Connection conexao = this.conectar();
            resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
            System.out.println("Erro no selectEspecifico(String cpfCliente) da ContaCliente: "+ error.getMessage());   
        }
        
        return resultadoSelect;
    }
}
