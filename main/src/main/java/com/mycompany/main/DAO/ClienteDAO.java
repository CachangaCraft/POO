package com.mycompany.main.DAO;

import com.mycompany.main.modelo.Cliente;
import com.mycompany.main.modelo.Cliente;
import com.mycompany.main.modelo.Conexion;
import com.mycompany.main.modelo.Conexion;
import java.sql.*;

public class ClienteDAO {

    public void insertarCliente(Cliente c) {
        String sql = "INSERT INTO cliente (id_cliente, nombre, telefono, correo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getIdCliente());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getTelefono());
            stmt.setString(4, c.getCorreo());

            stmt.executeUpdate();
            System.out.println("✅ Cliente insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar cliente: " + e.getMessage());
        }
    }
}
