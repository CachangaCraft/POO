package com.mycompany.main.modelo;

import java.util.*;

public class SistemaAutoAtencion {
    private List<Producto> productos;
    private List<Mesa> mesas;
    private List<Pedido> pedidos;
    private int contadorPedidos;

    public SistemaAutoAtencion() {
        productos = new ArrayList<>();
        mesas = new ArrayList<>();
        pedidos = new ArrayList<>();
        contadorPedidos = 1;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public List<Producto> getProductosDisponibles() {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getStock() > 0) disponibles.add(p);
        }
        return disponibles;
    }

    public Mesa buscarMesaLibre() {
        for (Mesa m : mesas) {
            if (m.isDisponible()) return m;
        }
        return null;
    }

    public Pedido crearPedido(Cliente cliente) {
        Pedido pedido = new Pedido(contadorPedidos++, cliente);
        pedidos.add(pedido);
        return pedido;
    }

    public void confirmarPedido(Pedido pedido) {
        Mesa mesa = buscarMesaLibre();
        if (mesa != null) {
            pedido.asignarMesa(mesa);
        }
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
