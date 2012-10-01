/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exnumsa;

import beans.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author miguelavg
 */
public class ExNumSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Recocido algSA = new Recocido("parametros.xml");
        algSA.simular();
    }
}
