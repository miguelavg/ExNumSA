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
    private double pParada;
    private int intentos;
    private int iteracionesGrasp;
    private int kSA;
    private int numExperimentos;
    private int numRepeticiones;
    private String xmlAeropuertos;
    private String xmlVuelos;
    private String xmlEnvio;

    public Parametro(double temperaturaInicial, double temperaturaFinal, double alfaSA, double alfaGrasp, double pParada, int intentos, int iteracionesGrasp, int kSA, int numExperimentos, int numRepeticiones, String xmlAeropuertos, String xmlVuelos, String xmlEnvio) {
        this.temperaturaInicial = temperaturaInicial;
        this.temperaturaFinal = temperaturaFinal;
        this.alfaSA = alfaSA;
        this.alfaGrasp = alfaGrasp;
        this.pParada = pParada;
        this.intentos = intentos;
        this.iteracionesGrasp = iteracionesGrasp;
        this.kSA = kSA;
        this.numExperimentos = numExperimentos;
        this.numRepeticiones = numRepeticiones;
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

    public double getpParada() {
        return pParada;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getIteracionesGrasp() {
        return iteracionesGrasp;
    }

    public int getkSA() {
        return kSA;
    }

    public int getNumExperimentos() {
        return numExperimentos;
    }

    public int getNumRepeticiones() {
        return numRepeticiones;
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
