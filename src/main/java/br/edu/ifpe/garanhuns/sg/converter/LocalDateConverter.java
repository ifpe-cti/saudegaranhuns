/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author fernando
 */
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        try {
            if (string != null && !string.isEmpty()) {
                return LocalDate.parse(string, DateTimeFormatter.ofPattern(("dd/MM/yyyy")));
            }
        } catch (Exception e) {
            System.err.println("Falha ao fazer conversão de String para LocalDate. Erro: " + e);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if (value != null) {
                return ((LocalDate) value).format(DateTimeFormatter.ofPattern(("dd/MM/yyyy")));
            }
        } catch (Exception e) {
            System.err.println("Falha ao fazer conversão de LocalDate para String. Erro: " + e);
        }
        return null;
    }

}
