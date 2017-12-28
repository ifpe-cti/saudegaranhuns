/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author herik
 */
public class SGBD {

    private Connection con  = new ConnectionFactory().getConnection();

    public void query(String sql) throws SQLException  {
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        stmt.close();

    }
    

}
