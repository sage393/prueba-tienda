/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.managedbeans;

import com.sgonzalez.ui.tienda.helpers.ProductoWSHelper;
import com.sgonzalez.ws.tienda.services.Producto;
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
@ManagedBean(name = "productoManagedBean")
@ViewScoped
public class ProductoManagedBean {
    
    private Collection<Producto> productosList = new ArrayList<>();
    private ProductoWSHelper productoWSHelper;
    private Producto productoEnEdicion = new Producto();

    @PostConstruct
    public void init() {
        productoWSHelper = new ProductoWSHelper();
        poblarProductos();
    }
    
    private void poblarProductos() {
        try {
            productosList.clear();
            productosList.addAll(productoWSHelper.buscarProductos());
        } catch (Exception ex) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al obtener productos", ex.getMessage()));
        }
    }
    
    public void eliminarProducto(Producto producto) {
        try {
            productoWSHelper.eliminarProducto(producto.getId());
            poblarProductos();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Eliminado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al eliminar", ex.getMessage()));
        }
    } 
    
    public void guardarProducto() {
        try {
            productoWSHelper.agregarProducto(productoEnEdicion);
            poblarProductos();
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Guardado correctamente"));
        } catch (Exception ex) {
            Logger.getLogger(ProductoManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar", ex.getMessage()));
        }
    }
    
    public void editarProducto(Producto producto) {
        productoEnEdicion = producto;
    }
    
    public void nuevoProducto() {
        productoEnEdicion = new Producto();
    }

    public Collection<Producto> getProductosList() {
        return productosList;
    }

    public void setProductosList(Collection<Producto> productosList) {
        this.productosList = productosList;
    }

    public Producto getProductoEnEdicion() {
        return productoEnEdicion;
    }

    public void setProductoEnEdicion(Producto productoEnEdicion) {
        this.productoEnEdicion = productoEnEdicion;
    }
    
}
