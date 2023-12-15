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
public final class PopUp_login extends JDialog {

    private final JPanel painelTotal = new JPanel();
    private final JLabel mensagem = new JLabel();
    private final JLabel icone = new JLabel();
    private final ButtonCirculo sairBotao = new ButtonCirculo();
    private final int largura;
    private final int altura;
    private String mensagemErro;

    public PopUp_login(Frame pai, String mensagemErro) {
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

        this.sairBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PopUp_login.this.dispose();
            }
        });
        //Parando a execução enquanto o JDialog não for fechado
        this.setModal(true);
    }

    public void estilizarPainelTotal() {
        this.painelTotal.setPreferredSize(new Dimension(360, 175));
        this.painelTotal.setBackground(new Color(252, 252, 252));
        this.painelTotal.setLayout(null);
    }

    public void confereMensagem(String conferirMensagem) {
        String cpfInexistente = "CPF não encontrado!";
        String erroSenha = "Senha incorreta!";
        String logou = "Login efetuado com sucesso!";

        if (!conferirMensagem.equals(logou) && !conferirMensagem.equals(erroSenha) && !conferirMensagem.equals(cpfInexistente)) {
            try {
                throw new MensagemIncorreta(cpfInexistente + " | " + erroSenha + " | " + logou);
            } catch (MensagemIncorreta erro) {
                erro.printStackTrace();
            }

            this.mensagemErro = "Parâmetro não está correto!";
        } else {
            this.mensagemErro = conferirMensagem;
        }
    }

    public void estilizarMensagem() {
        this.mensagem.setText(this.mensagemErro);

        if (this.mensagemErro.equals("CPF não encontrado!")) {
            this.mensagem.setBounds(this.largura - 230, this.altura - 130, 230, 20);
        } else if (this.mensagemErro.equals("Senha incorreta!")) {
            this.mensagem.setBounds(this.largura - 210, this.altura - 130, 210, 20);
        } else {
            this.mensagem.setBounds(this.largura - 260, this.altura - 120, 260, 20);
        }
        this.mensagem.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
        this.mensagem.setForeground(new Color(79, 84, 101));
    }

    public void estilizarIcone() {

        try {
            Image imagemLida = null;
            if (this.mensagemErro.equals("CPF não encontrado!")) {
                imagemLida = ImageIO.read(new File("src/img/icons/i_cpfInexistente.png"));

            } else if (this.mensagemErro.equals("Senha incorreta!")) {
                imagemLida = ImageIO.read(new File("src/img/icons/i_senhaIncorreta.png"));

            } else if (this.mensagemErro.equals("Login efetuado com sucesso!")) {
                imagemLida = ImageIO.read(new File("src/img/icons/i_loginSucesso.png"));

            } else {
                imagemLida = ImageIO.read(new File("src/img/icons/i_404.png"));
            }
            Icon iconeMais = new ImageIcon(imagemLida);
            this.icone.setIcon(iconeMais);
            this.icone.setBounds(this.largura - 180, this.altura - 90, 180, 60);

        } catch (IOException error) {
            System.out.println("Imagem não encontrado: ");
            error.printStackTrace();
        }
    }

    public void estilizarSairBotao() {
        this.sairBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/x.png")));
        this.sairBotao.setBackground(new Color(255, 128, 128));
        this.sairBotao.setBounds(largura - 35, altura - 165, 27, 27);
    }

}
