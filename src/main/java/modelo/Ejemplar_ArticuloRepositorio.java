/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class Ejemplar_ArticuloRepositorio {
    
    ConexionPrueba conexionSql;
     Connection con;
     
     public Ejemplar_ArticuloRepositorio() {
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

    
    public void mostrarEjemplar_Articulo(String articulo) throws SQLException{
         conectar();
        String query = "SELECT * FROM EJEMPLAR_ARTICULO WHERE ARTICULO = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int idEjemplar = rs.getInt("ID_EJEMPLAR");
                    String articuloNombre = rs.getString("ARTICULO");
                    String estado = rs.getString("ESTADO");
                    String fechaAdquisicion = rs.getString("FECHA_ADQUISICION");

                    System.out.println("Ejemplar ID: " + idEjemplar + ", Artículo: " + articuloNombre + 
                                       ", Estado: " + estado + ", Fecha Adquisición: " + fechaAdquisicion);
                }
            }
        }
    }
    
    public void insertarEjemplarArticulo(String articulo, int codFabricante, String estado, 
                                         Timestamp fechaAdquisicion, String ubicacion) throws SQLException {
        conectar();
        String query = "INSERT INTO EJEMPLAR_ARTICULO (ARTICULO, COD_FABRICANTE, ESTADO, FECHA_ADQUISICION, UBICACION) "
                     + "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            stmt.setString(3, estado);
            stmt.setTimestamp(4, fechaAdquisicion);
            stmt.setString(5, ubicacion);
            stmt.executeUpdate();
        }
    }

    public void actualizarEjemplarArticulo(int idEjemplar, String estado, Timestamp fechaAdquisicion, 
                                           String ubicacion) throws SQLException {
        conectar();
        String query = "UPDATE EJEMPLAR_ARTICULO SET ESTADO = ?, FECHA_ADQUISICION = ?, UBICACION = ? "
                     + "WHERE ID_EJEMPLAR = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, estado);
            stmt.setTimestamp(2, fechaAdquisicion);
            stmt.setString(3, ubicacion);
            stmt.setInt(4, idEjemplar);
            stmt.executeUpdate();
        }
    }

    public void eliminarEjemplarArticulo(int idEjemplar) throws SQLException {
        conectar();
        String query = "DELETE FROM EJEMPLAR_ARTICULO WHERE ID_EJEMPLAR = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idEjemplar);
            stmt.executeUpdate();
        }
    }
}
