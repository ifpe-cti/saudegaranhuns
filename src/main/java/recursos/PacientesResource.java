/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

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
@Path("pacientes")
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
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(String pacienteJason) {

        new PacienteHibernate().insert(
                new Paciente().fromJason(pacienteJason)
        );
        //Alterar o caminho de resposta
        URI uri = URI.create("/pacienteCadastrado");
        return Response.created(uri).build();
    }
}
