/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

/**
 *
 * @author Hérikles
 */
public enum Especialidade {
    
    GERAL(1),DENTISTA(2);
    
    private int valor;
    private Especialidade(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }
}
