/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import model.DAO.interfaces.HorarioAtendimentoDAO;
import model.POJO.HorarioAtendimento;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Hérikles
 */
public class HorarioAtendimentoHibernate implements HorarioAtendimentoDAO {

    @Override
    public void insert(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        AtendimentoHibernate aH = new AtendimentoHibernate();
        try {
            session.beginTransaction();
            aH.insert(o.getAtendimento());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        AtendimentoHibernate aH = new AtendimentoHibernate();
        try {
            session.beginTransaction();
            aH.insert(o.getAtendimento());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public HorarioAtendimento read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (HorarioAtendimento) session.get(HorarioAtendimento.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<HorarioAtendimento> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<HorarioAtendimento> lista = session.createQuery("from " + HorarioAtendimento.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
}

