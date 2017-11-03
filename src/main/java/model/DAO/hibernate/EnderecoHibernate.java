/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;
import model.DAO.interfaces.EnderecoDAO;
import model.POJO.Endereco;

/**
 *
 * @author Herikles
 */
public class EnderecoHibernate implements EnderecoDAO {

    @Override
    public void insert(Endereco o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Endereco o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Endereco o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Endereco read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Endereco) session.get(Endereco.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Endereco> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Endereco> enderecos = session.createQuery("from " + Endereco.class.getName()).list();
            session.getTransaction().commit();
            return enderecos;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
}
