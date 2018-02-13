/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Jose Junio
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class PostosResourceTest {

    /**
     * Test of recuperarTodosOsPostos method, of class PostosResource.
     */
    // @Ignore
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int port;

    @Before
    public void removePostos() {
        List<PostoSaude> listPostos = new PostoSaudeHibernate().recuperarTodos();
        if (!(listPostos.isEmpty())) {
            for (int i = 0; i < listPostos.size(); i++) {
                new PostoSaudeHibernate().deletar(
                        new PostoSaudeHibernate().recuperar(
                                listPostos.get(i).getId()));
            }
        }
    }

    //@Ignore
    @Test

    public void testRecuperarTodosOsPostos() {

        new PostoSaudeHibernate().inserir(
                new PostoSaude("PSF",
                        new Endereco("123", "Rua",
                                new Bairro("Centro")
                        )
                )
        );

        ResponseEntity response = this.restTemplate.getForEntity(URI.create("http://localhost:" + port + "/postos"), String.class);
        Assert.assertTrue(response.getStatusCodeValue() == 200);
        String conteudo = (String) response.getBody();
        Gson gson = new Gson();
        Type postosListType
                = new TypeToken<ArrayList<PostoSaude>>() {
                }.getType();
        List<PostoSaude> listaPostos = gson.fromJson(conteudo, postosListType);
        Assert.assertTrue(listaPostos.size() == 1);

    }

    //@Ignore
    @Test
    public void testRecuperarListaDePostosVazia() {

        ResponseEntity response = this.restTemplate.getForEntity(URI.create("http://localhost:" + port + "/postos"), String.class);
        Assert.assertEquals(204, response.getStatusCodeValue());
        Assert.assertNull(response.getBody());

    }

}
