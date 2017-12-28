/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.Atendimento;
import br.edu.ifpe.garanhuns.sg.model.DiasSemana;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.AtendenteHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.HorarioAtendimentoHibernate;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author Jose Junio
 */
@ManagedBean
@RequestScope
public class HorarioAtendimentoController implements Serializable {

    private HorarioAtendimentoHibernate model;
    private HorarioAtendimento horarioAtendimento;
    private Atendimento atendimento;
    private Atendente atendente;

    public HorarioAtendimentoController() {

    }

    @PostConstruct
    public void init() {

        model = new HorarioAtendimentoHibernate();
        atendimento = new Atendimento();
        horarioAtendimento = new HorarioAtendimento();
        horarioAtendimento.setAtendimento(atendimento);
        recuperarAtendenteLogado();
    }

    public void cadastrarHorarioAtendimentoPosto() {
        this.horarioAtendimento.setHoraInicio("07:00");
        this.horarioAtendimento.setHoraTermino("17:00");
        atendimento.setPostoSaude(atendente.getPostoSaude());
        horarioAtendimento.setAtendimento(atendimento);
        model.inserir(this.horarioAtendimento);
        horarioAtendimento.setQuantidade(0);
    }

    public HorarioAtendimento getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(HorarioAtendimento horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public Especialidade[] getEspecialidade() {
        return Especialidade.values();
    }

    public DiasSemana[] getDias() {
        return DiasSemana.values();
    }

    public void recuperarAtendenteLogado() {

        Usuario usuario = (Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("usuarioLogado");

        this.atendente = new AtendenteHibernate().recuperarAtendentePorUsuario(usuario);
    }

    public HorarioAtendimentoHibernate getModel() {
        return model;
    }

    public void setModel(HorarioAtendimentoHibernate model) {
        this.model = model;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

}
