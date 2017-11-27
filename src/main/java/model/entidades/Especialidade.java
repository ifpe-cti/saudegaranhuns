/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidades;

/**
 *
 * @author Fernando
 */
public enum Especialidade {
    DENTISTA("Dentista"),
    OUTROS("Outros");

    private String label;

    private Especialidade(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
