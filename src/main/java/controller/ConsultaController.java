<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ConsultaModel;
import model.entidades.Consulta;
import model.entidades.Especialidade;
import model.entidades.Prioridade;
import model.entidades.Status;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ConsultaController implements Serializable {

    private ConsultaModel model;
    private Consulta consulta;

    @PostConstruct
    public void init() {
	consulta = new Consulta();
	model = new ConsultaModel();
    }

    public ConsultaController() {
    }

    public Prioridade[] getPrioridade() {
        return Prioridade.values();
    }

    public Especialidade[] getEspecialidade() {
        return Especialidade.values();
    }

<<<<<<< HEAD
    public ConsultaController() {
<<<<<<< HEAD
        System.out.println("construtor controller");
        consulta = new Consulta();
        model = new ConsultaModel();
    }

    public void cadastrar() {
        System.out.println("cadastro controller");
        if (model.cadastrar(consulta)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta cadastrada"));
        }
    }

    public void alterar() {
        if (model.alterar(consulta)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta alterada"));
        }
    }

    public void deletar() {
        if (model.deletar(consulta)) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Consulta deletada"));
        }
=======
	consulta = new Consulta();
	model = new ConsultaModel();
=======
    public Status[] getStatus() {
	return Status.values();
>>>>>>> removendo pagina de alteracao de consulta e adicionando recursos a tela de cadastro
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
	    limpar();
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

    public void cancelar(Consulta consulta) {
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
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("setconsulta controller");
        System.out.println(consulta.toString());
        this.consulta = consulta;
=======
	this.consulta = consulta;
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
=======
	System.out.println("entrou no set");
=======
>>>>>>> formatando
	this.consulta = consulta;
    }

    public void limpar() {
	this.consulta = new Consulta();
>>>>>>> removendo pagina de alteracao de consulta e adicionando recursos a tela de cadastro
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Fernando
 */
@ManagedBean
@SessionScoped
public class ConsultaController implements Serializable {

    private ConsultaModel model;
    private Consulta consulta;

    @PostConstruct
    public void init() {
        consulta = new Consulta();
        model = new ConsultaModel();
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
        if (model.cadastrar(consulta)) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Sucesso, consulta cadastrada",
                            null
                    )
            );
            limpar();
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

    public void cancelar(Consulta consulta) {
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

    public void limpar() {
        this.consulta = new Consulta();
    }
}
>>>>>>> apagando classes de suporte e imports delas em outras classes
