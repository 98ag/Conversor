package com.proyectos.Conversor.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataSource datasource;

    public ConnectionFactory(){
        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mariadb://localhost:3306/conversor?useTimeZone=true&serverTimeZone=UTC-3");
        pooledDataSource.setUser("admin");
        pooledDataSource.setPassword("admin1234");
        pooledDataSource.setMaxPoolSize(10);

        this.datasource = pooledDataSource;
    }

    public Connection getConexion(){
        try{
            return this.datasource.getConnection();
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}
