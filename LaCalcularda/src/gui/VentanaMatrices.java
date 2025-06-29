package gui;

import javax.swing.*;
import java.awt.*;
import operaciones.Operaciones;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMatrices extends JFrame {
    
    private JTextField filasAField, columnasAField;
    private JTextField filasBField, columnasBField;
    private JTextField escalarField;
    
    private JPanel panelMatrizA, panelMatrizB;
    private JTextArea resultadoArea;
    private JTextField[][] camposA, camposB;

    float[][] ans;

    public VentanaMatrices() {
    	setTitle("La Calcularda - Matrices");
        setSize(1100, 600);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Labels y campos para Matriz A
        JLabel lblFilasA = new JLabel("Filas A:");
        lblFilasA.setBounds(10, 10, 50, 25);
        getContentPane().add(lblFilasA);

        filasAField = new JTextField("2");
        filasAField.setBounds(60, 10, 40, 25);
        getContentPane().add(filasAField);

        JLabel lblColumnasA = new JLabel("Columnas A:");
        lblColumnasA.setBounds(110, 10, 80, 25);
        getContentPane().add(lblColumnasA);

        columnasAField = new JTextField("2");
        columnasAField.setBounds(190, 10, 40, 25);
        getContentPane().add(columnasAField);

        // Labels y campos para Matriz B
        JLabel lblFilasB = new JLabel("Filas B:");
        lblFilasB.setBounds(240, 10, 50, 25);
        getContentPane().add(lblFilasB);

        filasBField = new JTextField("2");
        filasBField.setBounds(290, 10, 40, 25);
        getContentPane().add(filasBField);

        JLabel lblColumnasB = new JLabel("Columnas B:");
        lblColumnasB.setBounds(344, 10, 80, 25);
        getContentPane().add(lblColumnasB);

        columnasBField = new JTextField("2");
        columnasBField.setBounds(420, 10, 40, 25);
        getContentPane().add(columnasBField);
        
        JLabel lblEscalar = new JLabel("Escalar:");
        lblEscalar.setBounds(706, 10, 70, 25);
        getContentPane().add(lblEscalar);

        escalarField = new JTextField();
        escalarField.setBounds(760, 10, 40, 25);
        getContentPane().add(escalarField);

        JButton generarBtn = new JButton("Generar");
        generarBtn.setBounds(494, 10, 100, 25);
        getContentPane().add(generarBtn);

        JButton borrarBtn = new JButton("Borrar");
        borrarBtn.setBounds(887, 10, 100, 25);
        getContentPane().add(borrarBtn);

        JButton ansBtn = new JButton("Ans");
        ansBtn.setBounds(1010, 10, 64, 25);
        getContentPane().add(ansBtn);

        panelMatrizA = new JPanel();
        panelMatrizA.setBorder(BorderFactory.createTitledBorder("Matriz A"));
        panelMatrizA.setBounds(185, 46, 300, 200);
        panelMatrizA.setLayout(new GridLayout(0, 1));
        getContentPane().add(panelMatrizA);

        panelMatrizB = new JPanel();
        panelMatrizB.setBorder(BorderFactory.createTitledBorder("Matriz B"));
        panelMatrizB.setBounds(614, 46, 300, 200);
        panelMatrizB.setLayout(new GridLayout(0, 1));
        getContentPane().add(panelMatrizB);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultadoArea);
        scroll.setBounds(10, 330, 1065, 200);
        getContentPane().add(scroll);

        JButton sumarBtn = new JButton("Sumar");
        sumarBtn.setBounds(10, 270, 90, 25);
        getContentPane().add(sumarBtn);

        JButton restarBtn = new JButton("Restar");
        restarBtn.setBounds(110, 270, 95, 25);
        getContentPane().add(restarBtn);

        generarBtn.addActionListener(e -> generarCampos());
        borrarBtn.addActionListener(e -> borrarCampos());
        ansBtn.addActionListener(e -> ansCampoA());

        sumarBtn.addActionListener(e -> realizarOperacion("sumar"));
        restarBtn.addActionListener(e -> realizarOperacion("restar"));

        JButton multiplicarBtn = new JButton("Multiplicar");
        multiplicarBtn.setBounds(433, 270, 106, 25);
        getContentPane().add(multiplicarBtn);

        JButton dividirBtn = new JButton("Dividir");
        dividirBtn.setBounds(549, 270, 90, 25);
        getContentPane().add(dividirBtn);

        JButton inversaBtn = new JButton("Inversa (A)");
        inversaBtn.setBounds(958, 270, 117, 25);
        getContentPane().add(inversaBtn);

        JButton determinanteBtn = new JButton("Determinante (A)");
        determinanteBtn.setBounds(651, 270, 139, 25);
        getContentPane().add(determinanteBtn);
        
        JButton multiplicarEscalarBtn = new JButton("Multiplicar por escalar (A)");
        multiplicarEscalarBtn.setBounds(215, 270, 208, 25);
        getContentPane().add(multiplicarEscalarBtn);
        
        JButton transpuestaBtn = new JButton("Transpuesta (A)");
        transpuestaBtn.setBounds(800, 270, 148, 25);
        getContentPane().add(transpuestaBtn);

        multiplicarBtn.addActionListener(e -> realizarOperacion("multiplicar"));
        dividirBtn.addActionListener(e -> realizarOperacion("dividir"));
        inversaBtn.addActionListener(e -> realizarOperacion("inversa"));
        determinanteBtn.addActionListener(e -> realizarOperacion("determinante"));
        multiplicarEscalarBtn.addActionListener(e -> realizarOperacion("multiplicarEscalar"));
        transpuestaBtn.addActionListener(e -> realizarOperacion("transpuesta"));
    }

    private void generarCampos() {
        try {
            int filasA = Integer.parseInt(filasAField.getText());
            int columnasA = Integer.parseInt(columnasAField.getText());
            int filasB = Integer.parseInt(filasBField.getText());
            int columnasB = Integer.parseInt(columnasBField.getText());

            panelMatrizA.removeAll();
            panelMatrizB.removeAll();

            panelMatrizA.setLayout(new GridLayout(filasA, columnasA));
            panelMatrizB.setLayout(new GridLayout(filasB, columnasB));

            camposA = new JTextField[filasA][columnasA];
            camposB = new JTextField[filasB][columnasB];

            for (int i = 0; i < filasA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    camposA[i][j] = new JTextField("", 3);
                    panelMatrizA.add(camposA[i][j]);
                }
            }

            for (int i = 0; i < filasB; i++) {
                for (int j = 0; j < columnasB; j++) {
                    camposB[i][j] = new JTextField("", 3);
                    panelMatrizB.add(camposB[i][j]);
                }
            }

            panelMatrizA.revalidate();
            panelMatrizB.revalidate();
            panelMatrizA.repaint();
            panelMatrizB.repaint();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Faltan los numeros", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void borrarCampos() {
        filasAField.setText(null);
        columnasAField.setText(null);
        filasBField.setText(null);
        columnasBField.setText(null);
        escalarField.setText(null);
        resultadoArea.setText(null);
        panelMatrizA.removeAll();
        panelMatrizB.removeAll();
        panelMatrizA.repaint();
        panelMatrizB.repaint();
    }

    private void ansCampoA() {
        if (ans == null) return;
        String filas = String.valueOf(ans.length);
        String columnas = String.valueOf(ans[0].length);
        filasAField.setText(filas);
        columnasAField.setText(columnas);
        generarCampos();
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                camposA[i][j].setText(String.valueOf(ans[i][j]));
            }
        }
    }

    private void realizarOperacion(String operacion) {
        try {
            int filasA = camposA.length;
            int columnasA = camposA[0].length;

            int filasB = camposB.length;
            int columnasB = camposB[0].length;

            float[][] a = new float[filasA][columnasA];
            float[][] b = new float[filasB][columnasB];

           
            if (operacion.equals("inversa") || operacion.equals("determinante") || operacion.equals("multiplicarEscalar") || operacion.equals("transpuesta")) {
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasA; j++) {
                        a[i][j] = Float.parseFloat(camposA[i][j].getText());
                    }
                }
            } else { 
                for (int i = 0; i < filasA; i++) {
                    for (int j = 0; j < columnasA; j++) {
                        a[i][j] = Float.parseFloat(camposA[i][j].getText());
                    }
                }
                for (int i = 0; i < filasB; i++) {
                    for (int j = 0; j < columnasB; j++) {
                        b[i][j] = Float.parseFloat(camposB[i][j].getText());
                    }
                }
            }

            float[][] resultado = null;
            String textoResultado = "";

            switch (operacion) {
                case "sumar":
                    if(filasA != filasB || columnasA != columnasB) {
                        JOptionPane.showMessageDialog(this, "Para sumar las matrices deben tener las mismas dimensiones.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = Operaciones.sumar(a, b);
                    ans = resultado;
                    break;
                case "restar":
                    if(filasA != filasB || columnasA != columnasB) {
                        JOptionPane.showMessageDialog(this, "Para restar las matrices deben tener las mismas dimensiones.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = Operaciones.restar(a, b);
                    ans = resultado;
                    break;
                case "multiplicar":
                    if (columnasA != filasB) {
                        JOptionPane.showMessageDialog(this, "Para multiplicar, las columnas de A deben ser igual a filas de B.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = Operaciones.multiplicarMatrices(a, b);
                    ans = resultado;
                    break;
                case "dividir":
                    if (columnasA != filasB) {
                        JOptionPane.showMessageDialog(this, "Para dividir, las columnas de A deben ser igual a filas de B.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = Operaciones.dividirMatrices(a, b);
                    if (resultado == null) {
                        JOptionPane.showMessageDialog(this, "La matriz B no es invertible, no se puede dividir.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ans = resultado;
                    break;
                case "inversa":
                    if (filasA != columnasA) {
                        JOptionPane.showMessageDialog(this, "La matriz A debe ser cuadrada para calcular su inversa.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = Operaciones.inversa(a);
                    if (resultado == null) {
                        JOptionPane.showMessageDialog(this, "La matriz A no es invertible.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    ans = resultado;
                    break;
                case "determinante":
                    if (filasA != columnasA) {
                        JOptionPane.showMessageDialog(this, "La matriz A debe ser cuadrada para calcular su determinante.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    float det = Operaciones.determinante(a, filasA);
                    textoResultado = "Determinante: " + String.format("%.2f", det);
                    break;
                case "multiplicarEscalar":
                	int escalar = Integer.parseInt(escalarField.getText());
                	resultado = Operaciones.multiplicarEscalar(a, escalar);
                	ans = resultado;
                    break;
                case "transpuesta":
                	resultado = Operaciones.transpuesta(a);
                	ans = resultado;
                    break;
                default:
                    return;
            }

            if (resultado != null) {
                resultadoArea.setText(mostrarMatriz(resultado));
            } else if (!textoResultado.isEmpty()) {
                resultadoArea.setText(textoResultado);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al leer las matrices y/o escalar. Asegúrate de ingresar números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String mostrarMatriz(float[][] matriz) {
        StringBuilder sb = new StringBuilder();
        for (float[] fila : matriz) {
            for (float val : fila) {
                sb.append(String.format("%.2f\t", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}