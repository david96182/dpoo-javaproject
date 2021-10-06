package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import logica.CMF;
import logica.Paciente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class BuscarParaVacunar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextFieldMejorado IDpaciente;
	private JButton okButton;
	
	private CMF cmf = CMF.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BuscarParaVacunar dialog = new BuscarParaVacunar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarParaVacunar() 
	{
		setTitle("Buscar Paciente para vacuna");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 335, 141);
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		this.setLocationRelativeTo(null);
		{
			JLabel lblIntroduzcaElId = new JLabel("Introduzca el carn\u00E9 del paciente a vacunar:");
			lblIntroduzcaElId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblIntroduzcaElId.setBounds(36, 11, 332, 14);
			contentPanel.add(lblIntroduzcaElId);
		}

		IDpaciente = new JTextFieldMejorado();
		IDpaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) || IDpaciente.getText().length()>10) 
				{
					getToolkit().beep();
					arg0.consume();

				}
				if(arg0.getKeyChar()== KeyEvent.VK_ENTER)
					okButton.doClick();
			}
		});
		IDpaciente.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				if(!IDpaciente.getText().isEmpty()){
					okButton.setEnabled(true);
				}
				else{
					okButton.setEnabled(false);
				}
			}
		});
		
		IDpaciente.setLimite(11);
		IDpaciente.setBounds(91, 36, 138, 20);
		contentPanel.add(IDpaciente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Aceptar");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{	
						if(cmf.posicionPaciente(IDpaciente.getText()) != -1){
							BuscarParaVacunar.this.dispose();
							Paciente pac = CMF.getInstancia().buscarPorID(IDpaciente.getText());
							RegistrarVacuna vac = new RegistrarVacuna(pac);
							vac.setVisible(true);
						}
						else{
							if(JOptionPane.showConfirmDialog(BuscarParaVacunar.this, "El paciente no esta registrado ,"
									+ " desea registrarlo","Paciente no registrado", 0) == 0){
								BuscarParaVacunar.this.dispose();
								Annadir_Paciente anadir = new Annadir_Paciente();
								anadir.setVisible(true);
							}
						}
					}	
				});
					
						okButton.setActionCommand("OK");
						buttonPane.add(okButton);
						getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BuscarParaVacunar.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
