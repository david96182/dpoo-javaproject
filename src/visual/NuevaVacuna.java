package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.CMF;

public class NuevaVacuna extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextFieldMejorado nombreVacuna;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			NuevaVacuna dialog = new NuevaVacuna();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public NuevaVacuna(final RegistrarVacuna registrar) {
		setTitle("Registrar Nuevo Tipo de Vacuna");
		setBounds(100, 100, 450, 168);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		nombreVacuna = new JTextFieldMejorado();
		nombreVacuna.setLimite(1000);
		nombreVacuna.setBounds(91, 37, 234, 29);
		contentPanel.add(nombreVacuna);
		
		JLabel lblNombreDeLa = new JLabel("Introduzca el nombre de la Vacuna:");
		lblNombreDeLa.setBounds(119, 12, 206, 14);
		contentPanel.add(lblNombreDeLa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						if(nombreVacuna.getText().isEmpty())
							JOptionPane.showInternalMessageDialog(NuevaVacuna.this,"Debe introducirse un nombre");
						else if(CMF.getInstancia().registrarVacuna(nombreVacuna.getText()))
						{
							JOptionPane.showMessageDialog(NuevaVacuna.this, "Registrado Correctamente");
							NuevaVacuna.this.dispose();
							registrar.cargarListaVacunas();
						}
						else
							JOptionPane.showMessageDialog(NuevaVacuna.this, "Ya se encuentra registrado");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						NuevaVacuna.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}