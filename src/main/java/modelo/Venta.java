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
public class Venta {
    
    private String nif;
    private String articulo;
    private int cod_fabricante;
    private int peso;
    private String categoria;
    private Timestamp fecha_venta;
    private int unidades_vendidas;

    public Venta(String nif, String articulo, int cod_fabricante, int peso, String categoria, Timestamp fecha_venta, int unidades_vendidas) {
        this.nif = nif;
        this.articulo = articulo;
        this.cod_fabricante = cod_fabricante;
        this.peso = peso;
        this.categoria = categoria;
        this.fecha_venta = fecha_venta;
        this.unidades_vendidas = unidades_vendidas;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public Timestamp getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Timestamp fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getUnidades_vendidas() {
        return unidades_vendidas;
    }

    public void setUnidades_vendidas(int unidades_vendidas) {
        this.unidades_vendidas = unidades_vendidas;
    }

    @Override
    public String toString() {
        return "Venta: " + "nif=" + nif + ", articulo=" + articulo + ", cod_fabricante=" + cod_fabricante + ", peso=" + peso + ", categoria=" + categoria + ", fecha_venta=" + fecha_venta + ", unidades_vendidas=" + unidades_vendidas;
    }
    
    
}
