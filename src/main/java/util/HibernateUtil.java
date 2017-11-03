/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Herikles
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory () {
          if (sessionFactory == null) {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
          }
        return sessionFactory;  
    }
    
    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
