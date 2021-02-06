/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.services.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sam
 */
@ManagedBean(name = "inicioManagedBean")
@ViewScoped
public class InicioManagedBean {
    
    private static final long serialVersionUID = 1L;
    
    private String mensajeBienvenida;

    @PostConstruct
    public void init() {
        mensajeBienvenida = "Este es un mensaje de prueba";
    }

    public String getMensajeBienvenida() {
        return mensajeBienvenida;
    }

    public void setMensajeBienvenida(String mensajeBienvenida) {
        this.mensajeBienvenida = mensajeBienvenida;
    }
    
}
