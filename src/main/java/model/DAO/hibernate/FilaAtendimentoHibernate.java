/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import model.DAO.interfaces.FilaAtandimentoDAO;
import model.POJO.FilaAtendimento;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Hérikles
 */
public class FilaAtendimentoHibernate implements FilaAtandimentoDAO {

    @Override
    public void insert(FilaAtendimento o) {
        Session session = HibernateUtil.getSession();
        ConsultaHibernate cH = new ConsultaHibernate();
        try {
            session.beginTransaction();
            cH.insert(o.getConsulta());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar FilaAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(FilaAtendimento o) {
        Session session = HibernateUtil.getSession();
        ConsultaHibernate cH = new ConsultaHibernate();
        try {
            session.beginTransaction();
            cH.insert(o.getConsulta());
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar FilaAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(FilaAtendimento o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public FilaAtendimento read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (FilaAtendimento) session.get(FilaAtendimento.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar FilaAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<FilaAtendimento> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<FilaAtendimento> lista = session.createQuery("from " + FilaAtendimento.class.getName()).getResultList();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Endereços. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

}
