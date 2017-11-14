/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
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
	consultas.add(new Consulta(1, "blabla", Status.PENDENTE, Prioridade.IDOSO, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(2, "blabla", Status.CONSULTADO, Prioridade.BEBEDECOLO, Especialidade.OUTROS, LocalDate.now()));
	consultas.add(new Consulta(3, "blabla", Status.PENDENTE, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(4, "blabla", Status.CANCELADO, Prioridade.GESTANTE, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(5, "blabla", Status.PENDENTE, Prioridade.NENHUMA, Especialidade.OUTROS, LocalDate.now()));
    }

    public static RepositorioMemoria getInstance() {
	System.out.println("getinstance");
	if (self == null) {
	    self = new RepositorioMemoria();
	}
	return self;
    }

    public void cadastrar(Consulta consulta) {
	consultas.add(consulta);
	System.out.println("cadastro repositorio");
	System.out.println(consulta.toString());
    }

    public void deletar(Consulta consulta) {
	consultas.remove(consulta);
    }

    public void alterar(Consulta consulta) {
	for (Consulta objeto : consultas) {
	    if (objeto.getId() == consulta.getId()) {
		objeto.setObservacao(consulta.getObservacao());
		objeto.setStatus(consulta.getStatus());
		objeto.setPrioridade(consulta.getPrioridade());
		objeto.setEspecialidade(consulta.getEspecialidade());
	    }
	}
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
