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
    private double alfa;
    private int beta;
    private String xmlAeropuertos;
    private String xmlVuelos;

    public Parametro(double tInicial, double tFinal, double alfa, int beta, String xmlAeropuertos, String xmlVuelos) {
        this.tInicial = tInicial;
        this.tFinal = tFinal;
        this.alfa = alfa;
        this.beta = beta;
        this.xmlAeropuertos = xmlAeropuertos;
        this.xmlVuelos = xmlVuelos;
    }

    public double gettInicial() {
        return tInicial;
    }

    public double gettFinal() {
        return tFinal;
    }

    public double getAlfa() {
        return alfa;
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
    
    
}
