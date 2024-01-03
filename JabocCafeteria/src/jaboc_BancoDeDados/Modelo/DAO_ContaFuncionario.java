/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import jaboc_BancoDeDados.Controle.Logavel;
import jaboc_BancoDeDados.Controle.SenhaEditavel;
import jaboc_Classes.Conta;
import jaboc_Classes.Conta_Funcionario;
import jaboc_Classes.Login;
import jaboc_Classes.Pessoa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class DAO_ContaFuncionario implements DAO, Logavel, SenhaEditavel{           
    private static Conta_Funcionario dadosFuncionario_emMemoria;
    
    @Override
    public ResultSet selectTodos(){
               
        String comandoSelect = "SELECT C.cpfFuncionario, C.senhaFuncionario, C.salario, C.cargo,P.nome, P.endereco, P.telefone FROM "
                    + "jaboc_servidor.Conta_Funcionario C, jaboc_servidor.Pessoa P WHERE  P.cpf = C.cpfFuncionario ORDER BY C.cargo;";
        
        ResultSet resultadosSelect = null;
         
        try(Connection conexao = this.conectar()){
            
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
            
        }catch(SQLException error){
                System.out.println("Erro no selectTodos() da Conta funcionário: "+ error.getMessage());
        }
        return resultadosSelect;
    }
    
    public List<Conta_Funcionario> listagem(){
        ResultSet todosFuncionarios = this.selectTodos();
        List<Conta_Funcionario> listaFuncionarios = new ArrayList<>();
        DAO_Pessoa daoPessoa = new DAO_Pessoa();
        
        try{
            while(todosFuncionarios.next()){
                String cpfPessoa = todosFuncionarios.getString("cpfFuncionario");
                String cargoFuncionario = todosFuncionarios.getString("cargo");
                double salario = todosFuncionarios.getDouble("salario");
                                
                ResultSet pessoaAtual = daoPessoa.selectEspecifico(cpfPessoa);
                pessoaAtual.next();
                
                String nomePessoa = pessoaAtual.getString("nome");
                String enderecoPessoa = pessoaAtual.getString("endereco");
                String telefonePessoa = pessoaAtual.getString("telefone");
                
                Pessoa objetoPessoa = new Pessoa(nomePessoa, cpfPessoa, enderecoPessoa, telefonePessoa);
                listaFuncionarios.add(new Conta_Funcionario(objetoPessoa,null,cargoFuncionario,salario));
                
               
            }    
            
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro na listagem() da Conta Funcionario: "+ error.getMessage());
        }
        
        return listaFuncionarios;
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

                boolean inseriu = conexao.createStatement().executeUpdate(comandoInsert) > 0;
                
                if(inseriu){
                    this.armazenarDados_Cadastro(inserirFuncionario);
                }
                
                return inseriu;
                     
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
        DAO_ContaCliente daoCliente = new DAO_ContaCliente();
        ResultSet funcionarioCliente = daoCliente.selectEspecifico(cpfFuncionario);
        String comandoDelete = "DELETE FROM jaboc_servidor.Conta_Funcionario WHERE cpfFuncionario = '"+cpfFuncionario+"'";
        
        try(Connection conexao = this.conectar()){
            boolean apagouFuncionario = conexao.createStatement().executeUpdate(comandoDelete) > 0;
            
            if(!funcionarioCliente.next()){
                comandoDelete = "DELETE FROM jaboc_servidor.Pessoa WHERE cpf = '"+ cpfFuncionario+"';";
                apagouFuncionario = conexao.createStatement().executeUpdate(comandoDelete) > 0;
            }
            
            return apagouFuncionario;
                   
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
    
    public boolean update_Administrador(Conta_Funcionario funcionarioEditado){
        
        String comandoUpdate = "UPDATE  jaboc_servidor.Conta_Funcionario SET "
                + "cargo = '"+funcionarioEditado.getCargoFuncionario()+ "', "
                + "salario = '"+ funcionarioEditado.getSalario()+"' "
                + "WHERE cpfFuncionario = '"+ funcionarioEditado.getTitular().getCpf()+"';";
        
        try(Connection conexao = this.conectar()){
        
            return conexao.createStatement().executeUpdate(comandoUpdate) > 0;
            
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro no update_Administrador(Conta_Funcionario funcionarioEditado) da Conta funcionário: "+ error.getMessage());
        }
        
        return false;
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
                    this.armazenarDados_Login(funcionarioLogando);
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
    public boolean verificarSenha(String senhaInformada){
        
        String comandoSelect = "SELECT senhaFuncionario FROM jaboc_servidor.Conta_Funcionario "
                + "WHERE cpfFuncionario = '"+ dadosFuncionario_emMemoria.getTitular().getCpf() + "';";
        
        try(Connection conexao = this.conectar()){
         
            ResultSet resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);
            
            if(resultadoSelect.next()){
                String senhaFuncionario_FromSelect = resultadoSelect.getString("senhaFuncionario");
                
                return senhaFuncionario_FromSelect.equals(senhaInformada);
            }
        }catch(SQLException error){
            System.out.println("Erro no login(Login funcionarioLogando) da ContaFuncionario: "+ error.getMessage());
        }
        
        return false;
    }
    
    @Override
    public boolean atualizarSenha(String novaSenha, String cpfFuncionario){
        
        String comandoUpdate = "UPDATE jaboc_servidor.Conta_Funcionario SET "
                + "senhaFuncionario = '"+ novaSenha +"' WHERE cpfFuncionario = '" +cpfFuncionario+ "';";
        
        try(Connection conexao = this.conectar()){
            return conexao.createStatement().executeUpdate(comandoUpdate) > 0;
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro no atualizarSenha(String novaSenha, String cpfFuncionario) da ContaFuncionario: ");
            error.printStackTrace();
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
    
    private void armazenarDados_Login(Login funcionarioLogando){
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
    
    private void armazenarDados_Cadastro(Conta funcionarioCadastrado){
        dadosFuncionario_emMemoria = (Conta_Funcionario) funcionarioCadastrado;
    }
    
    public static Conta_Funcionario getDadosCadastro(){
        return dadosFuncionario_emMemoria;
    }
    
    public static void limparDados_Memoria(){
        dadosFuncionario_emMemoria = null;
    }            
}
