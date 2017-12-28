/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import br.edu.ifpe.garanhuns.sg.model.Bairro;

/**
 *
 * @author Herikles
 */
public interface BairroDAO extends DAO<Bairro> {

    public Bairro recuperarPorNome(String name);

    public void deletarEmCascata(Bairro b);
}
