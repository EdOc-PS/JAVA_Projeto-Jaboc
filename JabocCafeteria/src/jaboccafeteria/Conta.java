/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboccafeteria;

/**
 *
 * @author guilh
 */
public class Conta {
    private int IdCliente;
    private Cliente titular;
    private String senha;
    
    public Conta(int IdCliente, Cliente titular, String senha){
        this.IdCliente = IdCliente;
        this.titular = titular;
        this.senha = senha;
    }

    public int getIdCliente() {
        return this.IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Cliente getTitular() {
        return this.titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean verificaSenha(String senha){
        if(senha.equals(this.senha)){
            return true;
        }else{
            return false;
        }
    }    
    public boolean verificaCPF(String CPF){
        if(CPF.equals(this.titular.getCpfCliente())){
            return true;
        }else{
            return false;
        }    
    }
}
