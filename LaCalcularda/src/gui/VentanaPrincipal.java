package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("La Calcularda");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalcularda = new JLabel("La Calcularda");
		lblCalcularda.setForeground(new Color(0, 0, 0));
		lblCalcularda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcularda.setBounds(0, 31, 434, 39);
		lblCalcularda.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblCalcularda);
		
		JButton btnNumeros = new JButton("Números");
		btnNumeros.setBounds(83, 107, 100, 30);
		contentPane.add(btnNumeros);
		btnNumeros.addActionListener(e -> {
			new VentanaNumeros().setVisible(true);
		});
		
		JButton btnVectores = new JButton("Vectores");
		btnVectores.setBounds(243, 107, 100, 30);
		contentPane.add(btnVectores);
		btnVectores.addActionListener(e -> {
			new VentanaVectores().setVisible(true);
		});
		
		JButton btnMatrices = new JButton("Matrices");
		btnMatrices.setBounds(83, 158, 100, 30);
		contentPane.add(btnMatrices);
		btnMatrices.addActionListener(e -> {
			new VentanaMatrices().setVisible(true);
		});
		
		JButton btnSistemas = new JButton("Sistemas");
		btnSistemas.setBounds(243, 158, 100, 30);
		contentPane.add(btnSistemas);
		btnSistemas.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
	}
}
