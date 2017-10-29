/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJO;

/**
 *
 * @author Herikles
 */
public class Endereco {
    
    private Bairro bairro;
    private String numero;

    public Endereco(Bairro bairro, String numero) {
        this.bairro = bairro;
        this.numero = numero;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" + "bairro=" + bairro + ", numero=" + numero + '}';
    }
}
