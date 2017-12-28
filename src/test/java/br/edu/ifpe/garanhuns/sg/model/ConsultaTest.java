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
        String consultaTest = "{\"id\":0,\"especialidade\":\"GERAL\",\"prioridade\":\"IDOSO\",\"status\":\"AGENDADO\",\"dataSolicitacao\":{\"year\":2017,\"month\":12,\"day\":28},\"dataAgendamento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"paciente\":{\"id\":0,\"nome\":\"Paciente Test\",\"cartaoSus\":\"0001\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto Teste\","
                + "\"endereco\":{\"id\":0,\"numero\":\"007\",\"logradouro\":\"Rua Aqui\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"t\",\"senha\":\"123\",\"perfilUsuario\":\"PACIENTE\"}}}";
        Assert.assertTrue(Consulta.validarConsultaJson(consultaTest));

    }

    @Test
    public void testValidarConsultaJsonFormatoInvalido() {

        String consultaTest = "\"id\":0,\"especialidade\":\"GERAL\",\"prioridade\":\"IDOSO\",\"status\":\"AGENDADO\",\"dataSolicitacao\":{\"year\":2017,\"month\":12,\"day\":28},\"dataAgendamento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"paciente\":{\"id\":0,\"nome\":\"Paciente Test\",\"cartaoSus\":\"0001\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto Teste\","
                + "\"endereco\":{\"id\":0,\"numero\":\"007\",\"logradouro\":\"Rua Aqui\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"t\",\"senha\":\"123\",\"perfilUsuario\":\"PACIENTE\"}}}";
        Assert.assertFalse(Consulta.validarConsultaJson(consultaTest));

    }

    @Test
    public void testValidarConsultaJsonCampoEspecialidadeInvalido() {
        String consultaTest = "{\"id\":0,\"especialidad\":\"GERAL\",\"prioridade\":\"IDOSO\",\"status\":\"AGENDADO\",\"dataSolicitacao\":{\"year\":2017,\"month\":12,\"day\":28},\"dataAgendamento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"paciente\":{\"id\":0,\"nome\":\"Paciente Test\",\"cartaoSus\":\"0001\",\"dataNascimento\":{\"year\":2017,\"month\":12,\"day\":28},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"Posto Teste\","
                + "\"endereco\":{\"id\":0,\"numero\":\"007\",\"logradouro\":\"Rua Aqui\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Centro\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"t\",\"senha\":\"123\",\"perfilUsuario\":\"PACIENTE\"}}}";
        Assert.assertFalse(Consulta.validarConsultaJson(consultaTest));

    }

}
