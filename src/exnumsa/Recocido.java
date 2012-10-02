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

    private int kSA;                           // iteraciones por temperatura
    private double temperaturaInicial;                    // temperatura inicial
    private double temperatura;
    private double temperaturaFinal;                      // temperatura final
    private double alfaSA;                      // coeficiente de reducción de temperatura
    private double alfaGrasp;                   // coeficiente de relajación del grasp construcción
    private double parada;                      // porcentaje de malas iteraciones para parar
    private Envio envio;                        // envío a realizar
    private ArrayList<Aeropuerto> aeropuertos;  // todos los aeropuertos
    private ArrayList<Vuelo> vuelos;            // todos los vuelos
    private ArrayList<Vuelo> solucion;          // ruta solución
    private ArrayList<Vuelo> alterado;          // ruta alterada

    public Recocido(String archParametros) {
        Parametro parametro = (Parametro) Serializer.deserializar(archParametros).get(0);
        this.envio = (Envio) Serializer.deserializar(parametro.getXmlEnvio()).get(0);
        this.temperaturaInicial = parametro.getTemperaturaInicial();
        this.temperatura = this.temperaturaInicial;
        this.temperaturaFinal = parametro.getTemperaturaFinal();
        this.alfaSA = parametro.getAlfaSA();
        this.alfaGrasp = parametro.getAlfaGrasp();
        this.kSA = parametro.getkSA();
        this.parada = parametro.getParada();

        this.aeropuertos = Serializer.deserializar(parametro.getXmlAeropuertos());
        this.vuelos = Serializer.deserializar(parametro.getXmlVuelos());

        for (int i = 0; i < this.aeropuertos.size(); i++) {
            Aeropuerto aeropuerto = this.aeropuertos.get(i);

            if (aeropuerto.getIdAeropuerto() == envio.getIdOrigen()) {
                envio.setOrigen(aeropuerto);
            }

            if (aeropuerto.getIdAeropuerto() == envio.getIdDestino()) {
                envio.setDestino(aeropuerto);
            }

            for (int j = 0; j < this.vuelos.size(); j++) {
                Vuelo vuelo = this.vuelos.get(j);

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
    }

    private double enfriamiento() {
        this.temperatura = this.alfaSA * this.temperatura;
        return this.temperatura;
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

    private ArrayList<Vuelo> liteGrasp(Aeropuerto aOrigen, Aeropuerto aDestino, Date fecha, double alfa) {
        Aeropuerto aActual = aOrigen;
        Random rnd = new Random();

        Date dActual = fecha;
        int iActual = aActual.getIdAeropuerto();
        int iFinal = aDestino.getIdAeropuerto();

        ArrayList<Vuelo> posibles;
        ArrayList<Vuelo> construccion = new ArrayList<Vuelo>();
        ArrayList<Vuelo> rcl;
        Vuelo aleatorio;

        double beta = Double.MAX_VALUE;
        double tau = 0;
        double e;

        // Mientras no hayamos llegado al final...

        while (iActual != iFinal && aActual.getCapacMax() > aActual.getCapacActual()) {
            posibles = new ArrayList<Vuelo>();

            // Calcular los vuelos posibles, el beta y el tau

            for (int i = 0; i < aActual.getVuelosSalida().size(); i++) {
                Vuelo vuelo = aActual.getVuelosSalida().get(i);

                if (vuelo.getfSalida().after(dActual)
                        && vuelo.getCapacEnvioMax() > vuelo.getCapacEnviUsada()
                        && aDestino.getCapacMax() > aDestino.getCapacActual() + vuelo.getCapacEnviUsada()) {
                    posibles.add(vuelo);
                    ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                    wrap.add(vuelo);
                    e = estadoEnergia(wrap);

                    if (e < beta) {
                        beta = e;
                    }
                    if (e > tau) {
                        tau = e;
                    }

                }

            }

            rcl = new ArrayList<Vuelo>();

            for (int i = 0; i < posibles.size(); i++) {
                Vuelo vuelo = posibles.get(i);
                ArrayList<Vuelo> wrap = new ArrayList<Vuelo>();
                wrap.add(vuelo);
                e = estadoEnergia(wrap);

                if (beta <= e && e <= beta + alfa * (tau - beta)) {
                    rcl.add(vuelo);
                }
            }

            aleatorio = rcl.get(rnd.nextInt(rcl.size()));
            construccion.add(aleatorio);

            aActual = aleatorio.getDestino();
            iActual = aActual.getIdAeropuerto();
            dActual = aleatorio.getfLlegada();
            beta = Double.MAX_VALUE;
            tau = 0;

        }

        if (iActual != iFinal) {
            return null;
        }

        return construccion;
    }

    private ArrayList<Vuelo> alteracionMolecular() {
        Random rnd = new Random();
        this.alterado = new ArrayList<Vuelo>();

        int iAleatorio = rnd.nextInt(this.solucion.size());
        Vuelo aleatorio = this.solucion.get(iAleatorio);
        Aeropuerto pivote = aleatorio.getOrigen();

        for (int i = 0; i < iAleatorio; i++) {
            alterado.add(this.solucion.get(i));
        }

        Date fecha;

        if (iAleatorio > 0) {
            fecha = solucion.get(iAleatorio - 1).getfLlegada();
        } else {
            fecha = envio.getFechaRegistro();
        }

        ArrayList<Vuelo> construccion = liteGrasp(pivote, envio.getDestino(), fecha, this.alfaGrasp);

        if (construccion == null) {
            this.alterado = null;
            return null;
        }

        for (int i = 0; i < construccion.size(); i++) {
            this.alterado.add(construccion.get(i));
        }

        return alterado;
    }

    public Resultado simular() {
        Random rnd = new Random();
        long tiempoInicio, tiempoFin;
        double dEnergia;
        double b, p;

        int iteraciones = (int) (Math.log(this.temperaturaFinal / this.temperaturaInicial) / Math.log(this.alfaSA));
        int outIt = 0;

        tiempoInicio = new Date().getTime();

        for (int i = 0; i < 100; i++) {
            this.solucion = liteGrasp(envio.getOrigen(), envio.getDestino(), envio.getFechaRegistro(), this.alfaGrasp);
            if (this.solucion != null) {
                break;
            }
        }

        if (this.solucion == null) {
            return null;
        }

        while (this.temperatura > this.temperaturaFinal) {

            for (int k = 0; k < this.kSA; k++) {

                for (int i = 0; i < 100; i++) {
                    this.alteracionMolecular();
                    if (this.alterado != null) {
                        break;
                    }
                }

                if (this.alterado == null) {
                    outIt++;
                    continue;
                }

                dEnergia = estadoEnergia(this.alterado) - estadoEnergia(this.solucion);

                if (dEnergia > 0) {

                    outIt++;
                    b = boltzmann(dEnergia, temperatura);
                    p = rnd.nextDouble();

                    if (p <= b) {
                        this.solucion = this.alterado;
                    }
                } else {
                    outIt = 0;
                    this.solucion = this.alterado;
                }

                if (outIt >= iteraciones * this.parada) {
                    tiempoFin = new Date().getTime();
                    return new Resultado(tiempoFin - tiempoInicio, estadoEnergia(this.solucion));
                }

            }

            this.enfriamiento();
        }

        tiempoFin = new Date().getTime();
        return new Resultado(tiempoFin - tiempoInicio, estadoEnergia(this.solucion));
    }
}