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
		setSize(600, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCalcularda = new JLabel("La Calcularda");
		lblCalcularda.setForeground(new Color(0, 0, 0));
		lblCalcularda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalcularda.setBounds(0, 28, 584, 39);
		lblCalcularda.setFont(new Font("Tahoma", Font.BOLD, 32));
		contentPane.add(lblCalcularda);
		
		JButton btnNumeros = new JButton("Números");
		btnNumeros.setBounds(58, 140, 100, 30);
		contentPane.add(btnNumeros);
		btnNumeros.addActionListener(e -> {
			new VentanaNumeros().setVisible(true);
		});
		
		JButton btnVectores = new JButton("Vectores");
		btnVectores.setBounds(181, 140, 100, 30);
		contentPane.add(btnVectores);
		btnVectores.addActionListener(e -> {
			new VentanaVectores().setVisible(true);
		});
		
		JButton btnMatrices = new JButton("Matrices");
		btnMatrices.setBounds(309, 140, 100, 30);
		contentPane.add(btnMatrices);
		btnMatrices.addActionListener(e -> {
			new VentanaMatrices().setVisible(true);
		});
		
		JButton btnSistemas = new JButton("Sistemas");
		btnSistemas.setBounds(433, 140, 100, 30);
		contentPane.add(btnSistemas);
		
		JLabel lblNewLabel = new JLabel("Desarrollado por Santiago Papale, Octavio Romero, Leandro Zelaya y Matias Zurita");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 222, 584, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblconQuDesea = new JLabel("Aprete el botón correspondiente a lo que desea trabajar:");
		lblconQuDesea.setHorizontalAlignment(SwingConstants.CENTER);
		lblconQuDesea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblconQuDesea.setBackground(Color.BLACK);
		lblconQuDesea.setBounds(0, 101, 584, 28);
		contentPane.add(lblconQuDesea);
		btnSistemas.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
	}
}
