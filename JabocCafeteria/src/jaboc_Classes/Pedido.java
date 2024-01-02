/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jaboc_Classes;

/**
 *
 * @author eeuar
 */
public class Pedido {

    private String nomePedido;
    private String statusPedido;
    private String dataPedido;
    private String tipoPedido;
    private int idPedido;
    private double precoPedido;

    public Pedido() {
        this.nomePedido = "";
        this.statusPedido = "";
        this.dataPedido = "";
        this.tipoPedido = "";
        this.idPedido = 0;
        this.precoPedido = 0;
    }

    public double getPrecoPedido() {
        return precoPedido;
    }

    public void setPrecoPedido(double precoPedido) {
        this.precoPedido = precoPedido;
    }

    public Pedido(int idPedido, String statusPedido, String dataPedido, String tipoPedido, String nomePedido, double precoPedido) {
        this.nomePedido = nomePedido;
        this.statusPedido = statusPedido;
        this.dataPedido = dataPedido;
        this.tipoPedido = tipoPedido;
        this.idPedido = idPedido;
        this.precoPedido = precoPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getNomePedido() {
        return nomePedido;
    }

    public void setNomePedido(String nomePedido) {
        this.nomePedido = nomePedido;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

}
