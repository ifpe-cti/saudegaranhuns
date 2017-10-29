/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

/**
 *
 * @author Herikles
 */
public class PostoSaude {
    
    private String nome;
    private Bairro bairro;

    public PostoSaude(String nome, Bairro bairro) {
        this.nome = nome;
        this.bairro = bairro;
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
        return "PostoSaude{" + "nome=" + nome + ", bairro=" + bairro + '}';
    }
}
