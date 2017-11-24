/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO.enumerador;

/**
 *
 * @author Herikles
 */
public enum Prioridade {
    IDOSO(1),
    GESTANTE(2);

    private int valor;

    private Prioridade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}
