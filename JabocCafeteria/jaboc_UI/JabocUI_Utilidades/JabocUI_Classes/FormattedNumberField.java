/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_Classes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author guilh
 */
public class FormattedNumberField extends JFormattedTextField{
    private int contCliques;
    private String numeroAtual;
    
    public FormattedNumberField(){
        
        this.setOpaque(false);
        this.setBorder(new EmptyBorder(1, 3, 1, 3));
        this.setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        this.setForeground(new Color(153, 153, 153));
        this.setBackground(new Color(255,255,255));
        
        this.setFormatterFactory(new DefaultFormatterFactory(this.setFormatadorNumerico()));
        this.contCliques = 1;
        
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                            
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] char_textoAtual = getText().toCharArray();
                
                for(int posTexto = 0;posTexto < char_textoAtual.length;posTexto++){
                    if(char_textoAtual[posTexto] == '.'){
                        char_textoAtual[posTexto]=  ',';
                    }else if(char_textoAtual[posTexto] == ','){
                        char_textoAtual[posTexto]=  '.';
                    }   
                }
                
                String textoAtual = String.valueOf(char_textoAtual);
                numeroAtual = textoAtual;
            }
        });          
    }
    
    public double formatarDouble(){
        double numeroFormatado = 0;
        
        try{
            numeroFormatado = Double.parseDouble(numeroAtual);
        }catch(NumberFormatException error){
            System.out.println(error.getMessage());
        }  
        
        return numeroFormatado;
    }
    
    private NumberFormatter setFormatadorNumerico(){
        DecimalFormat formatadorDecimal = new DecimalFormat();
        formatadorDecimal.setMinimumFractionDigits(2);
        formatadorDecimal.setMaximumFractionDigits(2);
        formatadorDecimal.setDecimalSeparatorAlwaysShown(true);
        formatadorDecimal.setGroupingSize(0);
        NumberFormatter formatadorNumerico = new NumberFormatter(formatadorDecimal);
        formatadorNumerico.setAllowsInvalid(false);
             
        return formatadorNumerico;
    }
}
