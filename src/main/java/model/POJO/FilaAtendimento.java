/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Hérikles
 */
@Entity
public class FilaAtendimento implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate data;
    private Consulta consulta;
    private int vagas;

    public FilaAtendimento() {
    }

    public FilaAtendimento(LocalDate data, Consulta consulta, int vagas) {
        this.data = data;
        this.consulta = consulta;
        this.vagas = vagas;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "FilaAtendimento{" + "id=" + id + ", data=" + data + ", consulta=" + consulta + ", vagas=" + vagas + '}';
    }
    
}
