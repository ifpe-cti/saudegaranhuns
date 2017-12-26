/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.model.Helper.DbUnitHelper;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.BairroHibernate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Herikles
 */
public class BairroTest {
    
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
        dbUnitHelper.deleteAll("/tabelas/Bairro.xml");
    }
    
    @Test
    public void deveRetornarBairroPorId(){
        Bairro bairro = new BairroHibernate().recuperar(99);
        Bairro b = new Bairro("COHAB 99");
        
        Assert.assertEquals(bairro.getNome(),b.getNome());
    }
}
