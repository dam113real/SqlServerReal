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
public class TiendasRepositorio {

    ConexionPrueba conexionSql;
    Connection con;

    public TiendasRepositorio() {
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

    public void mostrarTienda(String nif) throws SQLException {
    conectar();
    String query = "SELECT * FROM TIENDAS WHERE NIF = ?";
    
    try (PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setString(1, nif);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String nifTienda = rs.getString("NIF");
                String nombre = rs.getString("NOMBRE");
                String direccion = rs.getString("DIRECCION");
                String poblacion = rs.getString("POBLACION");
                String provincia = rs.getString("PROVINCIA");
                String codPostal = rs.getString("CODPOSTAL");
                
                System.out.println("NIF: " + nifTienda + 
                                 ", Nombre: " + nombre +
                                 ", Dirección: " + direccion +
                                 ", Población: " + poblacion +
                                 ", Provincia: " + provincia +
                                 ", Código Postal: " + codPostal);
            }
        }
    }
}


    public void insertarTienda(String nif, String nombre, String direccion, String poblacion,
            String provincia, int codPostal) throws SQLException {
        conectar();
        String query = "INSERT INTO TIENDAS (NIF, NOMBRE, DIRECCION, POBLACION, PROVINCIA, CODPOSTAL) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.setString(2, nombre);
            stmt.setString(3, direccion);
            stmt.setString(4, poblacion);
            stmt.setString(5, provincia);
            stmt.setInt(6, codPostal);
            stmt.executeUpdate();
        }
    }

    public void actualizarTienda(String nif, String nombre, String direccion, String poblacion,
            String provincia, int codPostal) throws SQLException {
        conectar();
        String query = "UPDATE TIENDAS SET NOMBRE = ?, DIRECCION = ?, POBLACION = ?, PROVINCIA = ?, CODPOSTAL = ? "
                + "WHERE NIF = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, poblacion);
            stmt.setString(4, provincia);
            stmt.setInt(5, codPostal);
            stmt.setString(6, nif);
            stmt.executeUpdate();
        }
    }

    public void eliminarTienda(String nif) throws SQLException {
        conectar();
        String query = "DELETE FROM TIENDAS WHERE NIF = ?";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, nif);
            stmt.executeUpdate();
        }
    }
}
