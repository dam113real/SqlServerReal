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


        
        

    // Configuración de la conexión
    static String user = "Usuario1";
    static String pwd = "1234";
    static String nombreBD = "AccesoDatos";
    static String url = "jdbc:sqlserver://1433/" + nombreBD;

    // Método para obtener la conexión
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pwd);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos:");
            e.printStackTrace();
        }
        return connection;
    }
/*
    // Método main para probar la conexión
    public static void main(String[] args) {
        getConnection();
    }*/
}

