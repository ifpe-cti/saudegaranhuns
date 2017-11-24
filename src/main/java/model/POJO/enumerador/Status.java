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
public enum Status {
    FILA(1),
    AGENDADO(2),
    CANSELADO(3);

    private int valor;

    private Status(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }
}
