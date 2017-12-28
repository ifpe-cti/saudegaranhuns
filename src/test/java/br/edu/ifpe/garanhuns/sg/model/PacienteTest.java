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
        String pacienteJson = "{\"id\":0,\"nome\":\"Teste\",\"cartaoSus\":\"123\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto\","
                + "\"endereco\":{\"id\":0,\"numero\":\"123\",\"logradouro\":\"Rua\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"LoginTest\",\"senha\":\"000009\",\"perfilUsuario\":\"PACIENTE\"}}";
        Assert.assertTrue(Paciente.validarPacienteJson(pacienteJson));
    }

    @Test
    public void testValidarPacienteJsonFormatoInvalido() {
        String pacienteJson = "\"id\":0,\"nome\":\"Teste\",\"cartaoSus\":\"123\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto\","
                + "\"endereco\":{\"id\":0,\"numero\":\"123\",\"logradouro\":\"Rua\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"LoginTest\",\"senha\":\"000009\",\"perfilUsuario\":\"PACIENTE\"}}";
        Assert.assertFalse(Paciente.validarPacienteJson(pacienteJson));

    }

    @Test
    public void testValidarPacienteJsonCampoNomeInvalido() {
        String pacienteJson = "{\"id\":0,\"nom\":\"Teste\",\"cartaoSus\":\"123\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto\","
                + "\"endereco\":{\"id\":0,\"numero\":\"123\",\"logradouro\":\"Rua\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"LoginTest\",\"senha\":\"000009\",\"perfilUsuario\":\"PACIENTE\"}}";
        Assert.assertFalse(Paciente.validarPacienteJson(pacienteJson));
    }

}
