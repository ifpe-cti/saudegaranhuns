/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

import java.time.LocalDate;

/**
 *
 * @author Fernando
 */
public class Consulta {

    private int id;
    private Status status;
    private Prioridade prioridade;
    private Especialidade especialidade;
    private LocalDate agendamento;
    private LocalDate solicitacao;

    public Consulta() {
	this.status = Status.PENDENTE;
	this.solicitacao = LocalDate.now();
	this.agendamento = null;
    }

    public Consulta(int id, Prioridade prioridade, Especialidade especialidade) {
	this();
	this.id = id;
	this.prioridade = prioridade;
	this.especialidade = especialidade;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public LocalDate getSolicitacao() {
	return solicitacao;
    }

    public void setSolicitacao(LocalDate solicitacao) {
	this.solicitacao = solicitacao;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public Prioridade getPrioridade() {
	return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
	this.prioridade = prioridade;
    }

    public Especialidade getEspecialidade() {
	return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
	this.especialidade = especialidade;
    }

    public LocalDate getAgendamento() {
	return agendamento;
    }

    public void setAgendamento(LocalDate agendamento) {
	this.agendamento = agendamento;
    }

    @Override
    public String toString() {
	return "Consulta{" + "id=" + id + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + ", solicitacao=" + solicitacao + '}';
    }

}
