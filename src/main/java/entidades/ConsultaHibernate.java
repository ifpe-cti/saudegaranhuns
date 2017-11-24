package entidades;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Junio
 */
public class ConsultaHibernate {

    private List<Consulta> consultas;

    public ConsultaHibernate() {
        this.consultas = new ArrayList<>();
    }

    public ConsultaHibernate(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public void insert(Consulta consulta) {
        System.out.println(consulta.getNome());
        this.consultas.add(consulta);
    }

}
