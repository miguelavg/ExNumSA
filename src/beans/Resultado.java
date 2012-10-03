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
        System.out.println("Envío :");
        System.out.println("- Origen:  " + envio.getOrigen().getIdAeropuerto());
        System.out.println("- Destino:  " + envio.getDestino().getIdAeropuerto());
        System.out.println("-- Hora de registro: " + envio.getFecha());
        System.out.println();
        
        if (this.solucion == null) {
            return;
        }
        
        for (int i = 0; i < this.solucion.size(); i++) {
            Vuelo vuelo = this.solucion.get(i);
            System.out.println("Vuelo " + i + ":");
            System.out.println("- Origen:  " + vuelo.getOrigen().getIdAeropuerto());
            System.out.println("-- Hora de salida: " + vuelo.getfSalida());
            System.out.println("- Destino:  " + vuelo.getDestino().getIdAeropuerto());
            System.out.println("-- Hora de llegada: " + vuelo.getfLlegada());
            System.out.println();
        }
        
        System.out.println("Costo: " + (int) costo + "u");
        System.out.println("Tiempo de respuesta: " + (double) this.tiempo / 1000 + "s\n");
        
    }
}
