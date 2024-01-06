
package com.mycompany.pro.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Empaquetado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idEmpaquetado;
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private double pesoTotal;
    private int numeroContenedores;

    public int getNumeroContenedores() {
        return numeroContenedores;
    }

    public void setNumeroContenedores(int numeroContenedores) {
        this.numeroContenedores = numeroContenedores;
    }
    

    public Empaquetado() {
    }

    public Empaquetado(int idEmpaquetado, Pedido pedido, double pesoTotal, int numeroContenedores) {
        this.idEmpaquetado = idEmpaquetado;
        this.pedido = pedido;
        this.pesoTotal = pesoTotal;
        this.numeroContenedores = numeroContenedores;
    }

  


    public int getIdEmpaquetado() {
        return idEmpaquetado;
    }

    public void setIdEmpaquetado(int idEmpaquetado) {
        this.idEmpaquetado = idEmpaquetado;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    
    
}
