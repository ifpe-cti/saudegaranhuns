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
public enum Prioridade {
    NENHUMA("Nenhuma"),
    IDOSO("Idoso"),
    DEFICIENTEFISICO("Deficiente fisíco"),
    BEBEDECOLO("Bebê de colo"),
    GESTANTE("Gestate");

    private String label;

    private Prioridade(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }
}
