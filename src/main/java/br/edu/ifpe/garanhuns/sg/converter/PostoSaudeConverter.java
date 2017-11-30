/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.converter;

import br.edu.ifpe.garanhuns.sg.model.dao.hibernate.PostoSaudeHibernate;
import br.edu.ifpe.garanhuns.sg.model.PostoSaude;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author 20161D13GR0155
 */
@FacesConverter("postoSaudeConverter")
public class PostoSaudeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            if (string != null && !string.isEmpty()) {
                PostoSaudeHibernate hibernate = new PostoSaudeHibernate();
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
                return String.valueOf(((PostoSaude) o).getId());
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }

}
