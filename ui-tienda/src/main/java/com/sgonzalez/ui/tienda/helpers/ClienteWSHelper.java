/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.helpers;

import com.sgonzalez.ws.tienda.services.Cliente;
import com.sgonzalez.ws.tienda.services.ClienteWS;
import com.sgonzalez.ws.tienda.services.ClienteWS_Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.internal.tool.Main;

/**
 *
 * @author sam
 */
public class ClienteWSHelper {
    
    private ClienteWS clienteProxy;

    public ClienteWSHelper() {
        try {
            URL url = new URL("http://localhost:8080/ws-tienda-services/ClienteWS?wsdl");
            ClienteWS_Service cliente = new ClienteWS_Service(url);
            clienteProxy = cliente.getClienteWSPort();
        } catch (MalformedURLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Cliente agregarCliente(Cliente cliente) throws Exception {
        return clienteProxy.agregarCliente(cliente);
    }
    
    public Boolean eliminarCliente(Long id) throws Exception {
        return clienteProxy.eliminarCliente(id);
    }
    
    public Cliente buscarCliente(Long id) throws Exception {
        return clienteProxy.obtenerCliente(id);
    }
    
    public Collection<Cliente> buscarClientes() throws Exception {
        return clienteProxy.obtenerClientes();
    }
            
            
    
}
