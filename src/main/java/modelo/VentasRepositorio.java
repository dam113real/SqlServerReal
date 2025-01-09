/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class VentasRepositorio {
    
ConexionPrueba conexionSql;
     Connection con;

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


    public void mostrarVenta(String articulo) throws SQLException{
         conectar();
        String query = "SELECT * FROM VENTAS WHERE ARTICULO = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idVenta = rs.getInt("ID_VENTA");
                    String nif = rs.getString("NIF");
                    double cantidad = rs.getDouble("CANTIDAD");
                    double total = rs.getDouble("TOTAL");
                    String fechaVenta = rs.getString("FECHA_VENTA");

                    System.out.println("Venta ID: " + idVenta + ", NIF: " + nif + ", Cantidad: " + cantidad + 
                                       ", Total: " + total + ", Fecha Venta: " + fechaVenta);
                }
            }
        }
    }
    
    public void insertarVenta(String nif, String articulo, int codFabricante, int peso, 
                              String categoria, java.sql.Timestamp fechaVenta, int unidadesVendidas) throws SQLException {
         conectar();
        String query = "INSERT INTO VENTAS (NIF, ARTICULO, COD_FABRICANTE, PESO, CATEGORIA, FECHA_VENTA, UNIDADES_VENDIDAS) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.setString(2, articulo);
            stmt.setInt(3, codFabricante);
            stmt.setInt(4, peso);
            stmt.setString(5, categoria);
            stmt.setTimestamp(6, fechaVenta);
            stmt.setInt(7, unidadesVendidas);
            stmt.executeUpdate();
        }
    }


    public void actualizarVenta(String nif, String articulo, int codFabricante, int peso, 
                                String categoria, java.sql.Timestamp fechaVenta, int unidadesVendidas) throws SQLException {
        conectar();
        String query = "UPDATE VENTAS SET PESO = ?, CATEGORIA = ?, FECHA_VENTA = ?, UNIDADES_VENDIDAS = ? "
                     + "WHERE NIF = ? AND ARTICULO = ? AND COD_FABRICANTE = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, peso);
            stmt.setString(2, categoria);
            stmt.setTimestamp(3, fechaVenta);
            stmt.setInt(4, unidadesVendidas);
            stmt.setString(5, nif);
            stmt.setString(6, articulo);
            stmt.setInt(7, codFabricante);
            stmt.executeUpdate();
        }
    }


    public void eliminarVenta(String nif, String articulo, int codFabricante) throws SQLException {
         conectar();
        String query = "DELETE FROM VENTAS WHERE NIF = ? AND ARTICULO = ? AND COD_FABRICANTE = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.setString(2, articulo);
            stmt.setInt(3, codFabricante);
            stmt.executeUpdate();
        }
    }
}
