/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.helpers;

import com.sgonzalez.ws.tienda.services.Orden;
import com.sgonzalez.ws.tienda.services.OrdenWS;
import com.sgonzalez.ws.tienda.services.OrdenWS_Service;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.internal.tool.Main;

/**
 *
 * @author sam
 */
public class OrdenWSHelper {
    
    private OrdenWS ordenProxy;

    public OrdenWSHelper() {
        try {
            URL url = new URL("http://localhost:8080/ws-tienda-services/OrdenWS?wsdl");
            OrdenWS_Service orden = new OrdenWS_Service(url);
            ordenProxy = orden.getOrdenWSPort();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Orden guardarOrden(Orden orden) throws Exception {
        return ordenProxy.agregarOrden(orden);
    }
    
    public Boolean eliminarOrden(Long id) throws Exception {
        return ordenProxy.eliminarOrden(id);
    }
    
    public Orden buscarOrden(Long id) throws Exception {
        return ordenProxy.obtenerOrden(id);
    }
    
    public Collection<Orden> buscarOrdenes() throws Exception {
        return ordenProxy.obtenerOrdenes();
    }
    
}
