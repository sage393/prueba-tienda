/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.dao;

import com.sgonzalez.ws.tiends.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Id;

/**
 *
 * @author sam
 */
public class DAOGenerico {
    private EntityManager em;

    public DAOGenerico(EntityManager em) {
        this.em = em;
    }

    public <T> Collection<T> obtenerTodos(Class clase) throws Exception {
        try {
            return (Collection<T>) em.createNamedQuery(String.format("%s.findAll", clase.getSimpleName()), clase).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public <T> T obtener(Class clase, Long id) throws Exception {
        try {
            return (T) em.find(clase, id);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public <T> T guardar(Class clase, Object obj) throws Exception {
        try {
            Field campo = ReflectionUtils.obtenerCampoAnotado(clase, Id.class);
            Object valor = campo.get(obj);
            
            if (valor == null) {
                em.persist(obj);
            } else {
                obj = em.merge(obj);
            }
        } catch (Exception e) {
            throw e;
        }
        
        return (T) obj;
    }
    
    public void eliminar(Class clase, Object obj) throws Exception {
        try {
            if (!em.contains(obj)) {
                obj = em.merge(obj);
            }
            
            em.remove(obj);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
