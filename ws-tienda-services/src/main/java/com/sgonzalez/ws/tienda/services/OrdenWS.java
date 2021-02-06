/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.services;

import com.sgonzalez.ws.tienda.ejb.GenericoSessionBeanLocal;
import com.sgonzalez.ws.tienda.entities.Orden;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sam
 */
@WebService(serviceName = "OrdenWS")
public class OrdenWS {
    
    @Inject
    private GenericoSessionBeanLocal gsbl;

    /**
     * This is a sample web service operation
     * @return String
     */
    @WebMethod(operationName = "obtenerOrdenes")
    public Collection<Orden> obtenerOrdenes() {
        try {
            return gsbl.obtenerTodos(Orden.class);
        } catch (Exception ex) {
            Logger.getLogger(OrdenWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return Orden
     */
    @WebMethod(operationName = "obtenerOrden")
    public Orden obtenerOrden(@WebParam(name = "id") Long id) {
        try {
            return gsbl.obtenerPorId(Orden.class, id);
        } catch (Exception ex) {
            Logger.getLogger(OrdenWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param cliente
     * @return Orden
     */
    @WebMethod(operationName = "agregarOrden")
    public Orden agregarOrden(@WebParam(name = "cliente") Orden cliente) {
        try {
            return gsbl.guardar(Orden.class, cliente);
        } catch (Exception ex) {
            Logger.getLogger(OrdenWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param id
     * @return Boolean
     */
    @WebMethod(operationName = "eliminarOrden")
    public Boolean eliminarOrden(@WebParam(name = "id") Long id) {
        try {
            Orden orden = gsbl.obtenerPorId(Orden.class, id);
            gsbl.eliminar(Orden.class, orden);
            
            return Boolean.TRUE;
        } catch (Exception ex) {
            Logger.getLogger(OrdenWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Boolean.FALSE;
    }
    
}
