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

public class Creditos extends JDialog {

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
			Creditos dialog = new Creditos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Creditos() {
		setResizable(false);
		setModal(true);
		setTitle("Datos de los Autores");
		setBounds(100, 100, 316, 170);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblAutores = new JLabel("Autores:");
		lblAutores.setBounds(20, 24, 56, 14);
		contentPanel.add(lblAutores);
		
		JLabel lblNewLabel = new JLabel("David Puerta Mart\u00EDn #23");
		lblNewLabel.setBounds(86, 24, 277, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jorge Luis P\u00E9rez Enriquez #22");
		lblNewLabel_1.setBounds(86, 49, 208, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblTutor = new JLabel("Tutor:");
		lblTutor.setBounds(32, 74, 46, 14);
		contentPanel.add(lblTutor);
		
		JLabel lblDocSoniaPerez = new JLabel("Dr. Sonia P\u00E9rez Lovelle");
		lblDocSoniaPerez.setBounds(86, 74, 154, 14);
		contentPanel.add(lblDocSoniaPerez);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Creditos.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
