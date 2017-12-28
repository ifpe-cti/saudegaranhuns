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
public class ConsultaTest {

    /**
     * Test of validarConsultaJson method, of class Consulta.
     */
    @Test
    public void testValidarConsultaJsonValido() {
        String consultaTest = "{\"id\":0,\"especialidade\":\"GERAL\","
                + "\"prioridade\":\"IDOSO\","
                + "\"status\":\"AGENDADO\","
                + "\"dataSolicitacao\":{\"year\":2017,\"month\":11,\"day\":24},"
                + "\"dataAgendamento\":{\"year\":2018,\"month\":1,\"day\":1},"
                + "\"paciente\":{\"id\":0,\"nome\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}}\n"
                + "";
        Assert.assertTrue(Consulta.validarConsultaJson(consultaTest));

    }

    @Test
    public void testValidarConsultaJsonFormatoInvalido() {

        String consultaTest = "\"id\":0,\"especialidade\":\"GERAL\","
                + "\"prioridade\":\"IDOSO\","
                + "\"status\":\"FILA\","
                + "\"dataSolicitacao\":{\"year\":2017,\"month\":11,\"day\":24},"
                + "\"dataAgendamento\":{\"year\":2018,\"month\":1,\"day\":1},"
                + "\"paciente\":{\"id\":0,\"nome\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}}\n"
                + "";
        Assert.assertFalse(Consulta.validarConsultaJson(consultaTest));

    }

    @Test
    public void testValidarConsultaJsonCampoInvalido() {
        String consultaTest = "{\"id\":0,\"especialidade\":\"GERAL\","
                + "\"rioridade\":\"IDOSO\","
                + "\"status\":\"FILA\","
                + "\"dataSolicitacao\":{\"year\":2017,\"month\":11,\"day\":24},"
                + "\"dataAgendamento\":{\"year\":2018,\"month\":1,\"day\":1},"
                + "\"paciente\":{\"id\":0,\"nome\":\"asdf\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}}\n"
                + "";
        Assert.assertFalse(Consulta.validarConsultaJson(consultaTest));

    }

}
