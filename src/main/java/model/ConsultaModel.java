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
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("construtor model");
        repositorio = RepositorioMemoria.getInstance();
    }

    public boolean cadastrar(Consulta consulta) {
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("cadastro model");
        repositorio.cadastrar(consulta);
        return true;
    }

    public boolean alterar(Consulta consulta) {
        repositorio.alterar(consulta);
        return true;
    }

    public boolean deletar(Consulta consulta) {
        repositorio.deletar(consulta);
        return true;
=======
	System.out.println("cadastro model");
	return repositorio.cadastrar(consulta);
    }

    public boolean alterar(Consulta consulta) {
	return repositorio.alterar(consulta);
    }

    public boolean cancelar(Consulta consulta) {
	System.out.println("cancelar model");
	System.out.println(consulta.toString());
	return repositorio.cancelar(consulta);
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
    }

    public Consulta buscar(int id) {
        return repositorio.buscar(id);
    }

    public List<Consulta> buscarTodos() {
        return repositorio.buscarTodos();
=======
	System.out.println("construtor model");
	repositorio = RepositorioMemoria.getInstance();
=======
        System.out.println("construtor model");
        repositorio = RepositorioMemoria.getInstance();
>>>>>>> resolvendo conflitos
    }

    public boolean cadastrar(Consulta consulta) {
=======
>>>>>>> resolvendo conflitos 5/9
        System.out.println("cadastro model");
        repositorio.cadastrar(consulta);
        return true;
    }

    public boolean alterar(Consulta consulta) {
        repositorio.alterar(consulta);
        return true;
    }

    public boolean deletar(Consulta consulta) {
        repositorio.deletar(consulta);
        return true;
=======
	System.out.println("cadastro model");
	return repositorio.cadastrar(consulta);
    }

    public boolean alterar(Consulta consulta) {
	return repositorio.alterar(consulta);
    }

    public boolean cancelar(Consulta consulta) {
	return repositorio.cancelar(consulta);
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
    }

    public Consulta buscar(int id) {
        return repositorio.buscar(id);
    }

    public List<Consulta> buscarTodos() {
<<<<<<< HEAD
	return repositorio.buscarTodos();
>>>>>>> Classes de suporte, serão apagadas
=======
        return repositorio.buscarTodos();
>>>>>>> resolvendo conflitos
    }

}
