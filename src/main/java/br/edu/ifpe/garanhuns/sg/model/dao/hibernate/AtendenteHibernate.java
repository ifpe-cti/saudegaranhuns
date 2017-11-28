/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.interfaces.AtendenteDAO;
import br.edu.ifpe.garanhuns.sg.model.pojo.Atendente;
import br.edu.ifpe.garanhuns.sg.model.pojo.PostoSaude;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class AtendenteHibernate implements AtendenteDAO {

    @Override
    public void insert(Atendente o) {
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
            System.err.println("Falha ao salvar Atendente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Atendente o) {
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
            System.err.println("Falha ao alterar Atendente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Atendente o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Atendente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Atendente read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Atendente) session.get(Atendente.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Atendente. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Atendente> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Atendente> lista = session.createQuery("from " + Atendente.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Atendentes. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

}
