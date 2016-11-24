/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.dao;

import com.tiendaweb.entidad.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dansan
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "TiendaWeb2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
     public Usuario Login(String user,String password)
    {
        Usuario usuario = null;
        Query query = em.createQuery("select u from Usuario u where u.login=:user AND u.password=:password");
        query.setParameter("user", user);
        query.setParameter("password", password);
        if(!query.getResultList().isEmpty())
            usuario = (Usuario) query.getResultList().get(0);
        return usuario;
    }
    
    public boolean IsAdmin(Usuario usuario)
    {
        if(usuario.getTipo().equals("ADMIN"))
            return true;
        return false;
    }
    
}
