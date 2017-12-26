/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.model.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.operation.TransactionOperation;

/**
 *
 * @author Herikles
 */
public class DbUnitHelper {

    private final Connection connection = ConnectionHelper.getConnection();

    public void cleanInsert(String resourcePath) {
        execute(resourcePath, TransactionOperation.CLEAN_INSERT);
    }

    public void truncateAndInsert(String resourcePath) {
        execute(resourcePath, TransactionOperation.TRUNCATE_TABLE);
        execute(resourcePath, TransactionOperation.INSERT);
    }

    public void insert(String resourcePath) {
        execute(resourcePath, DatabaseOperation.INSERT);
    }

    public void delete(String resourcePath) {
        execute(resourcePath, DatabaseOperation.DELETE);
    }

    public void deleteAll(String resourcePath) {
        execute(resourcePath, DatabaseOperation.DELETE_ALL);
    }

    public void truncate(String resourcePath) {
        execute(resourcePath, DatabaseOperation.TRUNCATE_TABLE);
    }

    private void execute(String resourcePath, DatabaseOperation... operations) {

        try (InputStream resourceAsStream = DbUnitHelper.class.getResourceAsStream(resourcePath)) {
            FlatXmlDataSetBuilder builder
                    = new FlatXmlDataSetBuilder();

            builder.setCaseSensitiveTableNames(true);
            IDataSet dataSet = builder.build(resourceAsStream);

            ReplacementDataSet replacementDataSet = new ReplacementDataSet(dataSet);
            replacementDataSet.addReplacementObject("[null]", null);
            IDatabaseConnection iConnection = new DatabaseConnection(connection);

            for (DatabaseOperation operation : operations) {
                operation.execute(iConnection, replacementDataSet);
            }
        } catch (IOException | SQLException | DatabaseUnitException e) {
            System.err.println("Erro ao executar operação usando DbUnit. Erro: " + e.toString());
        }
    }
}
