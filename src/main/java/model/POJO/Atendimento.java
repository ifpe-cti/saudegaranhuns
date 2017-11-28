/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import model.POJO.enumerador.Especialidade;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Hérikles
 */

@Entity
public class Atendimento implements Serializable{
    
    @Id
    @GeneratedValue
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
    
    
    
}
