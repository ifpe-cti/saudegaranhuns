/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.model.Helper.DbUnitHelper;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.BairroHibernate;
import javax.swing.JOptionPane;
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
    private static DbUnitHelper dbUnitHelper;

    public BairroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        bH = new BairroHibernate();
        dbUnitHelper = new DbUnitHelper();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbUnitHelper.cleanInsert("/tabelas/Bairro.xml");
    }

    @After
    public void tearDown() {
      //  dbUnitHelper.deleteAll("/tabelas/Bairro.xml");
    }

    @Test
    public void deveRetornarBairroPorId() {
        Bairro bairro = bH.recuperar(9);
        Bairro b = new Bairro("COHAB 99");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }
    /*
    @Test
    public void deveRetornarBairroPorNome(){
        Bairro bairro = bH.recuperarPorNome("não sei");
        Bairro b = new Bairro("não sei");
        Assert.assertEquals(bairro.getNome(), b.getNome());
    }
    
    @Test
    public void deveInserirBairro(){
        Bairro b = new Bairro("Test1");
        bH.inserir(b);
        Assert.assertEquals(bH.recuperarPorNome("Test1").getNome(), b.getNome());
    }
    */
    /*@Test
    public void deveDeletarBairro(){
        Bairro b = new Bairro("Test1");
        bH.deletar(bH.recuperarPorNome("Test1"));
        Assert.assertNull(bH.recuperarPorNome("Test1"));
    }*/
}
