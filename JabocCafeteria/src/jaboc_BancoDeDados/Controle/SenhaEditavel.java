/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jaboc_BancoDeDados.Controle;

/**
 *
 * @author guilh
 */
public interface SenhaEditavel {
    public boolean verificarSenha(String cpfConta);
    public boolean atualizarSenha(String novaSenha, String cpfConta);
}
