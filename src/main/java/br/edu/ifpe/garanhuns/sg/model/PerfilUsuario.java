/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

/**
 *
 * @author Hérikles Vinícyus
 */
public enum PerfilUsuario {
    
    ADMINISTRADOR(0, "ADMINISTRADOR"),
    ATENDENTE(1, "ATENDENTE"),
    PACIENTE(2, "PACIENTE");

    private int valor;
    private String nome;

    private PerfilUsuario(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return this.valor;
    }

    public String getNome() {
        return this.nome;
    }
}
