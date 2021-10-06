package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Autenticar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private boolean med = false;
	private JButton btnEnfermera;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Autenticar dialog = new Autenticar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Autenticar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Autenticar.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("CMF");
		setBounds(100, 100, 450, 325);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblSistemaDeGestin = new JLabel("Sistema de Gesti\u00F3n de CMF");
			lblSistemaDeGestin.setBounds(209, 13, 203, 40);
			lblSistemaDeGestin.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
			contentPanel.add(lblSistemaDeGestin);
		}
		{
			JLabel lblInc = new JLabel("Iniciar Sesi\u00F3n Como:");
			lblInc.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblInc.setBounds(266, 117, 137, 22);
			contentPanel.add(lblInc);
		}
		{
			btnNewButton = new JButton("");
			btnNewButton.setIcon(new ImageIcon(Autenticar.class.getResource("/Images/iconMedico.png")));
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setMnemonic('M');
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					med = true;
					Credenciales cred = new Credenciales(Autenticar.this,med);
					cred.setVisible(true);
				}
			});
			btnNewButton.setBounds(209, 175, 89, 67);
			contentPanel.add(btnNewButton);
		}
		{
			btnEnfermera = new JButton("");
			btnEnfermera.setBackground(Color.WHITE);
			btnEnfermera.setIcon(new ImageIcon(Autenticar.class.getResource("/Images/icons8_Medical_Doctor9_64.png")));
			//btnEnfermera.setSelectedIcon(new ImageIcon("C:\\Users\\David\\Pictures\\ICONO project\\Medical Doctor_96px.png"));
			//entanaPrincipal.class.getResource("/
			btnEnfermera.setSelectedIcon(new ImageIcon(Autenticar.class.getResource("/Images/icons8_Medical_Doctor9_64.png")));
			btnEnfermera.setMnemonic('E');
			btnEnfermera.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					med = false;
					Credenciales cred = new Credenciales(Autenticar.this,med);
					cred.setVisible(true);
				}
			});
			btnEnfermera.setBounds(335, 175, 89, 67);
			contentPanel.add(btnEnfermera);
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setMinimumSize(new Dimension(0, 0));
		lblNewLabel_1.setMaximumSize(new Dimension(0, 0));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setIcon(new ImageIcon(Autenticar.class.getResource("/Images/256e47854cf97d875151d0a90f8dde82.jpg")));
		lblNewLabel_1.setBounds(0, 0, 203, 253);
		contentPanel.add(lblNewLabel_1);
		
		JTextPane txtpnBienvenioAlSistema = new JTextPane();
		txtpnBienvenioAlSistema.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtpnBienvenioAlSistema.setText("Bienvenido al Sistema de Gesti\u00F3n de un consultorio m\u00E9dico, seleccione su usuario para poder continuar.");
		txtpnBienvenioAlSistema.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtpnBienvenioAlSistema.setEditable(false);
		txtpnBienvenioAlSistema.setBounds(205, 51, 219, 67);
		contentPanel.add(txtpnBienvenioAlSistema);
		{
			JLabel lblNewLabel = new JLabel("Enfermera");
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(342, 150, 82, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_2 = new JLabel("M\u00E9dico");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(227, 150, 58, 14);
		contentPanel.add(lblNewLabel_2);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setMnemonic('C');
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Autenticar.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isMed() {
		return med;
	}

	public void setMed(boolean med) {
		this.med = med;
	}
}
