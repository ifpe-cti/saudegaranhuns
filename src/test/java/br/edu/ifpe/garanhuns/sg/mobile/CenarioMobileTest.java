/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.mobile;

import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.Atendimento;
import br.edu.ifpe.garanhuns.sg.model.Bairro;
import br.edu.ifpe.garanhuns.sg.model.Endereco;
import br.edu.ifpe.garanhuns.sg.model.HorarioAtendimento;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import br.edu.ifpe.garanhuns.sg.model.Usuario;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.AtendenteHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.HorarioAtendimentoHibernate;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.enumarador.DiasSemana;
import br.edu.ifpe.garanhuns.sg.model.enumarador.Especialidade;
import br.edu.ifpe.garanhuns.sg.model.enumarador.PerfilUsuario;
import java.time.LocalDate;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Jose Junio
 */
public class CenarioMobileTest {

    @Test
    public void testIniciarUsoMobile() {
        Bairro bairro = new Bairro("Centro");
        Endereco endereco = new Endereco("007", "Rua Aqui", bairro);
        PostoSaude posto = new PostoSaude("Posto Teste", endereco);
        Atendimento atendimentoGeral = new Atendimento(Especialidade.GERAL, posto);
        Atendimento atendimentoDentista = new Atendimento(Especialidade.DENTISTA, posto);

        HorarioAtendimento horarioAtendimentoGeral = new HorarioAtendimento(DiasSemana.SEGUNDA, "07:00", "17:00", 20, atendimentoGeral);
        HorarioAtendimento horarioAtendimentoDentista = new HorarioAtendimento(DiasSemana.TERÇA, "07:00", "17:00", 20, atendimentoDentista);

        new HorarioAtendimentoHibernate().inserir(horarioAtendimentoGeral);
        new HorarioAtendimentoHibernate().inserir(horarioAtendimentoDentista);
        List<HorarioAtendimento> horarioBDGeral = new HorarioAtendimentoHibernate().
                recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(posto, Especialidade.GERAL);
        List<HorarioAtendimento> horarioBDDentista = new HorarioAtendimentoHibernate().
                recuperarHorarioAtendimentoPorPostoSaudeEspecialidade(posto, Especialidade.DENTISTA);

        new PacienteHibernate().inserir(new Paciente("Teste", "009", LocalDate.now(), posto, new Usuario("teste", "teste", PerfilUsuario.PACIENTE)));
        new AtendenteHibernate().inserir(new Atendente("ADMINSTRADOR", posto, new Usuario("admin", "admin", PerfilUsuario.ADMINISTRADOR)));

        // Assert.assertEquals(1, horarioBDDentista.size());
        // Assert.assertEquals(1, horarioBDGeral.size());
    }

}
