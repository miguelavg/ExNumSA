/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author miguelavg
 */
public class Parametro {
    private double tInicial;
    private double tFinal;
    private double alfaSA;
    private double alfaGrasp;
    private double parada;
    private int beta;
    private String xmlAeropuertos;
    private String xmlVuelos;
    private String xmlEnvio;

    public Parametro(double tInicial, double tFinal, double alfaSA, double alfaGrasp, double parada, int beta, String xmlAeropuertos, String xmlVuelos, String xmlEnvio) {
        this.tInicial = tInicial;
        this.tFinal = tFinal;
        this.alfaSA = alfaSA;
        this.alfaGrasp = alfaGrasp;
        this.parada = parada;
        this.beta = beta;
        this.xmlAeropuertos = xmlAeropuertos;
        this.xmlVuelos = xmlVuelos;
        this.xmlEnvio = xmlEnvio;
    }

    public double gettInicial() {
        return tInicial;
    }

    public double gettFinal() {
        return tFinal;
    }

    public double getAlfaSA() {
        return alfaSA;
    }

    public double getAlfaGrasp() {
        return alfaGrasp;
    }

    public double getParada() {
        return parada;
    }

    public int getBeta() {
        return beta;
    }

    public String getXmlAeropuertos() {
        return xmlAeropuertos;
    }

    public String getXmlVuelos() {
        return xmlVuelos;
    }

    public String getXmlEnvio() {
        return xmlEnvio;
    }
}
