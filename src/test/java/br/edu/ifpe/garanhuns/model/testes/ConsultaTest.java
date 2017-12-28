/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.HorarioAtendimentoHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        cB.limparBancoTest();
    }

    @Before
    public void setUp() throws SQLException {
    }

    @After
    public void tearDown() throws SQLException {
    }

    @Test
    public void test() {
        PostoSaude p = new PostoSaudeHibernate().recuperar(1);
        List<LocalDate> test = cH.agendamentoAutomaticoConsulta(p, Especialidade.GERAL);

        for (LocalDate ob : test) {
            System.out.println("dsf" + ob);
        }
        System.out.println("dsf" + new HorarioAtendimentoHibernate().recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(p, Especialidade.GERAL));
    }

}
