/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.services;

import com.sgonzalez.ws.tienda.ejb.GenericoSessionBeanLocal;
import com.sgonzalez.ws.tienda.entities.Cliente;
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
@WebService(serviceName = "ClienteWS")
public class ClienteWS {
    
    @Inject
    private GenericoSessionBeanLocal gsbl;

    /**
     * This is a sample web service operation
     * @return String
     */
    @WebMethod(operationName = "obtenerClientes")
    public Collection<Cliente> obtenerClientes() {
        try {
            return gsbl.obtenerTodos(Cliente.class);
        } catch (Exception ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Web service operation
     * @param id
     * @return Cliente
     */
    @WebMethod(operationName = "obtenerCliente")
    public Cliente obtenerCliente(@WebParam(name = "id") Long id) {
        try {
            return gsbl.obtenerPorId(Cliente.class, id);
        } catch (Exception ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param cliente
     * @return Cliente
     */
    @WebMethod(operationName = "agregarCliente")
    public Cliente agregarCliente(@WebParam(name = "cliente") Cliente cliente) {
        try {
            return gsbl.guardar(Cliente.class, cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Web service operation
     * @param id
     * @return Boolean
     */
    @WebMethod(operationName = "eliminarCliente")
    public Boolean eliminarCliente(@WebParam(name = "id") Long id) {
        try {
            Cliente cliente = gsbl.obtenerPorId(Cliente.class, id);
            gsbl.eliminar(Cliente.class, cliente);
            
            return Boolean.TRUE;
        } catch (Exception ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Boolean.FALSE;
    }
    
}
