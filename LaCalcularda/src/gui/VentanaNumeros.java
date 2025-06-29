package gui;

import javax.swing.*;

public class VentanaNumeros extends JFrame {
    private JTextField textN1;
    private JTextField textN2;
    private JLabel lblRes;

    float ans;
    
    public VentanaNumeros() {
        setTitle("La Calcularda - Números");
        setSize(700, 325);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblN1 = new JLabel("Número 1 / Base:");
        lblN1.setBounds(85, 45, 100, 15);
        getContentPane().add(lblN1);

        textN1 = new JTextField();
        textN1.setBounds(190, 42, 100, 23);
        getContentPane().add(textN1);

        JLabel lblN2 = new JLabel("Número 2 / Exponente:");
        lblN2.setBounds(350, 45, 130, 15);
        getContentPane().add(lblN2);

        textN2 = new JTextField();
        textN2.setBounds(485, 42, 100, 23);
        getContentPane().add(textN2);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setBounds(260, 225, 70, 14);
        getContentPane().add(lblResultado);

        lblRes = new JLabel(" ");
        lblRes.setBounds(340, 225, 200, 14);
        getContentPane().add(lblRes);

        JButton borrarBtn = new JButton("Borrar");
        borrarBtn.setBounds(250, 75, 80, 23);
        borrarBtn.addActionListener(e -> borrar());
        getContentPane().add(borrarBtn);
        
        JButton ansBtn = new JButton("Ans");
        ansBtn.setBounds(350, 75, 80, 23);
        ansBtn.addActionListener(e -> ans());
        getContentPane().add(ansBtn);
        
        agregarBoton("Suma", 50, 145);
        agregarBoton("Resta", 140, 145);
        agregarBoton("Multiplicación", 230, 145);
        agregarBoton("División", 355, 145);
        agregarBoton("Raíz", 445, 145);
        agregarBoton("Potencia", 535, 145);
    }

    private void agregarBoton(String operacion, int x, int y) {
        JButton btn = new JButton(operacion);
        btn.setBounds(x, y, 80, 23);
        if(operacion == "Multiplicación"){
        	btn.setBounds(x, y, 115, 23);
        }
        else if(operacion == "Potencia"){
        	btn.setBounds(x, y, 90, 23);
        }
        btn.addActionListener(e -> realizarOperacion(operacion));
        getContentPane().add(btn);
    }

    private void borrar(){
    	textN1.setText(null);
    	textN2.setText(null);
    	lblRes.setText(null);
    }
    
    private void ans(){
    	textN1.setText("" + ans);
    	textN2.setText(null);
    }
    
    private void realizarOperacion(String operacion) {
        try {
            float num1;
            float num2;
            float res = 0;
            String texto = "";
            num1 = Float.parseFloat(textN1.getText());
            num2 = Float.parseFloat(textN2.getText());

            switch (operacion) {
                case "Suma":
                    res = num1 + num2;
                    ans = res;
                    texto = "" + res;
                    break;
                case "Resta":
                    res = num1 - num2;
                    ans = res;
                    texto = "" + res;
                    break;
                case "Multiplicación":
                    res = num1 * num2;
                    ans = res;
                    texto = "" + res;
                    break;
                case "División":
                    if (num2 == 0) {
                        texto = "Error: División por cero";
                    } else {
                        res = num1 / num2;
                        ans = res;
                        texto = "" + res;
                    }
                    break;
                case "Potencia":
                    res = (float) Math.pow(num1, num2);
                    ans = res;
                	texto = "" + res;
                    break;
                case "Raíz":
                    if (num2 == 0) {
                        texto = "Error: Índice cero";
                    } else {
                        res = (float) Math.pow(num1, 1.0 / num2);
                        ans = res;
                        texto = "" + res;
                    }
                    break;
            }

            lblRes.setText(texto);
        } catch (Exception ex) {
        	lblRes.setText("Error en los valores");
        }
    }
}