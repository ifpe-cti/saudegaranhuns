/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO.enumerador;

/**
 *
 * @author Hérikles
 */
public enum DiasSemana {

    DOMINGO(1),
    SEGUNDA(2),
    TERÇA(3),
    QUARTA(4),
    QUINTA(5),
    SEXTA(6),
    SABADO(7);

    private int valor;

    private DiasSemana(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

}
