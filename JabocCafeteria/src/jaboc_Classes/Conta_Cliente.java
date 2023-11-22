/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Conta_Cliente extends Conta{
    private double gastoTotal;
    
    public Conta_Cliente (Pessoa titularCliente, String senhaCliente){
       super(titularCliente, senhaCliente);
       this.gastoTotal = 0.0;
    }
    
    public void setGastoTotal(double gastoTotal){
        this.gastoTotal = gastoTotal;
    }
    
    public double getGastoTotal(){
        return this.gastoTotal;
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "\nGasto Total: "+ this.gastoTotal;
    }
}
