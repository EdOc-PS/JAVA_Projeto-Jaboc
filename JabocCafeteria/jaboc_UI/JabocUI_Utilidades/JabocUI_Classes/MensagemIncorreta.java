/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_Classes;

/**
 *
 * @author guilh
 */
public class MensagemIncorreta extends IllegalStateException{
    private String mensagemErro;
    
    public MensagemIncorreta(String mensagemErro){
        this.mensagemErro = mensagemErro;
    }
    
    @Override
    public String toString(){
        return "Parâmetro de mensagem passado incorretamente para a interface\n"+
               "Parâmetros esperadas: "+ this.mensagemErro;
    }
}
