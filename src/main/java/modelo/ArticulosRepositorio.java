/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class ArticulosRepositorio {

    ConexionPrueba conexionSql;
    Connection con;

    public ArticulosRepositorio() {
        this.conexionSql = new ConexionPrueba();  // Inicializar la conexión
    }

    public void conectar() {
        if (con == null) {
            con = conexionSql.getConnection();
        }
        if (con != null) {
            System.out.println("Estas conectado");
        } else {
            System.out.println("No te has conectado");
        }
    }

    public void mostrarArticulo() throws SQLException {
        conectar();
        String query = "SELECT * FROM ARTICULOS";

        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String articulo = rs.getString("ARTICULO");
                int codFabricante = rs.getInt("COD_FABRICANTE");
                int peso = rs.getInt("PESO");
                String categoria = rs.getString("CATEGORIA");
                double precioVenta = rs.getDouble("PRECIO_VENTA");
                double precioCosto = rs.getDouble("PRECIO_COSTO");
                double existencias = rs.getDouble("EXISTENCIAS");

                System.out.println("Artículo: " + articulo + ", Código Fabricante: " + codFabricante
                        + ", Peso: " + peso + ", Categoría: " + categoria
                        + ", Precio Venta: " + precioVenta + ", Precio Costo: " + precioCosto
                        + ", Existencias: " + existencias);
            }
        }
    }

    public void insertarArticulo(String articulo, int codFabricante, int peso, String categoria,
            double precioVenta, double precioCosto, double existencias) throws SQLException {

        conectar();
        
        if (existeArticulo(articulo, codFabricante)) {
            throw new SQLException("El artículo ya existe con ese código de fabricante. Use actualizarArticulo si desea modificarlo.");
        }

        String query = "INSERT INTO ARTICULOS (ARTICULO, COD_FABRICANTE, PESO, CATEGORIA, PRECIO_VENTA, PRECIO_COSTO, EXISTENCIAS) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            stmt.setInt(3, peso);
            stmt.setString(4, categoria);
            stmt.setDouble(5, precioVenta);
            stmt.setDouble(6, precioCosto);
            stmt.setDouble(7, existencias);
            stmt.executeUpdate();
        }
    }

    public void actualizarArticulo(String articulo, int codFabricante, int peso, String categoria,
            double precioVenta, double precioCosto, double existencias) throws SQLException {
        
        if (!existeArticulo(articulo, codFabricante)) {
            throw new SQLException("Artículo ya existente, este se modifica");
        }

        String query = "UPDATE ARTICULOS SET PESO = ?, CATEGORIA = ?, PRECIO_VENTA = ?, " +
                      "PRECIO_COSTO = ?, EXISTENCIAS = ? " +
                      "WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
                      
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, peso);
            stmt.setString(2, categoria);
            stmt.setDouble(3, precioVenta);
            stmt.setDouble(4, precioCosto);
            stmt.setDouble(5, existencias);
            stmt.setString(6, articulo);
            stmt.setInt(7, codFabricante);
            stmt.executeUpdate();
        }
    }

    public boolean existeArticulo(String articulo, int codFabricante) throws SQLException {
        String query = "SELECT COUNT(*) FROM ARTICULOS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    // Método que combina inserción y actualización 
    public void insertarOActualizarArticulo(String articulo, int codFabricante, int peso, String categoria,
            double precioVenta, double precioCosto, double existencias) throws SQLException {
        
        if (existeArticulo(articulo, codFabricante)) {
            actualizarArticulo(articulo, codFabricante, peso, categoria, precioVenta, precioCosto, existencias);
        } else {
            insertarArticulo(articulo, codFabricante, peso, categoria, precioVenta, precioCosto, existencias);
        }
    }


     public void eliminarArticulo(String articulo, int codFabricante) throws SQLException {
         
         conectar();
         
        // Primero verificamos si el artículo existe
        if (!existeArticulo(articulo, codFabricante)) {
            throw new SQLException("No se puede eliminar: El artículo no existe");
        }

        // Verificar si hay ventas relacionadas
        if (tieneVentasAsociadas(articulo, codFabricante)) {
            throw new SQLException("No se puede eliminar: El artículo tiene ventas asociadas");
        }

        // Verificar si hay ejemplares relacionados
        if (tieneEjemplaresAsociados(articulo, codFabricante)) {
            throw new SQLException("No se puede eliminar: El artículo tiene ejemplares asociados");
        }

        String query = "DELETE FROM ARTICULOS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
        conectar();
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas == 0) {
                throw new SQLException("No se pudo eliminar el artículo");
            }
        }
    }

    private boolean tieneVentasAsociadas(String articulo, int codFabricante) throws SQLException {
        String query = "SELECT COUNT(*) FROM VENTAS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private boolean tieneEjemplaresAsociados(String articulo, int codFabricante) throws SQLException {
        String query = "SELECT COUNT(*) FROM EJEMPLAR_ARTICULO WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
    
    public void eliminarArticuloConRelaciones(String articulo, int codFabricante) throws SQLException {
        conectar();
        // Iniciamos una transacción para asegurar que todas las operaciones se completen
        con.setAutoCommit(false);
        try {
            //  eliminamos las ventas relacionadas
            String deleteVentas = "DELETE FROM VENTAS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
            try (PreparedStatement stmt = con.prepareStatement(deleteVentas)) {
                stmt.setString(1, articulo);
                stmt.setInt(2, codFabricante);
                stmt.executeUpdate();
            }

            //  eliminamos los ejemplares relacionados
            String deleteEjemplares = "DELETE FROM EJEMPLAR_ARTICULO WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
            try (PreparedStatement stmt = con.prepareStatement(deleteEjemplares)) {
                stmt.setString(1, articulo);
                stmt.setInt(2, codFabricante);
                stmt.executeUpdate();
            }

            //  eliminamos el artículo
            String deleteArticulo = "DELETE FROM ARTICULOS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";
            try (PreparedStatement stmt = con.prepareStatement(deleteArticulo)) {
                stmt.setString(1, articulo);
                stmt.setInt(2, codFabricante);
                stmt.executeUpdate();
            }

            // confirmamos 
            con.commit();
        } catch (SQLException e) {
            // Si hay algún error, revertimos todos los cambios
            con.rollback();
            throw new SQLException("Error al eliminar el artículo y sus relaciones: " + e.getMessage());
        } finally {
            // Restauramos el autocommit a su estado original
            con.setAutoCommit(true);
        }
    }
}

