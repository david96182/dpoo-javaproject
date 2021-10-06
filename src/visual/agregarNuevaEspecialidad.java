package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logica.CMF;

public class agregarNuevaEspecialidad extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			agregarNuevaEspecialidad dialog = new agregarNuevaEspecialidad();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public agregarNuevaEspecialidad() {
		setAlwaysOnTop(true);
		setResizable(false);
		setModal(true);
		setTitle("Registrar Nueva Especialidad");
		setBounds(100, 100, 450, 169);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
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
		textField.setBounds(103, 57, 236, 29);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblIntroduzcaElNombre = new JLabel("Introduzca el nombre de la nueva especilidad:");
		lblIntroduzcaElNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIntroduzcaElNombre.setBounds(77, 21, 357, 14);
		contentPanel.add(lblIntroduzcaElNombre);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = textField.getText();
						if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
							JOptionPane.showMessageDialog(agregarNuevaEspecialidad.this, "Debe introducirse un nombre parar poder registrarse","Error en los datos",2);
						}
						else{
							if(CMF.getInstancia().registrarEspecialidad(nombre)){
								JOptionPane.showMessageDialog(agregarNuevaEspecialidad.this, "Especialidad registrada correctamente","Especilidad Registrada", -1);
								agregarNuevaEspecialidad.this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(agregarNuevaEspecialidad.this, "Ya se encuentra registrada esa especialidad","Error en los datos", 2);
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
					public void actionPerformed(ActionEvent e) {
						agregarNuevaEspecialidad.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
