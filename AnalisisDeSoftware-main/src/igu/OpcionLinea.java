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

public class OpcionLinea extends JFrame {

	private JPanel contentPane;
	private JTextField txtActualizado;

	/**
	 * Create the frame.
	 */
	public OpcionLinea(int campoAModif, int posLibro) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 296, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese la correspondiente actualizaci\u00F3n:");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.ITALIC, 16));
		lblNewLabel_1_1.setBounds(10, 11, 280, 31);
		panel.add(lblNewLabel_1_1);
		
		txtActualizado = new JTextField();
		txtActualizado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtActualizado.setColumns(10);
		txtActualizado.setBounds(10, 46, 270, 21);
		panel.add(txtActualizado);
		
		JButton btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibreriaManager.modificar(posLibro, campoAModif, txtActualizado.getText());
				JOptionPane.showMessageDialog(null, "El libro fue actualizado correctamente.");
				dispose();
			}
		});
		btnCargar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCargar.setBounds(93, 78, 104, 31);
		panel.add(btnCargar);
	}

}
