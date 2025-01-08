/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diurno
 */
public class ConexionSqlServer {

    public static void main(String[] args) {
        
        
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=NombreBaseDeDatos";
    private static final String USER = "tu_usuario";  // Usuario de la base de datos
    private static final String PASSWORD = "tu_contraseña";  // Contraseña del usuario

    // Método para obtener la conexión
    public static Connection getConnection() throws SQLException {
        try {
            // Cargar el driver de SQL Server (no es necesario en las versiones más recientes de JDBC)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Retornar la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se pudo encontrar el driver de SQL Server", e);
        }
    }
}
