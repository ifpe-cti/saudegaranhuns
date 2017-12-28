/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import br.edu.ifpe.garanhuns.sg.model.DiasSemana;
import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.HorarioAtendimentoDAO;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;
import java.util.ArrayList;

/**
 *
 * @author Hérikles
 */
public class HorarioAtendimentoHibernate implements HorarioAtendimentoDAO {

    @Override
    public void inserir(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        AtendimentoHibernate aH = new AtendimentoHibernate();
        try {
            session.beginTransaction();
            aH.inserir(o.getAtendimento());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        AtendimentoHibernate aH = new AtendimentoHibernate();
        try {
            session.beginTransaction();
            aH.inserir(o.getAtendimento());
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(HorarioAtendimento o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public HorarioAtendimento recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (HorarioAtendimento) session.get(HorarioAtendimento.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<HorarioAtendimento> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<HorarioAtendimento> lista = session.createQuery("from " + HorarioAtendimento.class.getName()).list();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os HorarioAtendimento. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }
 
    @Override
    public List<HorarioAtendimento> recuperarHorarioAtendimentoPorPostoSaude(PostoSaude ps) {
        Session session = HibernateUtil.getSession();
        try {
            List<HorarioAtendimento> horarios = session.createNativeQuery(
                    "select * from HorarioAtendimento h where h.atendimento_id in ("
                    + "select id from Atendimento a where a.postoSaude_id = " + ps.getId() + ")", HorarioAtendimento.class).list();

            if (horarios != null) {
                return horarios;
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar o Horario. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<HorarioAtendimento> recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(PostoSaude ps, Especialidade especialidade) {
        Session session = HibernateUtil.getSession();
        try {
            List<HorarioAtendimento> horarios = session.createNativeQuery(
                    "select * \n"
                    + "from HorarioAtendimento h\n"
                    + "where h.atendimento_id in (\n"
                    + "	select id\n"
                    + "	from Atendimento a \n"
                    + "	where a.postoSaude_id = " + ps.getId() + " and especialidade =" + especialidade.getValor() + ");", HorarioAtendimento.class).list();
            

            if (horarios != null) {
                return horarios;
            }
        } catch (Exception e) {
            System.err.println("Falha ao recuperar o Horario. Erro: " + e.toString());
        }

        return null;
    }
    
}
