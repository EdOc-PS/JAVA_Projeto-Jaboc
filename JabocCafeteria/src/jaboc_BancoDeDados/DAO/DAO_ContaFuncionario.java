/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO;

import jaboc_BancoDeDados.interfaces.Logavel;
import java.sql.*;
import jaboc_Classes.Conta_Funcionario;
import jaboc_BancoDeDados.interfaces.ManipulandoDados;
import jaboc_Classes.Login;
import jaboc_Classes.Pessoa;

/**
 *
 * @author guilh
 */
public class DAO_ContaFuncionario implements ManipulandoDados, Logavel{           
    private static Conta_Funcionario dadosFuncionario_emMemoria;
    
    @Override
    public ResultSet selectTodos(){
               
        String comandoSelect = "SELECT C.cpfFuncionario, C.senhaFuncionario, C.salario, C.cargo,P.nome, P.endereco, P.telefone FROM "
                    + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE  P.cpf = C.cpfFuncionario;";
        
        ResultSet resultadosSelect = null;
         
        try(Connection conexao = this.conectar()){
            
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
        
        try(Connection conexao = this.conectar()){
            
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
                  
            try(Connection conexao = this.conectar()){

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
        
        try(Connection conexao = this.conectar()){
            
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
        try(Connection conexao = this.conectar()){
                      
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
            
            try(Connection conexao = this.conectar()){
                
                return conexao.createStatement().executeUpdate(comandoUpdate) > 0;
                
            }catch(SQLException error){
                System.out.println("Erro no update(Object o, String cpfFuncionario) da Conta funcionário: "+ error.getMessage());
            }
        }            
        return false;
    }
    
    @Override
    public String alerta(Object o, String frase){
        if(o instanceof Conta_Funcionario){
            Conta_Funcionario especificarErro = (Conta_Funcionario) o;

            return especificarErro.getTitular().getNome() + " " + frase;
        }
        return "Erro";
    }    
    
    @Override
    public boolean login(Login funcionarioLogando){
        
        String comandoSelect = "SELECT senhaFuncionario FROM jaboc_servidor.Conta_Funcionario "
                + "WHERE cpfFuncionario = '"+ funcionarioLogando.getCPF() + "';";
        
        try(Connection conexao = this.conectar()){
         
            ResultSet resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
            if(resultadoSelect.next()){
                String senhaFuncionario_FromSelect = resultadoSelect.getString("senhaFuncionario");
                
                if(senhaFuncionario_FromSelect.equals(funcionarioLogando.getSENHA())){
                    this.armazenarEmMemoria_dadosContaLogada(funcionarioLogando);
                    return true;
                }else{
                    return false;
                }
            }
        }catch(SQLException error){
            System.out.println("Erro no login(Login funcionarioLogando) da ContaFuncionario: "+ error.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean existeCpf(String cpfFuncionario){
        String comandoSelect = "SELECT cpfFuncionario FROM jaboc_servidor.Conta_Funcionario "
                + "WHERE cpfFuncionario = '"+ cpfFuncionario + "';";
        
        try(Connection conexao = this.conectar()){
            ResultSet funcionarioExiste = conexao.createStatement().executeQuery(comandoSelect);
            return funcionarioExiste.next();
            
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro no existeCpf(Login funcionarioLogando) da ContaFuncionario: ");
            error.printStackTrace();
        }
        
        return false;
    }
    
    @Override
    public void armazenarEmMemoria_dadosContaLogada(Login funcionarioLogando){
        DAO_Pessoa dadosPessoa = new DAO_Pessoa();
        ResultSet selectPessoa = dadosPessoa.selectEspecifico(funcionarioLogando.getCPF());
        ResultSet selectContaFuncionario = this.selectEspecifico(funcionarioLogando.getCPF());
        
        try{
            String nomePessoa = selectPessoa.getString("nome");
            String cpfPessoa = selectPessoa.getString("cpf");
            String enderecoPessoa = selectPessoa.getString("endereco");
            String telefonePessoa = selectPessoa.getString("telefone");
            
            Pessoa dados_tabelaPessoaBD = new Pessoa(nomePessoa,cpfPessoa, enderecoPessoa, telefonePessoa);
            
            String cargoContaFuncionario = selectContaFuncionario.getString("cargoContaFuncionario");
            String senhaFuncionario = selectContaFuncionario.getString("senhaFuncionario");
            double salario = selectContaFuncionario.getDouble("salario");
            
            dadosFuncionario_emMemoria = new Conta_Funcionario(dados_tabelaPessoaBD, senhaFuncionario,  cargoContaFuncionario, salario);
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro no armazenarDadosLogin(login funcionarioLogando) da ContaFuncionario: ");
            error.printStackTrace();
        }
    }
}
