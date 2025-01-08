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

    public Controlador(ArticulosRepositorio ar, TiendasRepositorio tr, VentasRepositorio vr, Ejemplar_ArticuloRepositorio ear, Vista v) throws SQLException {
        this.ar = ar;
        this.tr = tr;
        this.vr = vr;
        this.ear = ear;
        this.v = v;
        
//        mostrarTodosArticulos();
//        mostrarTienda();
//        mostrarVentas();
//        mostrarEjemplar_Articulo();
//        insertarArticulo();
//        actualizarArticulo();
//        eliminarArticulo();
    }

    public void mostrarTodosArticulos() throws SQLException{
        ar.mostrarArticulo();
    }
    
    public void mostrarTienda() throws SQLException{
        String nif = "5555-B";
        tr.mostrarTienda(nif);
    }
    
    public void mostrarVentas() throws SQLException{
        String articulo = "Macarrones";
        vr.mostrarVenta(articulo);
    }
    
    public void mostrarEjemplar_Articulo() throws SQLException{
        String articulo = "Macarrones";
        ear.mostrarEjemplar_Articulo(articulo);
    }
    
    public void insertarArticulo() throws SQLException{
        String articulo = "Macarrones";
        int codFabricante = 20;
        int peso = 1;
        String categoria = "Primera";
        double precioVenta = 1.00;
        double precioCosto = 0.98;
        int existencias = 120;

        ar.insertarArticulo(articulo, codFabricante, peso, categoria, precioVenta, precioCosto, existencias);
    }
    
    public void actualizarArticulo() throws SQLException{
        String articulo = "Macarrones";
        int codFabricante = 20;
        int peso = 1;
        String categoria = "Primera";
        double precioVenta = 1.10;
        double precioCosto = 0.58;
        int existencias = 100;
        
        ar.actualizarArticulo(articulo, codFabricante, peso, categoria, precioVenta, precioCosto, precioVenta);
    }
    
    public void eliminarArticulo() throws SQLException{
        String articulo = "Macarrones";
        int codFabricante = 20;
        
        ar.eliminarArticulo(articulo, codFabricante);
    }
}
