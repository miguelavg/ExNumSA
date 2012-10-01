/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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

    public Aeropuerto(int idAeropuerto, String nombre, double x, double y, double costoAlmacen, int capacMax, int capacActual, boolean principal) {
        this.idAeropuerto = idAeropuerto;
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.costoAlmacen = costoAlmacen;
        this.capacMax = capacMax;
        this.capacActual = capacActual;
        this.principal = principal;
    }
}
