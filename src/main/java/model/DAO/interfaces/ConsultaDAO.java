/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.interfaces;

import java.util.List;
import model.POJO.Consulta;
import model.POJO.Paciente;

/**
 *
 * @author Hérikles
 */
public interface ConsultaDAO extends DAO<Consulta> {
    List<Consulta> recuperarConsultasPorPaciente(Paciente c);

}
