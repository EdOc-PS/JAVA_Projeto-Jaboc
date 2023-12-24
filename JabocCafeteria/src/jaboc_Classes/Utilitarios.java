/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author eeuar
 */
public class Utilitarios {
     public void InserirIcone(JFrame frm) {
        try {
            frm.setIconImage(Toolkit.getDefaultToolkit().getImage("src/img/logo5.png"));
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
