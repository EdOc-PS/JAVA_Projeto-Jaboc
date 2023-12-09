/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados;

import jaboc_BancoDeDados.interfaces.Logavel;
import jaboc_UI.jabocUI_Utilidades.JabocUI_popUp.PopUp_inseriu;
import java.sql.*;
import jaboc_BancoDeDados.interfaces.ManipulandoDados;
import jaboc_Biblioteca.glasspanepopup.GlassPanePopup;
import jaboc_Classes.Login;
/**
 *
 * @author guilh
 */
public class AcessandoBD {
    
    public static void inserir(ManipulandoDados inserir, Object o){

        if(inserir.insert(o)){
            GlassPanePopup.showPopup(new PopUp_inseriu(inserir.alerta(o, " cadastrado com sucesso!")));
        }else{
            GlassPanePopup.showPopup(new PopUp_inseriu(inserir.alerta(o, " não foi cadastrado!")));
        }
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
    
    public static boolean login(Logavel logavel, Login alguemLogando){
        if(logavel.login(alguemLogando)){
         
            return true;
        }else{
            
            return false;
        }
    }
}
