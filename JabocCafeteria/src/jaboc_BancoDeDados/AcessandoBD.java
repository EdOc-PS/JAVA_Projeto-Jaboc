/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados;

import jaboc_BancoDeDados.interfaces.ComandosSQL;
import jaboc_BancoDeDados.interfaces.Logavel;

/**
 *
 * @author guilh
 */
public class AcessandoBD {
    
    public static boolean inserir(ComandosSQL inserir, Object o){
        
        return inserir.insert(o);
    }
    
    public static boolean login(Logavel logavel){
        return logavel.login(cpf, senha);
    }
}
