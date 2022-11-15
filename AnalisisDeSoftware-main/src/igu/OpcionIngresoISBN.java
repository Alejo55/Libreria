package igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import libreria.LibreriaManager;
import libreria.Libro;

public class OpcionIngresoISBN extends JFrame {// PARA CONSULTA,BAJA,ACTUALIZACION

	private JPanel contentPane;
	private JTextField isbn;

	/**
	 * Create the frame.
	 */
	public OpcionIngresoISBN(String modo) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 336, 93);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ingrese el ISBN del libro:");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(10, 11, 192, 39);
		panel.add(lblNewLabel_1);

		isbn = new JTextField();
		isbn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		isbn.setBounds(193, 19, 123, 20);
		panel.add(isbn);
		isbn.setColumns(10);

		JButton btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (modo.equals("Baja")) {
					Libro libro = new Libro();
					libro.setISBN(isbn.getText());
					Libro borrado = LibreriaManager.darDeBaja(libro);
					if (borrado == null)
						JOptionPane.showMessageDialog(null, "El libro ingresado no existe.");
					else {
						JOptionPane.showMessageDialog(null, "El siguiente libro fue borrado correctamente:\n\n" + borrado);
						dispose();
					}
				}
				if (modo.equals("Actualización")) {
					Libro libro = new Libro();
					libro.setISBN(isbn.getText());
					int pos = LibreriaManager.posicionLibro(libro);
					if(pos >= 0) {
						OpcionActualizacion actualizacion = new OpcionActualizacion(pos);
						actualizacion.setVisible(true);	
						dispose();
					}else
						JOptionPane.showMessageDialog(null, "El libro ingresado no existe.");
				}
				if(modo.equals("Consulta")) {
					Libro libro = new Libro();
					libro.setISBN(isbn.getText());
					libro = LibreriaManager.consultar(libro);
					if(libro != null) {
						JOptionPane.showMessageDialog(null, "El libro consultado es el siguiente:\n\n" + libro);
						dispose();
					}else
						JOptionPane.showMessageDialog(null, "El libro ingresado no existe.");
				}
			}
		});
		btnCargar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCargar.setBounds(124, 51, 104, 31);
		panel.add(btnCargar);
	}
}
