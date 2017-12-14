/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Igor Sousa PC
 */
@ManagedBean
@SessionScoped
public class LoginUsuarioController {

    private Usuario userLogado = null;
    private Usuario usuario = new Usuario();

    public LoginUsuarioController() {
    }
    
    public String realizarLogin(String login, String senha) {
        
        PacienteController paciente = new PacienteController();
        AtendenteController atendente = new AtendenteController();
        ArrayList<Paciente> pacientes = (ArrayList<Paciente>) paciente.recuperarTodos();
        ArrayList<Atendente> atendentes = (ArrayList<Atendente>) atendente.recuperarTodos();
        Usuario usuario = new Usuario();
        
        for (int i = 0; i < pacientes.size(); i++) {
            
            if (pacientes.get(i).getUsuario().getLogin().equals(login) && pacientes.get(i).getUsuario().getSenha().equals(senha)) {
                userLogado = usuario;
                break;
            }
        }
        for (int i = 0; i < atendentes.size(); i++) {
            
            if (atendentes.get(i).getUsuario().getLogin().equals(login) && atendentes.get(i).getUsuario().getSenha().equals(senha)) {
                userLogado = usuario;
                break;
            }
        }
        
        if ((userLogado == null) ) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Problema!", "O usuário não existe!"));
            return "index.html";
        }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário logado com sucesso!"));
            
                    
            return "index.html";
    }
    public String realizarlogout(){
        
        userLogado = null;
        
        return "index.html?faces-redirect=true";
    }

    public Usuario getUserLogado() {
        return userLogado;
    }

    public void setUserLogado(Usuario userLogado) {
        this.userLogado = userLogado;
    }
        
 

}
