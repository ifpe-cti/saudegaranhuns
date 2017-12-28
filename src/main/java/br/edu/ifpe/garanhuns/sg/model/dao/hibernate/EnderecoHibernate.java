/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;
import br.edu.ifpe.garanhuns.sg.model.dao.EnderecoDAO;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.Endereco;

/**
 *
 * @author Herikles
 */
public class EnderecoHibernate implements EnderecoDAO {

    @Override
    public void inserir(Endereco o) {
        Session session = HibernateUtil.getSession();
        BairroHibernate bh = new BairroHibernate();
        
        try {
            session.beginTransaction();
            Bairro b = bh.recuperarPorNome(o.getBairro().getNome());
            if(b==null){
                bh.inserir(o.getBairro());
                session.save(o);
            }
            //perguntar se isso faz sentido
            else{
                o.setBairro(b);
                session.save(o);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Endereco o) {
        Session session = HibernateUtil.getSession();
         BairroHibernate bh = new BairroHibernate();
        try {
            session.beginTransaction();
            Bairro b = bh.recuperarPorNome(o.getBairro().getNome());
            if(b==null){
                bh.inserir(o.getBairro());
                session.update(o);
            }
            //perguntar se isso faz sentido
            else{
                o.setBairro(b);
                session.update(o);
            }
           
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Endereço. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Endereco o) {
        Session session = HibernateUtil.getSession();
         BairroHibernate bh = new BairroHibernate();
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
    public Endereco recuperar(Integer id) {
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
            
            List<Endereco> lista = session.createQuery("from " + Endereco.class.getName()).list();
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

    @Override
    public void deletarEmCascata(Endereco b) {
        
        deletar(b);
    }

    @Override
    public Endereco recuperarPorLogradouro(String name) {
        try (Session session = HibernateUtil.getSession()) {
            List<Endereco> enderecos = (session.createQuery("from Endereco e where e.logradouro = :name").setParameter("name", name).list());
            if(enderecos!=null)
                return enderecos.get(0);
            
        } catch (Exception e) {
            System.err.println("Falha ao recuperar o  Endereço por nome. Erro: " + e.toString());
        }
        return null;
    }
}
