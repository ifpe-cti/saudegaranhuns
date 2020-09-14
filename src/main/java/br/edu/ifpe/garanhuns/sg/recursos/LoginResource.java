/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.UsuarioHibernate;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * REST Web Service
 *
 * @author Jose Junio
 */
@RestController
@RequestMapping(value = "/login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PostosResource
     */
    public LoginResource() {
    }

    @RequestMapping(method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity logar(@RequestBody String usuarioJson) {

        if (Usuario.validarJson(usuarioJson)) {
            Usuario usuario = new Gson().fromJson(usuarioJson, Usuario.class);

            try {

                Usuario usuarioLogado = new UsuarioHibernate().recuperarUsuarioPorLogin(usuario.getLogin(), usuario.getSenha());
                if(usuarioLogado != null){
                    return ResponseEntity.status(HttpStatus.OK).build();
                }else{
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }
                    
            } catch (Exception err) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
