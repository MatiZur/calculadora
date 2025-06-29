package gui;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.*;

import operaciones.Operaciones;
import java.awt.Color;

public class VentanaSistemas extends JFrame {

    private JPanel contentPane;
    private JLabel lblSistemas3;
    private JTextField txtX1, txtY1, txtZ1, txtR1;
    private JTextField txtX2, txtY2, txtZ2, txtR2;
    private JTextField txtX3, txtY3, txtZ3, txtR3;
    private JLabel lblX1, lblY1, lblZ1, lblR1;
    private JLabel lblX2, lblY2, lblZ2, lblR2;
    private JLabel lblX3, lblY3, lblZ3, lblR3;
    private JButton btnCalcular3x3;
    private JButton btnCalcular2x2;
    private JLabel lblXE, lblYE, lblZE;
    private JLabel lblX, lblY, lblZ;
    private JComboBox<String> comboSistema;

    private boolean sistema3x3;

    public VentanaSistemas() {
    	setTitle("La Calcularda - Sistemas");
        setBounds(100, 100, 550, 350);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboSistema = new JComboBox<>(new String[]{"2x2", "3x3"});
        comboSistema.setBounds(20, 10, 100, 25);
        contentPane.add(comboSistema);

        lblSistemas3 = new JLabel("Sistema 3x3");
        lblSistemas3.setForeground(new Color(0, 0, 0));
        lblSistemas3.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblSistemas3.setBounds(200, 10, 180, 30);
        contentPane.add(lblSistemas3);

    
        txtX1 = new JTextField();
        txtX1.setBounds(20, 60, 60, 25);
        txtX1.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtX1);

        lblX1 = new JLabel("x");
        lblX1.setBounds(85, 60, 20, 25);
        lblX1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblX1);

        txtY1 = new JTextField();
        txtY1.setBounds(110, 60, 60, 25);
        txtY1.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtY1);

        lblY1 = new JLabel("y");
        lblY1.setBounds(175, 60, 20, 25);
        lblY1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblY1);

        txtZ1 = new JTextField();
        txtZ1.setBounds(200, 60, 60, 25);
        txtZ1.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtZ1);

        lblZ1 = new JLabel("z");
        lblZ1.setBounds(265, 60, 20, 25);
        lblZ1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblZ1);

        lblR1 = new JLabel("=");
        lblR1.setBounds(295, 60, 20, 25);
        lblR1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblR1);

        txtR1 = new JTextField();
        txtR1.setBounds(320, 60, 60, 25);
        txtR1.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtR1);

        
        txtX2 = new JTextField();
        txtX2.setBounds(20, 100, 60, 25);
        txtX2.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtX2);

        lblX2 = new JLabel("x");
        lblX2.setBounds(85, 100, 20, 25);
        lblX2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblX2);

        txtY2 = new JTextField();
        txtY2.setBounds(110, 100, 60, 25);
        txtY2.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtY2);

        lblY2 = new JLabel("y");
        lblY2.setBounds(175, 100, 20, 25);
        lblY2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblY2);

        txtZ2 = new JTextField();
        txtZ2.setBounds(200, 100, 60, 25);
        txtZ2.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtZ2);

        lblZ2 = new JLabel("z");
        lblZ2.setBounds(265, 100, 20, 25);
        lblZ2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblZ2);

        lblR2 = new JLabel("=");
        lblR2.setBounds(295, 100, 20, 25);
        lblR2.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblR2);

        txtR2 = new JTextField();
        txtR2.setBounds(320, 100, 60, 25);
        txtR2.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtR2);

        
        txtX3 = new JTextField();
        txtX3.setBounds(20, 140, 60, 25);
        txtX3.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtX3);

        lblX3 = new JLabel("x");
        lblX3.setBounds(85, 140, 20, 25);
        lblX3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblX3);

        txtY3 = new JTextField();
        txtY3.setBounds(110, 140, 60, 25);
        txtY3.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtY3);

        lblY3 = new JLabel("y");
        lblY3.setBounds(175, 140, 20, 25);
        lblY3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblY3);

        txtZ3 = new JTextField();
        txtZ3.setBounds(200, 140, 60, 25);
        txtZ3.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtZ3);

        lblZ3 = new JLabel("z");
        lblZ3.setBounds(265, 140, 20, 25);
        lblZ3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblZ3);

        lblR3 = new JLabel("=");
        lblR3.setBounds(295, 140, 20, 25);
        lblR3.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblR3);

        txtR3 = new JTextField();
        txtR3.setBounds(320, 140, 60, 25);
        txtR3.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(txtR3);

       
        lblXE = new JLabel("x =");
        lblXE.setBounds(20, 190, 30, 25);
        contentPane.add(lblXE);

        lblX = new JLabel(" ");
        lblX.setBounds(50, 190, 100, 25);
        contentPane.add(lblX);

        lblYE = new JLabel("y =");
        lblYE.setBounds(20, 215, 30, 25);
        contentPane.add(lblYE);

        lblY = new JLabel(" ");
        lblY.setBounds(50, 215, 100, 25);
        contentPane.add(lblY);

        lblZE = new JLabel("z =");
        lblZE.setBounds(20, 240, 30, 25);
        contentPane.add(lblZE);

        lblZ = new JLabel(" ");
        lblZ.setBounds(50, 240, 100, 25);
        contentPane.add(lblZ);

      
        btnCalcular3x3 = new JButton("Calcular");
        btnCalcular3x3.setBounds(400, 97, 110, 30);
        contentPane.add(btnCalcular3x3);

        btnCalcular2x2 = new JButton("Calcular");
        btnCalcular2x2.setBounds(400, 78, 110, 30);
        contentPane.add(btnCalcular2x2);
        
        JButton btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(400, 137, 110, 30);
        contentPane.add(btnBorrar);

        
        btnCalcular3x3.addActionListener(e -> calcularSistema3());
        btnCalcular2x2.addActionListener(e -> calcularSistema2());
        btnBorrar.addActionListener(e -> limpiarCampos());
        

        comboSistema.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                sistema3x3 = comboSistema.getSelectedItem().equals("3x3");
                actualizarComponentesSegunSistema();
            }
        });

        
        sistema3x3 = comboSistema.getSelectedItem().equals("3x3");
        actualizarComponentesSegunSistema();
    }

    private void actualizarComponentesSegunSistema() {
    	if (sistema3x3) {
    	    lblSistemas3.setText("Sistema 3x3");
    	    btnCalcular2x2.setVisible(false);
    	    btnCalcular3x3.setVisible(true);
    	} else {
    	    lblSistemas3.setText("Sistema 2x2");
    	    btnCalcular2x2.setVisible(true);
    	    btnCalcular3x3.setVisible(false);
    	}      
        txtZ1.setVisible(sistema3x3);
        lblZ1.setVisible(sistema3x3);
        txtZ2.setVisible(sistema3x3);
        lblZ2.setVisible(sistema3x3);
        txtZ3.setVisible(sistema3x3);
        lblZ3.setVisible(sistema3x3);
        txtX3.setVisible(sistema3x3);
        lblX3.setVisible(sistema3x3);
        txtY3.setVisible(sistema3x3);
        lblY3.setVisible(sistema3x3);
        txtR3.setVisible(sistema3x3);
        lblR3.setVisible(sistema3x3);

        lblZE.setVisible(sistema3x3);
        lblZ.setVisible(sistema3x3);

        
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtX1.setText("");
        txtY1.setText("");
        txtZ1.setText("");
        txtR1.setText("");
        txtX2.setText("");
        txtY2.setText("");
        txtZ2.setText("");
        txtR2.setText("");
        txtX3.setText("");
        txtY3.setText("");
        txtZ3.setText("");
        txtR3.setText("");
        lblX.setText("");
        lblY.setText("");
        lblZ.setText("");
    }

    public void calcularSistema3() {
        try {
            int x1 = Integer.parseInt(txtX1.getText());
            int y1 = Integer.parseInt(txtY1.getText());
            int z1 = Integer.parseInt(txtZ1.getText());
            int r1 = Integer.parseInt(txtR1.getText());
            int x2 = Integer.parseInt(txtX2.getText());
            int y2 = Integer.parseInt(txtY2.getText());
            int z2 = Integer.parseInt(txtZ2.getText());
            int r2 = Integer.parseInt(txtR2.getText());
            int x3 = Integer.parseInt(txtX3.getText());
            int y3 = Integer.parseInt(txtY3.getText());
            int z3 = Integer.parseInt(txtZ3.getText());
            int r3 = Integer.parseInt(txtR3.getText());

            float[] variables = Operaciones.sistema3(x1, y1, z1, r1, x2, y2, z2, r2, x3, y3, z3, r3);
            
            for(int i = 0 ; i < 3 ; i++){
            	if (Float.isNaN(variables[i]) || Float.isInfinite(variables[i])){
                    JOptionPane.showMessageDialog(this, "El sistema no tiene solución, tiene más de una sola o hay una división por cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            lblX.setText(Float.toString(variables[0]));
            lblY.setText(Float.toString(variables[1]));
            lblZ.setText(Float.toString(variables[2]));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresá bien los números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calcularSistema2() {
        try {
            int x1 = Integer.parseInt(txtX1.getText());
            int y1 = Integer.parseInt(txtY1.getText());
            int r1 = Integer.parseInt(txtR1.getText());
            int x2 = Integer.parseInt(txtX2.getText());
            int y2 = Integer.parseInt(txtY2.getText());
            int r2 = Integer.parseInt(txtR2.getText());

            float[] res = Operaciones.sistema2(x1, y1, r1, x2, y2, r2);
            
            for(int i = 0 ; i < 2 ; i++){
            	if (Float.isNaN(res[i]) || Float.isInfinite(res[i])){
                    JOptionPane.showMessageDialog(this, "El sistema no tiene solución, tiene más de una sola o hay una división por cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            lblX.setText(Float.toString(res[0]));
            lblY.setText(Float.toString(res[1]));
            lblZ.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingresá bien los números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}