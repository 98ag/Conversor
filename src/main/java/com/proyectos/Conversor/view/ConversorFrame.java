package com.proyectos.Conversor.view;

import com.proyectos.Conversor.controller.MonedaController;
import com.proyectos.Conversor.modelo.Conversor;
import com.proyectos.Conversor.modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.lang.Double.parseDouble;

public class ConversorFrame extends JFrame {
    private JLabel labelEntrada1, labelEntrada2, labelResultado;
    private JComboBox<Moneda> comboMoneda;
    private JButton botonConvertir, botonInvertir;

    private JTextField fieldCantidad, fieldResultado;
    private MonedaController monedaController;
    private boolean condicion;
    private Container container;

    public ConversorFrame() {
        super("Conversor");

        this.monedaController = new MonedaController();
        this.condicion = true;

        setSize(500, 185);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        container = getContentPane();

        crearItems();
        configurarLayout();
    }

    private void crearItems() {
        labelEntrada1 = new JLabel();
        labelEntrada2 = new JLabel();
        labelResultado = new JLabel();
        comboMoneda = new JComboBox<>();
        botonConvertir = new JButton("Convertir");
        botonInvertir = new JButton("Invertir");
        fieldCantidad = new JTextField(20);
        // Checkeo de tecla presionada (numeros 0-9, . (punto), (espacio), (flechas izq y der))
        fieldCantidad.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
                if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9'
                        || key.getKeyCode() == KeyEvent.VK_BACK_SPACE
                        || key.getKeyCode() == KeyEvent.VK_LEFT
                        || key.getKeyCode() == KeyEvent.VK_RIGHT
                        || key.getKeyChar() == '.') {
                    fieldCantidad.setEditable(true);
                } else {
                    fieldCantidad.setEditable(false);
                }
            }
        });
        fieldResultado = new JTextField(20);

        configurarBotonConvertir();
        configurarBotonInvertir();
        configurarComboBox();

        container.add(labelEntrada1);
        container.add(labelEntrada2);
        container.add(fieldCantidad);
        container.add(fieldResultado);
        container.add(botonConvertir);
        container.add(botonInvertir);
        container.add(labelResultado);
        container.add(comboMoneda);
    }

    private void configurarBotonInvertir() {
        botonInvertir.addActionListener(actionEvent -> {
            condicion = !condicion;
            configurarLayout();
        });

    }

    private void configurarLayout() {
        configurarLabel(labelEntrada1, "Convertir", 30, 30, 200, 15);
        fieldResultado.setBounds(130, 73, 200, 30);
        fieldResultado.setEditable(false);
        configurarLabel(labelResultado, "Resultado: ", 30, 80, 200, 15);
        botonConvertir.setBounds(380, 22, 100, 65);
        botonInvertir.setBounds(380, 90, 100, 30);

        if (condicion) {
            configurarLabel(labelEntrada2, "ARS a ", 210, 30, 200, 15);
            fieldCantidad.setBounds(100, 23, 100, 30);
            comboMoneda.setBounds(265, 22, 100, 30);
        } else {
            configurarLabel(labelEntrada2, "a ARS ", 320, 30, 200, 15);
            fieldCantidad.setBounds(100, 23, 100, 30);
            comboMoneda.setBounds(210, 22, 100, 30);
        }
        setVisible(true);
    }

    private void configurarComboBox() {
        var monedas = this.monedaController.listar();
        monedas.forEach(moneda -> comboMoneda.addItem(moneda));
    }

    private void configurarLabel(JLabel label, String text, int x, int y, int width, int height) {
        label.setText(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.BLACK);
    }

    private void configurarBotonConvertir() {
        botonConvertir.addActionListener(actionEvent -> {
            if (!(fieldCantidad.getText().isEmpty())) {
                if (this.condicion) {
                    fieldResultado.setText(
                            Conversor.convertirPesoAMoneda(
                                    (Moneda) comboMoneda.getSelectedItem(),
                                    parseDouble(fieldCantidad.getText())));
                } else {
                    fieldResultado.setText(
                            Conversor.convertirMonedaAPeso(
                                    (Moneda) comboMoneda.getSelectedItem(),
                                    parseDouble(fieldCantidad.getText())));
                }
            }
        });
    }

}

