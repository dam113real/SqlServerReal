/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diurno
 */
public class TiendasRepositorio {
    
    public void mostrarTienda(Connection conn, String nif) throws SQLException{
        String query = "SELECT * FROM VENTAS WHERE NIF = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nif);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idVenta = rs.getInt("ID_VENTA");
                    String articulo = rs.getString("ARTICULO");
                    double cantidad = rs.getDouble("CANTIDAD");
                    double total = rs.getDouble("TOTAL");
                    String fechaVenta = rs.getString("FECHA_VENTA");

                    
                    System.out.println("Venta ID: " + idVenta + ", Artículo: " + articulo + 
                                       ", Cantidad: " + cantidad + ", Total: " + total + 
                                       ", Fecha Venta: " + fechaVenta);
                }
            }
        }
    }
        
    public void insertarTienda(Connection conn, String nif, String nombre, String direccion, String poblacion, 
                               String provincia, int codPostal) throws SQLException {
        String query = "INSERT INTO TIENDAS (NIF, NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL) "
                     + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.setString(4, poblacion);
            stmt.setString(5, provincia);
            stmt.setInt(6, codPostal);
            stmt.executeUpdate();
        }
    }


    public void actualizarTienda(Connection conn, String nif, String nombre, String direccion, String poblacion, 
                                 String provincia, int codPostal) throws SQLException {
        String query = "UPDATE TIENDAS SET NOMBRE = ?, DIRECCION = ?, POBLACION = ?, PROVINCIA = ?, CODPOSTAL = ? "
                     + "WHERE NIF = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, poblacion);
            stmt.setString(4, provincia);
            stmt.setInt(5, codPostal);
            stmt.setString(6, nif);
            stmt.executeUpdate();
        }
    }


    public void eliminarTienda(Connection conn, String nif) throws SQLException {
        String query = "DELETE FROM TIENDAS WHERE NIF = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.executeUpdate();
        }
    }
}
