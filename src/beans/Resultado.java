/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author miguelavg
 */
public class Resultado {
    double tiempo;
    double costo;

    public Resultado(double tiempo, double costo) {
        this.tiempo = tiempo;
        this.costo = costo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getCosto() {
        return costo;
    }  
}
