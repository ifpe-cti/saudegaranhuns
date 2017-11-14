/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
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
	System.out.println("construtor controller");
	consulta = new Consulta();
	model = new ConsultaModel();
    }

    public void cadastrar() {
	System.out.println("cadastro controller");
	model.cadastrar(consulta);
    }

    public void alterar() {
	model.alterar(consulta);
    }

    public void deletar() {
	model.deletar(consulta);
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
	System.out.println("setconsulta controller");
	System.out.println(consulta.toString());
	this.consulta = consulta;
    }

}
