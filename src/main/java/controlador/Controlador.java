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


        /* VAN
        mostrarTodosArticulos();
        mostrarTienda();
        mostrarVentas();
        mostrarEjemplar_Articulo();
        insertarArticulo();
        eliminarArticulo();
        eliminarArticuloRelacionado();
         */

        mostrarMenu();
    }

    public void mostrarTodosArticulos() throws SQLException {
        ar.mostrarArticulo();
    }

    public void mostrarTienda() throws SQLException {
        String nif = "5555-B";
        tr.mostrarTienda(nif);
    }

public void mostrarVentas() throws SQLException {
    String articulo = "Macarrones";
    vr.mostrarVenta(articulo); 
}

    public void mostrarEjemplar_Articulo() throws SQLException {
        String articulo = "Tallarines";
        ear.mostrarEjemplar_Articulo(articulo);
    }

    public void insertarArticulo() {
        try {
            String articulo = "Macarrones";
            int codFabricante = 21; 
            int peso = 1;
            String categoria = "Primera";
            double precioVenta = 2.00;
            double precioCosto = 0.98;
            int existencias = 120;

            // Opción 1: Solo insertar (lanzará error si existe)
            try {
                ar.insertarArticulo(articulo, codFabricante, peso, categoria, 
                                  precioVenta, precioCosto, existencias);
                System.out.println("Artículo insertado correctamente");
            } catch (SQLException e) {
                System.out.println("Error al insertar: " + e.getMessage());
            }

            // Opción 2: Insertar o actualizar según corresponda
            try {
                ar.insertarOActualizarArticulo(articulo, codFabricante, peso, categoria, 
                                             precioVenta, precioCosto, existencias);
            } catch (SQLException e) {
                System.out.println("Error en la operación: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }

   public void eliminarArticulo() {
        try {
            String articulo = "Macarrones";
            int codFabricante = 21;
            
            try {
                ar.eliminarArticulo(articulo, codFabricante);
                System.out.println("Artículo eliminado correctamente");
            } catch (SQLException e) {
                System.out.println("Error al eliminar el artículo: " + e.getMessage());
                // Aquí podrías registrar el error en un log
            }
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
            e.printStackTrace();
        }
    }
   
   public void eliminarArticuloRelacionado() {
        try {
            String articulo = "Macarrones";
            int codFabricante = 20;
            
            try {
                ar.eliminarArticuloConRelaciones(articulo, codFabricante);
                System.out.println("Artículo y todas sus relaciones eliminados correctamente");
            } catch (SQLException e) {
                System.out.println("Error en el proceso de eliminación: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertarTienda() throws SQLException {
        String nif = "T4233232";
        String nombre = "TiendaA";
        String direccion = "Calle Juan Serrano";
        String poblacion = "Logroño";
        String provincia = "La Rioja";
        int codpostal = 26004;

        tr.insertarTienda(nif, nombre, direccion, poblacion, provincia, codpostal);
    }

    public void actualizarTienda() throws SQLException {
        String nif = "T4233232";
        String nombre = "TiendaA";
        String direccion = "Calle Gregorio";
        String poblacion = "Lardero";
        String provincia = "La Rioja";
        int codpostal = 26104;

        tr.actualizarTienda(nif, nombre, direccion, poblacion, provincia, codpostal);
    }

    public void eliminarTienda() throws SQLException {
        String nif = "T4233232";

        tr.eliminarTienda(nif);
    }

    public void insertarVentas() throws SQLException {
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;
        int peso = 1;
        String categoria = "Primaria";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        int unidadesVendidas = 10;

        vr.insertarVenta(nif, articulo, codFabricante, peso, categoria, time, unidadesVendidas);
    }

    public void actualizarVentas() throws SQLException {
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;
        int peso = 2;
        String categoria = "Segunda";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        int unidadesVendidas = 4;

        vr.actualizarVenta(nif, articulo, codFabricante, peso, categoria, time, unidadesVendidas);
    }

    public void eliminarVentas() throws SQLException {
        String nif = "R3242343";
        String articulo = "Macarrones";
        int codFabricante = 1243;

        vr.eliminarVenta(nif, articulo, codFabricante);
    }

    public void insertarEjemplar_Articulo() throws SQLException {
        String articulo = "Pasta";
        int codFabricante = 5342;
        String estado = "En Proceso";
        Timestamp fechaAdquisicion = new Timestamp(System.currentTimeMillis());
        String ubicacion = "Almacen";

        ear.insertarEjemplarArticulo(articulo, codFabricante, estado, fechaAdquisicion, ubicacion);
    }

    public void actualizarEjemplar_Articulo() throws SQLException {
        int idEjemplar = 12;
        String estado = "En Proceso";
        Timestamp fechaAdquisicion = new Timestamp(System.currentTimeMillis());
        String ubicacion = "Almacen";

        ear.actualizarEjemplarArticulo(idEjemplar, estado, fechaAdquisicion, ubicacion);
    }

    public void eliminarEjemplar_Articulo() throws SQLException {
        int idEjemplar = 12;

        ear.eliminarEjemplarArticulo(idEjemplar);
    }
    
    public void mostrarMenu() {
        boolean salir = false;
        
        while (!salir) {
            try {
                System.out.println("\n=== MENÚ DE GESTIÓN ===");
                System.out.println("1. Gestión de Artículos");
                System.out.println("2. Gestión de Tiendas");
                System.out.println("3. Gestión de Ventas");
                System.out.println("4. Gestión de Ejemplares");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = v.leerEntero();

                switch (opcion) {
                    case 1 -> menuArticulos();
                    case 2 -> menuTiendas();
                    case 3 -> menuVentas();
                    case 4 -> menuEjemplares();
                    case 5 -> salir = true;
                    default -> System.out.println("Opción no válida");
                }
            } catch (SQLException e) {
                System.out.println("Error en la base de datos: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
        System.out.println("Adiós tete");
    }

    private void menuArticulos() throws SQLException {
        System.out.println("\n=== GESTIÓN DE ARTÍCULOS ===");
        System.out.println("1. Mostrar todos los artículos");
        System.out.println("2. Insertar artículo");
        System.out.println("3. Eliminar artículo");
        System.out.println("4. Eliminar artículo y sus relaciones");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");

        int opcion = v.leerEntero();
        
        switch (opcion) {
            case 1 -> mostrarTodosArticulos();
            case 2 -> insertarArticulo();
            case 3 -> eliminarArticulo();
            case 4 -> eliminarArticuloRelacionado();
            case 5 -> { return; }
            default -> System.out.println("Opción no válida");
        }
    }

    private void menuTiendas() throws SQLException {
        System.out.println("\n=== GESTIÓN DE TIENDAS ===");
        System.out.println("1. Mostrar tienda");
        System.out.println("2. Insertar tienda");
        System.out.println("3. Actualizar tienda");
        System.out.println("4. Eliminar tienda");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");

        int opcion = v.leerEntero();
        
        switch (opcion) {
            case 1 -> mostrarTienda();
            case 2 -> insertarTienda();
            case 3 -> actualizarTienda();
            case 4 -> eliminarTienda();
            case 5 -> { return; }
            default -> System.out.println("Opción no válida");
        }
    }

    private void menuVentas() throws SQLException {
        System.out.println("\n=== GESTIÓN DE VENTAS ===");
        System.out.println("1. Mostrar ventas");
        System.out.println("2. Insertar venta");
        System.out.println("3. Actualizar venta");
        System.out.println("4. Eliminar venta");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");

        int opcion = v.leerEntero();
        
        switch (opcion) {
            case 1 -> mostrarVentas();
            case 2 -> insertarVentas();
            case 3 -> actualizarVentas();
            case 4 -> eliminarVentas();
            case 5 -> { return; }
            default -> System.out.println("Opción no válida");
        }
    }

    private void menuEjemplares() throws SQLException {
        System.out.println("\n=== GESTIÓN DE EJEMPLARES ===");
        System.out.println("1. Mostrar ejemplares");
        System.out.println("2. Insertar ejemplar");
        System.out.println("3. Actualizar ejemplar");
        System.out.println("4. Eliminar ejemplar");
        System.out.println("5. Volver al menú principal");
        System.out.print("Seleccione una opción: ");

        int opcion = v.leerEntero();
        
        switch (opcion) {
            case 1 -> mostrarEjemplar_Articulo();
            case 2 -> insertarEjemplar_Articulo();
            case 3 -> actualizarEjemplar_Articulo();
            case 4 -> eliminarEjemplar_Articulo();
            case 5 -> { return; }
            default -> System.out.println("Opción no válida");
        }
    }
}
