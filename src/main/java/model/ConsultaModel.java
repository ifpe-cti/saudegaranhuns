/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import model.entidades.Consulta;

/**
 *
 * @author Fernando
 */
public class ConsultaModel {

    RepositorioMemoria repositorio = null;

    public ConsultaModel() {
	System.out.println("construtor model");
	repositorio = RepositorioMemoria.getInstance();
    }

    public boolean cadastrar(Consulta consulta) {
	System.out.println("cadastro model");
	return repositorio.cadastrar(consulta);
    }

    public boolean alterar(Consulta consulta) {
	return repositorio.alterar(consulta);
    }

    public boolean cancelar(Consulta consulta) {
	return repositorio.cancelar(consulta);
    }

    public Consulta buscar(int id) {
	return repositorio.buscar(id);
    }

    public List<Consulta> buscarTodos() {
	return repositorio.buscarTodos();
    }

}
