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
    private float tInicial;
    private float tFinal;
    private int beta;
    private int alfa;

    public Parametro(float tInicial, float tFinal, int beta, int alfa) {
        this.tInicial = tInicial;
        this.tFinal = tFinal;
        this.beta = beta;
        this.alfa = alfa;
    }
}
