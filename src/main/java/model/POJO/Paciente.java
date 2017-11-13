/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Herikles
 */
@Entity
public class Paciente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cartaoSus;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar dataNascimento;
    // private Date dataNascimento;
    /*@OneToOne
    private Usuario usuario;*/
    @ManyToOne
    private Endereco endereco;
    @ManyToOne
    private PostoSaude postoSaude;

    public Paciente() {
    }

    public Paciente(String nome, String cartaoSus, Calendar dataNascimento, Endereco endereco, PostoSaude postoSaude) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.postoSaude = postoSaude;
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

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PostoSaude getPostoSaude() {
        return postoSaude;
    }

    public void setPostoSaude(PostoSaude postoSaude) {
        this.postoSaude = postoSaude;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nome=" + nome + ", cartaoSus=" + cartaoSus + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", postoSaude=" + postoSaude + '}';
    }

}
