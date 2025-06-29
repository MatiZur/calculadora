package gui;

import javax.swing.*;

public class VentanaNumero extends JFrame {
    private JTextField textN1;
    private JTextField textN2;
    private JTextField textPR;
    private JTextArea textRes;

    public VentanaNumero() {
        setTitle("Calculadora");
        setSize(500, 300);
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

        JLabel lblPotenciaRaiz = new JLabel("Numero:");
        lblPotenciaRaiz.setBounds(10, 132, 70, 14);
        add(lblPotenciaRaiz);

        textPR = new JTextField();
        textPR.setBounds(80, 129, 100, 23);
        add(textPR);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(10, 205, 70, 14);
        add(lblResultado);

        textRes = new JTextArea();
        textRes.setBounds(80, 200, 200, 22);
        textRes.setEditable(false);
        add(textRes);

        agregarBoton("Suma", 250, 11);
        agregarBoton("Resta", 360, 11);
        agregarBoton("Multiplicacion", 250, 45);
        agregarBoton("Division", 360, 45);
        agregarBoton("Potencia", 250, 128);
        agregarBoton("Raiz", 360, 128);
    }

    private void agregarBoton(String operacion, int x, int y) {
        JButton btn = new JButton(operacion);
        btn.setBounds(x, y, 100, 23);
        btn.addActionListener(e -> realizarOperacion(operacion));
        add(btn);
    }

    private void realizarOperacion(String operacion) {
        try {
            float res = 0;
            String texto = "";

            switch (operacion) {
                case "Suma":
                    float s1 = Float.parseFloat(textN1.getText());
                    float s2 = Float.parseFloat(textN2.getText());
                    res = s1 + s2;
                    texto = "Suma: " + res;
                    break;
                case "Resta":
                    float r1 = Float.parseFloat(textN1.getText());
                    float r2 = Float.parseFloat(textN2.getText());
                    res = r1 - r2;
                    texto = "Resta: " + res;
                    break;
                case "Multiplicacion":
                    float m1 = Float.parseFloat(textN1.getText());
                    float m2 = Float.parseFloat(textN2.getText());
                    res = m1 * m2;
                    texto = "Multiplicacion: " + res;
                    break;
                case "Division":
                    float d1 = Float.parseFloat(textN1.getText());
                    float d2 = Float.parseFloat(textN2.getText());
                    if (d2 == 0) {
                        texto = "Error: Division por cero.";
                    } else {
                        res = d1 / d2;
                        texto = "Division: " + res;
                    }
                    break;
                case "Potencia":
                    float base = Float.parseFloat(textPR.getText());
                    float exponente = Float.parseFloat(textN2.getText());
                    res = (float) Math.pow(base, exponente);
                    texto = "Potencia: " + res;
                    break;
                case "Raiz":
                    float radicando = Float.parseFloat(textPR.getText());
                    float indice = Float.parseFloat(textN2.getText());
                    if (indice == 0) {
                        texto = "Error: Indice cero.";
                    } else {
                        res = (float) Math.pow(radicando, 1.0 / indice);
                        texto = "Raiz: " + res;
                    }
                    break;
            }

            textRes.setText(texto);
        }  catch (Exception ex) {
	        // No muestra mensaje de error por ahora
	    }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaNumero().setVisible(true));
    }
}
