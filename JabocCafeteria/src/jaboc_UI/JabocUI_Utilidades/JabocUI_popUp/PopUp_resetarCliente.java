/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_popUp;

import jaboc_UI.jabocUI_Utilidades.ButtonCirculo;
import java.awt.Color;
import static java.awt.Dialog.ModalityType.APPLICATION_MODAL;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author guilh
 */
public class PopUp_resetarCliente extends JDialog{
    private JPanel painelTotal = new JPanel();
    int largura = this.painelTotal.getWidth();
    int altura = this.painelTotal.getHeight();
    
    private JLabel mensagemAviso = new JLabel("Deseja realmente sair?");
    private JLabel icone = new JLabel();
    private ButtonCirculo simBotao = new ButtonCirculo();
    private ButtonCirculo naoBotao = new ButtonCirculo();
    
    boolean respostaDialogo = false;
    
    public PopUp_resetarCliente(){
        this.setTitle("Aviso: ");
        
        this.add(painelTotal);         
        this.estilizarPainelTotal();
        this.pack();
        largura = this.painelTotal.getWidth();
        altura = this.painelTotal.getHeight();       
                
        
        this.setLocationRelativeTo(null);
        
        this.painelTotal.add(this.icone);
        this.adicionarIcone();
        
        this.painelTotal.add(this.mensagemAviso);
        this.estilizarMensagemAviso();
        
        this.painelTotal.add(this.simBotao);
        this.estilizarSimBotao();
        
        this.painelTotal.add(this.naoBotao);
        this.estilizarNaoBotao();
        
        this.simBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PopUp_resetarCliente.this.respostaDialogo = true;
                //Pegando a classe pai do botão SIM
                PopUp_resetarCliente.this.setVisible(false);
            }
        });
        
        this.naoBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Pegando a classe pai do botão Não
                 PopUp_resetarCliente.this.setVisible(false);
            }
        });

        
        this.setModalityType(APPLICATION_MODAL);
        this.setVisible(true);
    }
    
    public boolean getRespostaDialogo(){
        return this.respostaDialogo;
    }
    
    private void estilizarPainelTotal(){
        this.painelTotal.setPreferredSize(new Dimension(300, 180));
        this.painelTotal.setBackground(new Color(252,252,252));
        this.painelTotal.setLayout(null);
    }
    
    private void adicionarIcone(){
        try{
            //Talvez o arquivo não exista! // não existe mesmo jaba!
            Image imagem = ImageIO.read(new File("src\\img\\icons\\i_logout.png"));
            Icon icone = new ImageIcon(imagem);
            this.icone.setIcon(icone);
            this.icone.setBounds(largura - 180, altura - 150, 200, 60);
        }catch(IOException error){
            System.out.println("Imagem n�o encontrada!");
        }  
    }    
    
    private void estilizarMensagemAviso(){
        this.mensagemAviso.setForeground(new Color(79, 84, 101));
        this.mensagemAviso.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        this.mensagemAviso.setBounds(largura - 220, altura - 130,240,20);
    }
    
    private void estilizarSimBotao(){
        this.simBotao.setBorder(null);
        this.simBotao.setText("SIM");
        this.simBotao.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        this.simBotao.setForeground(Color.white);
        this.simBotao.setBackground(new Color(188, 226, 158));
        this.simBotao.setBounds(largura - 280, altura - 55, 70, 35);
    }
    
    private void estilizarNaoBotao(){
        this.naoBotao.setBorder(null);
        this.naoBotao.setText("NÃO");
        this.naoBotao.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
        this.naoBotao.setForeground(Color.white);
        this.naoBotao.setBackground(new Color(255, 128, 128));
        this.naoBotao.setBounds(largura - 90, altura - 55, 70, 35);       
    }
}
