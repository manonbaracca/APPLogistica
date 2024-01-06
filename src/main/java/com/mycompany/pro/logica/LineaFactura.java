
package com.mycompany.pro.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LineaFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLinea; 
    private int cantidadLinea;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    private String descripcion;
    private double precio;
    private double iva;
    private double costoTotal;

    public LineaFactura() {
    }

    public LineaFactura(int idLinea, int cantidadLinea, Factura factura, Producto producto, String descripcion, double precio, double iva, double costoTotal) {
        this.idLinea = idLinea;
        this.cantidadLinea = cantidadLinea;
        this.factura = factura;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.costoTotal = costoTotal;
    }

    public int getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }

    public int getCantidadLinea() {
        return cantidadLinea;
    }

    public void setCantidadLinea(int cantidadLinea) {
        this.cantidadLinea = cantidadLinea;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
    
}
