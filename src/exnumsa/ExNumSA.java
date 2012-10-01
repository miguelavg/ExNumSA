/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exnumsa;

import beans.*;
import java.util.ArrayList;

/**
 *
 * @author miguelavg
 */
public class ExNumSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Aeropuerto> a = Serializer.deserializar("miguel.xml");
        
        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i).nombre);
        }
    }
}
