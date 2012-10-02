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

    double tiempo;
    double costo;
    Envio envio;
    ArrayList<Vuelo> solucion;

    public Resultado(Envio envio, double tiempo, double costo, ArrayList<Vuelo> solucion) {
        this.envio = envio;
        this.tiempo = tiempo;
        this.costo = costo;
        this.solucion = solucion;
    }

    public Envio getEnvio() {
        return envio;
    }
    public double getTiempo() {
        return tiempo;
    }

    public double getCosto() {
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
        
        System.out.println("Costo: " + this.costo + "u");
        System.out.println("Tiempo de respuesta: " + (double) this.tiempo / 1000 + "ms");
        
    }
}
