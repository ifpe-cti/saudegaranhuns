/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import java.util.List;

/**
 *
 * @author Hérikles
 */
public interface HorarioAtendimentoDAO extends DAO<HorarioAtendimento> {

    public List<HorarioAtendimento> recuperarHorarioAtendimentoPorPostoSaude(PostoSaude ps);

    public List<HorarioAtendimento> recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(PostoSaude ps, Especialidade especialidade);
}
