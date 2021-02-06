/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sgonzalez.ws.tienda.ejb;

import com.sgonzalez.ws.tienda.dao.DAOGenerico;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sam
 */
@Stateless
public class GenericoSessionBean implements GenericoSessionBeanLocal {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public <T> Collection<T> obtenerTodos(Class clase) throws Exception {
        DAOGenerico dao = new DAOGenerico(em);
        return dao.obtenerTodos(clase);
    }

    @Override
    public <T> T obtenerPorId(Class clase, Long id) throws Exception {
        DAOGenerico dao = new DAOGenerico(em);
        return dao.obtener(clase, id);
    }

    @Override
    public <T> T guardar(Class clase, Object obj) throws Exception {
        DAOGenerico dao = new DAOGenerico(em);
        return dao.guardar(clase, obj);
    }

    @Override
    public void eliminar(Class clase, Object obj) throws Exception {
        DAOGenerico dao = new DAOGenerico(em);
        dao.eliminar(clase, obj);
    }


}
