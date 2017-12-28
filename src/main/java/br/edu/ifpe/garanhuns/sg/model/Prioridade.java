/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

/**
 *
 * @author Herikles
 */
public enum Prioridade {
    NENHUMA(0, "Nenhuma"),
    IDOSO(1, "Idoso"),
    GESTANTE(2, "Gestante"),
    DEFICIENTEFISICO(3, "Deficiente Físico"),
    BEBEDECOLO(4, "Bebê de colo");

    private int valor;
    private String nome;

    private Prioridade(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public int getValor() {
        return this.valor;
    }

    public String getNome() {
        return nome;
    }
}
