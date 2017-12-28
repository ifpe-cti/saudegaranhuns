/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.Status;
import java.time.LocalDate;

/**
 *
 * @author Hérikles
 */
public interface ConsultaDAO extends DAO<Consulta> {

    List<Consulta> recuperarConsultasPorPaciente(Paciente c);

    public void alterarStatusConsulta(Consulta c, int i);

    public List<Consulta> recuperarConsultasDoDia(LocalDate dia);

    public List<Consulta> recuperarTodasConsultasDoPosto(PostoSaude posto);

    public List<Consulta> recuperarConsultasDoPostoPorDia(PostoSaude posto, LocalDate data);

    public List<Consulta> recuperarConsultasDoPostoPorDiaEspecialidade(PostoSaude posto, LocalDate data, Especialidade especialidade);

    public List<Consulta> recuperarConsultasDoPostoPorDiaEspecialidadeStatus(PostoSaude posto, LocalDate data, Especialidade especialidade, Status status);

    public List<LocalDate> agendamentoAutomaticoConsulta(PostoSaude posto, Especialidade especialidade);

    public List<Consulta> gerarRelatorioConsultaPorStatus(Status status, LocalDate dataInicio, LocalDate dataFim);

    public List<Consulta> gerarRelatorioConsultaPorPostoStatus(PostoSaude posto, Status status, LocalDate dataInicio, LocalDate dataFim);
}
