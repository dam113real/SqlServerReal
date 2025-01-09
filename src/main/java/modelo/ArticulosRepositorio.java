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
         conectar();

        String query = "UPDATE ARTICULOS SET PESO = ?, CATEGORIA = ?, PRECIO_VENTA = ?, PRECIO_COSTO = ?, EXISTENCIAS = ? "
                + "WHERE ARTICULO = ? AND COD_FABRICANTE = ?";

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

    public void eliminarArticulo(String articulo, int codFabricante) throws SQLException {
        String query = "DELETE FROM ARTICULOS WHERE ARTICULO = ? AND COD_FABRICANTE = ?";

         conectar();

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, articulo);
            stmt.setInt(2, codFabricante);
            stmt.executeUpdate();
        }
    }
}
