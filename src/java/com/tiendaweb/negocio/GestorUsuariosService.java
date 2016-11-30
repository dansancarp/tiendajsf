/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.dao.ClienteFacade;
import com.tiendaweb.dao.UsuarioFacade;
import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author dansan
 */
@Stateless
public class GestorUsuariosService implements GestorUsuariosServiceLocal {

    @EJB
    private ClienteFacade clienteFacade;
    @EJB
    private UsuarioFacade usuarioFacade;     
        
    //metodos de negocio

    @Override
    public Usuario Login(String user, String password) {
        Usuario usuario = usuarioFacade.Login(user, password);
        usuario.setUltimoacceso(new Date());
        usuarioFacade.edit(usuario);
        return usuario;
    }    

    
    
    @Override
    public void createUsuario(Usuario usuario) {
        usuarioFacade.create(usuario);
    }

    @Override
    public void createCliente(Cliente cliente) {
        clienteFacade.create(cliente);
    }

    @Override
    public void editCliente(Cliente cliente) {
        clienteFacade.edit(cliente);
    }

    @Override
    public void editUsuario(Usuario usuario) {
        usuarioFacade.edit(usuario);
    }

    @Override
    public Cliente findClientexUsuario(Usuario usuario) {
        return clienteFacade.findClientexUsuario(usuario);
    }

    @Override
    public boolean isAdmin(Usuario usuario) {
        return usuarioFacade.IsAdmin(usuario);
    }

    @Override
    public List<Usuario> listUsuario() {
        return usuarioFacade.findAll();
    }

    @Override
    public void removeUsuario(Usuario usuario) {
        usuarioFacade.remove(usuario);
    }

    @Override
    public Usuario findUsuario(int idUsuario) {
        return usuarioFacade.find((long)idUsuario);
    }

    @Override
    public void removeCliente(Cliente cliente) {
        clienteFacade.remove(cliente);
    }

    @Override
    public List<Cliente> listClientes() {
        return clienteFacade.findAll();
    }

    @Override
    public Cliente findCliente(int idCliente) {
        return clienteFacade.find((long)idCliente);
    }
    
    
    
    
}
