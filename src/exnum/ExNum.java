/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exnum;

import beans.*;

/**
 *
 * @author miguelavg
 */
public class ExNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parametro parametros = (Parametro) Serializer.deserializar("parametros.xml").get(0);
        int numExperimentos = parametros.getNumExperimentos();
        int numRepeticiones = parametros.getNumRepeticiones();

        if (args.length != 1 || (!args[0].equals("-sa") && !args[0].equals("-g"))) {
            System.out.println("¡Malos parámetros! '-sa': Recocido simulado, '-g': Grasp");
            return;
        }


        for (int i = 0; i < numExperimentos; i++) {
            for (int j = 0; j < numRepeticiones; j++) {
                Recocido algSA = new Recocido(parametros, i);
                Resultado resultado = null;

                if (args[0].equals("-g")) {
                    resultado = algSA.grasp();
                }

                if (args[0].equals("-sa")) {
                    resultado = algSA.simular();
                }

                //Resultado resultado = algSA.grasp();

                if (resultado != null) {
                    resultado.imprimirResultados();
                } else {
                    System.out.println("¡No hay solución!");
                }
            }
            System.out.println("----------------");
        }
    }
}
