/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.BairroDAO;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class BairroHibernate implements BairroDAO {
    
    @Override
    public void inserir(Bairro o) {
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
    public void atualizar(Bairro o) {
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
    public void deletar(Bairro o) {
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
    public Bairro recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Bairro) session.get(Bairro.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
    
    @Override
    public List<Bairro> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Bairro> lista = session.createQuery("from " + Bairro.class.getName()).getResultList();
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
    public void deletarEmCascata(Bairro b) {
        //Session session = HibernateUtil.getSession();
        EnderecoHibernate eh = new EnderecoHibernate();
        PostoSaudeHibernate ps = new PostoSaudeHibernate();
        
        List<Endereco> todosEnderecos = eh.recuperarTodos();
        List<PostoSaude> todosPostos = ps.recuperarTodos();
        for (Endereco e : todosEnderecos) {
            if (e.getBairro().getNome().equals(b.getNome())) {
                eh.deletarEmCascata(e);
            }
        }
        for (PostoSaude p : todosPostos) {
            if (p.getEndereco().getLogradouro().equals(b.getNome())) {
                ps.deletarEmCascata(p);
            }
        }
        deletar(b);
    }
    
    @Override
    public Bairro recuperarPorNome(String name) {
        try (Session session = HibernateUtil.getSession()) {
            List<Bairro> bairros = (session.createQuery("from Bairro b where b.nome = :name").setParameter("name", name).list());
            if(bairros!=null)
                return bairros.get(0);
            
        } catch (Exception e) {
            System.err.println("Falha ao recuperar o Bairro por nome. Erro: " + e.toString());
        }
        return null;
    }
    
}
