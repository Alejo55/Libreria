package igu;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OpcionActualizacion extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OpcionActualizacion(int pos) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 421, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 409, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblActualizacin = new JLabel("ACTUALIZACI\u00D3N");
		lblActualizacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizacin.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		lblActualizacin.setBounds(66, 11, 279, 50);
		panel.add(lblActualizacin);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione el campo a modificar:");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.ITALIC, 19));
		lblNewLabel_1.setBounds(10, 64, 279, 43);
		panel.add(lblNewLabel_1);
		
		JButton btnTtulo = new JButton("T\u00CDTULO");
		btnTtulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionLinea modif = new OpcionLinea(1, pos);
				modif.setVisible(true);
				dispose();
			}
		});
		btnTtulo.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnTtulo.setBounds(20, 111, 174, 43);
		panel.add(btnTtulo);
		
		JButton btnAutor = new JButton("AUTOR");
		btnAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionLinea modif = new OpcionLinea(2, pos);
				modif.setVisible(true);
				dispose();
			}
		});
		btnAutor.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnAutor.setBounds(217, 111, 174, 43);
		panel.add(btnAutor);
		
		JButton btnEditorial = new JButton("EDITORIAL");
		btnEditorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionLinea modif = new OpcionLinea(3, pos);
				modif.setVisible(true);
				dispose();
			}
		});
		btnEditorial.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnEditorial.setBounds(20, 165, 174, 43);
		panel.add(btnEditorial);
		
		JButton btnBaja = new JButton("EDICI\u00D3N");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionLinea modif = new OpcionLinea(4, pos);
				modif.setVisible(true);
				dispose();
			}
		});
		btnBaja.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnBaja.setBounds(217, 165, 174, 43);
		panel.add(btnBaja);
		
		JButton btnAoDePublicacin = new JButton("A\u00D1O DE PUBLICACI\u00D3N");
		btnAoDePublicacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionLinea modif = new OpcionLinea(5, pos);
				modif.setVisible(true);
				dispose();
			}
		});
		btnAoDePublicacin.setFont(new Font("BankGothic Md BT", Font.BOLD, 20));
		btnAoDePublicacin.setBounds(49, 224, 310, 43);
		panel.add(btnAoDePublicacin);
	}

}
