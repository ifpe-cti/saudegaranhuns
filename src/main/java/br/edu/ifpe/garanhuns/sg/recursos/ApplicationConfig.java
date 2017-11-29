/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.sg.recursos;

import java.util.Set;
import java.util.logging.Logger;
import javax.ws.rs.core.Application;

/**
 *
 * @author Jose Junio
 */
@javax.ws.rs.ApplicationPath("psf")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.edu.ifpe.garanhuns.sg.recursos.ConsultasResource.class);
        resources.add(br.edu.ifpe.garanhuns.sg.recursos.PacientesResource.class);
        resources.add(br.edu.ifpe.garanhuns.sg.recursos.PostosResource.class);
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);
    }
}
