/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

import java.util.Date;

/**
 *
 * @author Herikles
 */
public class Paciente {
    
    private String nome;
    private String cartaoSus;
    private Date dataNascimento;
    private Usuario usuario;
    private Endereco enderoco;
    private PostoSaude postoSaude;    

    public Paciente(String nome, String cartaoSus, Date dataNascimento, Usuario usuario, Endereco enderoco, PostoSaude postoSaude) {
        this.nome = nome;
        this.cartaoSus = cartaoSus;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.enderoco = enderoco;
        this.postoSaude = postoSaude;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEnderoco() {
        return enderoco;
    }

    public void setEnderoco(Endereco enderoco) {
        this.enderoco = enderoco;
    }

    public PostoSaude getPostoSaude() {
        return postoSaude;
    }

    public void setPostoSaude(PostoSaude postoSaude) {
        this.postoSaude = postoSaude;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nome=" + nome + ", cartaoSus=" + cartaoSus + ", dataNascimento=" + dataNascimento + ", enderoco=" + enderoco + ", postoSaude=" + postoSaude + '}';
    }
}
