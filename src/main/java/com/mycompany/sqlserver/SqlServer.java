/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sqlserver;

import controlador.Controlador;
import java.sql.SQLException;
import modelo.ArticulosRepositorio;
import modelo.ConexionPrueba;
import modelo.Ejemplar_ArticuloRepositorio;
import modelo.TiendasRepositorio;
import modelo.VentasRepositorio;
import vista.Vista;


/**
 *
 * @author Diurno
 */
public class SqlServer {
       

   public static void main(String[] args) throws SQLException {
       
        ArticulosRepositorio ar = new ArticulosRepositorio();
        TiendasRepositorio tr = new TiendasRepositorio();
        VentasRepositorio vr = new VentasRepositorio();
        Ejemplar_ArticuloRepositorio ear = new Ejemplar_ArticuloRepositorio();
        Vista v = new Vista();
        
        Controlador c = new Controlador(ar, tr, vr, ear, v);
        ConexionPrueba conexion = new ConexionPrueba();
        conexion.getConnection();
    }
}
