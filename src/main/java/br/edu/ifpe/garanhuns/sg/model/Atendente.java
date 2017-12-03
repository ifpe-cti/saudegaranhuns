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
import javax.persistence.OneToOne;

/**
 *
 * @author Herikles
 */
@Entity
public class Atendente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @OneToOne
    private PostoSaude postoSaude;
    @OneToOne
    private Usuario usuario;

    public Atendente() {
    }

    public Atendente(String nome, PostoSaude postoSaude, Usuario usuario) {
        this.nome = nome;
        this.postoSaude = postoSaude;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public PostoSaude getPostoSaude() {
        return postoSaude;
    }

    public void setPostoSaude(PostoSaude postoSaude) {
        this.postoSaude = postoSaude;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Atendente{" + "id=" + id + ", nome=" + nome + ", postoSaude=" + postoSaude + '}';
    }
}
