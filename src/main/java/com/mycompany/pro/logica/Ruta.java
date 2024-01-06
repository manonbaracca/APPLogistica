package com.mycompany.pro.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ruta implements Serializable {
    @Id
    protected int idRuta;
    protected String origen;
    protected String destino;
    protected String consignee; 
    protected String shipper;
    protected int tiempoEnvio;
    @Column(name = "IDUSU")
    protected int idUsu;

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

  
    public Ruta() {
    }

    public Ruta(int idRuta, String origen, String destino, String consignee, String shipper, int tiempoEnvio, int idUsu) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.consignee = consignee;
        this.shipper = shipper;
        this.tiempoEnvio = tiempoEnvio;
        this.idUsu= idUsu;
    }

    
 
    public int getTiempoEnvio() {
        return tiempoEnvio;
    }

    public void setTiempoEnvio(int tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }
    
}

