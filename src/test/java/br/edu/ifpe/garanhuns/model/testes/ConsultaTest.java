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
    private static SGBD sg;
    
    public ConsultaTest() {
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
        sg.query("DELETE FROM HorarioAtendimento");
        sg.query("DELETE FROM Atendimento");
        sg.query("DELETE FROM PostoSaude");
        sg.query("DELETE FROM Endereco");
        sg.query("DELETE FROM BAIRRO");
        sg.query("DELETE FROM Consulta");
        sg.query("DELETE FROM Paciente");
        sg.query("DELETE FROM Usuario");
        
        sg.query("INSERT INTO Bairro VALUES (1,\"COHAB 6\")");
        sg.query("INSERT INTO Endereco VALUES (1 ,\"0\", \"Rua do cão 2\", 1);");
        sg.query("INSERT INTO PostoSaude VALUES(1, \"Casa de deus\", 1)");
        sg.query("INSERT INTO Atendimento VALUES(1, 1, 1)");
        sg.query("INSERT INTO HorarioAtendimento VALUES (1,1, \"08:00\", \"12:00\", 10, 1)");
        
        sg.query("INSERT INTO Bairro VALUES (2,\"COHAB 5\")");
        sg.query("INSERT INTO Endereco VALUES (2, \"0\", \"Rua do cão 3\", 2)");
        sg.query("INSERT INTO PostoSaude VALUES (2,\"Casa de deus2\", 2)");
        sg.query("INSERT INTO Atendimento VALUES (2,0, 2);");
        sg.query("INSERT INTO HorarioAtendimento VALUES (2 ,2, \"08:00\", \"12:00\", 10, 2)");
        
        sg.query("INSERT INTO Atendimento VALUES (3, 0, 1)");
        sg.query("INSERT INTO HorarioAtendimento VALUES (3, 5, \"01:00\", \"12:00\", 10, 3)");
        
        sg.query("INSERT INTO Atendimento VALUES (4,0, 2)");
        sg.query("INSERT INTO HorarioAtendimento VALUES (4, 1, \"03:00\", \"12:00\", 10, 4)");
        
        sg.query("INSERT INTO Atendimento VALUES (5,0, 1)");
        sg.query("INSERT INTO HorarioAtendimento VALUES (5 ,5, \"07:00\", \"13:00\", 10, 5)");
        
        sg.query("INSERT INTO Atendimento VALUES (6, 0, 2)");
        sg.query("INSERT INTO HorarioAtendimento VALUES (6, 2, \"18:00\", \"19:00\", 10, 6)");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        sg.query("INSERT INTO Usuario VALUES(1, \"a123\", 2,\"123\");");
        sg.query("INSERT INTO Paciente VALUES(1, \"123\",\"1995-06-01\",\"João\", 1, 1);");
        
        sg.query("INSERT INTO Consulta VALUES (1, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (2, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (3, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (4, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (5, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (6, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (7, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (8, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (9, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (10, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (11, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        sg.query("INSERT INTO Consulta VALUES (12, "+LocalDate.now()+","+LocalDate.now().plusDays(0)+", 0, 0, 1,  1)");
        
        
        
    }
    
    @After
    public void tearDown() throws SQLException {
        /*sg.query("DELETE FROM HorarioAtendimento");
        sg.query("DELETE FROM Atendimento");
        sg.query("DELETE FROM PostoSaude");
        sg.query("DELETE FROM Endereco");
        sg.query("DELETE FROM BAIRRO");
        sg.query("DELETE FROM Consulta");
        sg.query("DELETE FROM Paciente");
        sg.query("DELETE FROM Usuario");*/
    }
    @Test
    public void test(){
        System.out.println("dsf");
    }

    
}
