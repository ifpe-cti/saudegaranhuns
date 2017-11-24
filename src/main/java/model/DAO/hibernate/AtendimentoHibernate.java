/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import model.DAO.interfaces.AtendimentoDAO;
import model.POJO.Atendimento;
import model.POJO.PostoSaude;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Hérikles
 */
public class AtendimentoHibernate implements AtendimentoDAO {

    @Override
    public void insert(Atendimento o) {
        Session session = HibernateUtil.getSession();
        PostoSaudeHibernate ph = new PostoSaudeHibernate();
        try {
            session.beginTransaction();
            PostoSaude ps = ph.readByName(o.getPostoSaude().getNome());
            if (ps == null) {
                ph.insert(o.getPostoSaude());
            } else {
                o.setPostoSaude(ps);
            }
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Atendimento o) {
        Session session = HibernateUtil.getSession();
        PostoSaudeHibernate ph = new PostoSaudeHibernate();
        try {
            session.beginTransaction();
            PostoSaude ps = ph.readByName(o.getPostoSaude().getNome());
            if (ps == null) {
                ph.insert(o.getPostoSaude());
            } else {
                o.setPostoSaude(ps);
            }
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Atendimento o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Atendimento read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Atendimento) session.get(Atendimento.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Atendimento> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Atendimento> lista = session.createQuery("from " + Atendimento.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Atendimentos. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

}
