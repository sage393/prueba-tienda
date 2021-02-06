/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.ejb;

import java.util.Collection;

/**
 *
 * @author sam
 */
public interface GenericoSessionBeanLocal {
    
    public <T> Collection<T> obtenerTodos(Class clase) throws Exception;
    
    public <T> T obtenerPorId(Class clase, Long id) throws Exception;
    
    public <T> T guardar(Class clase, Object obj) throws Exception;
    
    public void eliminar(Class clase, Object obj) throws Exception;
    
}
