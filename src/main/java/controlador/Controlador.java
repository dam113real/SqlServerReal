/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;


import java.sql.Timestamp;

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

        mostrarTodosArticulos();
        mostrarTienda();

//        mostrarVentas();
//        mostrarEjemplar_Articulo();
//        insertarArticulo();
//        actualizarArticulo();
//        eliminarArticulo();


//        insertarTienda();
//        actualizarTienda();
//        eliminarTienda();
//        insertarVentas();
//        actualizarVentas();
//        eliminarVentas();
//        insertarEjemplar_Articulo();
//        actualizarEjemplar_Articulo();
//        eliminarEjemplar_Articulo();

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



    
    public void insertarTienda() throws SQLException{
        String nif = "T4233232";
        String nombre = "TiendaA";
        String direccion = "Calle Juan Serrano";
        String poblacion = "Logroño";
        String provincia = "La Rioja";
        int codpostal = 26004;
        
        tr.insertarTienda(nif, nombre, direccion, poblacion, provincia, codpostal);
    }
    
    public void actualizarTienda() throws SQLException{
        String nif = "T4233232";
        String nombre = "TiendaA";
        String direccion = "Calle Gregorio";
        String poblacion = "Lardero";
        String provincia = "La Rioja";
        int codpostal = 26104;
        
        tr.actualizarTienda(nif, nombre, direccion, poblacion, provincia, codpostal);
    }
    
    public void eliminarTienda() throws SQLException{
        String nif = "T4233232";
        
        tr.eliminarTienda(nif);
    }
    
    public void insertarVentas() throws SQLException{
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;
        int peso = 1;
        String categoria = "Primaria";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        int unidadesVendidas = 10;
        
        vr.insertarVenta(nif, articulo, codFabricante, peso, categoria, time, unidadesVendidas);
    }
    
    public void actualizarVentas() throws SQLException{
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;
        int peso = 2;
        String categoria = "Segunda";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        int unidadesVendidas = 4;
        
        vr.actualizarVenta(nif, articulo, codFabricante, peso, categoria, time, unidadesVendidas);
    }
    
    public void eliminarVentas() throws SQLException{
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;
        
        vr.eliminarVenta(nif, articulo, codFabricante);
    }
    
    public void insertarEjemplar_Articulo() throws SQLException{
        String articulo = "Pasta";
        int codFabricante = 5342;
        String estado = "En Proceso";
        Timestamp fechaAdquisicion = new Timestamp(System.currentTimeMillis());
        String ubicacion = "Almacen";
        
        ear.insertarEjemplarArticulo(articulo, codFabricante, estado, fechaAdquisicion, ubicacion);
    }
    
    public void actualizarEjemplar_Articulo() throws SQLException{
        int idEjemplar = 12;
        String estado = "En Proceso";
        Timestamp fechaAdquisicion = new Timestamp(System.currentTimeMillis());
        String ubicacion = "Almacen";
        
        ear.actualizarEjemplarArticulo(idEjemplar, estado, fechaAdquisicion, ubicacion);
    }
    
    public void eliminarEjemplar_Articulo() throws SQLException{
        int idEjemplar = 12;
        
        ear.eliminarEjemplarArticulo(idEjemplar);
    }
}



