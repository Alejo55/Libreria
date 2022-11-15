package igu;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import libreria.LibreriaManager;

public class OpcionListar extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public OpcionListar() {
		setTitle("Listado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 370, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 356, 368);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 356, 368);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textArea.setText(LibreriaManager.listar());
		textArea.setSelectionStart(0);
		textArea.setSelectionEnd(0);
	}
}
