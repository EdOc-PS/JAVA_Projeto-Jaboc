/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados;

import jaboc_BancoDeDados.interfaces.Logavel;
import jaboc_BancoDeDados.interfaces.ManipulandoDados;
import jaboc_Classes.Login;
import jaboc_UI.JabocUI_Utilidades.JabocUI_popUp.PopUp_inseriuItem;
import jaboc_UI.JabocUI_Utilidades.JabocUI_popUp.PopUp_login;
import java.awt.Frame;
import raven.glasspanepopup.GlassPanePopup;
/**
 *
 * @author guilh
 */
public class AcessandoBD {
    
    public static void inserir( ManipulandoDados inserir, Object o){
        String mensagem;
        if(inserir.insert(o)){
            mensagem = "Cadastro efetuado com sucesso!";
        }else{
            mensagem = "Houve um erro no cadastro!";
        }
        
        PopUp_inseriuItem inseriu = new PopUp_inseriuItem(null, mensagem);
        inseriu.setVisible(true);
    }
    
    public static <T>boolean existeRegistro(ManipulandoDados existe, T param){
        if(!existe.existeRegistro(param)){
            
            return false;
        }
        
        return true;
    }       
    
    public static <T> boolean delete(ManipulandoDados apagar, T param){
        if(apagar.delete(param)){
            GlassPanePopup.showPopup(new PopUp_inseriu(apagar.alerta(param, " foi apagado!")));
            return true;
        }else{
            GlassPanePopup.showPopup(new PopUp_inseriu(apagar.alerta(param, " não foi apagado!")));
            return false;
        }
    }
    
    public static <T> boolean update(ManipulandoDados atualizar, Object o, T param){
        if(atualizar.update(o, param)){
            
            return true; 
       }else{
            return false;
        }
    }
    
    public static boolean login(Frame pai, Logavel logavel, Login alguemLogando){
        String mensagemLogin;
        boolean logou = false;
        if(!logavel.existeCpf(alguemLogando.getCPF())){
            mensagemLogin = "CPF não encontrado!";
        }else if(logavel.login(alguemLogando)){
            mensagemLogin = "Login efetuado com sucesso!";
            logou = true;
        }else{
            mensagemLogin = "Senha incorreta!";
        }
        
        PopUp_login logouPopUp = new PopUp_login(null, mensagemLogin);
        logouPopUp.setVisible(true);
        return logou;
    }
}
