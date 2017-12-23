/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.HorarioAtendimentoHibernate;
import javax.faces.bean.ManagedBean;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScope
public class HorarioAtendimentoController {

    HorarioAtendimentoHibernate model = new HorarioAtendimentoHibernate();
    HorarioAtendimento horarioAtendimento = new HorarioAtendimento();

    public HorarioAtendimentoController() {
    }

    public void cadastrarHorarioAtendimentoPosto() {

        model.inserir(horarioAtendimento);
    }

}
