/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.FilaAtandimentoDAO;
import br.edu.ifpe.garanhuns.sg.model.FilaAtendimento;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Hérikles
 */
public class FilaAtendimentoHibernate implements FilaAtandimentoDAO {

    @Override
    public void inserir(FilaAtendimento o) {
        Session session = HibernateUtil.getSession();
        ConsultaHibernate cH = new ConsultaHibernate();
        try {
            session.beginTransaction();
            cH.inserir(o.getConsulta());
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
    public void atualizar(FilaAtendimento o) {
        Session session = HibernateUtil.getSession();
        ConsultaHibernate cH = new ConsultaHibernate();
        try {
            session.beginTransaction();
            cH.inserir(o.getConsulta());
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
    public void deletar(FilaAtendimento o) {
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
    public FilaAtendimento recuperar(Integer id) {
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
