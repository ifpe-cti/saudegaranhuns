/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import java.net.URI;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jose Junio
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PacientesResourceTest.class)
public class PacientesResourceTest {

    /**
     * Test of cadastrarPaciente method, of class PacientesResource.
     */
    @Ignore
    @Test
    public void testCadastrarPacienteJsonValido() {

        Paciente paciente = new PacienteHibernate().recuperarPorNome("Teste");
        Assert.assertNull(paciente);
        String pacienteJson = "{\"id\":0,\"nome\":\"Teste\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity(URI.create("http://localhost:8080/pacientes"), pacienteJson, String.class);
        Assert.assertTrue(response.getStatusCodeValue() == 201);
        Paciente p = new PacienteHibernate().recuperarPorNome("Teste");
        Assert.assertEquals("Teste", p.getNome());
        new PacienteHibernate().deletar(p);
    }

    @Ignore
    @Test
    public void testCadastrarPacienteJsonInvalido() {
        String pacienteJson = "\"id\":0,\"nome\":\"Teste\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("===========================AQUII==================");
        ResponseEntity response = restTemplate.postForEntity(URI.create("http://localhost:8080/pacientes"), pacienteJson, String.class);
        System.out.println("===============outro========================================");
        System.out.println(response.getStatusCodeValue());
        Assert.assertTrue(response.getStatusCodeValue() == 415);
        Paciente p = new PacienteHibernate().recuperarPorNome("Teste");
        Assert.assertNull(p);
    }

    @Ignore
    @Test
    public void testCadastrarPacienteJsonCampoInvalido() {
        String pacienteJson = "{\"id\":0,\"ome\":\"Teste\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}";

        RestTemplate restTemplate = new RestTemplate();
        RequestEntity request = new RequestEntity(HttpMethod.POST, URI.create("http://localhost:8080/pacientes"));
        ResponseEntity response = restTemplate.postForEntity("http://localhost:8080/pacientes", request, String.class);
        Assert.assertEquals(response.getStatusCodeValue(), 415);
        Paciente p = new PacienteHibernate().recuperarPorNome("Teste");
        Assert.assertNull(p);
    }

}
