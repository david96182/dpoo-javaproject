package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import logica.CMF;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class buscarPacienteParaConsulta extends JDialog {

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
			buscarPacienteParaConsulta dialog = new buscarPacienteParaConsulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public buscarPacienteParaConsulta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(buscarPacienteParaConsulta.class.getResource("/Images/Find User Male_96px.png")));
		setTitle("Buscar Paciente para Consulta");
		setModal(true);
		setBounds(100, 100, 403, 137);
		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		this.setLocationRelativeTo(null);
		{
			JLabel lblIntroduzcaElId = new JLabel("Introduzca la identificaci\u00F3n del paciente para dar Consulta:");
			lblIntroduzcaElId.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblIntroduzcaElId.setBounds(20, 11, 367, 14);
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
			public void caretUpdate(CaretEvent arg0) {
				if(!IDpaciente.getText().isEmpty()){
					okButton.setEnabled(true);
				}
				else{
					okButton.setEnabled(false);
				}

			}
		});
		IDpaciente.setLimite(11);
		IDpaciente.setBounds(129, 36, 148, 20);
		contentPanel.add(IDpaciente);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Dar Consulta");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(!CMF.getInstancia().ValidarCarnet(IDpaciente.getText())){
							JOptionPane.showMessageDialog(buscarPacienteParaConsulta.this, "Carn� no v�lido","Carn� Incorrecto",0);
						}
						else
							if(cmf.posicionPaciente(IDpaciente.getText()) != -1){
								buscarPacienteParaConsulta.this.dispose();
								registrarConsulta regist = new registrarConsulta(IDpaciente.getText());
								regist.setVisible(true);

							}
							else{
								if(JOptionPane.showConfirmDialog(buscarPacienteParaConsulta.this, "El paciente no esta registrado ,"
										+ " �Desea registrarlo?","Paciente no registrado", 2) == 0){
									buscarPacienteParaConsulta.this.dispose();
									Annadir_Paciente anadir = new Annadir_Paciente(IDpaciente.getText());
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
						buscarPacienteParaConsulta.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
