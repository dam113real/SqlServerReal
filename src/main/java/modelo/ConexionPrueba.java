/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ConexionPrueba {
    Connection conexion = null;

    public Connection getConnection() {
        String connectionUrl = 
            "jdbc:sqlserver://localhost:1433;"
            + "database=AccesoDatos;"
            + "user=Usuario1;"
            + "password=1234;"
            + "timeout=30;"
            + "encrypt=true;trustServerCertificate=true;";
            
        try {
            Connection con = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (SQLException ex) {
            return null;
        }
}
}
