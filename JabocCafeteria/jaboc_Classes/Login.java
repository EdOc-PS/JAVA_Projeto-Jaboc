/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Login {
    private final String CPF;
    private final String SENHA;
    
    public Login(String cpf, String senha){
        this.CPF = cpf;
        this.SENHA = senha;
    }
    
    public String getCPF(){
        return this.CPF;
    }
    
    public String getSENHA(){
        return this.SENHA;
    }
}
