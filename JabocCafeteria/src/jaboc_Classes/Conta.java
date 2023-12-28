/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public abstract class Conta {
    private Pessoa titular;
    private String senha;
    
    public Conta(Pessoa titular, String senha){
        this.titular = titular;
        this.senha = senha;
    }   
    
    public void setTitular(Pessoa titular){
        this.titular = titular;
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
    
    @Override
    public boolean equals(Object outroObjeto){
        if(this == outroObjeto){
            return true;
        }else if(this.getClass() != outroObjeto.getClass()){
            return false;
        }else{
            Conta outraConta = (Conta) outroObjeto;
            return this.getTitular().getCpf().equals(outraConta.getTitular().getCpf());
        }
    }
    
    @Override
    public int hashCode(){
        return this.getTitular().hashCode();
    }
    
    @Override
    public String toString(){
        return this.titular.toString() +
                "\nSenha: "+ this.criptografaSenha();
    }
}
