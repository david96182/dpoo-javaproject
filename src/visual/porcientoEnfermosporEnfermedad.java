package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import logica.CMF;
import logica.Enfermedad;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class porcientoEnfermosporEnfermedad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox;
	/**
	 * @wbp.nonvisual location=421,59
	 */
	private final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			porcientoEnfermosporEnfermedad dialog = new porcientoEnfermosporEnfermedad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public porcientoEnfermosporEnfermedad() {
		setTitle("Por cientos de enfermos por enfermedad");
		setModal(true);
		setBounds(100, 100, 450, 156);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione Enfermedad:");
		lblNewLabel.setBounds(10, 11, 147, 21);
		contentPanel.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblNewLabel_2.setText(comboBox.getSelectedItem().toString()+" es:");
				lblNewLabel_3.setVisible(true);
				try {
					lblNewLabel_3.setText(CMF.getInstancia().obtenerPorcientoconEnfermedad(comboBox.getSelectedItem().toString())+" por ciento");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboBox.setBounds(153, 11, 109, 20);
		contentPanel.add(comboBox);
		
		lblNewLabel_1 = new JLabel("El por ciento que representan los enfermos con ");
		lblNewLabel_1.setBounds(20, 43, 283, 14);
		contentPanel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(286, 43, 126, 14);
		lblNewLabel_2.setVisible(false);
		contentPanel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(149, 68, 126, 14);
		lblNewLabel_3.setVisible(false);
		contentPanel.add(lblNewLabel_3);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						porcientoEnfermosporEnfermedad.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarComboBox();
	}
	public void cargarComboBox(){
		ArrayList<Enfermedad> enfes = CMF.getInstancia().getEnfermedades();
		for(int i = 0;i < enfes.size();i++){
			defaultComboBoxModel.addElement(enfes.get(i).getNombre_Enf());
		}
		comboBox.setModel(defaultComboBoxModel);
	}
}
