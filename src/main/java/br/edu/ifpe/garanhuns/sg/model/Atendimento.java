/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Hérikles
 */
@Entity
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Especialidade especialidade;
    @ManyToOne
    private PostoSaude postoSaude;

    public Atendimento(Especialidade especialidade, PostoSaude postoSaude) {
        this.especialidade = especialidade;
        this.postoSaude = postoSaude;
    }

    public Atendimento() {
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

    public PostoSaude getPostoSaude() {
        return postoSaude;
    }

    public void setPostoSaude(PostoSaude postoSaude) {
        this.postoSaude = postoSaude;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + ", especialidade=" + especialidade + ", postoSaude=" + postoSaude + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
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
        final Atendimento other = (Atendimento) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
