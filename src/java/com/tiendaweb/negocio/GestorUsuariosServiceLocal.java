/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.negocio;

import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Usuario;
import javax.ejb.Local;

/**
 *
 * @author dansan
 */
@Local
public interface GestorUsuariosServiceLocal {
    Usuario Login(String user, String password);

    void createUsuario(Usuario usuario);

    void createCliente(Cliente cliente);

    void editCliente(Cliente cliente);

    void editUsuario(Usuario usuario);

    Cliente findClientexUsuario(Usuario usuario);

    boolean isAdmin(Usuario usuario);
}
