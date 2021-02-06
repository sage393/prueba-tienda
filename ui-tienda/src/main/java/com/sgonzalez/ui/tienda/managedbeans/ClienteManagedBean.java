/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.managedbeans;

import com.sgonzalez.ui.tienda.helpers.ClienteWSHelper;
import com.sgonzalez.ws.tienda.services.Cliente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sam
 */
@ManagedBean(name = "clienteManagedBean")
@ViewScoped
public class ClienteManagedBean {
    
    private Collection<Cliente> clientesList = new ArrayList<>();
    private ClienteWSHelper clienteWSHelper;
    private Cliente clienteEnEdicion = new Cliente();

    @PostConstruct
    public void init() {
        clienteWSHelper = new ClienteWSHelper();
        poblarClientes();
    }
    
    private void poblarClientes() {
        try {
            clientesList.clear();
            clientesList.addAll(clienteWSHelper.buscarClientes());
        } catch (Exception ex) {
            Logger.getLogger(ClienteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener clientes", ex.getMessage()));
        }
    }
    
    public void eliminarCliente(Cliente cliente) {
        try {
            clienteWSHelper.eliminarCliente(cliente.getId());
            poblarClientes();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Eliminado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(ClienteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", ex.getMessage()));
        }
    } 
    
    public void guardarCliente() {
        try {
            clienteWSHelper.agregarCliente(clienteEnEdicion);
            poblarClientes();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Guardado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(ClienteManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", ex.getMessage()));
        }
    }
    
    public void editarCliente(Cliente cliente) {
        clienteEnEdicion = cliente;
    }
    
    public void nuevoCliente() {
        clienteEnEdicion = new Cliente();
    }

    public Collection<Cliente> getClientesList() {
        return clientesList;
    }

    public void setClientesList(Collection<Cliente> clientesList) {
        this.clientesList = clientesList;
    }

    public Cliente getClienteEnEdicion() {
        return clienteEnEdicion;
    }

    public void setClienteEnEdicion(Cliente clienteEnEdicion) {
        this.clienteEnEdicion = clienteEnEdicion;
    }
    
}
