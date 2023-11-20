/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public final class Conta_Cliente extends Conta{
    
    private double gastoTotal;
    
    public Conta_Cliente(int idCliente, Pessoa titular, String senha){
        super(idCliente, titular, senha);
        this.gastoTotal = 0;
    }    
    
    public void setGastoTotal(double gastoTotal){
        this.gastoTotal = gastoTotal;
    }
    
    public double getGastoTotal(){
        return this.gastoTotal;
    }    
    
    @Override
    public boolean equals(Object outraConta){
        if(this == outraConta){
            return true;
        }else if(this.getClass() != outraConta.getClass()){
            return false;
        }else{
            Conta_Cliente contaC = (Conta_Cliente) outraConta;
            return this.getIdConta() == contaC.getIdConta();
        }
    }
    
    @Override
    public int hashCode(){
        return this.getIdConta();
    }
    
    @Override
    public String toString(){
        return  super.getTitular().toString() +
                "\nSenha: "+ this.criptografaSenha() +
                "\nGasto total: R$"+ this.gastoTotal;
    }
}
