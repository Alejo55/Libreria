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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import libreria.LibreriaManager;
import libreria.Libro;

public class OpcionAlta extends JFrame {

	private JPanel contentPane;
	private JTextField textAutor;
	private JTextField textEdicion;
	private JTextField textIsbn;
	private JTextField textTitulo;
	private JTextField textEditorial;
	private JTextField textAnio;

	/**
	 * Create the frame.
	 */
	public OpcionAlta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 469, 393);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlta = new JLabel("ALTA");
		lblAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlta.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblAlta.setBounds(126, 11, 185, 50);
		panel.add(lblAlta);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese los siguientes valores:");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 68, 245, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("-ISBN:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 122, 88, 28);
		panel.add(lblNewLabel);
		
		JLabel lblautor = new JLabel("-AUTOR:");
		lblautor.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblautor.setBounds(10, 184, 88, 28);
		panel.add(lblautor);
		
		JLabel lblNewLabel_2_1 = new JLabel("-EDICI\u00D3N:");
		lblNewLabel_2_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(10, 245, 102, 28);
		panel.add(lblNewLabel_2_1);
		
		textAutor = new JTextField();
		textAutor.setBounds(20, 208, 144, 20);
		panel.add(textAutor);
		textAutor.setColumns(10);
		
		textEdicion = new JTextField();
		textEdicion.setColumns(10);
		textEdicion.setBounds(20, 269, 144, 20);
		panel.add(textEdicion);
		
		textIsbn = new JTextField();
		textIsbn.setColumns(10);
		textIsbn.setBounds(20, 145, 144, 20);
		panel.add(textIsbn);
		
		JLabel lblttulo = new JLabel("-T\u00CDTULO:");
		lblttulo.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblttulo.setBounds(247, 122, 117, 28);
		panel.add(lblttulo);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(257, 145, 144, 20);
		panel.add(textTitulo);
		
		JLabel lbleditorial = new JLabel("-EDITORIAL:");
		lbleditorial.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lbleditorial.setBounds(247, 184, 117, 28);
		panel.add(lbleditorial);
		
		textEditorial = new JTextField();
		textEditorial.setColumns(10);
		textEditorial.setBounds(257, 208, 144, 20);
		panel.add(textEditorial);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("-A\u00D1O DE PUBLICACI\u00D3N:");
		lblNewLabel_2_1_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(247, 245, 213, 28);
		panel.add(lblNewLabel_2_1_1);
		
		textAnio = new JTextField();
		textAnio.setColumns(10);
		textAnio.setBounds(257, 269, 144, 20);
		panel.add(textAnio);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Libro libro = new Libro();
				libro.setISBN(textIsbn.getText());
				libro.setTitulo(textTitulo.getText());
				libro.setAutor(textAutor.getText());
				libro.setEditorial(textEditorial.getText());
				libro.setEdicion(Integer.parseInt(textEdicion.getText()));
				libro.setAnno_de_publicacion(Integer.parseInt(textAnio.getText()));

				Libro existente = LibreriaManager.darDeAlta(libro);
				if(existente == null) {
					JOptionPane.showMessageDialog(null, "El libro fue agregado correctamente.");
					dispose();
				}
				else
					JOptionPane.showMessageDialog(null, "El libro ingresado ya existe y es el siguiente:\n\n" + existente);				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(137, 323, 144, 43);
		panel.add(btnNewButton);
	}

}
