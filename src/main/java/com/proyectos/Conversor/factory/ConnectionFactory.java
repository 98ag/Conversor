package com.proyectos.Conversor.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataSource datasource;

    public ConnectionFactory(){
        /*
            Se utiliza una base de datos "conversor" que tiene una table "monedas"
            con los siguientes campos:
                nombre varchar(100)
                peso_a_moneda double
                moneda_a_peso double


            Script SQL para crear la table e insertar datos de prueba:

            CREATE TABLE `monedas` (
                `nombre` varchar(100) NOT NULL,
                `peso_a_moneda` double NOT NULL,
                `moneda_a_peso` double NOT NULL
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

            INSERT INTO `monedas` VALUES    ('USD',0.00478,208.99),
                                            ('EURO',0.0044,227.444),
                                            ('GBP',0.00387,258.583),
                                            ('AUD',0.00714,140.107),
                                            ('CAD',0.00648,154.356);
         */

        var pooledDataSource = new ComboPooledDataSource();
        pooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/conversor?useTimeZone=true&serverTimeZone=UTC-3");
        pooledDataSource.setUser(""); // Usuario de DB
        pooledDataSource.setPassword(""); // Password de DB
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
