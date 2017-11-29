/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.util;

import java.time.LocalDate;
import java.time.Month;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.EnderecoHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.pojo.enumarador.Status;

/**
 *
 * @author herik
 */
public class NewClass {

    public static void main(String[] args) {
        EnderecoHibernate eh = new EnderecoHibernate();
        PacienteHibernate ph = new PacienteHibernate();
        ConsultaHibernate cH = new ConsultaHibernate();
        Endereco e = new Endereco("32", "Rua dos bobos", new Bairro("Juliana"));
        //
        Paciente p;
        p = new Paciente("asdf", "321", LocalDate.of(2010, 11, 10), e, new PostoSaude("asd", e));
        Consulta c = new Consulta(Especialidade.GERAL, Prioridade.IDOSO, Status.FILA, LocalDate.of(2017, 11, 24), LocalDate.of(2018, 1, 1), p);

        eh.inserir(e);
        ph.inserir(p);
        cH.inserir(c);
        System.out.println(eh.recuperarTodos().get(0).getBairro().getNome());
        cH.alterarStatusConsulta(c, 2);

    }
}
