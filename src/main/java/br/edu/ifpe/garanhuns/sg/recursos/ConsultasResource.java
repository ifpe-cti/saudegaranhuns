/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@RestController
public class ConsultasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConsultasResource
     */
    public ConsultasResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.ConsultasResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @RequestMapping(value = "/consultas{id}", method = RequestMethod.GET)
    public String recuperarConsultasPorPaciente(@RequestParam("id") int id) {

        //Paciente paciente = new PacienteHibernate().recuperar(id);
        List<Consulta> consultas = new ConsultaHibernate().
                recuperarConsultasPorPaciente(new PacienteHibernate().recuperar(id));

        return new Gson().toJson(consultas);
    }

    /**
     * POST method for updating or creating an instance of ConsultasResource
     *
     * @param pedidoConsultaJson
     * @return
     */
    @RequestMapping(value = "/consultas", method = RequestMethod.POST)
    public HttpStatus cadastroPedidoConsulta(@RequestBody String pedidoConsultaJson) {

        new ConsultaHibernate().inserir(
                new Gson().fromJson(
                        pedidoConsultaJson, Consulta.class)
        );
        return HttpStatus.CREATED;
    }
}
