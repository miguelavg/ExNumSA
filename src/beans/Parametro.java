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
    private double temperaturaInicial;
    private double temperaturaFinal;
    private double alfaSA;
    private double alfaGrasp;
    private double parada;
    private int kSA;
    private String xmlAeropuertos;
    private String xmlVuelos;
    private String xmlEnvio;

    public Parametro(double temperaturaInicial, double temperaturaFinal, double alfaSA, double alfaGrasp, double parada, int kSA, String xmlAeropuertos, String xmlVuelos, String xmlEnvio) {
        this.temperaturaInicial = temperaturaInicial;
        this.temperaturaFinal = temperaturaFinal;
        this.alfaSA = alfaSA;
        this.alfaGrasp = alfaGrasp;
        this.parada = parada;
        this.kSA = kSA;
        this.xmlAeropuertos = xmlAeropuertos;
        this.xmlVuelos = xmlVuelos;
        this.xmlEnvio = xmlEnvio;
    }

    public double getTemperaturaInicial() {
        return temperaturaInicial;
    }

    public double getTemperaturaFinal() {
        return temperaturaFinal;
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

    public int getkSA() {
        return kSA;
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
