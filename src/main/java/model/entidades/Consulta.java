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
    private String observacao;
    private Status status;
    private Prioridade prioridade;
    private Especialidade especialidade;
    private LocalDate agendamento;

    public Consulta() {
    }

    public Consulta(int id, String observacao, Status status, Prioridade prioridade, Especialidade especialidade, LocalDate agendamento) {
	this.id = id;
	this.observacao = observacao;
	this.status = status;
	this.prioridade = prioridade;
	this.especialidade = especialidade;
	this.agendamento = agendamento;
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getObservacao() {
	return observacao;
    }

    public void setObservacao(String observacao) {
	this.observacao = observacao;
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
	return "Consulta{" + "id=" + id + ", observacao=" + observacao + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + '}';
    }

}
