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
public class Aeropuerto {
    private int idAeropuerto;
    private String nombre;
    private double x;
    private double y;
    private double costoAlmacen;
    private int capacMax;
    private int capacActual;
    private boolean principal;
    private ArrayList<Vuelo> vuelosSalida;
    private ArrayList<Vuelo> vuelosLlegada;

    public Aeropuerto(int idAeropuerto, String nombre, double x, double y, double costoAlmacen, int capacMax, int capacActual, boolean principal) {
        this.idAeropuerto = idAeropuerto;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.costoAlmacen = costoAlmacen;
        this.capacMax = capacMax;
        this.capacActual = capacActual;
        this.principal = principal;
        this.vuelosLlegada = new ArrayList<Vuelo>();
        this.vuelosSalida = new ArrayList<Vuelo>();
    }

    public int getIdAeropuerto() {
        return idAeropuerto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCostoAlmacen() {
        return costoAlmacen;
    }

    public int getCapacMax() {
        return capacMax;
    }

    public int getCapacActual() {
        return capacActual;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public ArrayList<Vuelo> getVuelosLlegada() {
        return vuelosLlegada;
    }
    
    public ArrayList<Vuelo> getVuelosSalida() {
        return vuelosSalida;
    }
}
