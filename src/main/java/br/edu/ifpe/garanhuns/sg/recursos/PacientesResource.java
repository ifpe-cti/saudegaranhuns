/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PerfilUsuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
     * @param pacienteJson
     * @return an instance of java.lang.String
     */
    @RequestMapping(value = "/pacientes", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity cadastrarPaciente(@RequestBody String pacienteJson) {

        if (Paciente.validarPacienteJson(pacienteJson)) {
            Paciente paciente = new Gson().fromJson(pacienteJson, Paciente.class);
            paciente.getUsuario().setPerfilUsuario(PerfilUsuario.PACIENTE); // O perfil não está sendo reconhecido do frontend. Por isso está sendo definido aqui.
            try {
                new PacienteHibernate().inserir(paciente);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }catch(org.hibernate.exception.ConstraintViolationException erro){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            } catch (Exception err) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @RequestMapping(value = "/pacientes{cartaoSus}", method = RequestMethod.GET)
    public ResponseEntity<String> recuperarPacientePorCartaoDoSus(@RequestParam("cartaoSus") String cartaoSus) {
        try {
            Paciente paciente = new PacienteHibernate().recuperarPorCartaoSus(cartaoSus);
            if (null == paciente) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(paciente));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
