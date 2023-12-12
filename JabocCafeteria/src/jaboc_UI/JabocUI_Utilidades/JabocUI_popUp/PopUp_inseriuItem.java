/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_popUp;

import jaboc_UI.JabocUI_Utilidades.JabocUI_Classes.MensagemIncorreta;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jaboc_UI.jabocUI_Utilidades.ButtonCirculo;
import java.awt.Color;
import javax.swing.JDialog;

/**
 *
 * @author guilh
 */
public final class PopUp_inseriuItem extends JDialog{
    private final JPanel painelTotal = new JPanel();
    private final JLabel mensagem = new JLabel();
    private final JLabel icone = new JLabel();
    private final ButtonCirculo sairBotao = new ButtonCirculo();
    private final int largura;
    private final int altura;
    private String mensagemErro;
    
    public PopUp_inseriuItem(Frame pai, String mensagemErro){
        super(pai);
        
        this.confereMensagem(mensagemErro);
        
        //Retira a borda dejanela da aplicação
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        
        this.add(this.painelTotal);
        this.estilizarPainelTotal();
        
        this.pack();
        this.setLocationRelativeTo(pai);
        
        this.largura = this.painelTotal.getWidth();
        this.altura = this.painelTotal.getHeight();
        
        this.painelTotal.add(this.mensagem);
        this.estilizarMensagem();
        
        this.painelTotal.add(this.icone);
        this.estilizarIcone();
        
        this.painelTotal.add(this.sairBotao);
        this.estilizarSairBotao();
        
        this.sairBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                PopUp_inseriuItem.this.dispose();
            }
        });
        //Parando a execução enquanto o JDialog não for fechado
        this.setModal(true);
    }
    
    public void estilizarPainelTotal(){
        this.painelTotal.setPreferredSize(new Dimension(400, 200));
        this.painelTotal.setBackground(new Color(252, 252, 252));
        this.painelTotal.setLayout(null);
    }
    
    public void confereMensagem(String conferirMensagem){
        String cadastrou = "Cadastro efetuado com sucesso!";
        String erroCadastro = "Houve um erro no cadastro!";
        
        if(!conferirMensagem.equals(cadastrou) && !conferirMensagem.equals(erroCadastro)){
            try{
                throw new MensagemIncorreta(cadastrou +" | "+ erroCadastro);
            }catch(MensagemIncorreta erro){
                erro.printStackTrace();
            }
            
            this.mensagemErro = "Parâmetro não está correto!";
        }else{
            this.mensagemErro = conferirMensagem;
        }
    }
    
    public void estilizarMensagem(){
        this.mensagem.setText(this.mensagemErro);
        
        if(this.mensagemErro.equals("Cadastro efetuado com sucesso!")){
            this.mensagem.setBounds(this.largura - 320, this.altura - 170, 320, 20);
        }else{
            this.mensagem.setBounds(this.largura - 300, this.altura - 170, 300, 20);
        }
        this.mensagem.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
        this.mensagem.setForeground(new Color(79, 84, 101));      
    }
    
    public void estilizarIcone(){
        
        try{
            Image imagemLida = null;
            if(this.mensagemErro.equals("Cadastro efetuado com sucesso!")){
                imagemLida = ImageIO.read(new File("src/img/icons/i_mais.png"));
                
            }else if(this.mensagemErro.equals("Houve um erro no cadastro!")){
                imagemLida = ImageIO.read(new File("src/img/icons/i_erro.png"));
                
            }else{
                imagemLida = ImageIO.read(new File("src/img/icons/i_404.png"));
            }
            Icon iconeMais = new ImageIcon(imagemLida);
            this.icone.setIcon(iconeMais);
            this.icone.setBounds(this.largura - 240, this. altura - 130, 240,60);
            
        }catch(IOException error){
            System.out.println("Imagem não encontrado: ");
            error.printStackTrace();
        }
    }
    
    public void estilizarSairBotao(){
        this.sairBotao.setText("X");
        this.sairBotao.setBorder(null);
        this.sairBotao.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
        this.sairBotao.setForeground(Color.white);
        this.sairBotao.setBackground(new Color(255, 128, 128));
        this.sairBotao.setBounds(largura - 50, altura - 190, 40, 25);
    }
       
}
