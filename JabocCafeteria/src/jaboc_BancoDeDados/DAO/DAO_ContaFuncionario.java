/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import jaboc_BancoDeDados.interfaces.ComandosSQL;
import jaboc_BancoDeDados.interfaces.Logavel;
import java.sql.*;
import jaboc_Classes.Conta_Funcionario;

/**
 *
 * @author guilh
 */
public class DAO_ContaFuncionario implements ComandosSQL, Logavel{           
    
    @Override
    public ResultSet selectTodos(){
               
        String comandoSelect = "SELECT C.cpfFuncionario, C.senhaFuncionario, C.salario, C.cargo,P.nome, P.endereco, P.telefone FROM "
                    + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE  P.cpf = C.cpfFuncionario;";
        
        ResultSet resultadosSelect = null;
         
        try{
            
            Connection conexao = this.conectar();
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
                System.out.println("Erro no selectTodos() da Conta funcionário: "+ error.getMessage());
        }
        return resultadosSelect;
    }
    
    @Override
    public <T> ResultSet selectEspecifico(T cpfFuncionario){   
        
        String comandoSelect = "SELECT C.cpfFuncionario, C.senhaFuncionario, C.salario, C.cargo,P.nome, P.endereco, P.telefone FROM "
                + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE cpfFuncionario = '"+ cpfFuncionario +"' AND P.cpf = C.cpfFuncionario;";

        ResultSet resultadoSelect = null;
        
        try{
            
            Connection conexao = this.conectar();
            resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
             System.out.println("Erro no selectEspecifico(String cpfFuncionario) da Conta funcionário: "+ error.getMessage());
        }
        
        return resultadoSelect;
    }
    
    @Override
    public boolean insert(Object o){
        
        if(o instanceof Conta_Funcionario){
            Conta_Funcionario inserirFuncionario = (Conta_Funcionario) o;
            
            String comandoInsert = "INSERT INTO jaboc_servidor.Conta_Funcionario (cpfFuncionario, cargo, senhaFuncionario, salario) "
                    + " VALUES ('"+inserirFuncionario.getTitular().getCpf()+ "', '"+inserirFuncionario.getCargoFuncionario() + "',"
                    + " '"+ inserirFuncionario.getSenha() + "', '"+ inserirFuncionario.getSalario() + "');";
                  
            try{
            
                    Connection conexao = this.conectar();
                    return conexao.createStatement().executeUpdate(comandoInsert) > 0;
                     
            }catch(SQLException error){
                System.out.println("Erro no insert(Object o) da Conta funcionário: "+ error.getMessage());
            }                     
        }       
        return false;
    }
    
    @Override
    public <T> boolean existeRegistro(T cpfFuncionario){
        String comandoSelect = "SELECT C.cpfFuncionario, C.senhaFuncionario, C.salario, C.cargo,P.nome, P.endereco, P.telefone FROM "
                + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE cpfFuncionario = '"+ cpfFuncionario +"' AND P.cpf = C.cpfFuncionario;";
        
        try{
            
            Connection conexao = this.conectar();
            ResultSet resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            return resultadoSelect.next();
            
        }catch(SQLException error){
             System.out.println("Erro no existeRegistro(String cpfFuncionario) da Conta funcionário: "+ error.getMessage());
        }       
        return false;
    }
    
    
    @Override
    public <T> boolean delete(T cpfFuncionario){       
        
        String comandoDelete = "DELETE FROM jaboc_servidor.Conta_Funcionario WHERE cpfFuncionario = '"+cpfFuncionario+"'";
        try{
            
            Connection conexao= this.conectar();            
            return conexao.createStatement().executeUpdate(comandoDelete) > 0;
            
        }catch(SQLException error){
            System.out.println("Erro no delete(String cpfFuncionario) da Conta funcionário: "+ error.getMessage());
        }
        
        return false;
    }
    
    @Override
    public <T> boolean update(Object o,T cpfFuncionario){
    
        if(o instanceof Conta_Funcionario){
        
            Conta_Funcionario updateFuncionario = (Conta_Funcionario) o;
            
            String comandoUpdate = "UPDATE jaboc_servidor.Conta_Funcionario SET "
                    + "cpfFuncionario = '"+ updateFuncionario.getTitular().getCpf() +"', "
                    + "cargo = '"+ updateFuncionario.getCargoFuncionario() + "', "
                    + "senhaFuncionario = '"+ updateFuncionario.getSenha() + "', "
                    + "salario = '"+ updateFuncionario.getSalario() +"'"
                    + "WHERE cpfFuncionario = '"+ cpfFuncionario +"';";
            
            try{
                
                Connection conexao = this.conectar();
                return conexao.createStatement().executeUpdate(comandoUpdate) > 0;
                
            }catch(SQLException error){
                System.out.println("Erro no update(Object o, String cpfFuncionario) da Conta funcionário: "+ error.getMessage());
            }
        }            
        return false;
    }
    
    @Override
    public String alertaErro(Object o, String frase){
        if(o instanceof Conta_Funcionario){
            Conta_Funcionario especificarErro = (Conta_Funcionario) o;

            return especificarErro.getTitular().getNome() + " " + frase;
        }
        return "Erro";
    }    
    
    @Override
    public boolean login(String cpfLogin_Funcionario, String senhaLogin_Funcionario){
        
        String comandoSelect = "SELECT senhaFuncionario FROM jaboc_servidor.Conta_Funcionario "
                + "WHERE cpfFuncionario = '"+cpfLogin_Funcionario + "';";
        
        try{
         
            Connection conexao = this.conectar();
            ResultSet resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
            if(resultadoSelect.next()){
                String senhaFuncionario_FromSelect = resultadoSelect.getString("senhaFuncionario");
                
                return senhaFuncionario_FromSelect.equals(senhaLogin_Funcionario);
            }
        }catch(SQLException error){
            System.out.println("Errono login(String cpfLogin_Funcionario, String senhaLogin_Cliente) da ContaFuncionario: "+ error.getMessage());
        }
        
        return false;
    }
}
