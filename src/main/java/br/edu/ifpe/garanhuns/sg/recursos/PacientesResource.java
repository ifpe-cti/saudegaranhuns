/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.EnderecoHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import com.google.gson.Gson;
import java.net.URI;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@RestController
@RequestMapping(value = "/pacientes")
public class PacientesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PacientesResource
     */
    public PacientesResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.PacientesResource
     *
     * @return an instance of java.lang.String
     */
    @RequestMapping(method = RequestMethod.POST)
    public Response cadastrar(String pacienteJson) {

        Paciente paciente = new Gson().fromJson(pacienteJson, Paciente.class);
        Endereco enderecoPaciente = paciente.getEndereco();
        new EnderecoHibernate().inserir(enderecoPaciente);
        new PacienteHibernate().inserir(paciente);
        //Alterar o caminho de resposta
        URI uri = URI.create("/pacienteCadastrado");
        return Response.created(uri).build();
    }
}
