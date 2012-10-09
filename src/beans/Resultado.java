/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author miguelavg
 */
public class Resultado {

    long tiempo;
    int costo;
    Envio envio;
    ArrayList<Vuelo> solucion;

    public Resultado(Envio envio, long tiempo, int costo, ArrayList<Vuelo> solucion) {
        this.envio = envio;
        this.tiempo = tiempo;
        this.costo = costo;
        this.solucion = solucion;
    }

    public Envio getEnvio() {
        return envio;
    }
    public long getTiempo() {
        return tiempo;
    }

    public int getCosto() {
        return costo;
    }

    public ArrayList<Vuelo> getSolucion() {
        return this.solucion;
    }

    public void imprimirResultados() {
        System.out.println(costo + "\t" + (double) this.tiempo / 1000);
        
    }
}
