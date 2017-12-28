/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.controller;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor Sousa PC
 */
@ManagedBean
@SessionScoped
public class PostoSaudeController implements Serializable {

    private PostoSaudeHibernate model;
    private PostoSaude postosaude;
    

    @PostConstruct
    public void init() {
        postosaude = new PostoSaude();
        model = new PostoSaudeHibernate();
        postosaude.setEndereco(new Endereco());
        postosaude.getEndereco().setBairro(new Bairro()) ;
    }
    
    public void limparCampos() {
        postosaude = new PostoSaude();
        postosaude.setEndereco(new Endereco());
        postosaude.getEndereco().setBairro(new Bairro()) ;
    }

    public PostoSaudeController() {
    }

    public void cadastrar() {
        model.inserir(postosaude);
    }

    public void alterar() {
        model.atualizar(postosaude);
    }

    public void deletar() {
        model.deletar(postosaude);
    }

    public PostoSaude recuperar(int id) {
        return model.recuperar(postosaude.getId());
    }

    public List<PostoSaude> recuperarTodos() {
        return model.recuperarTodos();
    }

    public PostoSaude recuperarPorNome(String nome) {
        return model.recuperarPorNome(postosaude.getNome());
    }

    public void deletarEmCascata(PostoSaude postosaude) {
        model.deletarEmCascata(postosaude);
    }

    public PostoSaudeHibernate getModel() {
        return model;
    }

    public PostoSaude getPostosaude() {
        return postosaude;
    }

    public void setModel(PostoSaudeHibernate model) {
        this.model = model;
    }

    public void setPostosaude(PostoSaude postosaude) {
        this.postosaude = postosaude;
    }

}
