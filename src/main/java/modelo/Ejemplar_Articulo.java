/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author Diurno
 */
public class Ejemplar_Articulo {
    
    private int id_ejemplar;
    private String articulo;
    private int cod_fabricante;
    private String estado;
    private Timestamp fecha_adquisicion;
    private String ubicacion;

    public Ejemplar_Articulo(int id_ejemplar, String articulo, int cod_fabricante, String estado, Timestamp fecha_adquisicion, String ubicacion) {
        this.id_ejemplar = id_ejemplar;
        this.articulo = articulo;
        this.cod_fabricante = cod_fabricante;
        this.estado = estado;
        this.fecha_adquisicion = fecha_adquisicion;
        this.ubicacion = ubicacion;
    }

    public int getId_ejemplar() {
        return id_ejemplar;
    }

    public void setId_ejemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCod_fabricante() {
        return cod_fabricante;
    }

    public void setCod_fabricante(int cod_fabricante) {
        this.cod_fabricante = cod_fabricante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(Timestamp fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Ejemplar_Articulo: " + "id_ejemplar=" + id_ejemplar + ", articulo=" + articulo + ", cod_fabricante=" + cod_fabricante + ", estado=" + estado + ", fecha_adquisicion=" + fecha_adquisicion + ", ubicacion=" + ubicacion;
    }
    
    
}
