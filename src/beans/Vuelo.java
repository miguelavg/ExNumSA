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
    private Date fSalida;
    private Date fLlegada;
    private double costoAlquiler;
    private int capacEnvioMax;
    private int capacEnviUsada;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, Date fSalida, Date fLlegada, double costoAlquiler, int capacEnvioMax, int capacEnviUsada) {
        this.origen = origen;
        this.destino = destino;
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
}
