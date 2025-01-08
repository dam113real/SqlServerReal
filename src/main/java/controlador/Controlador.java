/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import modelo.ArticulosRepositorio;
import modelo.Ejemplar_Articulo;
import modelo.Ejemplar_ArticuloRepositorio;
import modelo.TiendasRepositorio;
import modelo.VentasRepositorio;
import vista.Vista;

/**
 *
 * @author Diurno
 */
public class Controlador {
    ArticulosRepositorio ar;
    TiendasRepositorio tr; 
    VentasRepositorio vr; 
    Ejemplar_ArticuloRepositorio ear; 
    Vista v;

    public Controlador(ArticulosRepositorio ar, TiendasRepositorio tr, VentasRepositorio vr, Ejemplar_ArticuloRepositorio ear, Vista v) {
        this.ar = ar;
        this.tr = tr;
        this.vr = vr;
        this.ear = ear;
        this.v = v;
        
        
    }

    public void mostrarTodosArticulos() throws SQLException{
        ar.mostrarArticulo();
    }
    
    
    
}
