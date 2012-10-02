/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exnumsa;

import beans.*;

/**
 *
 * @author miguelavg
 */
public class ExNumSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parametro parametros = (Parametro) Serializer.deserializar("parametros.xml").get(0);
        Recocido algSA = new Recocido(parametros, 0);
        Resultado resultado = algSA.simular();
        
        resultado.imprimirResultados();

    }
}
