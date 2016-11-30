/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tiendaweb.controlador;

import com.tiendaweb.entidad.Cliente;
import com.tiendaweb.entidad.Usuario;
import com.tiendaweb.negocio.GestorUsuariosServiceLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author dansan
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    @EJB
    private GestorUsuariosServiceLocal gestorUsuariosService;
       
    private Usuario usuario = new Usuario();
    private Cliente cliente = new Cliente();
        
    private List<Cliente> clientes;
    private List<Cliente> clientesFiltrados;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientesFiltrados() {
        return clientesFiltrados;
    }

    public void setClientesFiltrados(List<Cliente> clientesFiltrados) {
        this.clientesFiltrados = clientesFiltrados;
    }

   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }      
    
    
    
    public UsuarioController() {        
    }
    
    @PostConstruct
    public void cargarClientes()
    {
        this.clientes = gestorUsuariosService.listClientes();
    }
    
    public String irLogin()
    {
        return "login";
    }
    
    public String doLogin()
    {
        this.usuario = gestorUsuariosService.Login(this.usuario.getLogin(), this.usuario.getPassword());        
        if(this.usuario != null)
        {
            this.cliente = gestorUsuariosService.findClientexUsuario(this.usuario);
            return "index";                    
        }
        this.usuario = new Usuario();
        this.cliente = new Cliente();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Error. ","Los datos no coinciden con ningun usuario registrado.Por favor intenta de nuevo");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "login";
    }   
    
    public String doLogout()
    {
        this.usuario = new Usuario();
        this.cliente = new Cliente();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Has salido","Has salido del sistema.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "index";
    }
    
    public String doRegistro()
    {
        //setear usuario       
        this.usuario.setFechaalta(new Date());
        this.usuario.setTipo("CLIENTE");
        this.usuario.setVersion(1);
        this.usuario.setUltimoacceso(new Date());
        gestorUsuariosService.createUsuario(usuario);
        //setear cliente               
        this.cliente.setUsuarioId(usuario);
        this.cliente.setVersion(1);        
        gestorUsuariosService.createCliente(cliente);
        this.clientes = gestorUsuariosService.listClientes();
        return doLogin();
    }
    
    public String doEditar()
    {        
        gestorUsuariosService.editCliente(cliente);
        return "perfil";
    }
    
    public String doEditarTipo(Usuario u)
    {
        this.gestorUsuariosService.editUsuario(u);
        this.clientes = gestorUsuariosService.listClientes();
        return "/admin/usuarios/index";
    }
    
    public String doBorrar(Cliente c)
    {       
        gestorUsuariosService.removeCliente(c);
        this.clientes = gestorUsuariosService.listClientes();
        return "/admin/usuarios/index";
    }
    
    public String doAbrirEdicion()
    {        
        return "editarperfil";
    }
    
    public void doAuthAdmin()
    {
        ExternalContext context2 = FacesContext.getCurrentInstance().getExternalContext();
        try {
            if(this.usuario == null || !gestorUsuariosService.isAdmin(this.usuario))
            context2.redirect(context2.getRequestContextPath() +"/faces/index.xhtml");
        } catch (IOException e) {
             e.printStackTrace();
       }
    }
    
}
