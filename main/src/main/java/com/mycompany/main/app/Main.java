package com.mycompany.main.app;

import com.mycompany.main.modelo.DetallePedido;
import com.mycompany.main.modelo.Producto;
import com.mycompany.main.modelo.Cliente;
import com.mycompany.main.modelo.SistemaAutoAtencion;
import com.mycompany.main.modelo.Pedido;
import com.mycompany.main.modelo.Mesa;
import com.mycompany.main.DAO.ClienteDAO;
import com.mycompany.main.DAO.ProductoDAO;
import com.mycompany.main.DAO.PedidoDAO;
import com.mycompany.main.DAO.DetalleDAO;

public class Main {
    public static void main(String[] args) {
        ProductoDAO productoDAO = new ProductoDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        DetalleDAO detalleDAO = new DetalleDAO();

        Producto p1 = new Producto(3, "Pollo a la brasa", "Plato", 30.00, 10);
        Producto p2 = new Producto(4, "Inka Kola", "Bebida", 6.00, 20);
        productoDAO.insertarProducto(p1);
        productoDAO.insertarProducto(p2);

        Cliente cliente = new Cliente(2, "Luis", "987654321", "luis@mail.com");
        clienteDAO.insertarCliente(cliente);

        SistemaAutoAtencion sistema = new SistemaAutoAtencion();
        sistema.agregarProducto(p1);
        sistema.agregarProducto(p2);
        sistema.agregarMesa(new Mesa("M3"));
        Pedido pedido = sistema.crearPedido(cliente);
        pedido.agregarDetalle(p1, 1);
        pedido.agregarDetalle(p2, 2);
        sistema.confirmarPedido(pedido);

        pedidoDAO.insertarPedido(pedido);
        for (DetallePedido d : pedido.getDetalles()) {
            detalleDAO.insertarDetalle(d, pedido.getIdPedido());
        }

        System.out.println("💾 Pedido guardado con total: S/ " + pedido.calcularTotal());
    }
}
