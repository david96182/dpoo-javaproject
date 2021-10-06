package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logica.CMF;

public class agregarNuevaEnfermedad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton Registrar;
	private JTextPane nombreEnfermedad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			agregarNuevaEnfermedad dialog = new agregarNuevaEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public agregarNuevaEnfermedad() {
		setTitle("Registrar Nueva Enfermedad");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 480, 153);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Introduzca el nombre de la enfermedad a registrar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(85, 18, 332, 26);
		contentPanel.add(lblNewLabel);

		nombreEnfermedad = new JTextPane();
		
		nombreEnfermedad.setBorder(new LineBorder(new Color(0, 0, 0)));
		nombreEnfermedad.setBounds(116, 44, 257, 25);
		contentPanel.add(nombreEnfermedad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				Registrar = new JButton("Registrar");
				Registrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = nombreEnfermedad.getText();
						if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
							JOptionPane.showMessageDialog(agregarNuevaEnfermedad.this, "Debe introducirse un nombre parar poder registrarse","Error en los datos",2);
						}
						else{
							if(CMF.getInstancia().registrarEnfermedad(nombre)){
								JOptionPane.showMessageDialog(agregarNuevaEnfermedad.this, "Enfermedad Registrada Correctamente","Enfermedad Registrada",-1);
								agregarNuevaEnfermedad.this.dispose();
							}
							else
								JOptionPane.showMessageDialog(agregarNuevaEnfermedad.this, "La enfermedad ya se encuentra regisrada","Error en los datos",2);
						}
					}
				});
				Registrar.setActionCommand("OK");
				buttonPane.add(Registrar);
				getRootPane().setDefaultButton(Registrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						agregarNuevaEnfermedad.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
