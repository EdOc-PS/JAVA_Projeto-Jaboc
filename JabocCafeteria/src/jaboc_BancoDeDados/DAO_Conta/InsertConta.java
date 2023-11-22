/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.DAO_Conta;

import java.sql.*;
import java.sql.SQLException;
import jaboc_BancoDeDados.Conexao;
import jaboc_Classes.Conta;
import jaboc_Classes.Conta_Cliente;
import jaboc_Classes.Conta_Funcionario;

/**
 *
 * @author guilh
 */
public class InsertConta {
    /*Esse método é um auxiliar para o método de inserirConta, visto que ambas as Contas tem composicionalidade
    da classe Pessoa, sendo assim primeiro são inseridos dados da Pessoa na tabela no Banco de dados, para que depois
    essa seja referida por meio de uma chave estrangeiro a uma das possíveis duas Contas no banco.*/
    private static void insertPessoa(Conta conta, Connection conexao) throws SQLException{
        
        //Chamar o select por fora, para conferir!
        
        conexao.createStatement().executeUpdate("INSERT INTO jaboc_servidor.Pessoa (cpf, nome, endereco, telefone) VALUES ('"+
        conta.getTitular().getCpf() + "', '"+ conta.getTitular().getNome() + "', '"+ conta.getTitular().getEndereco()+
        "', '"+ conta.getTitular().getTelefone()+ "');");
        
    }
    
    /*Com base em um objeto Abstrato Conta enviado externamente, durante tempo de execução o compilador irá
    conferir se é uma instância de Conta_Cliente ou Conta_Funcionario, e partir de qual for irá inserir os dados
    na respectiva tabela no Banco de dados.*/
    public static void insertConta(Conta conta) throws SQLException{
        Connection conexao = Conexao.conectar();
        
        insertPessoa(conta, conexao);
        
        if(conta instanceof Conta_Funcionario){
            Conta_Funcionario contaF = (Conta_Funcionario) conta;
            
            conexao.createStatement().executeUpdate("INSERT INTO jaboc_servidor.Conta_Funcionario (cpfFuncionario, cargo, senhaFuncionario, salario) VALUES ('"+ 
            contaF.getTitular().getCpf() + "', '"+ contaF.getCargoFuncionario() + "', '"+ contaF.getSenha()+ "', '"+ contaF.getSalario()+ "');");
            
        }else {      
            Conta_Cliente contaC = (Conta_Cliente) conta;
            
            conexao.createStatement().executeUpdate("INSERT INTO jaboc_servidor.Conta_Cliente (cpfCliente, senhaCliente) VALUES '"+
            contaC.getTitular().getCpf() + "', '"+ contaC.getSenha()+ "');");
        }
    }
}
