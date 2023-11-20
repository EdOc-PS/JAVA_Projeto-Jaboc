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

    public Conta_Funcionario(int idFuncionario, Pessoa titularFuncionario, String senhaFuncionario, String cargoFuncionario, double salario){
        super(idFuncionario, titularFuncionario, senhaFuncionario);
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
       
    @Override
    public boolean equals(Object outraConta){
        if(this == outraConta){
            return true;
        }else if(this.getClass() != outraConta.getClass()){
            return false;
        }else{
            Conta_Funcionario contaF = (Conta_Funcionario) outraConta;
            return this.getIdConta() == contaF.getIdConta();
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
                "\nSalário: R$"+ this.salario;
    }
}
