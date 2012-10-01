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
    private Date fechaRegistro;
    private Date fecha;

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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }
}
