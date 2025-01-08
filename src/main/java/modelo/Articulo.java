/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diurno
 */
public class Articulo {
    
    private String articulo;
    private int cod_fabricante;
    private int peso;
    private String categoria; 
    private double precioVenta;
    private double precioCosto;
    private double existencias; 

    public Articulo(String articulo, int cod_fabricante, int peso, String categoria, double precio_venta, double precio_costo, double existencias) {
        this.articulo = articulo;
        this.cod_fabricante = cod_fabricante;
        this.peso = peso;
        this.categoria = categoria;
        this.precioVenta = precio_venta;
        this.precioCosto = precio_costo;
        this.existencias = existencias;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio_venta() {
        return precioVenta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precioVenta = precio_venta;
    }

    public double getPrecio_costo() {
        return precioCosto;
    }

    public void setPrecio_costo(double precio_costo) {
        this.precioCosto = precio_costo;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }

    @Override
    public String toString() {
        return "Articulo: " + "articulo=" + articulo + ", cod_fabricante=" + cod_fabricante + ", peso=" + peso + ", categoria=" + categoria + ", precio_venta=" + precioVenta + ", precio_costo=" + precioCosto + ", existencias=" + existencias ;
    }
    
    
}
