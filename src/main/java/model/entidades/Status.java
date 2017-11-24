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
public enum Status {
    PENDENTE("Pendente"),
    CANCELADO("Cancelado"),
    CONSULTADO("Consultado");

    private String label;

    private Status(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
