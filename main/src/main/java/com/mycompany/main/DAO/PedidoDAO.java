package com.mycompany.main.DAO;

import com.mycompany.main.modelo.Conexion;
import com.mycompany.main.modelo.Pedido;
import java.sql.*;

public class PedidoDAO {

    public void insertarPedido(Pedido p) {
        String sql = "INSERT INTO pedido (id_pedido, id_cliente, estado, mesa, pago) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdPedido());
            stmt.setInt(2, p.getCliente().getIdCliente());
            stmt.setString(3, p.getEstado());
            stmt.setString(4, p.getMesa().getIdMesa());
            stmt.setBoolean(5, p.isPagado());

            stmt.executeUpdate();
            System.out.println("✅ Pedido insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pedido: " + e.getMessage());
        }
    }
}
