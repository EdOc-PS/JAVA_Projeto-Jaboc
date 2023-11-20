/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author 0057113
 */
public abstract class Conta {
    private int idConta;
    private Pessoa titular;
    private String senha;
    
    public Conta(int idConta, Pessoa titular, String senha){
        this.idConta = idConta;
        this.titular = titular;
        this.senha = senha;
    }
    
    public int getIdConta(){
        return this.idConta;
    }
    
    public Pessoa getTitular(){
        return this.titular;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public boolean verificarSenha(String senha){
        return senha.equals(this.senha);
    }  
    
    public boolean verificaCPF(String CPF){
        return CPF.equals(this.titular.getCpf());    
    }
    
    public String criptografaSenha(){
        String senhaCriptografada = "";
        for(int posChar = 0; posChar < this.senha.length(); posChar++){
            senhaCriptografada += '*';
        }
        return senhaCriptografada;
    }    
}
