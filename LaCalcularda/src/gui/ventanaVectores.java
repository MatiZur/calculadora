package gui;

import Operaciones.Vectores;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;

public class ventanaVectores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblResultado_1;
	   private JTextField txtTam;
	   private JTextField txtValor1;
	   private int tam;
	   private int index1 = 0;
	   private int index2 = 0;
	   private int cont1 = 1;
	   private int cont2 = 1;
	   private float[] vector1;
	   private float[] vector2;
	   private float escalar;
	   private JTextField txtValor2;
	   private float[] res;
	   private float prodEsc;
	   private int opcion;

	public ventanaVectores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VECTORES");
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 19));
		lblNewLabel.setBounds(287, 0, 118, 38);
		contentPane.add(lblNewLabel);
		
		JPanel panelTam = new JPanel();
		panelTam.setBounds(204, 98, 318, 45);
		contentPane.add(panelTam);
		
		JLabel lblTam1 = new JLabel("Tamaño =>");
		lblTam1.setBounds(227, 112, 66, 14);
		panelTam.add(lblTam1);
		
		txtTam = new JTextField();
		txtTam.setBounds(303, 109, 86, 20);
		panelTam.add(txtTam);
		txtTam.setColumns(10);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(80, 142, 532, 100);
		panel1.setBorder(BorderFactory.createTitledBorder("Vector 1"));
		contentPane.add(panel1);

		JLabel lblValor1 = new JLabel("Valor 1");
		lblValor1.setBounds(156, 20, 57, 14);
		panel1.add(lblValor1);

		JTextField txtValor1 = new JTextField();
		txtValor1.setBounds(223, 17, 86, 20);
		txtValor1.setColumns(10);
		panel1.add(txtValor1);

		JButton btnValor1 = new JButton("INGRESAR");
		btnValor1.setBounds(319, 16, 97, 23);
		panel1.add(btnValor1);

		JLabel lblMsjTam1 = new JLabel("Limite de tamaño ya alcanzado");
		lblMsjTam1.setVisible(false);
		lblMsjTam1.setForeground(new Color(255, 0, 0));
		lblMsjTam1.setBounds(197, 45, 185, 14);
		panel1.add(lblMsjTam1);

		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(80, 252, 532, 100);
		panel2.setBorder(BorderFactory.createTitledBorder("Vector 2"));
		contentPane.add(panel2);

		JLabel lblValor2 = new JLabel("Valor 1");
		lblValor2.setBounds(158, 20, 66, 14);
		panel2.add(lblValor2);

		JTextField txtValor2 = new JTextField();
		txtValor2.setBounds(222, 17, 86, 20);
		txtValor2.setColumns(10);
		panel2.add(txtValor2);

		JButton btnValor2 = new JButton("INGRESAR");
		btnValor2.setBounds(318, 16, 100, 23);
		panel2.add(btnValor2);

		JLabel lblMsjTam2 = new JLabel("Limite de tamaño ya alcanzado");
		lblMsjTam2.setVisible(false);
		lblMsjTam2.setForeground(new Color(255, 0, 0));
		lblMsjTam2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMsjTam2.setBounds(207, 45, 166, 14);
		panel2.add(lblMsjTam2);
		
		JPanel panelValores1 = new JPanel();
		panelValores1.setLayout(new FlowLayout()); 
		panelValores1.setBounds(10, 70, 512, 25); 
		panel1.add(panelValores1);

		JPanel panelValores2 = new JPanel();
		panelValores2.setLayout(new FlowLayout());
		panelValores2.setBounds(10, 70, 512, 25);
		panel2.add(panelValores2);
		
		panel1.setVisible(false);
		panel2.setVisible(false);
		panelTam.setVisible(false);
		
		
		JButton btnTam = new JButton("INGRESAR");
		btnTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(opcion==1 || opcion==2 || opcion==4 || opcion==5)
				{
				tam=Integer.parseInt(txtTam.getText());
				vector1 = new float[tam];
				vector2 = new float[tam];
				panel1.setVisible(true);
				panel2.setVisible(true);
				}
				if(opcion==3)
				{
					tam=Integer.parseInt(txtTam.getText());
					vector1 = new float[tam];
					panel1.setVisible(true);
					panel2.setBorder(BorderFactory.createTitledBorder("Escalar"));
					panelValores2.setVisible(false);
					lblValor2.setText("Valor ");
					panel2.setVisible(true);
				}
			}
		});
		
		btnTam.setBounds(399, 108, 97, 23);
		panelTam.add(btnTam);
		
		JButton btnSuma = new JButton("Suma");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTam.setVisible(true);
				opcion=1;
			}
		});
		btnSuma.setBounds(69, 45, 89, 23);
		contentPane.add(btnSuma);
		
		JButton btnResta = new JButton("Resta");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTam.setVisible(true);
				opcion=2;
			}
		});
		btnResta.setBounds(168, 45, 89, 23);
		contentPane.add(btnResta);
		
		JButton btnMultiplicarPorEscalar = new JButton("Multiplicar por escalar");
		btnMultiplicarPorEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTam.setVisible(true);
				opcion=3;
			}
		});
		btnMultiplicarPorEscalar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnMultiplicarPorEscalar.setBounds(274, 45, 143, 24);
		contentPane.add(btnMultiplicarPorEscalar);
		
		JButton btnProductoEscalar = new JButton("Producto Escalar");
        btnProductoEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTam.setVisible(true);
				opcion=4;
			}
		});
		btnProductoEscalar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnProductoEscalar.setBounds(427, 45, 125, 23);
		contentPane.add(btnProductoEscalar);
		
		JButton btnProductoVectorial = new JButton("Producto Vectorial");
		btnProductoVectorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTam.setVisible(true);
				opcion=5;
			}
		});
		btnProductoVectorial.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnProductoVectorial.setBounds(562, 45, 125, 23);
		contentPane.add(btnProductoVectorial);
		
		
		JPanel panelRes = new JPanel();
		panelRes.setLayout(new FlowLayout());
		panelRes.setBounds(89, 428, 512, 25);
		contentPane.add(panelRes);
		
		JLabel lblRes = new JLabel("Resultado:");
		lblRes.setVisible(false);
		contentPane.add(lblRes);
		lblRes.setBounds(89, 411, 69, 14);
		
		btnValor1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (index1 < tam) {
		            float valor = Float.parseFloat(txtValor1.getText());
		            vector1[index1] = valor;

		            JTextField txt = new JTextField(String.valueOf(valor));
		            txt.setEditable(false);
		            txt.setColumns(4);
		            panelValores1.add(txt);
		            panelValores1.revalidate();
		            panelValores1.repaint();

		            txtValor1.setText("");
		            lblValor1.setText("Valor " + (index1 + 2));
		            index1++;
		        } else {	        
		            lblMsjTam1.setVisible(true);
		            new javax.swing.Timer(3000, et -> lblMsjTam1.setVisible(false)).start();
		        }
		    }
		});
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.setVisible(false);
		contentPane.add(btnCalc);
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				res=new float[tam];
				if(opcion==1)
				{
				res=Vectores.sumaVectores(vector1, vector2, tam);
				for(int i=0;i<tam;i++)
				{
					JTextField txt = new JTextField(String.valueOf(res[i]));
					txt.setEditable(false);
		            txt.setColumns(4);
		            panelRes.add(txt);
		            panelRes.revalidate();
		            panelRes.repaint();
				}
				}
				if(opcion==2)
				{
					res=Vectores.restaVectores(vector1, vector2, tam);
					for(int i=0;i<tam;i++)
					{
						JTextField txt = new JTextField(String.valueOf(res[i]));
						txt.setEditable(false);
			            txt.setColumns(4);
			            panelRes.add(txt);
			            panelRes.revalidate();
			            panelRes.repaint();
					}
				}
				if(opcion==3)
				{
					res=Vectores.multiEscalar(vector1, tam, escalar);
					JTextField txt = new JTextField(String.valueOf(prodEsc));
					txt.setEditable(false);
		            txt.setColumns(4);
		            panelRes.add(txt);
		            panelRes.revalidate();
		            panelRes.repaint();
				}
				if(opcion==4)
				{
					prodEsc=Vectores.productoEscalar(vector1, vector2, tam);
						JTextField txt = new JTextField(String.valueOf(prodEsc));
						txt.setEditable(false);
			            txt.setColumns(4);
			            panelRes.add(txt);
			            panelRes.revalidate();
			            panelRes.repaint();
				}
				if(opcion==5)
				{
					res=Vectores.productoVectorial(vector1, vector2);
					for(int i=0;i<tam;i++)
					{
						JTextField txt = new JTextField(String.valueOf(res[i]));
						txt.setEditable(false);
			            txt.setColumns(4);
			            panelRes.add(txt);
			            panelRes.revalidate();
			            panelRes.repaint();
					}
				}
			}
		});
		btnCalc.setBounds(298, 363, 97, 23);
		
		btnValor2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(opcion != 3)
		    	{		    		
		        if (index2 < tam) {
		            float valor = Float.parseFloat(txtValor2.getText());
		            vector2[index2] = valor;

		            JTextField txt = new JTextField(String.valueOf(valor));
		            txt.setEditable(false);
		            txt.setColumns(4);
		            panelValores2.add(txt);
		            panelValores2.revalidate();
		            panelValores2.repaint();

		            txtValor2.setText("");
		            lblValor2.setText("Valor " + (index2 + 2));
		            index2++;
		            if(index2==tam)
		            {
		            	lblRes.setVisible(true);
		            	btnCalc.setVisible(true);
		            }
		        } else {
		            lblMsjTam2.setVisible(true);
		            new javax.swing.Timer(3000, et -> lblMsjTam2.setVisible(false)).start();
		        }
		    }else if(opcion==3)
		    {
		    	escalar=Integer.parseInt(txtValor2.getText());
		    	JTextField txt = new JTextField(String.valueOf(escalar));
	            txt.setEditable(false);
	            txt.setColumns(4);
	            panelValores2.add(txt);
	            panelValores2.revalidate();
	            panelValores2.repaint();
		    }
		    }
		});
		
 }
}
