/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.AtendenteHibernate;
import br.edu.ifpe.garanhuns.sg.model.PerfilUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor Sousa PC
 *
 */
@ManagedBean
@SessionScoped
public class AtendenteController implements Serializable {

    private AtendenteHibernate model;
    private Atendente atendente;
       

    @PostConstruct
    public void init() {
        atendente = new Atendente();
        model = new AtendenteHibernate();
        atendente.setUsuario(new Usuario());
        atendente.setPostoSaude(new PostoSaude());
    }
    
    public void limparCampos() {
        atendente = new Atendente();
        atendente.setUsuario(new Usuario());
        atendente.setPostoSaude(new PostoSaude());
    }

    public AtendenteController() {
    }

    public void cadastrar() {
        atendente.getUsuario().setPerfilUsuario(PerfilUsuario.ATENDENTE);
        model.inserir(atendente);
    }

    public void alterar() {
        model.atualizar(atendente);
    }

    public void deletar() {
        model.deletar(atendente);
    }

    public Atendente recuperar(int id) {
        return model.recuperar(atendente.getId());
    }

    public List<Atendente> recuperarTodos() {
        return model.recuperarTodos();
    }

    public AtendenteHibernate getModel() {
        return model;
    }

    public void setModel(AtendenteHibernate model) {
        this.model = model;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

}
