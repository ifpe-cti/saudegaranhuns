/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Herikles
 */
@Entity
public class PostoSaude implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    @OneToOne
    private Bairro bairro;

    public PostoSaude() {
    }

    public PostoSaude(String nome, Bairro bairro) {
        this.nome = nome;
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "PostoSaude{" + "id=" + id + ", nome=" + nome + ", bairro=" + bairro + '}';
    }

   
}
