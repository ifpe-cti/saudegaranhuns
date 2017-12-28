/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.testes;

import br.edu.ifpe.garanhuns.model.JDBC.SGBD;
import br.edu.ifpe.garanhuns.sg.model.Atendente;
import br.edu.ifpe.garanhuns.sg.model.DiasSemana;
import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.AtendenteHibernate;
import br.edu.ifpe.garanhuns.sg.util.HibernateUtil;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Hérikles
 */
public class CenarioBanco {

    private final SGBD sgbd;

    public CenarioBanco() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.close();
        sgbd = new SGBD();
    }

    public void iniciarBancoTest() throws SQLException {
        sgbd.query("DELETE FROM HorarioAtendimento");
        sgbd.query("DELETE FROM Atendimento");
        sgbd.query("DELETE FROM Consulta");
        sgbd.query("DELETE FROM Paciente");
        sgbd.query("DELETE FROM Usuario");
        sgbd.query("DELETE FROM PostoSaude");
        sgbd.query("DELETE FROM Endereco");
        sgbd.query("DELETE FROM BAIRRO");

        sgbd.query("INSERT INTO Bairro VALUES (1,\"COHAB 6\")");
        sgbd.query("INSERT INTO Endereco VALUES (1 ,\"0\", \"Rua do cão 2\", 1);");

        sgbd.query("INSERT INTO PostoSaude VALUES(1, \"Casa de deus\", 1)");

        sgbd.query("INSERT INTO Atendimento VALUES(1, 1, 1)");
        sgbd.query("INSERT INTO HorarioAtendimento VALUES (1," + (DiasSemana.SEGUNDA.getValor()-1) + ", \"08:00\", \"12:00\", 10, 1)");

        sgbd.query("INSERT INTO Bairro VALUES (2,\"COHAB 5\")");
        sgbd.query("INSERT INTO Endereco VALUES (2, \"0\", \"Rua do cão 3\", 2)");
        sgbd.query("INSERT INTO PostoSaude VALUES (2,\"Casa de deus2\", 2)");

        sgbd.query("INSERT INTO Atendimento VALUES (2, 0, 2);");
        sgbd.query("INSERT INTO HorarioAtendimento VALUES (2 ," + (DiasSemana.TERÇA.getValor() -1)+ ", \"08:00\", \"12:00\", 10, 2)");

        sgbd.query("INSERT INTO Atendimento VALUES (3, 0, 1)");
        sgbd.query("INSERT INTO HorarioAtendimento VALUES (3," + (DiasSemana.SEXTA.getValor() -1)+ ", \"01:00\", \"12:00\", 10, 3)");

        sgbd.query("INSERT INTO Atendimento VALUES (4,0, 2)");
        sgbd.query("INSERT INTO HorarioAtendimento VALUES (4," + (DiasSemana.SEGUNDA.getValor()-1) + ", \"03:00\", \"12:00\", 10, 4)");

        sgbd.query("INSERT INTO Usuario VALUES(1, \"a123\", 2,\"123\");");
        sgbd.query("INSERT INTO Paciente VALUES(1, \"123\",\"1995-06-01\",\"João\", 1, 1);");
        
         sgbd.query("INSERT INTO Usuario VALUES(99, \"admin\", 0,\"admin\");");

        LocalDate ds = LocalDate.now();
        List<LocalDate> diasSemana = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            LocalDate daAux = LocalDate.now().plusDays(i);
            if (daAux.getDayOfWeek().getValue() == 1 || daAux.getDayOfWeek().getValue() == 2 || daAux.getDayOfWeek().getValue() == 5) {
                diasSemana.add(daAux);
            }
        }
        int i = 1;
        for (; i <= 10; i++) {
            LocalDate daAux = diasSemana.get(0).plusDays(0);
            sgbd.query("INSERT INTO Consulta VALUES (" + i + ", \"" + daAux + "\",\"" + ds + "\", 0, 0, 1,  1)");
        }
        for (; i <= 17; i++) {
            LocalDate daAux = diasSemana.get(1).plusDays(0);
            sgbd.query("INSERT INTO Consulta VALUES (" + i + ", \"" + daAux + "\",\"" + ds + "\", 0, 0, 1,  1)");
        }
        for (; i <= 27; i++) {
            LocalDate daAux = diasSemana.get(2).plusDays(0);
            sgbd.query("INSERT INTO Consulta VALUES (" + i + ", \"" + daAux + "\",\"" + ds + "\", 0, 0, 1,  1)");
        }
        
    }

    public void limparBancoTest() throws SQLException {
        sgbd.query("DELETE FROM HorarioAtendimento");
        sgbd.query("DELETE FROM Atendimento");
        sgbd.query("DELETE FROM Consulta");
        sgbd.query("DELETE FROM Paciente");
        sgbd.query("DELETE FROM Usuario");
        sgbd.query("DELETE FROM PostoSaude");
        sgbd.query("DELETE FROM Endereco");
        sgbd.query("DELETE FROM BAIRRO");
    }
}
