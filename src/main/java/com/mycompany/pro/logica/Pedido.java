
package com.mycompany.pro.logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOS")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private Usuario usr; // Asociación con la clase Usuario
    
    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta; // Asociación con la clase Ruta
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empaquetado_id", referencedColumnName = "idEmpaquetado", nullable = true)
    private Empaquetado empaquetado; // Asociación con la clase Empaquetado
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id", referencedColumnName = "idFactura")
    private Factura factura; // Asociación con la clase Factura
    
    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;
    
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado; // Enum que representa los distintos estados del pedido
    
    public enum EstadoPedido {
        EN_PREPARACION, ENVIADO, RETRAZADO, FINALIZADO
    }

    public Pedido() {
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }

    public Pedido(int idPedido, Usuario usr, Ruta ruta, Empaquetado empaquetado, Factura factura, LocalDate fechaPedido, EstadoPedido estado) {
        this.idPedido = idPedido;
        this.usr = usr;
        this.ruta = ruta;
        this.empaquetado = empaquetado;
        this.factura = factura;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Empaquetado getEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(Empaquetado empaquetado) {
        this.empaquetado = empaquetado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }   
    
}

