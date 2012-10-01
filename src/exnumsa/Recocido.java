/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exnumsa;

import beans.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author miguelavg
 */
public class Recocido {

    private double tInicial;
    private double tFinal;
    private double alfa;
    private int beta;
    private ArrayList<Aeropuerto> aeropuertos;
    private ArrayList<Vuelo> vuelos;
    private Envio envio;
    private ArrayList<Vuelo> solucion;
    private ArrayList<Vuelo> alterado;

    public Recocido(String archParametros) {
        Parametro parametro = (Parametro) Serializer.deserializar(archParametros).get(0);
        this.tInicial = parametro.gettInicial();
        this.tFinal = parametro.gettFinal();
        this.alfa = parametro.getAlfa();
        this.beta = parametro.getBeta();
        this.aeropuertos = Serializer.deserializar(parametro.getXmlAeropuertos());
        this.vuelos = Serializer.deserializar(parametro.getXmlVuelos());
        this.envio = (Envio) Serializer.deserializar(parametro.getXmlEnvio()).get(0);
    }

    private double estadoEnergia(ArrayList<Vuelo> vuelos) {
        Date llegada = this.envio.getFechaRegistro();
        Vuelo vuelo;
        long milisec;
        double iCostoAlmacen;
        double iCostoEnvio;
        double costoAlmacen = 0;
        double costoEnvio = 0;
        double costo = 0;

        double pLleno;
        double pCapacidad;
        Random rnd = new Random();

        for (int i = 0; i < vuelos.size(); i++) {
            vuelo = vuelos.get(i);
            milisec = vuelo.getfSalida().getTime() - llegada.getTime();

            iCostoAlmacen = vuelo.getOrigen().getCostoAlmacen() * (double) milisec / 60000;
            costoAlmacen = costoAlmacen + iCostoAlmacen;

            pLleno = rnd.nextDouble() * 0.2 + 0.8;
            pCapacidad = Math.max(pLleno * vuelo.getCapacEnvioMax(), vuelo.getCapacEnviUsada());

            iCostoEnvio = (double) vuelo.getCostoAlquiler() / pCapacidad;
            costoEnvio = costoEnvio + iCostoEnvio;
        }

        costo = costoEnvio + costoAlmacen;
        return costo;
    }

    private double boltzmann(double dEnergia, double temperatura) {
        return Math.exp(-1 * (dEnergia / temperatura));
    }

    private ArrayList<Vuelo> liteGrasp(ArrayList<Vuelo> vuelos) {
        return null;
    }

    private ArrayList<Vuelo> alteracionMolecular(ArrayList<Vuelo> vuelos) {
        return null;
    }

    public void simular() {

        this.solucion = liteGrasp(this.vuelos);
        Random rnd = new Random();

        double dEnergia;
        double b, p;
        int iteraciones = (int) (Math.log(this.tFinal / this.tInicial) / Math.log(this.alfa));

        for (double temperatura = this.tInicial; temperatura > this.tFinal; temperatura = this.alfa * temperatura) {
            for (int k = 0; k < this.beta; k++) {

                this.alterado = alteracionMolecular(this.solucion);
                dEnergia = estadoEnergia(this.alterado) - estadoEnergia(this.solucion);

                if (dEnergia > 0) {

                    b = boltzmann(dEnergia, temperatura);
                    p = rnd.nextDouble();

                    if (p <= b) {
                        this.solucion = this.alterado;
                    }      
                } else {
                    this.solucion = this.alterado;
                }
            }
        }

    }
}
