/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Prioridade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Status;

/**
 *
 * @author Herikles
 */
@Entity
public class Consulta implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Especialidade especialidade;
    private Prioridade prioridade;
    private Status status;
    private LocalDate dataSolicitacao;
    private LocalDate dataAgendamento;
    @OneToOne
    private Paciente paciente;

    public Consulta() {
    }

    public Consulta(Especialidade especialidade, Prioridade prioridade, Status status, LocalDate dataSolicitacao, LocalDate dataAgendamento, Paciente paciente) {
        this.especialidade = especialidade;
        this.prioridade = prioridade;
        this.status = status;
        this.dataSolicitacao = dataSolicitacao;
        this.dataAgendamento = dataAgendamento;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consulta{" + "especialidade=" + especialidade + ", prioridade=" + prioridade + ", status=" + status + ", dataSolicitacao=" + dataSolicitacao + ", dataAgendamento=" + dataAgendamento + ", paciente=" + paciente + '}';
    }
    
    
}
