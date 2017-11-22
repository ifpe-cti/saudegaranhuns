/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

<<<<<<< HEAD
=======
import java.time.LocalDate;
>>>>>>> Classes de suporte, serão apagadas
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        System.out.println("construtor repotorio");
        consultas = new ArrayList();
        consultas.add(new Consulta(1, Status.PENDENTE, Prioridade.IDOSO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(2, Status.CONSULTADO, Prioridade.BEBEDECOLO, Especialidade.OUTROS, LocalDate.now()));
        consultas.add(new Consulta(3, Status.PENDENTE, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(4, Status.CANCELADO, Prioridade.GESTANTE, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(5, Status.PENDENTE, Prioridade.NENHUMA, Especialidade.OUTROS, LocalDate.now()));
=======
	System.out.println("construtor repotorio");
	consultas = new ArrayList();
	consultas.add(new Consulta(1, Prioridade.IDOSO, Especialidade.DENTISTA));
	consultas.add(new Consulta(2, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA));
	consultas.add(new Consulta(3, Prioridade.GESTANTE, Especialidade.OUTROS));
	consultas.add(new Consulta(4, Prioridade.NENHUMA, Especialidade.DENTISTA));
	consultas.add(new Consulta(5, Prioridade.BEBEDECOLO, Especialidade.OUTROS));
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
    }

    public static RepositorioMemoria getInstance() {
        System.out.println("getinstance");
        if (self == null) {
            self = new RepositorioMemoria();
        }
        return self;
    }

    public boolean cadastrar(Consulta consulta) {
<<<<<<< HEAD
        consultas.add(consulta);
        System.out.println("cadastro repositorio");
        System.out.println(consulta.toString());
        return true;
    }

    public boolean deletar(Consulta consulta) {
        consultas.remove(consulta);
        return true;
    }

    public boolean alterar(Consulta consulta) {
        for (Consulta objeto : consultas) {
            if (objeto.getId() == consulta.getId()) {
                objeto.setStatus(consulta.getStatus());
                objeto.setPrioridade(consulta.getPrioridade());
                objeto.setEspecialidade(consulta.getEspecialidade());
            }
        }
        return true;
=======
	System.out.println("cadastro repositorio");
	System.out.println(consulta.toString());
	return consultas.add(consulta);
    }

    public boolean cancelar(Consulta consulta) {
	System.out.println("cancelar repositorio");
	System.out.println(consulta.toString());
	for (Consulta objeto : consultas) {
	    System.out.println("consulta id: " + consulta.getId() + "/nObjeto id: " + objeto.getId());
	    if (objeto.getId() == consulta.getId()) {
		objeto.setStatus(Status.CANCELADO);
		System.out.println("cancelou");
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
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
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
=======
	System.out.println("construtor repotorio");
	consultas = new ArrayList();
	consultas.add(new Consulta(1, "blabla", Status.PENDENTE, Prioridade.IDOSO, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(2, "blabla", Status.CONSULTADO, Prioridade.BEBEDECOLO, Especialidade.OUTROS, LocalDate.now()));
	consultas.add(new Consulta(3, "blabla", Status.PENDENTE, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(4, "blabla", Status.CANCELADO, Prioridade.GESTANTE, Especialidade.DENTISTA, LocalDate.now()));
	consultas.add(new Consulta(5, "blabla", Status.PENDENTE, Prioridade.NENHUMA, Especialidade.OUTROS, LocalDate.now()));
=======
        System.out.println("construtor repotorio");
        consultas = new ArrayList();
<<<<<<< HEAD
        consultas.add(new Consulta(1, "blabla", Status.PENDENTE, Prioridade.IDOSO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(2, "blabla", Status.CONSULTADO, Prioridade.BEBEDECOLO, Especialidade.OUTROS, LocalDate.now()));
        consultas.add(new Consulta(3, "blabla", Status.PENDENTE, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(4, "blabla", Status.CANCELADO, Prioridade.GESTANTE, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(5, "blabla", Status.PENDENTE, Prioridade.NENHUMA, Especialidade.OUTROS, LocalDate.now()));
>>>>>>> resolvendo conflitos
=======
        consultas.add(new Consulta(1, Status.PENDENTE, Prioridade.IDOSO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(2, Status.CONSULTADO, Prioridade.BEBEDECOLO, Especialidade.OUTROS, LocalDate.now()));
        consultas.add(new Consulta(3, Status.PENDENTE, Prioridade.DEFICIENTEFISICO, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(4, Status.CANCELADO, Prioridade.GESTANTE, Especialidade.DENTISTA, LocalDate.now()));
        consultas.add(new Consulta(5, Status.PENDENTE, Prioridade.NENHUMA, Especialidade.OUTROS, LocalDate.now()));
>>>>>>> Adaptando ao diagrama de classes
    }

    public static RepositorioMemoria getInstance() {
        System.out.println("getinstance");
        if (self == null) {
            self = new RepositorioMemoria();
        }
        return self;
    }

    public boolean cadastrar(Consulta consulta) {
        consultas.add(consulta);
        System.out.println("cadastro repositorio");
        System.out.println(consulta.toString());
        return true;
    }

    public boolean deletar(Consulta consulta) {
        consultas.remove(consulta);
        return true;
    }

    public boolean alterar(Consulta consulta) {
        for (Consulta objeto : consultas) {
            if (objeto.getId() == consulta.getId()) {
                objeto.setStatus(consulta.getStatus());
                objeto.setPrioridade(consulta.getPrioridade());
                objeto.setEspecialidade(consulta.getEspecialidade());
            }
        }
        return true;
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
<<<<<<< HEAD
	return consultas;
>>>>>>> Classes de suporte, serão apagadas
=======
        return consultas;
>>>>>>> resolvendo conflitos
    }

}
