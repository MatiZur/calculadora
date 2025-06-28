package gui;
import gui.VentanaSistemas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class VentanaNumeros extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNumeros frame = new VentanaNumeros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaNumeros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calculadora");
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu MenuNumeros = new JMenu("Números");
		menuBar.add(MenuNumeros);
		
		JMenuItem NumerosSuma = new JMenuItem("Suma");
		MenuNumeros.add(NumerosSuma);
		
		JMenuItem NumerosResta = new JMenuItem("Resta");
		MenuNumeros.add(NumerosResta);
		
		JMenuItem NumerosMultiplicacion = new JMenuItem("Multiplicación");
		MenuNumeros.add(NumerosMultiplicacion);
		
		JMenuItem NumerosDivision = new JMenuItem("División");
		MenuNumeros.add(NumerosDivision);
		
		JMenuItem NumerosRaiz = new JMenuItem("Raíz");
		MenuNumeros.add(NumerosRaiz);
		
		JMenuItem NumerosPotencia = new JMenuItem("Potencia");
		MenuNumeros.add(NumerosPotencia);
		
		JMenu MenuVectores = new JMenu("Vectores");
		menuBar.add(MenuVectores);
		
		JMenuItem VectoresSuma = new JMenuItem("Suma");
		MenuVectores.add(VectoresSuma);
		
		JMenuItem VectoresResta = new JMenuItem("Resta");
		MenuVectores.add(VectoresResta);
		
		JMenuItem VectoresMultiplicacion = new JMenuItem("Multiplicación por escalar");
		MenuVectores.add(VectoresMultiplicacion);
		
		JMenuItem VectoresProductoE = new JMenuItem("Producto escalar");
		MenuVectores.add(VectoresProductoE);
		
		JMenuItem VectoresProductoV = new JMenuItem("Producto vectorial");
		MenuVectores.add(VectoresProductoV);
		
		JMenu MenuMatrices = new JMenu("Matrices");
		menuBar.add(MenuMatrices);
		
		JMenuItem MatricesSuma = new JMenuItem("Suma");
		MenuMatrices.add(MatricesSuma);
		MatricesSuma.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesResta = new JMenuItem("Resta");
		MenuMatrices.add(MatricesResta);
		MatricesResta.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesMultiplicacion = new JMenuItem("Multiplicación");
		MenuMatrices.add(MatricesMultiplicacion);
		MatricesMultiplicacion.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesMultiplicacionE = new JMenuItem("Multiplicación por escalar");
		MenuMatrices.add(MatricesMultiplicacionE);
		MatricesMultiplicacionE.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesDeterminante = new JMenuItem("Determinante");
		MenuMatrices.add(MatricesDeterminante);
		MatricesDeterminante.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesInversa = new JMenuItem("Inversa");
		MenuMatrices.add(MatricesInversa);
		MatricesInversa.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem MatricesDivision = new JMenuItem("División");
		MenuMatrices.add(MatricesDivision);
		MatricesDivision.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenu MenuSistemas = new JMenu("Sistemas de ecuaciones");
		menuBar.add(MenuSistemas);
		
		JMenuItem Sistemas2x2 = new JMenuItem("Sistema 2 por 2");
		MenuSistemas.add(Sistemas2x2);
		Sistemas2x2.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});
		
		JMenuItem Sistemas3x3 = new JMenuItem("Sistema 3 por 3");
		MenuSistemas.add(Sistemas3x3);
		Sistemas3x3.addActionListener(e -> {
			new VentanaSistemas().setVisible(true);
		});

	}

}
