/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.DAO.hibernate.BairroHibernate;
import model.POJO.Bairro;
import org.hibernate.Session;

/**
 *
 * @author herik
 */
public class NewClass {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(new Bairro("laaa"));
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar Bairro. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }
}
