/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.dao;

import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dansan
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "TiendaWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente findClientexUsuario(Usuario idUsuario)
    {
        Cliente cliente = null;
        Query query = em.createQuery("select c from Cliente c where c.usuarioId =:idUsuario");
        query.setParameter("idUsuario", idUsuario);
        cliente = (Cliente) query.getSingleResult();
        return cliente;
    }
    
}
