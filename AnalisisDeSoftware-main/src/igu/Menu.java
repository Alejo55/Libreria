package igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import libreria.LibreriaManager;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Menu() {		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 559, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 545, 383);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEN\u00DA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblNewLabel.setBounds(182, 11, 185, 57);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Elija la operaci\u00F3n a realizar:");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(10, 79, 233, 43);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ALTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionAlta alta = new OpcionAlta();
				alta.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnNewButton.setBounds(20, 133, 234, 43);
		panel.add(btnNewButton);
		
		JButton btnConsulta = new JButton("CONSULTA");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibreriaManager.esArchivoVacio())
					JOptionPane.showMessageDialog(null, "El archivo no contiene registros.");
				else {
					OpcionIngresoISBN consulta= new OpcionIngresoISBN("Consulta");
					consulta.setVisible(true);					
				}
			}
		});
		btnConsulta.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnConsulta.setBounds(300, 133, 234, 43);
		panel.add(btnConsulta);
		
		JButton btnActualizacin = new JButton("ACTUALIZACI\u00D3N");
		btnActualizacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibreriaManager.esArchivoVacio())
					JOptionPane.showMessageDialog(null, "El archivo no contiene registros.");
				else {
					OpcionIngresoISBN actualizacion= new OpcionIngresoISBN("Actualización");
					actualizacion.setVisible(true);
				}
			}
		});
		btnActualizacin.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnActualizacin.setBounds(21, 187, 233, 43);
		panel.add(btnActualizacin);
		
		JButton btnBaja = new JButton("BAJA");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibreriaManager.esArchivoVacio())
					JOptionPane.showMessageDialog(null, "El archivo no contiene registros.");
				else {
					OpcionIngresoISBN baja= new OpcionIngresoISBN("Baja");
					baja.setVisible(true);
				}
			}
		});
		btnBaja.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnBaja.setBounds(300, 187, 234, 43);
		panel.add(btnBaja);
		
		JButton btnOrdenar = new JButton("ORDENAR");
		btnOrdenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibreriaManager.esArchivoVacio())
					JOptionPane.showMessageDialog(null, "El archivo no contiene registros.");
				else {
					LibreriaManager.ordenarRegistros();
					JOptionPane.showMessageDialog(null, "Los libros fueron ordenados correctamente.");
				}
			}
		});
		btnOrdenar.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnOrdenar.setBounds(20, 241, 234, 43);
		panel.add(btnOrdenar);
		
		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(LibreriaManager.esArchivoVacio())
					JOptionPane.showMessageDialog(null, "El archivo no contiene registros.");
				else {
					OpcionListar lista = new OpcionListar();
					lista.setVisible(true);
				}
			}
		});
		btnListar.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnListar.setBounds(300, 241, 234, 43);
		panel.add(btnListar);
		
		JButton btnListar_1 = new JButton("SALIR");
		btnListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnListar_1.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnListar_1.setBounds(159, 309, 234, 43);
		panel.add(btnListar_1);
	}
}
