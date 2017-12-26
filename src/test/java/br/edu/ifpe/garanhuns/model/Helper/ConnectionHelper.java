/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Herikles
 */
public class ConnectionHelper {
    private ConnectionHelper() {
    }

    public static Connection getConnection() {
        try {
            ResourceBundle banco = ResourceBundle.getBundle("banco");
            Class.forName(banco.getString("jdbc"));
            return DriverManager.getConnection(banco.getString("url"),
                    banco.getString("usuario"),
                    banco.getString("senha"));
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Não foi possivel criar a conexão, usando DbUnit. Erro: " + e.toString());
            return null;
        }
    }
}
