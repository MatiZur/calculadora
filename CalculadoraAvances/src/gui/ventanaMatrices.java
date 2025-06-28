package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ventanaMatrices extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTam1;
	private JTextField txtTam2;
	private JTable tableMat2;
	private JTable tableMat1;
	private JLabel lblHola;
	private TableModel modeloMat1;
	private TableModel modeloMat2;

	/**
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaMatrices frame = new ventanaMatrices();
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
	public ventanaMatrices() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Matrices");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTam1 = new JLabel("Tamaño matriz 1:");
		lblTam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTam1 = new JTextField();
		txtTam1.setColumns(10);
		
		txtTam2 = new JTextField();
		txtTam2.setColumns(10);
		
		JLabel lblTam2 = new JLabel("Tamaño matriz 2:");
		lblTam2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnTam = new JButton("Ingresar tamaños");
		btnTam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int val1_0_0 = Integer.parseInt((String) modeloMat1.getValueAt(0, 0));
				int val2_0_0 = Integer.parseInt((String) modeloMat2.getValueAt(0, 0));
				int suma = val1_0_0 + val2_0_0;
				lblHola.setText(Integer.toString(suma));
			}
		});
		
		tableMat2 = new JTable();
		tableMat2.setModel(new DefaultTableModel(4, 4));
		
		modeloMat2 = tableMat2.getModel();

		tableMat1 = new JTable();
		tableMat1.setModel(new DefaultTableModel(4, 4));
		
		modeloMat1 = tableMat1.getModel();
		
		lblHola = new JLabel("Hola");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(153)
							.addComponent(btnTam))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTam1)
									.addGap(18)
									.addComponent(txtTam1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTam2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtTam2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(tableMat1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tableMat2, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(199)
							.addComponent(lblHola)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTam1)
						.addComponent(txtTam1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTam2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTam2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnTam)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tableMat2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tableMat1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblHola)
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);
	}
}