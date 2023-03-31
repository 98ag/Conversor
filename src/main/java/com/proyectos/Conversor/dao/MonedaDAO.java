package com.proyectos.Conversor.dao;

import com.proyectos.Conversor.modelo.Moneda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonedaDAO {
    final private Connection connection;

    public MonedaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Moneda> listar() {
        List<Moneda> ret = new ArrayList<>();

        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "SELECT nombre, peso_a_moneda, moneda_a_peso FROM monedas");

            try (statement) {
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {
                    while (resultSet.next()) {
                        Moneda moneda = new Moneda(
                                resultSet.getString("nombre"),
                                resultSet.getDouble("peso_a_moneda"),
                                resultSet.getDouble("moneda_a_peso")
                        );
                        ret.add(moneda);
                    }
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
        return ret;
    }

}
