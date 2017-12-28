/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model.dao;

import br.edu.ifpe.garanhuns.sg.model.Paciente;

import br.edu.ifpe.garanhuns.sg.model.Usuario;
/**
 * 
 * @author Herikles
 */
public interface PacienteDAO extends DAO<Paciente> {

    public Paciente recuperarPorNome(String name);

    public Paciente recuperarPorCartaoSus(String numeroCartao);
    public Paciente recuperarPacientePorUsuario(Usuario usuario);
    
}
