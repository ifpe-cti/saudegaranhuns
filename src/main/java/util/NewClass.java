/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.LocalDate;
import java.time.Month;
import model.DAO.hibernate.ConsultaHibernate;
import model.DAO.hibernate.EnderecoHibernate;
import model.DAO.hibernate.PacienteHibernate;
import model.POJO.Bairro;
import model.POJO.Consulta;
import model.POJO.Endereco;
import model.POJO.Paciente;
import model.POJO.PostoSaude;
import model.POJO.enumerador.Especialidade;
import model.POJO.enumerador.Prioridade;
import model.POJO.enumerador.Status;

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

        eh.insert(e);
        ph.insert(p);
        cH.insert(c);
        System.out.println(eh.recuperarTodos().get(0).getBairro().getNome());
        cH.alterarStatusConsulta(c, 2);

    }
}
