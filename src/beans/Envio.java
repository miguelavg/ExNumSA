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
    private int idAeropuertoInicio;
    private int idAeropuertoFin;
    private Date fecha;

    public Envio(Aeropuerto idAeropuertoInicio, Aeropuerto idAeropuertoFin, Date fecha) {
        this.origen = idAeropuertoInicio;
        this.destino = idAeropuertoFin;
        this.fecha = fecha;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getIdAeropuertoInicio() {
        return idAeropuertoInicio;
    }

    public int getIdAeropuertoFin() {
        return idAeropuertoFin;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }  
}
