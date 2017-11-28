/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.pojo.Consulta;
import com.google.gson.Gson;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@Path("consultas")
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
     * @return an instance of java.lang.String
     */
    /**
     * PUT method for updating or creating an instance of ConsultasResource
     *
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastroPedidoConsulta(String content) {

        Gson gson = new Gson();

        new ConsultaHibernate().insert(
                gson.fromJson(content, Consulta.class)
        );
        //Alterar o caminho de resposta
        URI uri = URI.create("/pacienteCadastrado");
        return Response.created(uri).build();
    }
}
