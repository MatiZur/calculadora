package gui;

import javax.swing.*;
import java.awt.*;
import operaciones.Operaciones;

public class VentanaVectores extends JFrame {

    private JTextField tamañoField;
    private JTextField escalarField;

    private JPanel panelVectorA, panelVectorB;
    private JTextArea resultadoArea;
    private JTextField[] camposA, camposB;

    private float[] ans = null;
    private float resultadoNum;

    public VentanaVectores() {
        setTitle("La Calcularda - Vectores");
        setSize(750, 375);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblTamaño = new JLabel("Tamaño de ambos vectores:");
        lblTamaño.setBounds(25, 10, 180, 25);
        getContentPane().add(lblTamaño);

        tamañoField = new JTextField("3");
        tamañoField.setBounds(200, 10, 40, 25);
        getContentPane().add(tamañoField);

        JLabel lblEscalar = new JLabel("Escalar:");
        lblEscalar.setBounds(260, 10, 60, 25);
        getContentPane().add(lblEscalar);

        escalarField = new JTextField();
        escalarField.setBounds(320, 10, 40, 25);
        getContentPane().add(escalarField);

        JButton generarBtn = new JButton("Generar");
        generarBtn.setBounds(380, 10, 90, 25);
        getContentPane().add(generarBtn);

        JButton borrarBtn = new JButton("Borrar");
        borrarBtn.setBounds(480, 10, 100, 25);
        getContentPane().add(borrarBtn);

        JButton ansBtn = new JButton("Ans");
        ansBtn.setBounds(590, 10, 60, 25);
        getContentPane().add(ansBtn);

        panelVectorA = new JPanel();
        panelVectorA.setBorder(BorderFactory.createTitledBorder("Vector A"));
        panelVectorA.setBounds(10, 50, 710, 60);
        panelVectorA.setLayout(new FlowLayout(FlowLayout.LEFT));
        getContentPane().add(panelVectorA);

        panelVectorB = new JPanel();
        panelVectorB.setBorder(BorderFactory.createTitledBorder("Vector B"));
        panelVectorB.setBounds(10, 120, 710, 60);
        panelVectorB.setLayout(new FlowLayout(FlowLayout.LEFT));
        getContentPane().add(panelVectorB);

        JPanel panelBotones = new JPanel();
        panelBotones.setBounds(10, 190, 710, 40);
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        getContentPane().add(panelBotones);

        JButton sumarBtn = new JButton("Suma");
        JButton restarBtn = new JButton("Resta");
        JButton multiplicarEscalarBtn = new JButton("Multiplicar por escalar (A)");
        JButton productoEscalarBtn = new JButton("Producto escalar");
        JButton productoVectorialBtn = new JButton("Producto vectorial");

        panelBotones.add(sumarBtn);
        panelBotones.add(restarBtn);
        panelBotones.add(multiplicarEscalarBtn);
        panelBotones.add(productoEscalarBtn);
        panelBotones.add(productoVectorialBtn);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultadoArea);
        scroll.setBounds(10, 240, 710, 80);
        getContentPane().add(scroll);

        generarBtn.addActionListener(e -> generarCampos());
        borrarBtn.addActionListener(e -> borrarCampos());
        ansBtn.addActionListener(e -> cargarAns());

        sumarBtn.addActionListener(e -> sumar());
        restarBtn.addActionListener(e -> restar());
        multiplicarEscalarBtn.addActionListener(e -> multiplicarPorEscalar());
        productoEscalarBtn.addActionListener(e -> productoEscalar());
        productoVectorialBtn.addActionListener(e -> productoVectorial());
    }

    private void generarCampos() {
        try {
            int tamaño = Integer.parseInt(tamañoField.getText());

            if (tamaño <= 0) {
                mostrarError("El tamaño debe ser mayor que cero.");
                return;
            }
            
            if (tamaño > 13) {
                mostrarError("El tamaño máximo permitido es 13.");
                return;
            }

            panelVectorA.removeAll();
            panelVectorB.removeAll();

            camposA = new JTextField[tamaño];
            camposB = new JTextField[tamaño];

            for (int i = 0; i < tamaño; i++) {
                camposA[i] = new JTextField(4);
                panelVectorA.add(camposA[i]);
            }
            for (int i = 0; i < tamaño; i++) {
                camposB[i] = new JTextField(4);
                panelVectorB.add(camposB[i]);
            }

            panelVectorA.revalidate();
            panelVectorB.revalidate();
            panelVectorA.repaint();
            panelVectorB.repaint();

        } catch (NumberFormatException e) {
            mostrarError("Ingrese un número válido para el tamaño.");
        }
    }

    private void borrarCampos() {
        tamañoField.setText(null);
        escalarField.setText(null);
        resultadoArea.setText(null);
        panelVectorA.removeAll();
        panelVectorB.removeAll();
        panelVectorA.repaint();
        panelVectorB.repaint();
        ans = null;
    }

    private void cargarAns() {
        if (ans == null) return;
        int tamaño = ans.length;
        tamañoField.setText(String.valueOf(tamaño));

        panelVectorA.removeAll();
        panelVectorB.removeAll();

        camposA = new JTextField[tamaño];
        camposB = new JTextField[tamaño];

        for (int i = 0; i < tamaño; i++) {
            camposA[i] = new JTextField(4);
            String valStr = String.format("%.2f", ans[i]).replace(',', '.');
            camposA[i].setText(valStr);
            panelVectorA.add(camposA[i]);
        }
        for (int i = 0; i < tamaño; i++) {
            camposB[i] = new JTextField(4);
            panelVectorB.add(camposB[i]);
        }

        panelVectorA.revalidate();
        panelVectorB.revalidate();
        panelVectorA.repaint();
        panelVectorB.repaint();
    }

    private float[][] leerVectores() {
        try {
            int tamaño = camposA.length;
            float[] a = new float[tamaño];
            float[] b = new float[tamaño];
            for (int i = 0; i < tamaño; i++) {
                String textA = camposA[i].getText().replace(',', '.');
                String textB = camposB[i].getText().replace(',', '.');
                a[i] = Float.parseFloat(textA);
                b[i] = Float.parseFloat(textB);
            }
            return new float[][] { a, b };
        } catch (Exception e) {
            mostrarError("Error leyendo vectores. Asegurate de ingresar sólo números válidos.");
            return null;
        }
    }

    private void mostrarVector(float[] vector) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < vector.length; i++) {
            sb.append(String.format("%.2f", vector[i]));
            if (i < vector.length - 1) sb.append(" ; ");
        }
        sb.append(" ]");
        resultadoArea.setText(sb.toString());
    }

    private void mostrarError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void sumar() {
        float[][] vectores = leerVectores();
        if (vectores == null) return;
        int tamaño = camposA.length;
        float[] a = vectores[0];
        float[] b = vectores[1];
        if (a.length != b.length) {
            mostrarError("Los vectores deben tener el mismo tamaño para sumar.");
            return;
        }
        ans = Operaciones.sumaVectores(a, b, tamaño);
        mostrarVector(ans);
    }

    private void restar() {
        float[][] vectores = leerVectores();
        if (vectores == null) return;
        int tamaño = camposA.length;
        float[] a = vectores[0];
        float[] b = vectores[1];
        if (a.length != b.length) {
            mostrarError("Los vectores deben tener el mismo tamaño para restar.");
            return;
        }
        ans = Operaciones.restaVectores(a, b, tamaño);
        mostrarVector(ans);
    }

    private void multiplicarPorEscalar() {
        float[][] vectores = leerVectores();
        if (vectores == null) return;
        int tamaño = camposA.length;
        float[] a = vectores[0];
        String escalarStr = escalarField.getText();
        if (escalarStr.isEmpty()) {
            mostrarError("Ingresá un valor para el escalar.");
            return;
        }
        try {
            float escalar = Float.parseFloat(escalarStr.replace(',', '.'));
            ans = Operaciones.multiEscalar(a, tamaño, escalar);
            mostrarVector(ans);
        } catch (NumberFormatException ex) {
            mostrarError("Escalar inválido.");
        }
    }

    private void productoEscalar() {
        float[][] vectores = leerVectores();
        if (vectores == null) return;
        int tamaño = camposA.length;
        float[] a = vectores[0];
        float[] b = vectores[1];
        if (a.length != b.length) {
            mostrarError("Los vectores deben tener el mismo tamaño para el producto escalar.");
            return;
        }
        resultadoNum = Operaciones.productoEscalar(a, b, tamaño);
        resultadoArea.setText(String.format("%.2f", resultadoNum));
    }

    private void productoVectorial() {
        float[][] vectores = leerVectores();
        if (vectores == null) return;
        float[] a = vectores[0];
        float[] b = vectores[1];
        if (a.length != 3 || b.length != 3) {
            mostrarError("El producto vectorial sólo está definido para vectores de tamaño 3.");
            return;
        }
        ans = Operaciones.productoVectorial(a, b);
        mostrarVector(ans);
    }
}