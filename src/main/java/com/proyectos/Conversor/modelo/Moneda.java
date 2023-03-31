package com.proyectos.Conversor.modelo;

public class Moneda {
    private String nombre;
    private double tasaMonedaAPeso;
    private double tasaPesoAMoneda;

    public Moneda(String nombre, double tasaMonedaAPeso, double tasaPesoAMoneda) {
        this.nombre = nombre;
        this.tasaMonedaAPeso = tasaMonedaAPeso;
        this.tasaPesoAMoneda = tasaPesoAMoneda;
    }

    public double getConversionAPeso() {
        return tasaMonedaAPeso;
    }

    public double getConversionDePeso() {
        return tasaPesoAMoneda;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
