/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.ConsultaModel;
import model.entidades.Consulta;
import model.entidades.Especialidade;
import model.entidades.Prioridade;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ConsultaController implements Serializable {

    private ConsultaModel model;
    private Consulta consulta;

    public Prioridade[] getPrioridade() {
        return Prioridade.values();
    }

    public Especialidade[] getEspecialidade() {
        return Especialidade.values();
    }

    public ConsultaController() {
	consulta = new Consulta();
	model = new ConsultaModel();
    }

    public void cadastrar() {
	if (model.cadastrar(consulta)) {
	    FacesContext.getCurrentInstance().addMessage(
		    null,
		    new FacesMessage(
			    FacesMessage.SEVERITY_INFO,
			    "Sucesso, consulta cadastrada",
			    null
		    )
	    );
	}
    }

    public void alterar() {
	if (model.alterar(consulta)) {
	    FacesContext.getCurrentInstance().addMessage(
		    null,
		    new FacesMessage(
			    FacesMessage.SEVERITY_INFO,
			    "Sucesso, consulta alterada",
			    null
		    )
	    );
	}
    }

    public void cancelar() {
	if (model.cancelar(consulta)) {
	    FacesContext.getCurrentInstance().addMessage(
		    null,
		    new FacesMessage(
			    FacesMessage.SEVERITY_INFO,
			    "Sucesso, consulta cancelada",
			    null
		    )
	    );
	}
    }

    public Consulta buscar(int id) {
        return model.buscar(id);
    }

    public List<Consulta> buscarTodos() {
        return model.buscarTodos();
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
	this.consulta = consulta;
    }

}
