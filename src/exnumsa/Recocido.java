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
public class Recocido {
    private double tInicial;
    private double tFinal;
    private double alfa;
    private int beta;
    private ArrayList<Aeropuerto> aeropuertos;
    private ArrayList<Vuelo> vuelos;
    private Envio envio;
    
    public Recocido(String archParametros){
        Parametro parametro = (Parametro) Serializer.deserializar(archParametros).get(0);
        this.tInicial = parametro.gettInicial();
        this.tFinal = parametro.gettFinal();
        this.alfa = parametro.getAlfa();
        this.beta = parametro.getBeta();
        this.aeropuertos = Serializer.deserializar(parametro.getXmlAeropuertos());
        this.vuelos = Serializer.deserializar(parametro.getXmlVuelos());
        this.envio = (Envio) Serializer.deserializar(parametro.getXmlEnvio()).get(0);
    }
    
    private double estadoEnergia(ArrayList<Vuelo> vuelos){
        Date llegada = this.envio.getFechaRegistro();
        Vuelo vuelo;
        long milisec;
        double iCostoAlmacen;
        double iCosto;
        double costoAlmacen = 0;
        double costoEnvio = 0;
        double costo = 0;
        
        for(int i = 0; i < vuelos.size(); i++){
            vuelo = vuelos.get(i);
            milisec = vuelo.getfSalida().getTime() - llegada.getTime();
            iCostoAlmacen = vuelo.getOrigen().getCostoAlmacen() * (double) milisec / 60000;
            costoAlmacen = costoAlmacen + iCostoAlmacen;
            
            costoEnvio = vuelo.getCostoAlquiler() * (double) vuelo.getCapacEnviUsada() / vuelo.getCapacEnvioMax();
        }
        
        
        
        return 0;
    }
    
    public void simular(){
        
    }
            
}
