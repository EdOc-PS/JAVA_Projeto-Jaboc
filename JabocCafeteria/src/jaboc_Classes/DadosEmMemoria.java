/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author guilh
 */
public class DadosEmMemoria {
    //Variável constante
    private static Conta_Cliente CONTA_CLIENTE_CORRENTE = null;
    private static String descCarrinho = null;
    
    public static void setCONTA_CLIENTE(Conta_Cliente contaC){
        if(CONTA_CLIENTE_CORRENTE == null){
            CONTA_CLIENTE_CORRENTE = contaC;
        }   
    }
    
    public static Conta_Cliente getCONTA_CLIENTE(){
        return CONTA_CLIENTE_CORRENTE;
    }
    
    public void acrescentarCarrinho(String nomeProduto, int qtde, double preco){
        descCarrinho += nomeProduto + " Quantidade: "+ qtde + "Sub-total: "+ (qtde * preco) +"\n";
    }
    
    public String getDescCarrinho(){
        return descCarrinho;
    }
}
