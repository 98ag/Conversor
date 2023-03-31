package com.proyectos.Conversor.modelo;

public interface Conversor {


    static String convertirPesoAMoneda(Moneda moneda, double cantidad) {
        return String.format("%.2f", cantidad * moneda.getConversionAPeso());
    }

    static String convertirMonedaAPeso(Moneda moneda, double cantidad) {
        return String.format("%.2f", cantidad * moneda.getConversionDePeso());
    }
}
