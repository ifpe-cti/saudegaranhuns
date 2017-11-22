/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.google.gson.Gson;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.netbeans.rest.application.config.Consulta;
import org.netbeans.rest.application.config.ConsultaHibernate;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@Path("consulta")
public class ConsultasResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ConsultaResource
     */
    public ConsultasResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.ConsultasResource
     *
     * @return an instance of java.lang.String
     */
    @POST
    @Path("hoje")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pedidoConsulta(String consultaJson) {

        Gson gson = new Gson();
        new ConsultaHibernate().insert(
                gson.fromJson(consultaJson, Consulta.class));

        //Alterar o caminho de resposta
        URI uri = URI.create("/consultaCadastrada");
        return Response.created(uri).build();
    }

    /**
     * PUT method for updating or creating an instance of ConsultasResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    @GET
    @Path("ola")
    public String olaMundo() {
        return "oi";
    }
}
