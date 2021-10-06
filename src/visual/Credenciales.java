package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import auxiliar.Seguridad;
import java.awt.Toolkit;

public class Credenciales extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblCredencialesIncorrectas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Credenciales dialog = new Credenciales(null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Credenciales(final Autenticar auth,final boolean ventana){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Credenciales.class.getResource("/Images/icons8_Key_64.png")));
		
		
		setModal(true);
		if(ventana)
			setTitle("Autenticaci\u00F3n Médico");
		else
			setTitle("Autenticaci\u00F3n Enfermera");
		setBounds(100, 100, 358, 193);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Introduzca las credenciales de acceso:");
			lblNewLabel.setBounds(73, 10, 259, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setBounds(124, 35, 122, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(10, 38, 75, 14);
			contentPanel.add(lblUsuario);
		}

		passwordField = new JPasswordField();
		passwordField.setBounds(124, 68, 122, 20);
		contentPanel.add(passwordField);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(10, 71, 100, 14);
		contentPanel.add(lblContrasea);

		lblCredencialesIncorrectas = new JLabel("Credenciales Incorrectas");
		lblCredencialesIncorrectas.setForeground(Color.RED);
		lblCredencialesIncorrectas.setVisible(false);
		lblCredencialesIncorrectas.setBounds(108, 99, 158, 14);
		contentPanel.add(lblCredencialesIncorrectas);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.setMnemonic('I');
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Seguridad segur = new Seguridad();
						String nombre = textField.getText();
						textField.setText("");
						String contra = new String(passwordField.getPassword());
						passwordField.setText("");
						if(ventana){
							if(segur.accesoMed(nombre,contra)){
								Credenciales.this.setVisible(false);
								auth.setVisible(false);
								Ventana_Medico vent = new Ventana_Medico();
								vent.setVisible(true);
							}
							else
								lblCredencialesIncorrectas.setVisible(true);
						}
						else{
							if(segur.accesoEnf(nombre, contra)){
								Credenciales.this.setVisible(false);
								auth.setVisible(false);
								Ventana_Enfermera ventenf = new Ventana_Enfermera();
								ventenf.setVisible(true);
							}
							else
								lblCredencialesIncorrectas.setVisible(true);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setMnemonic('C');
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Credenciales.this.setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
/*
 Seguridad segur = new Seguridad();
						String nombre = textField.getText();
						textField.setText("");
						String contra = new String(passwordField.getPassword());
						passwordField.setText("");
						Autenticar aut = new Autenticar();
						if(ventana){
							if(segur.accesoMed(nombre,contra)){
								Credenciales.this.setVisible(false);
								Ventana_Medico vent = new Ventana_Medico();
								vent.setVisible(true);
							}
							else
								lblCredencialesIncorrectas.setVisible(true);
						}
						else{
							if(segur.accesoEnf(nombre, contra)){
								Credenciales.this.setVisible(false);
								Ventana_Enfermera ventenf = new Ventana_Enfermera();
								ventenf.setVisible(true);
							}
							else
								lblCredencialesIncorrectas.setVisible(true);
						}
 */
