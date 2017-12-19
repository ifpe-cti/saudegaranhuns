/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

import com.google.gson.Gson;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Herikles
 */
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(unique = true)
    private String cartaoSus;
    private LocalDate dataNascimento;
    @ManyToOne
    private PostoSaude postoSaude;
    @OneToOne
    private Usuario usuario;

    public Paciente() {
    }

    public Paciente(String nome, String cartaoSus, LocalDate dataNascimento, PostoSaude postoSaude, Usuario usuario) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
        this.dataNascimento = dataNascimento;
        this.postoSaude = postoSaude;
        this.usuario = usuario;
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

    public String getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", cartaoSus=" + cartaoSus + ", dataNascimento=" + dataNascimento + ", postoSaude=" + postoSaude + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
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
        final Paciente other = (Paciente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public static boolean validarPacienteJson(String pacienteJson) {

        Paciente pacienteValidado;

        try {
            pacienteValidado = new Gson().fromJson(pacienteJson, Paciente.class);
            if (pacienteValidado.getNome() != null
                    && pacienteValidado.getCartaoSus() != null
                    && pacienteValidado.getDataNascimento() != null
                    && pacienteValidado.getPostoSaude() != null
                    && pacienteValidado.getUsuario() != null) {
                return true;
            }
        } catch (com.google.gson.JsonSyntaxException err) {
            return false;
        }
        return false;
    }
}
