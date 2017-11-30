/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.converter;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.ConsultaHibernate;
import br.edu.ifpe.garanhuns.sg.model.Consulta;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fernando
 */
@FacesConverter("consultaConverter")
public class ConsultaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (string != null && !string.isEmpty()) {
                ConsultaHibernate hibernate = new ConsultaHibernate();
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
            return String.valueOf(((Consulta) o).getId());
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

}
