/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.dao.ConsultaDAO;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.Status;
import org.hibernate.Session;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;
import java.time.LocalDate;

/**
 *
 * @author Hérikles
 */
public class ConsultaHibernate implements ConsultaDAO {

    @Override
    public void inserir(Consulta o) {
        Session session = HibernateUtil.getSession();
        PacienteHibernate pH = new PacienteHibernate();
        try {
            session.beginTransaction();
            Paciente p = pH.recuperarPorNome((o.getPaciente()).getNome());
            if (p == null) {
                pH.inserir(o.getPaciente());
            } else {
                o.setPaciente(p);
            }
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void atualizar(Consulta o) {
        Session session = HibernateUtil.getSession();
        PacienteHibernate pH = new PacienteHibernate();
        try {
            session.beginTransaction();
            Paciente p = pH.recuperarPorNome((o.getPaciente()).getNome());
            if (p == null) {
                pH.inserir(o.getPaciente());
            } else {
                o.setPaciente(p);
            }
            session.update(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Consulta o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.delete(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao remover Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public Consulta recuperar(Integer id) {
        Session session = HibernateUtil.getSession();
        try {
            return (Consulta) session.get(Consulta.class.getName(), id);
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar Consulta. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarTodos() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Consulta> lista = session.createQuery("from " + Consulta.class.getName()).getResultList();
            session.getTransaction().commit();
            return lista;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar todos os Consultas. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasPorPaciente(Paciente c) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            List<Consulta> consultas = (session.createQuery("from " + Consulta.class.getName()).list());
            List<Consulta> retorno = new ArrayList<>();
            for (Consulta p : consultas) {
                if (p.getPaciente().getNome().equals(c.getNome())) {
                    retorno.add(p);
                }
            }
            session.getTransaction().commit();
            return retorno;

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao recuperar os Consulta por Paciente. Erro: " + e.toString());
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasDoDia(LocalDate dia) {
        try (Session session = HibernateUtil.getSession()) {
            List<Consulta> consultas = session.createQuery("from Consulta c where c.dataAgendamento = :data and c.status = 1").setParameter("data", dia).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar recuperarConsultasDoDia. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public void alterarStatusConsulta(Consulta c, int i) {
        switch (i) {
            case 1:
                c.setStatus(Status.ATENDIMENTO);
                break;
            case 2:
                c.setStatus(Status.AGENDADO);
                break;
            case 3:
                c.setStatus(Status.CANCELADO);
                break;
            default:
                throw new IllegalArgumentException("Argumento invalido!");
        }
        atualizar(c);
    }

    @Override
    public List<Consulta> recuperarTodasConsultasDoPosto(PostoSaude posto) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery("select * from Consulta where paciente_id in (select id from Paciente where postoSaude_id = " + posto.getId() + ")", Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar TodasConsultas Do Posto. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasDoPostoPorDia(PostoSaude posto, LocalDate data) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery(
                    "select * from Consulta where dataAgendamento = \"" + data + "\" and paciente_id in ("
                    + "select id from Paciente where postoSaude_id = " + posto.getId()
                    + ")", Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao rrecuperar Consultas Do Posto Por Dia. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasDoPostoPorDiaEspecialidade(PostoSaude posto, LocalDate data, Especialidade especialidade) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery(
                    "select * from Consulta"
                    + " where especialidade = " + especialidade.getValor()
                    + " and dataAgendamento = \"" + data
                    + "\" and paciente_id in ("
                    + "select id from Paciente "
                    + "where postoSaude_id = " + posto.getId() + ");",
                    Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar Consultas Do Posto Por Dia Especialidade. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<Consulta> recuperarConsultasDoPostoPorDiaEspecialidadeStatus(PostoSaude posto, LocalDate data, Especialidade especialidade, Status status) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery(
                    "select * from Consulta"
                    + " where especialidade = " + especialidade.getValor()
                    + " and dataAgendamento = \"" + data
                    + "\" and status = " + status.getValor()
                    + " and paciente_id in ("
                    + "select id from Paciente "
                    + "where postoSaude_id = " + posto.getId() + ");",
                    Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao recuperar Consultas Do Posto Por Dia Especialidade Status. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<LocalDate> agendamentoAutomaticoConsulta(PostoSaude posto, Especialidade especialidade) {
        List<HorarioAtendimento> horariosAtandimento = new HorarioAtendimentoHibernate().recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(posto, especialidade);
        List<LocalDate> retorno = new ArrayList<>();

        ConsultaHibernate cH = new ConsultaHibernate();
        //veriafica qual é o HorarioAtendimentoPorPostoSaudeEspecialidade
        for (int i = 0; i < horariosAtandimento.size(); i++) {
            //para verificar todas as datas em 2 meses 
            for (int j = 0; j < 60; j++) {
                //Compatibilidade dos dias da samana, se o dia testado é uma dia que o posto atende
                if (horariosAtandimento.get(i).getDia().getValor() == LocalDate.now().plusDays(j).getDayOfWeek().getValue()) {
                    List<Consulta> consultas = cH.recuperarConsultasDoPostoPorDiaEspecialidadeStatus(posto, LocalDate.now().plusDays(j), especialidade, Status.AGENDADO);
                    //Qua a quantidade de vagas no dia 
                    if (consultas.size() < horariosAtandimento.get(i).getQuantidade()) {
                        retorno.add(LocalDate.now().plusDays(j));
                    }
                }
            }
        }
        return retorno;
    }

    @Override
    public List<Consulta> gerarRelatorioConsultaPorStatus(Status status, LocalDate dataInicio, LocalDate dataFim) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery("select * from Consulta where status = " + status.getValor() + " and dataAgendamento between \"" + dataInicio + "\" and \"" + dataFim + "\"", Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao gerarRelatorioConsultaPorStatus. Erro: " + e.toString());
        }
        return null;
    }

    @Override
    public List<Consulta> gerarRelatorioConsultaPorPostoStatus(PostoSaude posto, Status status, LocalDate dataInicio, LocalDate dataFim) {
        Session session = HibernateUtil.getSession();
        try {
            List<Consulta> consultas = session.createNativeQuery("select * from Consulta where status = " + status.getValor() + " and dataAgendamento between \"" + dataInicio + "\" and \"" + dataFim + "\" and paciente_id in(select id from Paciente p where p.postoSaude_id = " + posto.getId() + ");", Consulta.class).list();
            if (consultas != null) {
                return consultas;
            }

        } catch (Exception e) {
            System.err.println("Falha ao gerarRelatorioConsultaPorPostoStatus. Erro: " + e.toString());
        }
        return null;
    }

}
