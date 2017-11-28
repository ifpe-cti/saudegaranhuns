/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.pojo.Consulta;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Status;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ConsultaController implements Serializable {

    private ConsultaHibernate model;
    private Consulta consulta;

    @PostConstruct
    public void init() {
        consulta = new Consulta();
        model = new ConsultaHibernate();
    }

    public ConsultaController() {
    }

    public Prioridade[] getPrioridade() {
        return Prioridade.values();
    }

    public Especialidade[] getEspecialidade() {
        return Especialidade.values();
    }

    public Status[] getStatus() {
        return Status.values();
    }

    public void cadastrar() {
        model.insert(consulta);
    }

    public void alterar() {
        model.update(consulta);
    }

    public void cancelar() {
        model.alterarStatusConsulta(consulta, 3);
    }

    public void cancelar(Consulta consulta) {
        model.alterarStatusConsulta(consulta, 3);
    }

    public Consulta buscar(int id) {
        return model.read(id);
    }

    public List<Consulta> buscarTodos() {
        return model.recuperarTodos();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public void limpar() {
        this.consulta = new Consulta();
    }
}
