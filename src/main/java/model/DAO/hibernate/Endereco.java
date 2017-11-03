/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.hibernate;

import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;


/**
 *
 * @author herik
 */
public class Endereco implements model.DAO.interfaces.Endereco{

    @Override
    public void insert(model.DAO.interfaces.Endereco o) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.save(o);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao salvar. Erro: " + e.toString());
        } finally {
            session.close();
        }
    }

    @Override
    public void update(model.DAO.interfaces.Endereco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(model.DAO.interfaces.Endereco o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public model.DAO.interfaces.Endereco read(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<model.DAO.interfaces.Endereco> recuperarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
