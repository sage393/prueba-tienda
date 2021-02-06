/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.managedbeans;

import com.sgonzalez.ui.tienda.helpers.ClienteWSHelper;
import com.sgonzalez.ui.tienda.helpers.OrdenWSHelper;
import com.sgonzalez.ui.tienda.helpers.ProductoWSHelper;
import com.sgonzalez.ws.tienda.services.Cliente;
import com.sgonzalez.ws.tienda.services.Orden;
import com.sgonzalez.ws.tienda.services.Producto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author sam
 */
@ManagedBean(name = "ordenManagedBean")
@ViewScoped
public class OrdenManagedBean {
    
    private Collection<Orden> ordensList = new ArrayList<>();
    private OrdenWSHelper ordenWSHelper;
    private Orden ordenEnEdicion = new Orden();
    
    private List<SelectItem> comboClientes;
    private List<SelectItem> comboProductos;
    
    private Date fechaSeleccionada;
    
    @PostConstruct
    public void init() {
        try {
            ordenWSHelper = new OrdenWSHelper();
            poblarOrdens();
            poblarComboClientes();
            poblarComboProductos();
        } catch (Exception ex) {
            Logger.getLogger(OrdenManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void poblarOrdens() {
        try {
            ordensList.clear();
            ordensList.addAll(ordenWSHelper.buscarOrdenes());
        } catch (Exception ex) {
            Logger.getLogger(OrdenManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener ordens", ex.getMessage()));
        }
    }
    
    public void eliminarOrden(Orden orden) {
        try {
            ordenWSHelper.eliminarOrden(orden.getId());
            poblarOrdens();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Eliminado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(OrdenManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", ex.getMessage()));
        }
    } 
    
    private XMLGregorianCalendar convertirFecha(Date fecha) throws Exception {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(fecha);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
    
    public void guardarOrden() {
        try {
            ordenEnEdicion.setFecha(convertirFecha(fechaSeleccionada));
            ordenWSHelper.guardarOrden(ordenEnEdicion);
            poblarOrdens();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Guardado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(OrdenManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", ex.getMessage()));
        }
    }
    
    private void poblarComboProductos() throws Exception {
        ProductoWSHelper helper = new ProductoWSHelper();
        Collection<Producto> productos = helper.buscarProductos();
        comboProductos = new ArrayList<>();
        
        if (productos != null && !productos.isEmpty()) {
            for (Producto item : productos) {
                comboProductos.add(new SelectItem(item, item.getNombre()));
            }
        } else {
            comboProductos.add(new SelectItem(null, "No hay productos para seleccionar"));
        }
    }
    
    private void poblarComboClientes() throws Exception {
        ClienteWSHelper helper = new ClienteWSHelper();
        Collection<Cliente> clientes = helper.buscarClientes();
        comboClientes = new ArrayList<>();
        
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente item : clientes) {
                comboClientes.add(new SelectItem(item, String.format("%s %s", item.getNombres(), item.getApellidos())));
            }
        } else {
            comboClientes.add(new SelectItem(null, "No hay clientes para seleccionar"));
                    
        }
    }
    
    public void editarOrden(Orden orden) {
        ordenEnEdicion = orden;
        fechaSeleccionada = new Date();
    }
    
    public void nuevoOrden() {
        ordenEnEdicion = new Orden();
        fechaSeleccionada = new Date();
    }

    public Collection<Orden> getOrdensList() {
        return ordensList;
    }

    public void setOrdensList(Collection<Orden> ordensList) {
        this.ordensList = ordensList;
    }

    public Orden getOrdenEnEdicion() {
        return ordenEnEdicion;
    }

    public void setOrdenEnEdicion(Orden ordenEnEdicion) {
        this.ordenEnEdicion = ordenEnEdicion;
    }

    public List<SelectItem> getComboClientes() {
        return comboClientes;
    }

    public void setComboClientes(List<SelectItem> comboClientes) {
        this.comboClientes = comboClientes;
    }

    public List<SelectItem> getComboProductos() {
        return comboProductos;
    }

    public void setComboProductos(List<SelectItem> comboProductos) {
        this.comboProductos = comboProductos;
    }

    public Date getFechaSeleccionada() {
        return fechaSeleccionada;
    }

    public void setFechaSeleccionada(Date fechaSeleccionada) {
        this.fechaSeleccionada = fechaSeleccionada;
    }
    
}
