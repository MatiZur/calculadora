package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import matrices.Matrices;

public class VentanaMatrices extends JFrame {
    private JTextField filasField, columnasField;
    private JPanel panelMatrizA, panelMatrizB;
    private JTextArea resultadoArea;
    private JTextField[][] camposA, camposB;

    float[][] ans = null;
    
     public VentanaMatrices() {
        setTitle("Calculadora - Matrices");
        setSize(742, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblFilas = new JLabel("Filas:");
        lblFilas.setBounds(10, 10, 50, 25);
        getContentPane().add(lblFilas);

        filasField = new JTextField("2");
        filasField.setBounds(60, 10, 40, 25);
        getContentPane().add(filasField);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setBounds(110, 10, 70, 25);
        getContentPane().add(lblColumnas);

        columnasField = new JTextField("2");
        columnasField.setBounds(180, 10, 40, 25);
        getContentPane().add(columnasField);

        JButton generarBtn = new JButton("Generar");
        generarBtn.setBounds(240, 10, 100, 25);
        getContentPane().add(generarBtn);
        
        JButton borrarBtn = new JButton("Borrar");
        borrarBtn.setBounds(350, 10, 100, 25);
        getContentPane().add(borrarBtn);
        
        JButton ansBtn = new JButton("Ans");
        ansBtn.setBounds(460, 10, 100, 25);
        getContentPane().add(ansBtn);

        panelMatrizA = new JPanel();
        panelMatrizA.setBorder(BorderFactory.createTitledBorder("Matriz A"));
        panelMatrizA.setBounds(10, 50, 300, 200);
        panelMatrizA.setLayout(new GridLayout(0, 1));
        getContentPane().add(panelMatrizA);

        panelMatrizB = new JPanel();
        panelMatrizB.setBorder(BorderFactory.createTitledBorder("Matriz B"));
        panelMatrizB.setBounds(320, 50, 300, 200);
        panelMatrizB.setLayout(new GridLayout(0, 1));
        getContentPane().add(panelMatrizB);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultadoArea);
        scroll.setBounds(10, 330, 610, 200);
        getContentPane().add(scroll);

        JButton sumarBtn = new JButton("Sumar");
        sumarBtn.setBounds(10, 270, 100, 25);
        getContentPane().add(sumarBtn);

        JButton restarBtn = new JButton("Restar");
        restarBtn.setBounds(120, 270, 100, 25);
        getContentPane().add(restarBtn);

        generarBtn.addActionListener(e -> generarCampos());
        borrarBtn.addActionListener(e -> borrarCampos());
        ansBtn.addActionListener(e -> ansCampoA());

        sumarBtn.addActionListener(e -> realizarOperacion("sumar"));
        restarBtn.addActionListener(e -> realizarOperacion("restar"));
        
        JButton multiplicarBtn = new JButton("Multiplicar");
        multiplicarBtn.setBounds(230, 270, 100, 25);
        getContentPane().add(multiplicarBtn);

        JButton dividirBtn = new JButton("Dividir");
        dividirBtn.setBounds(340, 270, 100, 25);
        getContentPane().add(dividirBtn);

        JButton inversaBtn = new JButton("Inversa A");
        inversaBtn.setBounds(616, 270, 100, 25);
        getContentPane().add(inversaBtn);

        JButton determinanteBtn = new JButton("Determinante A");
        determinanteBtn.setBounds(463, 270, 130, 25);
        getContentPane().add(determinanteBtn);

        
        multiplicarBtn.addActionListener(e -> realizarOperacion("multiplicar"));
        dividirBtn.addActionListener(e -> realizarOperacion("dividir"));
        inversaBtn.addActionListener(e -> realizarOperacion("inversa"));
        determinanteBtn.addActionListener(e -> realizarOperacion("determinante"));

    }

     private void generarCampos() {
    	    try {
    	        int filas = Integer.parseInt(filasField.getText());
    	        int columnas = Integer.parseInt(columnasField.getText());

    	        
    	        panelMatrizA.removeAll();
    	        panelMatrizB.removeAll();

    	        
    	        panelMatrizA.setLayout(new GridLayout(filas, columnas));
    	        panelMatrizB.setLayout(new GridLayout(filas, columnas));

    	      
    	        camposA = new JTextField[filas][columnas];
    	        camposB = new JTextField[filas][columnas];

    	        
    	        for (int i = 0; i < filas; i++) {
    	            for (int j = 0; j < columnas; j++) {
    	                camposA[i][j] = new JTextField("0", 3);
    	                panelMatrizA.add(camposA[i][j]);

    	                camposB[i][j] = new JTextField("0", 3);
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
     
     private void borrarCampos(){
    	 	filasField.setText(null);
	        columnasField.setText(null);
	        resultadoArea.setText(null);
	        panelMatrizA.removeAll();
	    	panelMatrizB.removeAll();
	        panelMatrizA.repaint();
	        panelMatrizB.repaint();
     }
     
     private void ansCampoA(){
    	 	String filas = String.valueOf(ans.length);
    	 	String columnas = String.valueOf(ans[0].length);
 	 		filasField.setText(filas);
 	 		columnasField.setText(columnas);
	        generarCampos();
	        for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[0].length; j++) {
                    camposA[i][j].setText(String.valueOf(ans[i][j]));
                }
            }
     }

     private void realizarOperacion(String operacion) {
    	    try {
    	        int filas = camposA.length;
    	        int columnas = camposA[0].length;

    	        float[][] a = new float[filas][columnas];
    	        float[][] b = new float[filas][columnas];

    	        // Solo lee matriz A para estas operaciones
    	        if (operacion.equals("inversa") || operacion.equals("determinante")) {
    	            for (int i = 0; i < filas; i++) {
    	                for (int j = 0; j < columnas; j++) {
    	                    a[i][j] = Float.parseFloat(camposA[i][j].getText());
    	                }
    	            }
    	        } else { // Lee ambas matrices para las otras operaciones
    	            for (int i = 0; i < filas; i++) {
    	                for (int j = 0; j < columnas; j++) {
    	                    a[i][j] = Float.parseFloat(camposA[i][j].getText());
    	                    b[i][j] = Float.parseFloat(camposB[i][j].getText());
    	                }
    	            }
    	        }

    	        float[][] resultado = null;
    	        String textoResultado = "";

    	        switch (operacion) {
    	            case "sumar":
    	                resultado = Matrices.sumar(a, b);
    	                ans = resultado;
    	                break;
    	            case "restar":
    	                resultado = Matrices.restar(a, b);
    	                ans = resultado;
    	                break;
    	            case "multiplicar":
    	                if (a[0].length != b.length) {
    	                    return; // No hace nada si no es compatible
    	                }
    	                resultado = Matrices.multiplicarMatrices(a, b);
    	                ans = resultado;
    	                break;
    	            case "dividir":
    	                resultado = Matrices.dividirMatrices(a, b);
    	                ans = resultado;
    	                if (resultado == null) {
    	                    return; // No hace nada si no es invertible
    	                }
    	                break;
    	            case "inversa":
    	                resultado = Matrices.inversa(a);
    	                ans = resultado;
    	                if (resultado == null) {
    	                    return; // No hace nada si no es invertible
    	                }
    	                break;
    	            case "determinante":
    	                if (a.length != a[0].length) {
    	                    return; // No hace nada si no es cuadrada
    	                }
    	                float det = Matrices.determinante(a, a.length);
    	                textoResultado = "Determinante: " + String.format("%.2f", det);
    	                break;
    	            default:
    	                return; // Operación no soportada, no hace nada
    	        }

    	        if (resultado != null) {
    	            resultadoArea.setText(mostrarMatriz(resultado));
    	        } else if (!textoResultado.isEmpty()) {
    	            resultadoArea.setText(textoResultado);
    	        }

    	    } catch (Exception ex) {
    	        // No muestra mensaje de error por ahora
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


	public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaMatrices().setVisible(true);
        });
    }
}