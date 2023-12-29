/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_Classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author eeuar
 */
public class FormattedTextField extends JFormattedTextField{
    String arm;
    int cont = 1;
    MaskFormatter maskF;
    String form;
    public FormattedTextField() {

        setOpaque(false);
        setBorder(new EmptyBorder(1, 3, 1, 3));
        setFont(new java.awt.Font("Gill Sans MT", 0, 14));
        setForeground(new Color(153, 153, 153));
        setBackground(new Color(255,255,255));
      
        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (cont == 1) {
                    arm = getText();
                    cont++;
                }
                if (getText().equals(arm)) {
                     try {
                        setText("");
                        maskF.install(FormattedTextField.this);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String dadoEscrito = getText();
                int contMaskAtual = FormattedTextField.this.setContPlaceHolder(dadoEscrito);
                                
                if (contMaskAtual > 0) {                   
                    maskF.uninstall();
                    setText(arm);
                }
            }
        });

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));

        g2.dispose();

        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    public int setContPlaceHolder(String maskFormat){
        int contPlaceHolder = 0;
        char[] mascara = maskFormat.toCharArray();
        
        for(char formatacao: mascara){
            if(formatacao == '_'){
                contPlaceHolder++;
            }
        }
        return contPlaceHolder;
    }
    
    public void addFormatacao(String formato){
        try{
            
            maskF = new MaskFormatter(); 
            maskF.setMask(formato);    
            maskF.setPlaceholderCharacter('_');
            form = formato;
            
        }catch(ParseException error){
            System.out.println("Erro ao definir a máscara:"+ "("+ formato +")" + error.getMessage());
        }
    }
    
    public void removerFormatacao(){
        this.maskF.uninstall();
    }
}
