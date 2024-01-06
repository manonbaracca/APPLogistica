
package com.mycompany.pro.logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class RutaAerea extends Ruta {




    public RutaAerea() {
    }

    public RutaAerea(int idRuta, String origen, String destino, String consignee, String shipper, int tiempoEnvio, int idUsu) {
        super(idRuta, origen, destino, consignee, shipper, tiempoEnvio, idUsu);
    }
    @Override
    public int getIdUsu() {
        return idUsu;
    }
    @Override
    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }



    
    @Override
    public int getIdRuta() {
        return idRuta;
    }

    @Override
    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    @Override
    public String getOrigen() {
        return origen;
    }

    @Override
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public String getDestino() {
        return destino;
    }
    @Override
    public void setDestino(String destino) {
        this.destino = destino;
    }
    @Override
    public String getConsignee() {
        return consignee;
    }
    @Override
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }
    @Override
    public String getShipper() {
        return shipper;
    }
    @Override
    public void setShipper(String shipper) {
        this.shipper = shipper;
    }
    @Override
    public int getTiempoEnvio() {
        return tiempoEnvio;
    }
    @Override
    public void setTiempoEnvio(int tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }
    
    
}
