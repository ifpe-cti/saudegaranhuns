/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import model.POJO.enumerador.DiasSemana;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


/**
 *
 * @author Hérikles
 */

@Entity
public class HorarioAtendimento implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private DiasSemana dia;
    private String horaInicio;
    private String horaTermino;
    private int quantidade;
    @OneToOne
    private Atendimento atendimento;

    public HorarioAtendimento() {
    }

    public HorarioAtendimento(DiasSemana dia, String horaInicio, String horaTermino, int quantidade, Atendimento atendimento) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.quantidade = quantidade;
        this.atendimento = atendimento;
    }

    public int getId() {
        return id;
    }

    public DiasSemana getDia() {
        return dia;
    }

    public void setDia(DiasSemana dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
    
    @Override
    public String toString() {
        return "HorarioAtendimento{" + "id=" + id + ", dia=" + dia + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino + ", quantidade=" + quantidade + ", atendimento=" + atendimento + '}';
    }
}
