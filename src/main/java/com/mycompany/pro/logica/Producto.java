
package com.mycompany.pro.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Producto implements Serializable {
    @Id
    private int idProducto;
    private double precio;
    private String descripcion;
    private double peso;
    private double iva;
    private int cantidadProducto;


    public Producto() {
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Producto(int idProducto, double precio, String descripcion, double peso, double iva, int cantidadProducto) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.peso = peso;
        this.iva = iva;
        this.cantidadProducto = cantidadProducto;
    }


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
}
