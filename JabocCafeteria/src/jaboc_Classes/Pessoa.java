/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    
    public Pessoa(String nome, String cpf, String endereco, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = null;
        this.telefone = null;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getEndereco(){
        return this.endereco;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    @Override
    public boolean equals(Object outraPessoa){
        if(this == outraPessoa){
            return true;
        }else if(this.getClass() != outraPessoa.getClass()){
            return false;
        }else{
            Pessoa P = (Pessoa) outraPessoa;
            return this.cpf.equals(P.cpf);
        }
    }
    
    @Override
    public int hashCode(){
        return this.cpf.hashCode();
    }
    
    @Override
    public String toString(){
        return "Nome: "+ this.nome +
                "\nCPF: "+ this.cpf +
                "\nEndereço: "+ this.endereco +
                "\nTelefone: "+ this.telefone;
    }
}
