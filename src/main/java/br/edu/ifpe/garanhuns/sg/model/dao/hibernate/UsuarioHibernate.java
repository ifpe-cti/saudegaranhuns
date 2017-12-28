/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.UsuarioDAO;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class UsuarioHibernate implements UsuarioDAO {

    @Override
    public void inserir(Usuario o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Usuario o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Usuario o) {
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
    public Usuario recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Usuario) session.get(Usuario.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;}

    @Override
    public List<Usuario> recuperarTodos() {
       Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Usuario> lista = session.createQuery("from " + Usuario.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deletarEmCascata(Usuario u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperarUsuarioPorLogin(String login, String senha) {
        try (Session session = HibernateUtil.getSession()) {
            List<Usuario> usuarios = (session.createQuery("from Usuario u where u.login = :login and u.senha = :senha").setParameter("login", login).setParameter("senha", senha).list());
            if(usuarios!=null && !usuarios.isEmpty())
                return usuarios.get(0);
            
        } catch (Exception e) {
            System.err.println("Falha ao recuperar usuario. Erro: " + e.toString());
        }
        return null;
    }
}
