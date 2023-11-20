/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public final class Conta_Cliente {
    private int IdCliente;
    private Pessoa titularCliente;
    private String senha;
    private double gastoTotal;
    
    public Conta_Cliente(int IdCliente, Pessoa titular, String senha){
        this.IdCliente = IdCliente;
        this.titularCliente = titular;
        this.senha = senha;
        this.gastoTotal = 0;
    }

    public int getIdCliente() {
        return this.IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Pessoa getTitular() {
        return this.titularCliente;
    }

    public void setTitular(Pessoa titularCliente) {
        this.titularCliente = titularCliente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setGastoTotal(double gastoTotal){
        this.gastoTotal = gastoTotal;
    }
    
    public double getGastoTotal(){
        return this.gastoTotal;
    }
    
    public boolean verificaCPF(String CPF){
        return CPF.equals(this.titularCliente.getCpf());    
    }
    
    public boolean verificaSenha(String senha){
        return senha.equals(this.senha);
    } 
    
    public String criptografaSenha(){
        String senhaCriptografada = "";
        for(int posChar = 0; posChar < this.senha.length(); posChar++){
            senhaCriptografada += '*';
        }
        return senhaCriptografada;
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\nSenha: "+ this.criptografaSenha() +
                "\nGasto total: "+ this.gastoTotal;
    }
}
