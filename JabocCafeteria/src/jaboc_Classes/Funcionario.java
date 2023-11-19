/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author eeuar
 */
public class Funcionario extends Pessoa{

    private String cargoFuncionario;
    
    public Funcionario(String nomeFuncionario, String cpfFuncionario, String enderecoFuncionario, String telefoneFuncionario, String cargoFuncionario) {
        super(nomeFuncionario, cpfFuncionario, enderecoFuncionario, telefoneFuncionario);
    }
    public Funcionario(String nomeFuncionario, String cpfFuncionario , String cargoFuncionario){
        super(nomeFuncionario, cpfFuncionario);
        this.cargoFuncionario = cargoFuncionario;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nCargo : "+ this.cargoFuncionario;
    }
      
}
