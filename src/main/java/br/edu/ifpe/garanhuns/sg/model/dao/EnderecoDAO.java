/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import br.edu.ifpe.garanhuns.sg.model.Endereco;

/**
 *
 * @author Herikles
 */
public interface EnderecoDAO extends DAO<Endereco> {

    public Endereco recuperarPorLogradouro(String name);

    public void deletarEmCascata(Endereco b);
}
