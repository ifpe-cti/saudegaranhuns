/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Herikles
 */
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return "Consulta{" + "id=" + id + ", especialidade=" + especialidade + ", prioridade=" + prioridade + ", status=" + status + ", dataSolicitacao=" + dataSolicitacao + ", dataAgendamento=" + dataAgendamento + ", paciente=" + paciente + '}';
    }

   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public static boolean validarConsultaJson(String consultaJson) {

        Consulta consultaValidada;

        try {
            consultaValidada = new Gson().fromJson(consultaJson, Consulta.class);
            if (consultaValidada.getDataAgendamento() != null
                    && consultaValidada.getDataSolicitacao() != null
                    && consultaValidada.getEspecialidade() != null
                    && consultaValidada.getPrioridade() != null
                    && consultaValidada.getStatus() != null
                    && (Paciente.validarPacienteJson(new Gson().toJson(consultaValidada.getPaciente())))) {
                return true;
            }
        } catch (com.google.gson.JsonSyntaxException err) {
            return false;
        }
        return false;
    }

}
