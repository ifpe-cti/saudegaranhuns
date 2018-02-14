/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PerfilUsuario;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import com.google.gson.Gson;
import java.net.URI;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Jose Junio
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PacientesResourceTest {

    /**
     * Test of cadastrarPaciente method, of class PacientesResource.
     */
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    public String gerarPacienteJson() {

        Bairro bairroTeste = new Bairro("Centro");
        Endereco enderecoTeste = new Endereco("001", "Rua", bairroTeste);
        PostoSaude postoTeste = new PostoSaude("Posto Teste", enderecoTeste);
        Usuario usuarioTeste = new Usuario("login", "senha", PerfilUsuario.PACIENTE);
        Paciente pacienteTeste = new Paciente("Paciente Teste", "1234 5678", LocalDate.now(), postoTeste, usuarioTeste);
        return new Gson().toJson(pacienteTeste);
    }

    @Test
    public void testCadastrarPacienteJsonValido() {

        Paciente p = new PacienteHibernate().recuperarPorNome("Paciente Teste");
        RequestEntity request = new RequestEntity(gerarPacienteJson(), HttpMethod.POST, URI.create("http://localhost:" + port + "/pacientes"));
        ResponseEntity response = this.restTemplate.postForEntity("http://localhost:" + port + "/pacientes", request, String.class);
        Assert.assertTrue(response.getStatusCodeValue() == 201);
        new PacienteHibernate().deletar(p);

    }

    @Test
    public void testCadastrarPacienteJsonInvalido() {

        String pacienteJson = "\"id\":0,\"nome\":\"PacienteTeste\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}";

        ResponseEntity response = this.restTemplate.postForEntity(URI.create("http://localhost:" + port + "/pacientes"), pacienteJson, String.class);
        Assert.assertTrue(response.getStatusCodeValue() == 415);
        Paciente p = new PacienteHibernate().recuperarPorNome("PacienteTeste");
        Assert.assertNull(p);
    }

    @Test
    public void testCadastrarPacienteJsonCampoInvalido() {

        String pacienteJson = "{\"id\":0,\"ome\":\"PacienteTeste\",\"cartaoSus\":\"321\",\"dataNascimento\":{\"year\":2010,\"month\":11,\"day\":10},"
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}},"
                + "\"postoSaude\":{\"id\":0,\"nome\":\"asd\","
                + "\"endereco\":{\"id\":0,\"numero\":\"32\",\"logradouro\":\"Rua dos bobos\","
                + "\"bairro\":{\"id\":0,\"nome\":\"Juliana\"}}},"
                + "\"usuario\":{\"id\":0,\"login\":\"login\",\"senha\":\"senha\",\"perfilUsuario\":\"ADMINISTRADOR\"}}";

        RequestEntity request = new RequestEntity(pacienteJson, HttpMethod.POST, URI.create("http://localhost:" + port + "/pacientes"));
        ResponseEntity response = this.restTemplate.postForEntity("http://localhost:" + port + "/pacientes", request, String.class);
        Assert.assertEquals(response.getStatusCodeValue(), 415);
        Paciente p = new PacienteHibernate().recuperarPorNome("PacienteTeste");
        Assert.assertNull(p);
    }

}
