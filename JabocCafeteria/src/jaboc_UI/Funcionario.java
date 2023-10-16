/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author eeuar
 */
public class Funcionario {

    private String nomeFuncionario;
    private String cpfFuncionario;
    private String enderecoFuncionario;
    private String telefoneFuncionario;
    private String cargoFuncionario;

    public Funcionario(String nomeFuncionario, String cpfFuncionario, String enderecoFuncionario, String telefoneFuncionario, String cargoFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cargoFuncionario = cargoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }
    
    public String toString() {
        return "\nNome: "+ this.nomeFuncionario +"\nCPF: "+ this.cpfFuncionario + "\nEndereço: "+this.enderecoFuncionario+ "\nTelefone: "+ this.telefoneFuncionario+ "\nCargo: "+ this.cargoFuncionario;
    }
      
}
