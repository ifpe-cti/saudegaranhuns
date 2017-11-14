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

    public void cadastrar(Consulta consulta) {
	System.out.println("cadastro model");
	repositorio.cadastrar(consulta);
    }

    public void alterar(Consulta consulta) {
	repositorio.alterar(consulta);
    }

    public void deletar(Consulta consulta) {
	repositorio.deletar(consulta);
    }

    public Consulta buscar(int id) {
	return repositorio.buscar(id);
    }

    public List<Consulta> buscarTodos() {
	return repositorio.buscarTodos();
    }

}
