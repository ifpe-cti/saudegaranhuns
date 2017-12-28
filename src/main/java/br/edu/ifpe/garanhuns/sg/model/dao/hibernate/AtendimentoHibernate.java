/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.AtendimentoDAO;
import br.edu.ifpe.garanhuns.sg.model.Atendimento;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;
import java.util.ArrayList;

/**
 *
 * @author Hérikles
 */
public class AtendimentoHibernate implements AtendimentoDAO {

    @Override
    public void inserir(Atendimento o) {
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
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Atendimento o) {
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
            System.err.println("Falha ao alterar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Atendimento o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Atendimento recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Atendimento) session.get(Atendimento.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Atendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Atendimento> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Atendimento> lista = session.createQuery("from " + Atendimento.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Atendimentos. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Atendimento> recuperarAtendimentoPorPosto(PostoSaude posto) {
        Session session = HibernateUtil.getSession();
        try {
            List<Atendimento> atendimentos = session.createNativeQuery("select * from atendimento a where a.postoSaude_id = " + posto.getId(), Atendimento.class).list();
            if (atendimentos != null) {
                return atendimentos;
            }
        } catch (Exception e) {
            System.err.println("Falha ao recuperar o atendimentos. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<Atendimento> recuperarAtendimentoPorPostoEspecialidade(PostoSaude posto, Especialidade especialidade) {
        List<Atendimento> atendimentos = recuperarAtendimentoPorPosto(posto);
        List<Atendimento> retorno = new ArrayList<>();
        if (atendimentos != null) {
            for (Atendimento atendimento : atendimentos) {
                if (atendimento.getEspecialidade().equals(especialidade)) {
                    retorno.add(atendimento);
                }
            }
            return retorno;
        }
        return null;
    }

}
