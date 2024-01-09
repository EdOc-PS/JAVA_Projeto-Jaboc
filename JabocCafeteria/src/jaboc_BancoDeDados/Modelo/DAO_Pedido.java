/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_BancoDeDados.Modelo;

import jaboc_Classes.Pedido;
import java.sql.ResultSet;
import java.sql.Connection;
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
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido;";

        ResultSet resultadosSelect = null;

        try (Connection conexao = this.conectar()) {
            resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
        } catch (SQLException error) {
            System.out.println("Erro no selectTodos() do Pedido: " + error.getMessage());
        }
        return resultadosSelect;
    }


    private ArrayList<Pedido> listagemEspecifica(String comandoSelect){
         ArrayList<Pedido> listaPedidos = new ArrayList<>();
        
        try(Connection conexao = this.conectar()){
            ResultSet resultadosSelect = conexao.createStatement().executeQuery(comandoSelect);
            
            while(resultadosSelect.next()){
                
                int id = resultadosSelect.getInt("idpedido");
                String status = resultadosSelect.getString("status");
                String data = resultadosSelect.getString("datapedido");
                String nomeCliente = resultadosSelect.getString("nomeCliente");
                String tipo = resultadosSelect.getString("tipoproduto");
                String nome = resultadosSelect.getString("nomeproduto");
                double preco = resultadosSelect.getDouble("precoproduto");

                Pedido pedido = new Pedido(id, status, data,  nomeCliente, tipo, nome, preco);
                listaPedidos.add(pedido);
            }
        }catch(SQLException | NullPointerException error){
            System.out.println("Erro no listagemEspceficica(String comandoSelect) do DAO_Pedido: "+ error.getMessage());
        }
        
        return listaPedidos;
    }
    
    public ArrayList<Pedido> listagemPedidos_Todos() {
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status IN ('Enviado', 'Preparando ') ORDER BY status;";
        return this.listagemEspecifica(comandoSelect);
    }
    
    public ArrayList<Pedido> listagemExtrato_Todos() {

        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status = 'Concluido ' ORDER BY idpedido";
        return this.listagemEspecifica(comandoSelect);
    }
    
    public ArrayList<Pedido> listagem_TipoProduto(String tipoProduto){
       
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status = 'Concluido ' AND tipoproduto = '"+tipoProduto+"' ORDER BY idpedido;";
        return this.listagemEspecifica(comandoSelect);
    }
    
    public ArrayList<Pedido> listagem_Data(String dataPedido){
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status = 'Concluido ' AND datapedido = '"+dataPedido+"' ORDER BY idpedido;";
        return this.listagemEspecifica(comandoSelect);
    }
    
    public ArrayList<Pedido> listagem_TipoPorData(String tipoProduto, String dataPedido){
        String comandoSelect = "SELECT * FROM jaboc_servidor.Pedido WHERE status = 'Concluido ' AND tipoproduto= '"+ tipoProduto+ "' AND datapedido = '"+dataPedido+"' ORDER BY idpedido;";
        return this.listagemEspecifica(comandoSelect);
    }

    public <T> boolean update(String status, T id) {

        String comandoUpdate = "UPDATE jaboc_servidor.Pedido SET "
                + "status = '" + status + " '"
                + "WHERE idpedido = '" + id + "' ;";

        try (Connection conexao = this.conectar()) {

            return conexao.createStatement().executeUpdate(comandoUpdate) > 0;

        } catch (SQLException error) {
            System.out.println("Erro no update(Object obj, int idpedido) da Pedido: " + error.getMessage());
        }

        return false;

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

            String comandoInsert = "INSERT INTO jaboc_servidor.Pedido (status, datapedido, nomeCliente, tipoproduto, nomeproduto, precoproduto) "
                    + "VALUES ('" + inserirPedido.getStatusPedido() + "','" + inserirPedido.getDataPedido()+ "', '" + inserirPedido.getNOME_CLIENTE()+"', '"
                    + inserirPedido.getTipoPedido() + "', '" + inserirPedido.getNomePedido() + "', '"
                    + inserirPedido.getPrecoPedido() + "');";

            try (Connection conexao = this.conectar()) {

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

    public String alerta(Object o, String frase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public <T> boolean update(Object o, T param) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
