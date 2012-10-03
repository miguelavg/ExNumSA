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
    private int idAeropuertoInicial;
    private int idAeropuertoFin;
    private Date fecha;

    public Envio(Aeropuerto idAeropuertoInicial, Aeropuerto idAeropuertoFin, Date fecha) {
        this.origen = idAeropuertoInicial;
        this.destino = idAeropuertoFin;
        this.fecha = fecha;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getIdAeropuertoInicial() {
        return idAeropuertoInicial;
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
