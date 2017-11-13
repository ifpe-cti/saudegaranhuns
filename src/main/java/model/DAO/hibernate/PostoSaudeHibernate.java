/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import model.DAO.interfaces.PostoSaudeDAO;
import model.POJO.Atendente;
import model.POJO.Bairro;
import model.POJO.Paciente;
import model.POJO.PostoSaude;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class PostoSaudeHibernate implements PostoSaudeDAO {
    
    @Override
    public void insert(PostoSaude o) {
        Session session = HibernateUtil.getSession();
        BairroHibernate bh = new BairroHibernate();
        
        try {
            session.beginTransaction();
            Bairro b = bh.readByName(o.getBairro().getNome());
            if (b == null) {
                bh.insert(o.getBairro());
                session.save(o);
            } //perguntar se isso faz sentido
            else {
                o.setBairro(b);
                session.save(o);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Posto de Saude. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }
    
    @Override
    public void update(PostoSaude o) {
        Session session = HibernateUtil.getSession();
        BairroHibernate bh = new BairroHibernate();
        try {
            session.beginTransaction();
            Bairro b = bh.readByName(o.getBairro().getNome());
            if (b == null) {
                bh.insert(o.getBairro());
                session.update(o);
            } //perguntar se isso faz sentido
            else {
                o.setBairro(b);
                session.update(o);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Posto de Saude. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }
    
    @Override
    public void delete(PostoSaude o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Posto de Saude. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }
    
    @Override
    public PostoSaude read(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (PostoSaude) session.get(PostoSaude.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar PostoSaude. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
    
    @Override
    public List<PostoSaude> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<PostoSaude> lista = session.createQuery("from " + PostoSaude.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Postos de Saude. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
    
    @Override
    public void deleteOnCascade(PostoSaude ps) {
        PacienteHibernate ph = new PacienteHibernate();
        AtendenteHibernate ah = new AtendenteHibernate();
        
        List<Paciente> todosPacientes = ph.recuperarTodos();
        List<Atendente> todosAtendentes = ah.recuperarTodos();
        
        for (Paciente p : todosPacientes) {
            if (p.getEndereco().getId() == ps.getId()) {
                ph.delete(p);
            }
        }
        for (Atendente a : todosAtendentes) {
            if (a.getPostoSaude().getId() == ps.getId()) {
                ah.delete(a);
            }
        }
        
        delete(ps);
    }
    
    @Override
    public PostoSaude readByName(String name) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<PostoSaude> postosaude = (session.createQuery("from " + PostoSaude.class.getName()).list());
            for (PostoSaude p : postosaude) {
                if (p.getNome().equals(name)) {
                    return p;
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar o  posto de saude por nome. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
    
}
