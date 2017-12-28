/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
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
public class PacienteController implements Serializable {

    private PacienteHibernate model;
    private Paciente paciente;

    @PostConstruct
    public void init() {
        paciente = new Paciente();
        model = new PacienteHibernate();
        paciente.setUsuario(new Usuario());
        paciente.setPostoSaude(new PostoSaude());
    }

    public void limparCampos() {
        paciente = new Paciente();
        paciente.setUsuario(new Usuario());
        paciente.setPostoSaude(new PostoSaude());
    }
    
    public PacienteController() {
    }

    public void cadastrar() {
        paciente.getUsuario().setLogin(paciente.getCartaoSus());
        paciente.getUsuario().setSenha("00000");
        paciente.getUsuario().setPerfilUsuario(PerfilUsuario.PACIENTE);
        model.inserir(paciente);
    }

    public void alterar() {
        model.atualizar(paciente);
    }

    public void deletar() {
        model.deletar(paciente);
    }

    public Paciente recuperar(int id) {
        return model.recuperar(paciente.getId());
    }

    public Paciente recuperarPorNome(String nome) {
        return model.recuperarPorNome(paciente.getNome());
    }

    public List<Paciente> recuperarTodos() {
        return model.recuperarTodos();
    }

    public PacienteHibernate getModel() {
        return model;
    }

    public void setModel(PacienteHibernate model) {
        this.model = model;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
