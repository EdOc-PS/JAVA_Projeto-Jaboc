/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.Modelo;

import com.sun.jdi.connect.spi.Connection;
import jaboc_Classes.Produto;
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
        List<Produto> lista_produtos = new ArrayList<Produto>();
        ResultSet resultadosListagem = this.selectTodos();

        try (java.sql.Connection conexao = this.conectar()) {

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
    public <T> ResultSet selectEspecifico(T id) {

        String comandoSelect = "SELECT * FROM jaboc_servidor.Produto WHERE idproduto = '" + id + "';";
        ResultSet resultadoSelect = null;

        try (java.sql.Connection conexao = this.conectar()) {
            resultadoSelect = conexao.createStatement().executeQuery(comandoSelect);

        } catch (SQLException error) {
            System.out.println("Erro no selectEspecifico(int idproduto) do Produto: " + error.getMessage());
        }

        return resultadoSelect;
    }

    public Produto consultaP(int id) {
        ResultSet resultadoSelect = this.selectEspecifico(id);
        Produto produto = new Produto();

        try (java.sql.Connection conexao = this.conectar()) {
            
            if (resultadoSelect.next()) {
                produto.setIdProduto(resultadoSelect.getInt("idproduto"));
                produto.setQtdeProduto(resultadoSelect.getInt("qtdeestoque"));
                produto.setTipoProduto(resultadoSelect.getString("tipoproduto"));
                produto.setPrecoProduto(resultadoSelect.getDouble("preco"));
                produto.setNomeProduto(resultadoSelect.getString("nomeproduto"));                                     
           }else{
               return null;
            }
            
        } catch (SQLException error) {
            System.out.println("Erro na consultP(int idproduto) do Produto: " + error.getMessage());

        }
        return produto;
    }

    @Override
    public <T> boolean existeRegistro(T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public <T> boolean delete(T id) {
        String comandoDelete = "DELETE FROM jaboc_servidor.Produto WHERE idproduto = '" + id + "';";

        try (java.sql.Connection conexao = this.conectar()) {

            return conexao.createStatement().executeUpdate(comandoDelete) > 0;

        } catch (SQLException error) {
            System.out.println("Erro no delete(int idproduto) do Produto: " + error.getMessage());
        }

        return false;
    }

    @Override
    public <T> boolean update(Object obj, T id) {
        if (obj instanceof Produto) {
            Produto updateProduto = (Produto) obj;

            String comandoUpdate = "UPDATE jaboc_servidor.Produto SET "
                    + "qtdeestoque = '" + updateProduto.getQtdeProduto() + "', "
                    + "tipoproduto = '" + updateProduto.getTipoProduto() + "', "
                    + "preco = '" + updateProduto.getPrecoProduto() + "', "
                    + "nomeproduto = '" + updateProduto.getNomeProduto() + "' "
                    + "WHERE idproduto = '" + id + "' ;";

            try (java.sql.Connection conexao = this.conectar()) {

                return conexao.createStatement().executeUpdate(comandoUpdate) > 0;

            } catch (SQLException error) {
                System.out.println("Erro no update(Object obj, int idproduto) da Produto: " + error.getMessage());
            }
        }
        return false;

    }

    public String alerta(Object o, String frase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
