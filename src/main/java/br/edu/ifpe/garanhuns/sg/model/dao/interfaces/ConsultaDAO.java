/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao.interfaces;

import java.util.List;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
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

    public List<LocalDate> agendamentoAutomáticoConsulta(PostoSaude posto, Especialidade especialidade);
}
