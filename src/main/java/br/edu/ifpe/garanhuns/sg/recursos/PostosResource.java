/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import com.google.gson.Gson;
import javax.ws.rs.client.ResponseProcessingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@RestController
@RequestMapping(value = "/postos")
public class PostosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PostosResource
     */
    public PostosResource() {
    }

    /**
     * Retrieves representation of an instance of
     * br.edu.ifpe.garanhuns.sg.recursos.PostosResource
     *
     * @return an instance of java.lang.String
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<String> recuperarTodosOsPostos() {

        String postosJson;
        try {
            postosJson = new Gson().toJson(
                    new PostoSaudeHibernate().recuperarTodos());
        } catch (ResponseProcessingException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        if (postosJson == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("null");
        }
        if (postosJson.equals("[]")) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(postosJson);

        }
        return ResponseEntity.status(HttpStatus.OK).body(postosJson);
    }
}
