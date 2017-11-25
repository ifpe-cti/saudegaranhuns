/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@Path("postos")
public class PostosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PostosResource
     */
    public PostosResource() {
    }

    /**
     * Retrieves representation of an instance of recursos.PostosResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String recuperarPostos() {

        return new PostoSaudeHibernate().recuperarTodos();

    }
}
