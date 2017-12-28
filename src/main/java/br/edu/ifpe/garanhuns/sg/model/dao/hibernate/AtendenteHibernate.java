/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.AtendenteDAO;
import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class AtendenteHibernate implements AtendenteDAO {

    @Override
    public void inserir(Atendente o) {
        Session session = HibernateUtil.getSession();
        PostoSaudeHibernate ph = new PostoSaudeHibernate();
        try {
            session.beginTransaction();
            PostoSaude ps = ph.recuperarPorNome(o.getPostoSaude().getNome());
            if (ps == null) {
                ph.inserir(o.getPostoSaude());
            } else {
                o.setPostoSaude(ps);
            }
            new UsuarioHibernate().inserir(o.getUsuario());
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
    public void atualizar(Atendente o) {
        Session session = HibernateUtil.getSession();
        PostoSaudeHibernate ph = new PostoSaudeHibernate();
        try {
            session.beginTransaction();
            PostoSaude ps = ph.recuperarPorNome(o.getPostoSaude().getNome());
            if (ps == null) {
                ph.inserir(o.getPostoSaude());
            } else {
                o.setPostoSaude(ps);
            }
            new UsuarioHibernate().inserir(o.getUsuario());
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
    public void deletar(Atendente o) {
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
    public Atendente recuperar(Integer id) {
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

    @Override
    public Atendente recuperarAtendentePorUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSession();
        try {
            Atendente atendente = session.createNativeQuery("select * from atendente where usuario_id = " + usuario.getId(), Atendente.class).getSingleResult();
            if (atendente != null) {
                return atendente;
            }
        } catch (Exception e) {
            System.err.println("Falha ao recuperar o  Atendente por Usuário. Erro: " + e.toString());
        }
        return null;
    }

}
