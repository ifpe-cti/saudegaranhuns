/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import model.DAO.interfaces.UsuarioDAO;
import model.POJO.Usuario;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class UsuarioHibernate implements UsuarioDAO {

    @Override
    public void insert(Usuario o) {
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
    public void update(Usuario o) {
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
    public void delete(Usuario o) {
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
    public Usuario read(Integer id) {
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

}
