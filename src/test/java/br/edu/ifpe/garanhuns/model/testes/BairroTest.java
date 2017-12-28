/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.BairroHibernate;
import java.sql.SQLException;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Herikles
 */
public class BairroTest {

    private static BairroHibernate bH;
    private static CenarioBanco cB;

    public BairroTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        bH = new BairroHibernate();
        cB = new CenarioBanco();
        cB.iniciarBancoTest();
    }

    @AfterClass
    public static void tearDownClass() throws SQLException {
    }

    @Before
    public void setUp() throws SQLException {
    }

    @After
    public void tearDown() throws SQLException {

    }
    
    
    @Ignore
    @Test
    public void deveRetornarBairroPorId() throws SQLException {
        Bairro bairro = bH.recuperar(1);
        Bairro b = new Bairro("COHAB 6");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }

    @Ignore
    @Test
    public void deveRetornarBairroPorNome() {
        Bairro bairro = bH.recuperarPorNome("COHAB 5");
        Bairro b = new Bairro("COHAB 5");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }

    @Ignore
    @Test
    public void deveRetornarTodosBairro() {
        List<Bairro> bairros = bH.recuperarTodos();
        assertThat(bairros, hasItems(new Bairro(1, "COHAB 6"), new Bairro(2, "COHAB 5")));
    }

    @Ignore
    @Test
    public void deveInserirBairro() {
        Bairro b = new Bairro("Test1");
        bH.inserir(b);
        Assert.assertEquals(bH.recuperarPorNome("Test1").getNome(), b.getNome());
    }

    @Ignore
    @Test
    public void deveDeletarBairro() {
        Bairro b = new Bairro("Test1");
        bH.deletar(bH.recuperarPorNome("Test1"));
        Assert.assertNull(bH.recuperarPorNome("Test1"));
    }
}
