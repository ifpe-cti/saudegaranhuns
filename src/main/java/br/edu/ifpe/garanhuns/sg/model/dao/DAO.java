/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import java.util.List;

/**
 *
 * @author Hérikles
 * @param <T>
 */
public interface DAO<T> {

    void inserir(T o);

    void atualizar(T o);

    void deletar(T o);

    T recuperar(Integer id);

    List<T> recuperarTodos();

}
