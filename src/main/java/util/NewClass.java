/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Date;
import java.util.Calendar;
import model.DAO.hibernate.BairroHibernate;
import model.DAO.hibernate.EnderecoHibernate;
import model.DAO.hibernate.PacienteHibernate;
import model.POJO.Bairro;
import model.POJO.Endereco;
import model.POJO.Paciente;
import model.POJO.PostoSaude;
import org.hibernate.Session;

/**
 *
 * @author herik
 */
public class NewClass {

    public static void main(String[] args) {
        /*EnderecoHibernate eh = new EnderecoHibernate();
        PacienteHibernate ph = new PacienteHibernate();
        Endereco e = new Endereco("32", "Rua dos bobos", new Bairro("Juliana"));
        Calendar c = Calendar.getInstance();
        c.set(2000, 10, 10);
        //
        Paciente p;
        //p = new Paciente("Dona maria", "22222", c.set(2010, Calendar.JULY, 1), e, new PostoSaude("lula", new Bairro("Juliana")));
        p = new Paciente("aca", "11", c, e, new PostoSaude("asdf", new Bairro("Juliana")));
        
        eh.insert(e);
        ph.insert(p);
        System.out.println(eh.recuperarTodos().get(0).getBairro().getNome());*/
        
        
        BairroHibernate bh =  new BairroHibernate();
        bh.deleteOnCascade(bh.readByName("Juliana"));

    }
}
