/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.entidades.Consulta;
import model.entidades.Especialidade;
import model.entidades.Prioridade;
import model.entidades.Status;

/**
 *
 * @author Fernando
 */
public class RepositorioMemoria {

    private static RepositorioMemoria self = null;
    private static List<Consulta> consultas = null;

    public RepositorioMemoria() {
	System.out.println("construtor repotorio");
	consultas = new ArrayList();
	consultas.add(new Consulta(1, Prioridade.IDOSO, Especialidade.DENTISTA));
	consultas.add(new Consulta(2, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA));
	consultas.add(new Consulta(3, Prioridade.GESTANTE, Especialidade.OUTROS));
	consultas.add(new Consulta(4, Prioridade.NENHUMA, Especialidade.DENTISTA));
	consultas.add(new Consulta(5, Prioridade.BEBEDECOLO, Especialidade.OUTROS));
    }

    public static RepositorioMemoria getInstance() {
	System.out.println("getinstance");
	if (self == null) {
	    self = new RepositorioMemoria();
	}
	return self;
    }

    public boolean cadastrar(Consulta consulta) {
	System.out.println("cadastro repositorio");
	System.out.println(consulta.toString());
	return consultas.add(consulta);
    }

    public boolean cancelar(Consulta consulta) {
	for (Consulta objeto : consultas) {
	    if (objeto.getId() == consulta.getId()) {
		objeto.setStatus(Status.CANCELADO);
		return true;
	    }
	}
	return false;
    }

    public boolean alterar(Consulta consulta) {
	for (Consulta objeto : consultas) {
	    if (objeto.getId() == consulta.getId()) {
		objeto.setPrioridade(consulta.getPrioridade());
		objeto.setEspecialidade(consulta.getEspecialidade());
		return true;
	    }
	}
	return false;
    }

    public Consulta buscar(int id) {
	for (Consulta consulta : consultas) {
	    if (consulta.getId() == id) {
		return consulta;
	    }
	}
	return null;
    }

    public List<Consulta> buscarTodos() {
	return consultas;
    }

}
