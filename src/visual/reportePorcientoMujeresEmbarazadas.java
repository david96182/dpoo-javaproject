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

import logica.CMF;

public class reportePorcientoMujeresEmbarazadas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			reportePorcientoMujeresEmbarazadas dialog = new reportePorcientoMujeresEmbarazadas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public reportePorcientoMujeresEmbarazadas() {
		setModal(true);
		setTitle("Reporte por ciento de mujeres embarazadas");
		setBounds(100, 100, 417, 231);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblElPorCiento = new JLabel("El por ciento que representan las mujeres embarazadas:");
			lblElPorCiento.setBounds(47, 26, 361, 14);
			contentPanel.add(lblElPorCiento);
		}
		{
			JLabel lblEnElConsultorio = new JLabel("en el consultorio es de:");
			lblEnElConsultorio.setBounds(137, 51, 139, 14);
			contentPanel.add(lblEnElConsultorio);
		}
		{
			lblNewLabel = new JLabel(CMF.getInstancia().obtenerPorcientoEmbarazadas()+"");
			lblNewLabel.setBounds(173, 76, 62, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("por ciento");
		lblNewLabel_1.setBounds(160, 101, 62, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Para un total de ");
		lblNewLabel_2.setBounds(21, 134, 96, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel(CMF.getInstancia().getMujeresEmbarazadas().size()+"");
		lblNewLabel_3.setBounds(113, 134, 31, 14);
		contentPanel.add(lblNewLabel_3);
		{
			JLabel lblNewLabel_4 = new JLabel("mujeres embarazadas.");
			lblNewLabel_4.setBounds(137, 134, 167, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reportePorcientoMujeresEmbarazadas.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
