/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class Cliente extends Pessoa{

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        super(nome, cpf, endereco, telefone);  
    }       

    @Override
    public String toString() {
        return super.toString();
    }
}
