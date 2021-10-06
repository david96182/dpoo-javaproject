package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;

public class Ayuda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ayuda dialog = new Ayuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setModal(true);
		setTitle("Ayuda");
		setBounds(100, 100, 430, 231);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextPane txtpnAplicacinDesarrolladaCon = new JTextPane();
		txtpnAplicacinDesarrolladaCon.setText("Aplicaci\u00F3n desarrollada con el fin de automatizar un consultorio m\u00E9dico de la familia, haciendo m\u00E1s c\u00F3moda la geti\u00F3n de las historias cl\u00EDnicas de los pacientes. Se muestra la informaci\u00F3n mediante tablas din\u00E1micas de las historias cl\u00EDnicas, los pacientes y las hojas de cargo. Contiene varios reportes que muestran informaci\u00F3n espec\u00EDfica sobre el consultorio. Mediante los men\u00FAes se puede visualizar las principales funcionalidades de la aplicaci\u00F3n.");
		txtpnAplicacinDesarrolladaCon.setForeground(Color.BLACK);
		txtpnAplicacinDesarrolladaCon.setEditable(false);
		txtpnAplicacinDesarrolladaCon.setBounds(10, 11, 394, 127);
		contentPanel.add(txtpnAplicacinDesarrolladaCon);
		
		JLabel lblVersin = new JLabel("Versi\u00F3n 0.1");
		lblVersin.setBounds(10, 149, 76, 14);
		contentPanel.add(lblVersin);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Ayuda.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
