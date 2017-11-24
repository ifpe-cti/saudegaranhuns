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

    DOMINGO(0),
    SEGUNDA(1),
    TERÇA(2),
    QUARTA(3),
    QUINTA(4),
    SEXTA(5),
    SABADO(6);

    private int valor;

    private DiasSemana(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

}
