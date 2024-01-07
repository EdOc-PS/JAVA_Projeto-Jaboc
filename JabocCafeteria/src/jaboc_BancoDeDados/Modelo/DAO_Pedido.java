/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.Modelo;

import jaboc_Classes.Pedido;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eeuar
 */
public class DAO_Pedido implements DAO {

    @Override
    public ResultSet selectTodos() {
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status IN ('Enviado', 'Preparando ') ORDER BY status;";

        ResultSet resultadosSelect = null;

        try (java.sql.Connection conexao = this.conectar()) {
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Pedido: " + error.getMessage());
        }
        return resultadosSelect;
    }

    public List<Pedido> Listagem() {
        List<Pedido> lista_pedidos = new ArrayList<Pedido>();
        ResultSet resultadosListagem = this.selectTodos();

        try (java.sql.Connection conexao = this.conectar()) {

            while (resultadosListagem.next()) {

                int id = resultadosListagem.getInt("idpedido");
                String status = resultadosListagem.getString("status");
                String data = resultadosListagem.getString("datapedido");
                String tipo = resultadosListagem.getString("tipoproduto");
                String nome = resultadosListagem.getString("nomeproduto");
                double preco = resultadosListagem.getDouble("precoproduto");

                Pedido pedido = new Pedido(id, status, data, tipo, nome, preco);
                lista_pedidos.add(pedido);
            }

        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Pedido: " + error.getMessage());
        }
        return lista_pedidos;
    }

    public List<Pedido> ListagemEspecifica(String statusPedido) {
        List<Pedido> lista_pedidos = new ArrayList<Pedido>();
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status = '" + statusPedido + "';";
        ResultSet resultadosListagem = null;

        try (java.sql.Connection conexao = this.conectar()) {
            resultadosListagem = conexao.createStatement().executeQuery(comandoSelect);

            while (resultadosListagem.next()) {

                int id = resultadosListagem.getInt("idpedido");
                String status = resultadosListagem.getString("status");
                String data = resultadosListagem.getString("datapedido");
                String tipo = resultadosListagem.getString("tipoproduto");
                String nome = resultadosListagem.getString("nomeproduto");
                double preco = resultadosListagem.getDouble("precoproduto");

                Pedido pedido = new Pedido(id, status, data, tipo, nome, preco);
                lista_pedidos.add(pedido);
            }

        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Pedido: " + error.getMessage());
        }
        return lista_pedidos;
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
    public boolean insert(Object obj) {
        if (obj instanceof Pedido) {
            Pedido inserirPedido = (Pedido) obj;

            String comandoInsert = "INSERT INTO jaboc_servidor.Pedido (status, datapedido, tipoproduto, nomeproduto, precoproduto) "
                    + "VALUES ('" + inserirPedido.getStatusPedido() + "','" + inserirPedido.getDataPedido() + "', '"
                    + inserirPedido.getTipoPedido() + "', '" + inserirPedido.getNomePedido() + "', '"
                    + inserirPedido.getPrecoPedido() + "');";

            try (java.sql.Connection conexao = this.conectar()) {

                return conexao.createStatement().executeUpdate(comandoInsert) > 0;

            } catch (SQLException error) {
                System.out.println("Erro no insert(Object obj) do Pedido: " + error.getMessage());
            }
        }
        return false;

    }

    @Override
    public <T> boolean delete(T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public <T> boolean update(String status, T id) {

        String comandoUpdate = "UPDATE jaboc_servidor.Pedido SET "
                + "status = '" + status + " '"
                + "WHERE idpedido = '" + id + "' ;";

        try (java.sql.Connection conexao = this.conectar()) {

            return conexao.createStatement().executeUpdate(comandoUpdate) > 0;

        } catch (SQLException error) {
            System.out.println("Erro no update(Object obj, int idpedido) da Pedido: " + error.getMessage());
        }

        return false;

    }

    public String alerta(Object o, String frase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public <T> boolean update(Object o, T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
