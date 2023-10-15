    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Conta_Funcionario {
    private int idFuncionario;
    private Funcionario titularFuncionario;
    private String senhaFuncionario;

    public Conta_Funcionario(int idFuncionario, Funcionario titularFuncionario, String senhaFuncionario){
        this.idFuncionario = idFuncionario;
        this.titularFuncionario = titularFuncionario;
        this.senhaFuncionario = senhaFuncionario;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.idFuncionario = IdFuncionario;
    }

    public Funcionario getTitularFuncionario() {
        return titularFuncionario;
    }

    public void setTitularFuncionario(Funcionario titularFuncionario) {
        this.titularFuncionario = titularFuncionario;
    }

    public String getSenha() {
        return senhaFuncionario;
    }

    public void setSenha(String senha) {
        this.senhaFuncionario = senha;
    }
    
    
    
}
