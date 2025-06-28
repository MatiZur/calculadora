package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import operaciones.OperacionesSistemas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSistemas extends JFrame{

	private JPanel contentPane;
	private JLabel lblSistemas3;
	private JTextField txtX1;
	private JTextField txtY1;
	private JTextField txtZ1;
	private JTextField txtR1;
	private JTextField txtX2;
	private JTextField txtY2;
	private JTextField txtZ2;
	private JTextField txtR2;
	private JTextField txtX3;
	private JTextField txtY3;
	private JTextField txtZ3;
	private JTextField txtR3;
	private JLabel lblX1;
	private JLabel lblY1;
	private JLabel lblZ1;
	private JLabel lblR1;
	private JLabel lblX2;
	private JLabel lblY2;
	private JLabel lblZ2;
	private JLabel lblR2;
	private JLabel lblX3;
	private JLabel lblY3;
	private JLabel lblZ3;
	private JLabel lblR3;
	private JButton btnCalcular;
	private JLabel lblXE;
	private JLabel lblYE;
	private JLabel lblZE;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblZ;

	OperacionesSistemas operaciones;
	
	public VentanaSistemas(){
		operaciones = new OperacionesSistemas();
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema 3 por 3");
		setBounds(100, 100, 498, 323);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblSistemas3 = new JLabel("Sistema 3 por 3");
		lblSistemas3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemas3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		txtY1 = new JTextField();
		txtY1.setHorizontalAlignment(SwingConstants.CENTER);
		txtY1.setColumns(10);
		
		lblY1 = new JLabel("y");
		lblY1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtZ1 = new JTextField();
		txtZ1.setHorizontalAlignment(SwingConstants.CENTER);
		txtZ1.setColumns(10);
		
		lblZ1 = new JLabel("z");
		lblZ1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtY2 = new JTextField();
		txtY2.setHorizontalAlignment(SwingConstants.CENTER);
		txtY2.setColumns(10);
		
		lblY2 = new JLabel("y");
		lblY2.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtZ2 = new JTextField();
		txtZ2.setHorizontalAlignment(SwingConstants.CENTER);
		txtZ2.setColumns(10);
		
		lblZ2 = new JLabel("z");
		lblZ2.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtX2 = new JTextField();
		txtX2.setHorizontalAlignment(SwingConstants.CENTER);
		txtX2.setColumns(10);
		
		lblX2 = new JLabel("x");
		lblX2.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtY3 = new JTextField();
		txtY3.setHorizontalAlignment(SwingConstants.CENTER);
		txtY3.setColumns(10);
		
		lblY3 = new JLabel("y");
		lblY3.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtZ3 = new JTextField();
		txtZ3.setHorizontalAlignment(SwingConstants.CENTER);
		txtZ3.setColumns(10);
		
		lblZ3 = new JLabel("z");
		lblZ3.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtX3 = new JTextField();
		txtX3.setHorizontalAlignment(SwingConstants.CENTER);
		txtX3.setColumns(10);
		
		lblX3 = new JLabel("x");
		lblX3.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblX1 = new JLabel("x");
		lblX1.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtX1 = new JTextField();
		txtX1.setHorizontalAlignment(SwingConstants.CENTER);
		txtX1.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularSistema3();
			}
		});
		
		lblR1 = new JLabel("=");
		lblR1.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblR2 = new JLabel("=");
		lblR2.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblR3 = new JLabel("=");
		lblR3.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtR1 = new JTextField();
		txtR1.setHorizontalAlignment(SwingConstants.CENTER);
		txtR1.setColumns(10);
		
		txtR2 = new JTextField();
		txtR2.setHorizontalAlignment(SwingConstants.CENTER);
		txtR2.setColumns(10);
		
		txtR3 = new JTextField();
		txtR3.setHorizontalAlignment(SwingConstants.CENTER);
		txtR3.setColumns(10);
		
		lblXE = new JLabel("x =");
		lblXE.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblYE = new JLabel("y =");
		lblYE.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblZE = new JLabel("z =");
		lblZE.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblX = new JLabel(" ");
		
		lblY = new JLabel(" ");
		
		lblZ = new JLabel(" ");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblSistemas3, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblZE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblZ, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblYE, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblY, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtX3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblX3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtY3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalcular)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblY3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtZ3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblZ3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblR3, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtR3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtX2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblX2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(txtY2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblY2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(txtZ2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblZ2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(txtX1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblX1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(txtY1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblY1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(txtZ1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addGap(4)
											.addComponent(lblZ1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
									.addGap(26))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblXE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblX, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblR1)
									.addGap(18)
									.addComponent(txtR1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblR2, GroupLayout.PREFERRED_SIZE, 8, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtR2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSistemas3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtZ1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblZ1)
								.addComponent(lblR1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtR1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtY1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY1))
						.addComponent(txtX1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX1)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtX2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX2))
						.addComponent(txtY2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY2))
						.addComponent(txtZ2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblZ2))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblR2)
							.addComponent(txtR2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtX3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX3))
						.addComponent(txtY3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY3))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtZ3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtR3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblZ3)
							.addComponent(lblR3)))
					.addGap(18)
					.addComponent(btnCalcular)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXE)
						.addComponent(lblX))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYE)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblZE)
						.addComponent(lblZ))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void calcularSistema3(){
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
		float[] variables = operaciones.sistema3(x1, y1, z1, r1, x2, y2, z2, r2, x3, y3, z3, r3);
		lblX.setText(Float.toString(variables[0]));
		lblY.setText(Float.toString(variables[1]));
		lblZ.setText(Float.toString(variables[2]));
		return;
	}
}