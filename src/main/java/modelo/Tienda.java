/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Diurno
 */
public class Tienda {
    
    private String nif;
    private String nombre;
    private String direccion; 
    private String poblacion;
    private String provincia;
    private int codpostal; 

    public Tienda(String nif, String nombre, String direccion, String poblacion, String provincia, int codpostal) {
        this.nif = nif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.codpostal = codpostal;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(int codpostal) {
        this.codpostal = codpostal;
    }

    @Override
    public String toString() {
        return "Tienda: " + "nif=" + nif + ", nombre=" + nombre + ", direccion=" + direccion + ", poblacion=" + poblacion + ", provincia=" + provincia + ", codpostal=" + codpostal;
    }
    
    
}
