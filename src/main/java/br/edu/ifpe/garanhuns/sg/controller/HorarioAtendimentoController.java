/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Atendimento;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.HorarioAtendimentoHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.DiasSemana;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScope
public class HorarioAtendimentoController implements Serializable {

    HorarioAtendimentoHibernate model;
    HorarioAtendimento horarioAtendimento;
    Atendimento atendimento;

    public HorarioAtendimentoController() {

    }

    @PostConstruct
    public void init() {

        model = new HorarioAtendimentoHibernate();
        atendimento = new Atendimento();
        horarioAtendimento = new HorarioAtendimento();
        horarioAtendimento.setAtendimento(atendimento);
    }

    public void cadastrarHorarioAtendimentoPosto() {
        this.horarioAtendimento.setHoraInicio("07:00");
        this.horarioAtendimento.setHoraTermino("17:00");
        model.inserir(this.horarioAtendimento);
    }

    public HorarioAtendimento getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public Especialidade[] recuperarEspecialidades() {
        return Especialidade.values();
    }

    public DiasSemana[] recuperarDiasDaSemana() {
        return DiasSemana.values();
    }
}
