/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.converter;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PacienteHibernate;
import br.edu.ifpe.garanhuns.sg.model.Paciente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fernando
 */
@FacesConverter("pacienteConverter")
public class PacienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (string != null && !string.isEmpty()) {
                PacienteHibernate hibernate = new PacienteHibernate();
                return hibernate.recuperar(Integer.valueOf(string));
            }
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        try {
            if (o != null) {
                return String.valueOf(((Paciente) o).getId());
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

}
