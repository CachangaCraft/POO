package com.mycompany.main.DAO;

import com.mycompany.main.modelo.Conexion;
import com.mycompany.main.modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertarProducto(Producto p) {
        String sql = "INSERT INTO producto (id_producto, nombre, categoria, precio, stock) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdProducto());
            stmt.setString(2, p.getNombre());
            stmt.setString(3, p.getCategoria());
            stmt.setDouble(4, p.getPrecio());
            stmt.setInt(5, p.getStock());

            stmt.executeUpdate();
            System.out.println("✅ Producto insertado correctamente.");

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar producto: " + e.getMessage());
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar productos: " + e.getMessage());
        }

        return lista;
    }
}
