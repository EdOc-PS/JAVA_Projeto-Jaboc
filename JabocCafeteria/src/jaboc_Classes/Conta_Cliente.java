/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Conta_Cliente {
    private int IdCliente;
    private Cliente titularCliente;
    private String senha;
    private boolean contaAtiva;
    
    public Conta_Cliente(int IdCliente, Cliente titular, String senha, boolean contaAtiva){
        this.IdCliente = IdCliente;
        this.titularCliente = titular;
        this.senha = senha;
        this.contaAtiva = contaAtiva;
    }

    public boolean isContaAtiva() {
        return this.contaAtiva;
    }

    public void setContaAtiva(boolean contaAtiva) {
        this.contaAtiva = contaAtiva;
    }

    public int getIdCliente() {
        return this.IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Cliente getTitular() {
        return this.titularCliente;
    }

    public void setTitular(Cliente titular) {
        this.titularCliente = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean verificaSenha(String senha){
        return senha.equals(this.senha);
    } 
    
    public boolean verificaCPF(String CPF){
        return CPF.equals(this.titularCliente.getCpf());    
    }
    
    public boolean verificarSenha(String senha, String verificarSenha){
        return (senha.equals(verificarSenha) && !senha.equals(""));
    }
}
