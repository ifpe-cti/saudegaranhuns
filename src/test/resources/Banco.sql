/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hérikles
 * Created: 27/12/2017
 */

DELETE FROM HorarioAtendimento;
DELETE FROM Atendimento;
DELETE FROM Consulta;
DELETE FROM Paciente;
DELETE FROM Usuario;
DELETE FROM PostoSaude;
DELETE FROM Endereco;
DELETE FROM BAIRRO;

INSERT INTO Bairro VALUES (1,"Bairro1");

INSERT INTO Bairro VALUES (1,"COHAB 6");
INSERT INTO Endereco VALUES (1 ,"0", "Rua do cão 2", 1);
INSERT INTO PostoSaude VALUES(1, "Casa de deus", 1);
INSERT INTO Atendimento VALUES(1, 1, 1);
INSERT INTO HorarioAtendimento VALUES (1,1, "08:00", "12:00", 10, 1);

