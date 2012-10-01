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
    private int capacEnvioMax;
    private int capacEnviUsada;

    public Vuelo(Aeropuerto origen, Aeropuerto destino, Date fSalida, Date fLlegada, int capacEnvioMax, int capacEnviUsada) {
        this.origen = origen;
        this.destino = destino;
        this.fSalida = fSalida;
        this.fLlegada = fLlegada;
        this.capacEnvioMax = capacEnvioMax;
        this.capacEnviUsada = capacEnviUsada;
    }
}
