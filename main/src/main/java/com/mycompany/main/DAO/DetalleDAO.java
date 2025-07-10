package com.mycompany.main.DAO;

import com.mycompany.main.modelo.Conexion;
import com.mycompany.main.modelo.DetallePedido;
import java.sql.*;

public class DetalleDAO {

    public void insertarDetalle(DetallePedido d, int idPedido) {
        String sql = "INSERT INTO detalle (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);
            stmt.setInt(2, d.getProducto().getIdProducto());
            stmt.setInt(3, d.getCantidad());

            stmt.executeUpdate();
            System.out.println("✅ Detalle insertado: Producto " + d.getProducto().getNombre());

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar detalle: " + e.getMessage());
        }
    }
}
