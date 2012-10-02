/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author miguelavg
 */
public class Vuelo {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int idOrigen;
    private int idDestino;
    private Date fSalida;
    private Date fLlegada;
    private double costoAlquiler;
    private int capacEnvioMax;
    private int capacEnviUsada;

    public Vuelo(int idOrigen, int idDestino, Date fSalida, Date fLlegada, double costoAlquiler, int capacEnvioMax, int capacEnviUsada) {
        this.idOrigen = idOrigen;
        this.idDestino = idDestino;
        this.fSalida = fSalida;
        this.fLlegada = fLlegada;
        this.costoAlquiler = costoAlquiler;
        this.capacEnvioMax = capacEnvioMax;
        this.capacEnviUsada = capacEnviUsada;
        
        
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public int getIdDestino() {
        return idDestino;
    }
    
    public Date getfSalida() {
        return fSalida;
    }

    public Date getfLlegada() {
        return fLlegada;
    }

    public int getCapacEnvioMax() {
        return capacEnvioMax;
    }

    public int getCapacEnviUsada() {
        return capacEnviUsada;
    }
    
    public double getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }
    
    
}
