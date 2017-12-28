/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Hérikles
 */
public class ConsultaTest {

    private static ConsultaHibernate cH;
    private static CenarioBanco cB;

    public ConsultaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws SQLException {
        cH = new ConsultaHibernate();
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
    public void deveRetornarTodasDatasPosto1() {
        PostoSaude p = new PostoSaudeHibernate().recuperar(1);
        List<LocalDate> datas = cH.agendamentoAutomaticoConsulta(p, Especialidade.GERAL);

        assertThat(datas, hasItems(LocalDate.of(2018, 1, 5), LocalDate.of(2018, 1, 12), LocalDate.of(2018, 1, 19), LocalDate.of(2018, 1, 26), LocalDate.of(2018, 2, 2), LocalDate.of(2018, 2, 9), LocalDate.of(2018, 2, 16), LocalDate.of(2018, 2, 23)));

    }

    @Ignore
    @Test
    public void deveRetornarTodasDatasPosto2() {
        PostoSaude p = new PostoSaudeHibernate().recuperar(2);
        List<LocalDate> datas = cH.agendamentoAutomaticoConsulta(p, Especialidade.GERAL);

        assertThat(datas, hasItems(LocalDate.of(2018,1,2), LocalDate.of(2018,1,9), LocalDate.of(2018,1,16), LocalDate.of(2018,1,23), LocalDate.of(2018,1,30), LocalDate.of(2018,2,6), LocalDate.of(2018,2,13), LocalDate.of(2018,2,20), LocalDate.of(2018,1,1), LocalDate.of(2018,1,8) , LocalDate.of(2018,1,15), LocalDate.of(2018,1,22), LocalDate.of(2018,1,29), LocalDate.of(2018,2,5), LocalDate.of(2018,2,12), LocalDate.of(2018,2,19)));
      

    }

}
