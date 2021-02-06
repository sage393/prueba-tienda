/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.services;

import com.sgonzalez.ws.tienda.ejb.GenericoSessionBeanLocal;
import com.sgonzalez.ws.tienda.entities.Producto;
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
@WebService(serviceName = "ProductoWS")
public class ProductoWS {
    
    @Inject
    private GenericoSessionBeanLocal gsbl;

    /**
     * This is a sample web service operation
     * @return String
     */
    @WebMethod(operationName = "obtenerProductos")
    public Collection<Producto> obtenerProductos() {
        try {
            return gsbl.obtenerTodos(Producto.class);
        } catch (Exception ex) {
            Logger.getLogger(ProductoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return Producto
     */
    @WebMethod(operationName = "obtenerProducto")
    public Producto obtenerProducto(@WebParam(name = "id") Long id) {
        try {
            return gsbl.obtenerPorId(Producto.class, id);
        } catch (Exception ex) {
            Logger.getLogger(ProductoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param producto
     * @return Producto
     */
    @WebMethod(operationName = "agregarProducto")
    public Producto agregarProducto(@WebParam(name = "producto") Producto producto) {
        try {
            return gsbl.guardar(Producto.class, producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param id
     * @return Boolean
     */
    @WebMethod(operationName = "eliminarProducto")
    public Boolean eliminarProducto(@WebParam(name = "id") Long id) {
        try {
            Producto producto = gsbl.obtenerPorId(Producto.class, id);
            gsbl.eliminar(Producto.class, producto);
            
            return Boolean.TRUE;
        } catch (Exception ex) {
            Logger.getLogger(ProductoWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Boolean.FALSE;
    }
    
}
