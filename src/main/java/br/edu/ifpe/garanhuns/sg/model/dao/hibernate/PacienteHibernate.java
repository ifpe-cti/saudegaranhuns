/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import javax.swing.JOptionPane;
import br.edu.ifpe.garanhuns.sg.model.dao.PacienteDAO;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

/**
 *
 * @author Herikles
 */
public class PacienteHibernate implements PacienteDAO {

    @Override
    public void inserir(Paciente o) {
        Session session = HibernateUtil.getSession();
        PostoSaudeHibernate ph = new PostoSaudeHibernate();
        UsuarioHibernate uH = new UsuarioHibernate();
        try {
            session.beginTransaction();
            PostoSaude ps = ph.recuperarPorNome(o.getPostoSaude().getNome());
            if (ps == null) {
                ph.inserir(o.getPostoSaude());
            } else {
                o.setPostoSaude(ps);
            }
            uH.inserir(o.getUsuario());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Paciente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Paciente o) {
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
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao alterar Paciente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Paciente o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Paciente. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Paciente recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Paciente) session.get(Paciente.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Paciente. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Paciente> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Paciente> lista = session.createQuery("from " + Paciente.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Pacientes. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Paciente recuperarPorNome(String name) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Paciente> pacientes = (session.createQuery("from " + Paciente.class.getName()).list());
            for (Paciente p : pacientes) {
                if (p.getNome().equals(name)) {
                    return p;
                }
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar os Pacientes por nome. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Paciente recuperarPorCartaoSus(String numeroCartao) {
        try (Session session = HibernateUtil.getSession()) {
            List<Paciente> pacientes = (session.createQuery("from Paciente p where p.cartaoSus = :numeroCartao").setParameter("numeroCartao", numeroCartao).list());
            if (pacientes != null) {
                return pacientes.get(0);
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar o  Paciente por Cartão do SUS. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public Paciente recuperarPacientePorUsuario(Usuario usuario) {
        try (Session session = HibernateUtil.getSession()) {
            List<Paciente> pacientes = session.createNativeQuery("select * from Paciente where usuario_id = "+usuario.getId(), Paciente.class).list();
            if (pacientes != null) {
                return pacientes.get(0);
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar o  Paciente por Usuário. Erro: " + e.toString());
        }
        return null;
    }

}
