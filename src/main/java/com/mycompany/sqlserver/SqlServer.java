/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sqlserver;

import controlador.Controlador;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import modelo.ArticulosRepositorio;
import modelo.ConexionPrueba;
import modelo.Ejemplar_ArticuloRepositorio;
import modelo.TiendasRepositorio;
import modelo.VentasRepositorio;
import vista.VentanaPrincipal;
import vista.Vista;


/**
 *
 * @author Diurno
 */
public class SqlServer {
       

   public static void main(String[] args) throws SQLException {
       
        
        ConexionPrueba conexion = new ConexionPrueba();
        conexion.getConnection();
        
        SwingUtilities.invokeLater(() -> {
            try {
                // Crear el frame
                JFrame frame = new JFrame("Gestión de Base de Datos");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                
                // Crear los componentes
                ArticulosRepositorio ar = new ArticulosRepositorio();
                TiendasRepositorio tr = new TiendasRepositorio();
                VentasRepositorio vr = new VentasRepositorio();
                Ejemplar_ArticuloRepositorio ear = new Ejemplar_ArticuloRepositorio();

                
                VentanaPrincipal panel = new VentanaPrincipal();
                Vista v = new Vista();
                
                Controlador c = new Controlador(ar, tr, vr, ear, v, panel);
                panel.setControlador(c);
                
                // Añadir el panel al frame
                frame.add(panel);
                
                // Mostrar el frame
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                    "Error al iniciar la aplicación: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    }

