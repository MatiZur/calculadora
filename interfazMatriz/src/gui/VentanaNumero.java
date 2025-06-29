package gui;

import javax.swing.*;

public class VentanaNumero extends JFrame {
    private JTextField textN1;
    private JTextField textN2;
    private JTextField textPR;
    private JTextField textExpo;
    private JTextArea textRes;

    public VentanaNumero() {
        setTitle("Calculadora");
        setSize(550, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblN1 = new JLabel("Numero 1:");
        lblN1.setBounds(10, 15, 70, 14);
        add(lblN1);

        textN1 = new JTextField();
        textN1.setBounds(80, 11, 100, 23);
        add(textN1);

        JLabel lblN2 = new JLabel("Numero 2:");
        lblN2.setBounds(10, 49, 70, 14);
        add(lblN2);

        textN2 = new JTextField();
        textN2.setBounds(80, 45, 100, 23);
        add(textN2);

        JLabel lblPotenciaRaiz = new JLabel("Base:");
        lblPotenciaRaiz.setBounds(10, 132, 70, 14);
        add(lblPotenciaRaiz);

        textPR = new JTextField();
        textPR.setBounds(80, 129, 100, 23);
        add(textPR);

        JLabel lblExpo = new JLabel("Exponente:");
        lblExpo.setBounds(200, 132, 70, 14);
        add(lblExpo);

        textExpo = new JTextField();
        textExpo.setBounds(280, 129, 100, 23);
        add(textExpo);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(10, 205, 70, 14);
        add(lblResultado);

        textRes = new JTextArea();
        textRes.setBounds(80, 200, 200, 22);
        textRes.setEditable(false);
        add(textRes);

        agregarBoton("Suma", 400, 11);
        agregarBoton("Resta", 400, 45);
        agregarBoton("Multiplicacion", 400, 79);
        agregarBoton("Division", 400, 113);
        agregarBoton("Potencia", 400, 147);
        agregarBoton("Raiz", 400, 181);
    }

    private void agregarBoton(String operacion, int x, int y) {
        JButton btn = new JButton(operacion);
        btn.setBounds(x, y, 110, 23);
        btn.addActionListener(e -> realizarOperacion(operacion));
        add(btn);
    }

    private void realizarOperacion(String operacion) {
        try {
            float num1;
            float num2;
            float res = 0;
            String texto = "";

            if (operacion.equals("Potencia") || operacion.equals("Raiz")) {
                num1 = Float.parseFloat(textPR.getText());
                num2 = Float.parseFloat(textExpo.getText());
            } else {
                num1 = Float.parseFloat(textN1.getText());
                num2 = Float.parseFloat(textN2.getText());
            }

            switch (operacion) {
                case "Suma":
                    res = num1 + num2;
                    texto = "Suma: " + res;
                    break;
                case "Resta":
                    res = num1 - num2;
                    texto = "Resta: " + res;
                    break;
                case "Multiplicacion":
                    res = num1 * num2;
                    texto = "Multiplicacion: " + res;
                    break;
                case "Division":
                    if (num2 == 0) {
                        texto = "Error: Division por cero.";
                    } else {
                        res = num1 / num2;
                        texto = "Division: " + res;
                    }
                    break;
                case "Potencia":
                    res = (float) Math.pow(num1, num2);
                    texto = "Potencia: " + res;
                    break;
                case "Raiz":
                    if (num2 == 0) {
                        texto = "Error: Indice cero.";
                    } else {
                        res = (float) Math.pow(num1, 1.0 / num2);
                        texto = "Raiz: " + res;
                    }
                    break;
            }

            textRes.setText(texto);
        } catch (Exception ex) {
            textRes.setText("Error en los valores.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaNumero().setVisible(true));
    }
}