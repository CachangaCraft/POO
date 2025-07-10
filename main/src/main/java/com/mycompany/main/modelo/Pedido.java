package com.mycompany.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<DetallePedido> detalles;
    private String estado; // pendiente, mesa_confirmada, en_preparacion, entregado, cancelado
    private Mesa mesa;
    private boolean pagado;

    public Pedido(int idPedido, Cliente cliente) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
        this.estado = "pendiente";
        this.pagado = false;
    }

    public void agregarDetalle(Producto producto, int cantidad) {
        detalles.add(new DetallePedido(producto, cantidad));
    }

    public double calcularTotal() {
        double total = 0;
        for (DetallePedido d : detalles) {
            total += d.getSubtotal();
        }
        return total;
    }

    public void asignarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.ocupar();
        this.estado = "mesa_confirmada";
    }

    public void marcarPreparacion() {
        this.estado = "en_preparacion";
    }

    public void marcarEntregado() {
        this.estado = "entregado";
    }

    public void marcarPagado() {
        this.pagado = true;
    }

    public int getIdPedido() { return idPedido; }
    public Cliente getCliente() { return cliente; }
    public Mesa getMesa() { return mesa; }
    public String getEstado() { return estado; }
    public boolean isPagado() { return pagado; }

    // ✅ Agregado para que funcione el for en Main
    public List<DetallePedido> getDetalles() {
        return detalles;
    }
}
