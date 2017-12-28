/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.Usuario;

/**
 *
 * @author Herikles
 */
public interface AtendenteDAO extends DAO<Atendente> {

    public Atendente recuperarAtendentePorUsuario(Usuario usuario);
}
