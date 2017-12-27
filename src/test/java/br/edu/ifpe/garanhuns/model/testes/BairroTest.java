/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.model.JDBC.SGBD;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.BairroHibernate;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Herikles
 */
public class BairroTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private static BairroHibernate bH;
    private static SGBD sg;

    public BairroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        bH = new BairroHibernate();
        sg = new SGBD();

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws SQLException {
        sg.query("DELETE FROM Bairro");
        sg.query("INSERT INTO Bairro VALUES (1,\"Bairro1\")");
        sg.query("INSERT INTO Bairro VALUES (2,\"Bairro2\")");
    }

    @After
    public void tearDown() throws SQLException {
        sg.query("DELETE FROM Bairro");
    }

    @Test
    public void deveRetornarBairroPorId() throws SQLException {
        Bairro bairro = bH.recuperar(1);
        Bairro b = new Bairro("Bairro1");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }
    
    @Test
    public void deveRetornarBairroPorNome(){
        Bairro bairro = bH.recuperarPorNome("Bairro2");
        Bairro b = new Bairro("Bairro2");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }
    
    @Test
    public void deveInserirBairro(){
        Bairro b = new Bairro("Test1");
        bH.inserir(b);
        Assert.assertEquals(bH.recuperarPorNome("Test1").getNome(), b.getNome());
    }
    
 @Test
    public void deveDeletarBairro(){
        Bairro b = new Bairro("Test1");
        bH.deletar(bH.recuperarPorNome("Test1"));
        Assert.assertNull(bH.recuperarPorNome("Test1"));
    }
}
