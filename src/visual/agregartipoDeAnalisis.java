package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.CMF;

public class agregartipoDeAnalisis extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			agregartipoDeAnalisis dialog = new agregartipoDeAnalisis();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public agregartipoDeAnalisis() {
		setTitle("Agregar Tipo de An\u00E1lisis");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 144);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Introduzca el nombre del An\u00E1lisis a registrar:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(99, 11, 334, 29);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SPACE))){					
					getToolkit().beep();
					arg0.consume();
				}
				if(arg0.getKeyChar()== KeyEvent.VK_ENTER)
					okButton.doClick();
			}
		});
		textField.setBounds(109, 51, 243, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String nombre = textField.getText();
						if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
							JOptionPane.showMessageDialog(agregartipoDeAnalisis.this, "Debe introducirse un nombre parar poder registrarse","Error en los datos",2);
						}
						else if(CMF.getInstancia().registrarAnalisis(nombre)){
							JOptionPane.showMessageDialog(agregartipoDeAnalisis.this, "Registrado Correctamente","Nuevo Análisis Registrago",-1);
							agregartipoDeAnalisis.this.dispose();
						}
						else{
							JOptionPane.showMessageDialog(agregartipoDeAnalisis.this, "Ya se encuentra registrado","Error en los datos",2);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						agregartipoDeAnalisis.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
