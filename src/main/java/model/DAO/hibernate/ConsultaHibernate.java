/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.ArrayList;
import java.util.List;
import model.DAO.interfaces.ConsultaDAO;
import model.POJO.Consulta;
import model.POJO.Paciente;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Hérikles
 */
public class ConsultaHibernate implements ConsultaDAO {

    @Override
    public void insert(Consulta o) {
        Session session = HibernateUtil.getSession();
        PacienteHibernate pH = new PacienteHibernate();
        try {
            session.beginTransaction();
            Paciente p = pH.readByName((o.getPaciente()).getNome());
            if (p == null) {
                pH.insert(o.getPaciente());
            } else {
                o.setPaciente(p);
            }
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Consulta o) {
        Session session = HibernateUtil.getSession();
        PacienteHibernate pH = new PacienteHibernate();
        try {
            session.beginTransaction();
            Paciente p = pH.readByName((o.getPaciente()).getNome());
            if (p == null) {
                pH.insert(o.getPaciente());
            } else {
                o.setPaciente(p);
            }
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Consulta o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Consulta read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Consulta) session.get(Consulta.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Consulta> lista = session.createQuery("from " + Consulta.class.getName()).getResultList();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Consultas. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasPorPaciente(Paciente c) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Consulta> consultas = (session.createQuery("from " + Consulta.class.getName()).list());
            List<Consulta> retorno = new ArrayList<>();
            for (Consulta p : consultas) {
                if (p.getPaciente().equals(c.getNome())) {
                    retorno.add(p);
                }
            }
            session.getTransaction().commit();
            return retorno;

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar os Pacientes por nome. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

}
