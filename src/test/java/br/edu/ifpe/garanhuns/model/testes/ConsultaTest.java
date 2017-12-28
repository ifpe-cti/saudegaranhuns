/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.sg.model.Atendimento;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.CenarioBanco;
import br.edu.ifpe.garanhuns.sg.model.DiasSemana;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
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
    public void deveRetornarDatasAtomaticamentePorPostoEspecialidade() {
        PostoSaude p = new PostoSaudeHibernate().recuperar(1);
        List<LocalDate> test = cH.agendamentoAutomaticoConsulta(p, Especialidade.GERAL);

        for (LocalDate ob : test) {
            System.out.println("dsf" + ob);
        }
        System.out.println("dsf" + new HorarioAtendimentoHibernate().recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(p, Especialidade.GERAL));
    }
    @Test
    public void deve() {
        new HorarioAtendimentoHibernate().inserir(new HorarioAtendimento(DiasSemana.SEGUNDA, "07:00", "17:00", 20, new Atendimento(Especialidade.GERAL, new PostoSaude("PostoTeste", new Endereco("0", "lsls", new Bairro("deusa"))))));
        new HorarioAtendimentoHibernate().inserir(new HorarioAtendimento(DiasSemana.SEGUNDA, "07:00", "17:00", 20, new Atendimento(Especialidade.GERAL, new PostoSaude("PostoTeste", new Endereco("0", "lsls", new Bairro("deusa"))))));
    }
    

}
