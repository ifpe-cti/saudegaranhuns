/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.model.JDBC.SGBD;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.BairroHibernate;
import java.sql.SQLException;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author herik
 */
public class ConsultaTest {
    
    private static BairroHibernate bH;
    private static CenarioBanco cB;
    
    public ConsultaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        bH = new BairroHibernate();
        cB = new CenarioBanco();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException{
        cB.iniciarBancoTest();
    }
    
    @After
    public void tearDown() throws SQLException {
       cB.limparBanco();
    }
    @Test
    public void test(){
        System.out.println("dsf");
    }

    
}
