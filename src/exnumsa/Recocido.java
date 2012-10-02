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
    private double alfaSA;
    private double alfaGrasp;
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
        this.alfaSA = parametro.getAlfaSA();
        this.alfaGrasp = parametro.getAlfaGrasp();
        this.beta = parametro.getBeta();
        this.aeropuertos = Serializer.deserializar(parametro.getXmlAeropuertos());
        this.vuelos = Serializer.deserializar(parametro.getXmlVuelos());

        for (int i = 0; i < this.vuelos.size(); i++) {
            Vuelo vuelo = this.vuelos.get(i);

            for (int j = 0; j < this.aeropuertos.size(); j++) {
                Aeropuerto aeropuerto = this.aeropuertos.get(j);

                if (aeropuerto.getIdAeropuerto() == vuelo.getIdOrigen()) {
                    vuelo.setOrigen(aeropuerto);
                    aeropuerto.getVuelosSalida().add(vuelo);
                }

                if (aeropuerto.getIdAeropuerto() == vuelo.getIdDestino()) {
                    vuelo.setDestino(aeropuerto);
                    aeropuerto.getVuelosLlegada().add(vuelo);
                }

            }
        }

        this.envio = (Envio) Serializer.deserializar(parametro.getXmlEnvio()).get(0);
        for (int i = 0; i < this.aeropuertos.size(); i++) {
            Aeropuerto aeropuerto = this.aeropuertos.get(i);

            if (aeropuerto.getIdAeropuerto() == envio.getIdOrigen()) {
                envio.setOrigen(aeropuerto);
            }

            if (aeropuerto.getIdAeropuerto() == envio.getIdDestino()) {
                envio.setDestino(aeropuerto);
            }

        }
    }

    private double estadoEnergia(ArrayList<Vuelo> vuelos) {
        Date llegada = this.envio.getFechaRegistro();
        Vuelo vuelo;
        long milisec;
        double iCostoAlmacen;
        double iCostoEnvio;
        double costoAlmacen = 0;
        double costoEnvio = 0;
        double costo;

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

    private ArrayList<Vuelo> liteGrasp(ArrayList<Vuelo> vuelos, Aeropuerto origen, Aeropuerto destino) {
        Aeropuerto aActual = origen;
        Aeropuerto aDestino = destino;

        Date dActual = envio.getFechaRegistro();
        int iActual = envio.getOrigen().getIdAeropuerto();
        int iFinal = envio.getDestino().getIdAeropuerto();

        ArrayList<Vuelo> posibles;
        ArrayList<Vuelo> rcl;
        
        double bet = Double.MAX_VALUE;
        double tau = 0;
        double e;

        // Mientras no hayamos llegado al final...

        while (iActual != iFinal && aActual.getCapacMax() > aActual.getCapacActual()) {
            posibles = new ArrayList<Vuelo>();

            for (int i = 0; i < aActual.getVuelosSalida().size(); i++) {
                Vuelo vuelo = aActual.getVuelosSalida().get(i);

                // si se es posible, calcular energía

                if (vuelo.getfSalida().after(dActual)
                        && vuelo.getCapacEnvioMax() > vuelo.getCapacEnviUsada()
                        && aDestino.getCapacMax() > aDestino.getCapacActual() + vuelo.getCapacEnviUsada())
                {
                    posibles.add(vuelo);
                    ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                    wrap.add(vuelo);
                    e = estadoEnergia(wrap);

                    if (e < bet) {
                        bet = e;
                    }
                    if (e > tau) {
                        tau = e;
                    }

                }

            }
            
            rcl = new ArrayList<Vuelo>();
            
            for(int i = 0; i < posibles.size(); i++){
                Vuelo vuelo = posibles.get(i);
                ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                wrap.add(vuelo);
                e = estadoEnergia(wrap);
                
                if(bet <= e && e <= bet + this.alfaGrasp*(tau - bet)){
                    rcl.add(vuelo);
                }
            }
            
            
        }

        return null;
    }

    private ArrayList<Vuelo> alteracionMolecular(ArrayList<Vuelo> vuelos) {
        return null;
    }

    public void simular() {

        this.solucion = liteGrasp(this.vuelos, envio.getOrigen(), envio.getDestino());
        Random rnd = new Random();

        double dEnergia;
        double b, p;
        int iteraciones = (int) (Math.log(this.tFinal / this.tInicial) / Math.log(this.alfaSA));

        for (double temperatura = this.tInicial; temperatura > this.tFinal; temperatura = this.alfaSA * temperatura) {
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
