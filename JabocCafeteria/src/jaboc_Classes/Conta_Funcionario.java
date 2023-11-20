    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Conta_Funcionario {
    private int idFuncionario;
    private Pessoa titularFuncionario;
    private String senhaFuncionario;
    private String cargoFuncionario;
    private double salario;

    public Conta_Funcionario(int idFuncionario, Pessoa titularFuncionario, String senhaFuncionario, String cargoFuncionario, double salario){
        this.idFuncionario = idFuncionario;
        this.titularFuncionario = titularFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.salario = salario;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.idFuncionario = IdFuncionario;
    }

    public Pessoa getTitularFuncionario() {
        return titularFuncionario;
    }

    public void setTitularFuncionario(Pessoa titularFuncionario) {
        this.titularFuncionario = titularFuncionario;
    }

    public String getSenha() {
        return senhaFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario){
        this.cargoFuncionario = cargoFuncionario;
    }
    
    public String getCargoFuncionario(){
        return this.cargoFuncionario;
    }
    
    public void setSenha(String senha) {
        this.senhaFuncionario = senha;
    }
    
    public void setSalario(double salario){
        this.salario = salario;
    }
    
    public boolean verificarSenha(String senha){
        return senha.equals(this.senhaFuncionario);
    }  
    
    public String criptografaSenha(){
        String senhaCriptografada = "";
        for(int posChar = 0; posChar < this.senhaFuncionario.length(); posChar++){
            senhaCriptografada += '*';
        }
        return senhaCriptografada;
    }
    
    @Override
    public boolean equals(Object outraContaF){
        if(this == outraContaF){
            return true;
        }else if(this.getClass() != outraContaF.getClass()){
            return false;
        }else{
            Conta_Funcionario contaF = (Conta_Funcionario) outraContaF;
            return this.idFuncionario == contaF.idFuncionario;
        }
    }
    
    @Override
    public int hashCode(){
        return this.idFuncionario;
    }
       
    @Override
    public String toString(){
        return  this.titularFuncionario.toString() +
                "\nSenha: "+ this.criptografaSenha() +
                "\nSalário: R$"+ this.salario;
    }
}
