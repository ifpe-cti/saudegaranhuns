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
<<<<<<< HEAD
<<<<<<< HEAD
=======
    private String observacao;
>>>>>>> Classes de suporte, serão apagadas
=======
>>>>>>> Adaptando ao diagrama de classes
    private Status status;
    private Prioridade prioridade;
    private Especialidade especialidade;
    private LocalDate agendamento;
<<<<<<< HEAD
    private LocalDate solicitacao;

    public Consulta() {
	this.status = Status.PENDENTE;
	this.solicitacao = LocalDate.now();
	this.agendamento = null;
    }

<<<<<<< HEAD
    public Consulta(int id, Status status, Prioridade prioridade, Especialidade especialidade, LocalDate agendamento) {
        this.id = id;
        this.status = status;
        this.prioridade = prioridade;
        this.especialidade = especialidade;
        this.agendamento = agendamento;
=======
    public Consulta(int id, Prioridade prioridade, Especialidade especialidade) {
	this();
	this.id = id;
	this.prioridade = prioridade;
	this.especialidade = especialidade;
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
<<<<<<< HEAD
        this.id = id;
=======
	this.id = id;
    }

    public LocalDate getSolicitacao() {
	return solicitacao;
    }

    public void setSolicitacao(LocalDate solicitacao) {
	this.solicitacao = solicitacao;
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
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
=======

    public Consulta() {
    }

    public Consulta(int id, Status status, Prioridade prioridade, Especialidade especialidade, LocalDate agendamento) {
        this.id = id;
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
<<<<<<< HEAD
	this.agendamento = agendamento;
>>>>>>> Classes de suporte, serão apagadas
=======
        this.agendamento = agendamento;
>>>>>>> Adaptando ao diagrama de classes
    }

    @Override
    public String toString() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        return "Consulta{" + "id=" + id + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + '}';
=======
	return "Consulta{" + "id=" + id + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + ", solicitacao=" + solicitacao + '}';
>>>>>>> Adicionando mensagem de confirmação e ajustando telas de acordo com o diagrama de classes
=======
	return "Consulta{" + "id=" + id + ", observacao=" + observacao + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + '}';
>>>>>>> Classes de suporte, serão apagadas
=======
        return "Consulta{" + "id=" + id + ", status=" + status + ", prioridade=" + prioridade + ", especialidade=" + especialidade + ", agendamento=" + agendamento + '}';
>>>>>>> Adaptando ao diagrama de classes
    }

}
