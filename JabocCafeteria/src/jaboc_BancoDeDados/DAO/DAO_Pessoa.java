/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import jaboc_Classes.Pessoa;
import java.sql.*;
import jaboc_BancoDeDados.interfaces.ManipulandoDados;
/**
 *
 * @author guilh
 */
public class DAO_Pessoa implements ManipulandoDados{
    
    @Override
    public ResultSet selectTodos(){
        
        String comandoSelect = "SELECT cpf, nome, endereco, telefone FROM jaboc_servidor.Pessoa;";
        
        ResultSet resultadosSelect = null;
        
        try(Connection conexao = this.conectar()){
                        
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
            System.out.println("Erro no selectTodos() da Pessoa: "+ error.getMessage());
        }
        return resultadosSelect;
    }
    
    @Override
    public <T> ResultSet selectEspecifico(T cpf){
    
        String comandoSelect = "SELECT cpf, nome, endereco, telefone FROM jaboc_servidor.Pessoa WHERE cpf = '"+ cpf + "';";
    
        ResultSet resultadoSelect = null;
        
        try(Connection conexao = this.conectar()){
        
            resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
            System.out.println("Erro no selectEspecifico(String cpf) da Pessoa: "+ error.getMessage());
        }
        
        return resultadoSelect;
    }
    
    @Override
    public boolean insert(Object o){
        if(o instanceof Pessoa){
            Pessoa inserirPessoa = (Pessoa) o;
            
            String comandoInsert = "INSERT INTO jaboc_servidor.Pessoa (cpf, nome, endereco, telefone) "
                    + "VALUES ('"+ inserirPessoa.getCpf() + "','"+ inserirPessoa.getNome() + "', '"
                    + inserirPessoa.getEndereco() + "', '"+ inserirPessoa.getTelefone() + "');";
            
            try(Connection conexao = this.conectar()){
            
                return conexao.createStatement().executeUpdate(comandoInsert) > 0;
                
            }catch(SQLException error){
                System.out.println("Erro no insert(Object o) da Pessoa: "+ error.getMessage());
            }
        }
        return false;
    }
    
    @Override
    public <T> boolean existeRegistro(T cpf){
        
        String comandoSelect = "SELECT cpf, nome, endereco, telefone FROM jaboc_servidor.Pessoa WHERE cpf = '"+ cpf + "';";
    
        ResultSet resultadoSelect = null;
        
        try(Connection conexao = this.conectar()){
            
            resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            return resultadoSelect.next();
            
        }catch(SQLException error){
            System.out.println("Erro no existeRegistro(String cpf) da Pessoa: "+ error.getMessage());
        }
        
        return false;
    }
    
    @Override
    public <T> boolean delete(T cpf){
        
        String comandoDelete = "DELETE FROM jaboc_servidor.Pessoa WHERE cpf = '"+ cpf +"';";
        
        try(Connection conexao = this.conectar()){
            
            return conexao.createStatement().executeUpdate(comandoDelete) > 0;
            
        }catch(SQLException error){
             System.out.println("Erro no delete(String cpf) da Pessoa: "+ error.getMessage());
        }
        
        return false;
    }
    
    @Override
    public <T> boolean update(Object o, T cpf){
        
        if(o instanceof Pessoa){
            Pessoa updatePessoa = (Pessoa) o;
            
            String comandoUpdate = "UPDATE jaboc_servidor.Pessoa SET "
                    + "cpf = '" + updatePessoa.getCpf() + "', "
                    + "nome = '" + updatePessoa.getNome() + "', "
                    + "endereco = '" + updatePessoa.getEndereco() + "', "
                    + "telefone = '" + updatePessoa.getTelefone() + "';";
            
            try(Connection conexao = this.conectar()){
                
                return conexao.createStatement().executeUpdate(comandoUpdate) > 0;
                
            }catch(SQLException error){
                System.out.println("Erro no update(Object o, String cpf) da Pessoa: "+ error.getMessage());
            }
        }
        return false;
    }
    
    @Override
    public String alerta(Object o, String frase){
        if(o instanceof Pessoa){
            Pessoa especificarErro = (Pessoa) o;

            return especificarErro.getNome() + " " + frase;
        }
        return "Erro";
    }
}
