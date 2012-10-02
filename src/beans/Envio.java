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
public class Envio {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private int idOrigen;
    private int idDestino;
    private Date fechaRegistro;

    public Envio(Aeropuerto origen, Aeropuerto destino, Date fechaRegistro) {
        this.origen = origen;
        this.destino = destino;
        this.fechaRegistro = fechaRegistro;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }  
}
