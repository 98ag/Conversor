package com.proyectos.Conversor.controller;

import com.proyectos.Conversor.dao.MonedaDAO;
import com.proyectos.Conversor.factory.ConnectionFactory;
import com.proyectos.Conversor.modelo.Moneda;

import java.util.List;

public class MonedaController {
    private MonedaDAO monedaDAO;

    public MonedaController() {
        monedaDAO = new MonedaDAO(new ConnectionFactory().getConexion());
    }

    public List<Moneda> listar() {
        return monedaDAO.listar();
    }
}
