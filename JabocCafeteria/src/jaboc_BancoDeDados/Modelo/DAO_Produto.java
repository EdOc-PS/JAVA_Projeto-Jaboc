/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.Modelo;

import com.sun.jdi.connect.spi.Connection;
import jaboc_Classes.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eeuar
 */
public class DAO_Produto implements DAO {

    @Override
    public boolean insert(Object obj) {
        if (obj instanceof Produto) {
            Produto inserirProduto = (Produto) obj;

            String comandoInsert = "INSERT INTO jaboc_servidor.Produto (qtdeestoque, tipoproduto, preco, nomeproduto) "
                    + "VALUES ('" + inserirProduto.getQtdeProduto() + "','" + inserirProduto.getTipoProduto() + "', '"
                    + inserirProduto.getPrecoProduto() + "', '" + inserirProduto.getNomeProduto() + "');";

            try (java.sql.Connection conexao = this.conectar()) {

                return conexao.createStatement().executeUpdate(comandoInsert) > 0;

            } catch (SQLException error) {
                System.out.println("Erro no insert(Object obj) do Produto: " + error.getMessage());
            }
        }
        return false;
    }

    @Override
    public ResultSet selectTodos() {
        String comandoSelect = "SELECT * FROM jaboc_servidor.Produto;";

        ResultSet resultadosSelect = null;

        try (java.sql.Connection conexao = this.conectar()) {

            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);

        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Produto: " + error.getMessage());
        }
        return resultadosSelect;
    }

    public List<Produto> Listagem() {
        String comandoList = "SELECT * FROM jaboc_servidor.Produto;";
        List<Produto> lista_produtos = new ArrayList<Produto>();
        ResultSet resultadosListagem = null;

        try (java.sql.Connection conexao = this.conectar()) {
            resultadosListagem = conexao.createStatement().executeQuery(comandoList);
            
            while (resultadosListagem.next()) {

                String nome = resultadosListagem.getString("nomeproduto");
                String tipo = resultadosListagem.getString("tipoproduto");
                int qtde = resultadosListagem.getInt("qtdeestoque");
                int id = resultadosListagem.getInt("idproduto");
                double preco = resultadosListagem.getDouble("preco");

                Produto produto = new Produto(nome, qtde, id, tipo, preco);
                lista_produtos.add(produto);
            }

        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Produto: " + error.getMessage());
        }
        return lista_produtos;

    }

    @Override
    public <T> ResultSet selectEspecifico(T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> boolean existeRegistro(T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> boolean delete(T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> boolean update(Object o, T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public String alerta(Object o, String frase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
