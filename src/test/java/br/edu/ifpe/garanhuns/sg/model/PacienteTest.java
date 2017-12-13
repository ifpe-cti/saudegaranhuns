/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.model;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Jose Junio
 */
public class PacienteTest {

    /**
     * Test of validarPacienteJson method, of class Paciente.
     */
    @Test
    public void testValidarPacienteJsonValido() {
        String pacienteJson = "{\"id\":0,\"nome\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}\n"
                + "";
        Assert.assertTrue(Paciente.validarPacienteJson(pacienteJson));
    }

    @Test
    public void testValidarPacienteJsonFormatoInvalido() {
        String pacienteJson = "\"id\":0,\"nome\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}\n"
                + "";
        Assert.assertFalse(Paciente.validarPacienteJson(pacienteJson));

    }

    @Test
    public void testValidarPacienteJsonCampoInvalido() {
        String pacienteJson = "{\"id\":0,\"nom\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}\n"
                + "";
        Assert.assertFalse(Paciente.validarPacienteJson(pacienteJson));
    }
}
