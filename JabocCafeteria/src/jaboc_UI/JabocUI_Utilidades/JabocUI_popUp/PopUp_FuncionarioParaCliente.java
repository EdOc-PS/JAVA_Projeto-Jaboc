/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_UI.JabocUI_Utilidades.JabocUI_popUp;


import jaboc_UI.jabocUI_Utilidades.ButtonCirculo;
import java.awt.Color;
import static java.awt.Dialog.ModalityType.DOCUMENT_MODAL;
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

/**
 *
 * @author guilh
 */

//Criando uma classe para o di�logo 
public final class PopUp_FuncionarioParaCliente extends javax.swing.JDialog{
    private boolean criarConta = false;
    private final JLabel titulo = new JLabel("Pessoa já possui conta funcionário!");
    private final JLabel mensagem = new JLabel("Deseja criar uma nova conta de Cliente? ");
    private final JPanel separador = new JPanel();
    private final ButtonCirculo simBotao = new ButtonCirculo();
    private final ButtonCirculo naoBotao = new ButtonCirculo();
    private final JPanel painelTotal = new JPanel();
    private final int largura;
    private final int altura;
    
    
    public PopUp_FuncionarioParaCliente(Frame pai){
        
        super(pai);
        this.setTitle("Aviso: ");
        this.add(painelTotal);
        this.estilizarPainelTotal();
        //Fazendo com que o tamanho do meuJDialog seja do tamanho do Jpainel
        this.pack();
        //Seta meu JDialog no centro do JFrame pai
        this.setLocationRelativeTo(pai);
      
        this.largura = painelTotal.getWidth();
        this.altura = painelTotal.getHeight();
        
        painelTotal.add(this.titulo);
        this.estilizarTitulo();
        
        painelTotal.add(separador);
        this.estilizarSeparador();
        
        painelTotal.add(mensagem);
        this.estilizarMensagem();

        painelTotal.add(this.simBotao);
        this.estilizarSimBotao();
        
        painelTotal.add(this.naoBotao);
        this.estilizarNaoBotao();
        
        
        /*Adicionando um evento de clique ao meu botão SIM - Composicionalidade
        Como se eu estivesse dentro da classe JButton*/
        this.simBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                criarConta = true;
                //Pegando a classe pai do botão SIM
                PopUp_FuncionarioParaCliente.this.setVisible(false);
            }
        });
        
        this.naoBotao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Pegando a classe pai do botão Não
                 PopUp_FuncionarioParaCliente.this.setVisible(false);
            }
        });        
        this.setModalityType(DOCUMENT_MODAL ); 
        this.setVisible(true);
    } 
    
    public boolean getRespostaDialogo(){
        return this.criarConta;
    }
    
    public void estilizarPainelTotal(){
        //Setando o tamanho do meupainel
        painelTotal.setPreferredSize(new Dimension(300, 150));
        painelTotal.setBackground(new Color(252,252,252));
        painelTotal.setLayout((null));
    }    
    
    public void estilizarTitulo(){
        try{
            //Talvez o arquivo não exista!
            Image imagem = ImageIO.read(new File("C:\\Users\\guilh\\OneDrive\\Documentos\\NetBeansProjects\\poo\\src\\CriandoJDialog\\i_malaFuncionario.png"));
            Icon icone = new ImageIcon(imagem);
            this.titulo.setIcon(icone);
        }catch(IOException error){
            System.out.println("Imagem n�o encontrada!");
        }
        this.titulo.setBounds(largura - 270, altura - 150, 230,20);
    }
    
    public void estilizarSeparador(){
        separador.setBackground(new Color(218,218,218));
        separador.setBounds(0, 30, largura, 5);
    }
    
    public void estilizarMensagem(){
        mensagem.setForeground(new Color(79, 84, 101));
        mensagem.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        mensagem.setBounds(largura - 280, altura - 100,280,20);
    }
    
    public void estilizarSimBotao(){
        this.simBotao.setBorder(null);
        this.simBotao.setText("SIM");
        this.simBotao.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
        this.simBotao.setForeground(Color.white);
        this.simBotao.setBackground(new Color(188, 226, 158));
        this.simBotao.setBounds(largura - 280, altura - 45, 70, 25);
    }
    
    public void estilizarNaoBotao(){
        this.naoBotao.setBorder(null);
        this.naoBotao.setText("NãO");
        this.naoBotao.setFont(new Font("Gill Sans MT", Font.BOLD, 13));
        this.naoBotao.setForeground(Color.white);
        this.naoBotao.setBackground(new Color(255, 128, 128));
        this.naoBotao.setBounds(largura - 90, altura - 45, 70, 25);       
    }
}
