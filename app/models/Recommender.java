package models;

import org.apache.mahout.cf.taste.impl.model.jdbc.PostgreSQLJDBCDataModel;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class Recommender {

    public Recommender() {}

    public PostgreSQLJDBCDataModel getDataModel() {
        try {
            PostgreSQLJDBCDataModel dataModel = new PostgreSQLJDBCDataModel(getDataSource());
            return dataModel;
        } catch (Exception e) {
            return null;
        }
    }

    private DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(5432);
        dataSource.setDatabaseName("SistemasRecomendacion");
        dataSource.setUser("SistemasRecomendacion");
        dataSource.setPassword("Grupo1");
        return dataSource;
    }
}
