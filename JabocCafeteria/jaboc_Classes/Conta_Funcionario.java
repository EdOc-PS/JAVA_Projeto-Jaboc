    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Conta_Funcionario extends Conta{
    
    private String cargoFuncionario;
    private double salario;

    public Conta_Funcionario(Pessoa titularFuncionario, String senhaFuncionario, String cargoFuncionario, double salario){
        super(titularFuncionario, senhaFuncionario);
        this.cargoFuncionario = cargoFuncionario;
        this.salario = salario;    
    }
    
    public void setCargoFuncionario(String cargoFuncionario){
        this.cargoFuncionario = cargoFuncionario;
    }
    
    public String getCargoFuncionario(){
        return this.cargoFuncionario;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public double getSalario(){
        return this.salario;
    }
   
    
    @Override
    public String toString(){
        return super.toString() +
                "\nCargo: "+ this.cargoFuncionario +
                "\nSalário: R$"+ this.salario;
    }
}
