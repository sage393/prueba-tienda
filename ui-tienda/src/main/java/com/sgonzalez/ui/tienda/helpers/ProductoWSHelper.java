/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ui.tienda.helpers;

import com.sgonzalez.ws.tienda.services.Producto;
import com.sgonzalez.ws.tienda.services.ProductoWS;
import com.sgonzalez.ws.tienda.services.ProductoWS_Service;
import java.net.URL;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jfr.internal.tool.Main;

/**
 *
 * @author sam
 */
public class ProductoWSHelper {

    private ProductoWS productoProxy;

    public ProductoWSHelper() {
        try {
            URL url = new URL("http://localhost:8080/ws-tienda-services/ProductoWS?wsdl");
            ProductoWS_Service producto = new ProductoWS_Service(url);
            productoProxy = producto.getProductoWSPort();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Producto agregarProducto(Producto producto) throws Exception {
        return productoProxy.agregarProducto(producto);
    }
    
    public Boolean eliminarProducto(Long id) throws Exception {
        return productoProxy.eliminarProducto(id);
    }
    
    public Producto buscarProducto(Long id) throws Exception {
        return productoProxy.obtenerProducto(id);
    }
    
    public Collection<Producto> buscarProductos() throws Exception {
        return productoProxy.obtenerProductos();
    }
}
