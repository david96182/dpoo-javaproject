package visual;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logica.CMF;
import logica.Enfermedad;
import javax.swing.JFrame;

public class Annadir_Paciente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	private CMF c = CMF.getInstancia();
	private JSpinner spinner;
	private JComboBox comboBox;
	private JLabel lblNombre;
	private JLabel lblDireccin;
	private JTextArea direcc;
	private JTextFieldMejorado textField_1;
	private JButton okButton;
	/**
	 * @wbp.nonvisual location=492,49
	 */
	private DefaultListModel EnfermedadesRegistradas = new DefaultListModel();
	/**
	 * @wbp.nonvisual location=482,99
	 */
	private DefaultListModel EnfermedadesDelPaciente = new DefaultListModel();
	private JButton Agregar;
	private JButton Eliminar;
	private JList listRegistradas;
	private JScrollPane scrollPane_2;
	private JList listEnfPaciente;
	private JButton btnNewButton;
	private JCheckBox rdbtnEmbarazada;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Annadir_Paciente dialog = new Annadir_Paciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Annadir_Paciente() {

		setModal(true);
		setResizable(false);
		setTitle("A\u00F1adir Paciente");
		setBounds(100, 100, 489, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Annadir_Paciente.class.getResource("/Images/Add User Male_96px.png")));
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 453, 206);
		contentPanel.add(panel);

		JLabel lblEdad = new JLabel("Edad:");

		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(((String)comboBox.getSelectedItem()).equals("Femenino") && ((Integer)spinner.getValue()) >= 14){
					rdbtnEmbarazada.setEnabled(true);
				}
				else{
					rdbtnEmbarazada.setEnabled(false);
				}
			}
		});
		spinner.setModel(new SpinnerNumberModel(0, 0, 125, 1));

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));

		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setAlignmentX(Component.CENTER_ALIGNMENT);

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
		textField.setColumns(10);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		direcc = new JTextArea();
		direcc.setLineWrap(true);
		scrollPane.setViewportView(direcc);

		textField_1 = new JTextFieldMejorado();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) || textField_1.getText().length()>10) 
				{
					getToolkit().beep();
					arg0.consume();

				}
				if(arg0.getKeyChar()== KeyEvent.VK_ENTER)
					okButton.doClick();
			}
		});
		textField_1.setLimite(11);

		rdbtnEmbarazada = new JCheckBox("Embarazada");
		rdbtnEmbarazada.setEnabled(false);

		label = new JLabel("Identificaci\u00F3n:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(23)
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(13)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblDireccin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panel.createSequentialGroup()
																.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)))
																.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(18)
																				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																				.addGroup(gl_panel.createSequentialGroup()
																						.addGap(18)
																						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
																						.addGroup(gl_panel.createSequentialGroup()
																								.addGap(21)
																								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
																										.addComponent(rdbtnEmbarazada, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
																										.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
																										.addPreferredGap(ComponentPlacement.UNRELATED)
																										.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(ComponentPlacement.RELATED)
																										.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))))
																										.addGap(50))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(17)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(label)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(20)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblDireccin)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
												.addGap(11)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(lblSexo)
														.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
																.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																.addComponent(lblEdad)
																.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
																.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
																.addComponent(rdbtnEmbarazada))
				);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enfermedades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 221, 453, 199);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		Agregar = new JButton("Agregar");
		Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listRegistradas.getSelectedValue()!=null){
					EnfermedadesDelPaciente.addElement(listRegistradas.getSelectedValue());
					EnfermedadesRegistradas.removeElement(listRegistradas.getSelectedValue());
					listRegistradas.setModel(EnfermedadesRegistradas);
					listEnfPaciente.setModel(EnfermedadesDelPaciente);
				}
			}
		});
		Agregar.setEnabled(false);
		Agregar.setBounds(182, 47, 89, 23);
		panel_1.add(Agregar);

		Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEnfPaciente.getSelectedValue()!=null){
					EnfermedadesRegistradas.addElement(listEnfPaciente.getSelectedValue());
					EnfermedadesDelPaciente.removeElement(listEnfPaciente.getSelectedValue());
					listEnfPaciente.setModel(EnfermedadesDelPaciente);
					listRegistradas.setModel(EnfermedadesRegistradas);

					actualizar();
				}
			}
		});
		Eliminar.setEnabled(false);
		Eliminar.setBounds(182, 85, 89, 23);
		panel_1.add(Eliminar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 150, 133);
		panel_1.add(scrollPane_1);

		listRegistradas = new JList();
		listRegistradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listRegistradas.getSelectedValue() !=null)
					Agregar.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(listRegistradas);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(293, 22, 150, 133);
		panel_1.add(scrollPane_2);

		listEnfPaciente = new JList();
		listEnfPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEnfPaciente.getSelectedValue() !=null)
					Eliminar.setEnabled(true);
			}
		});
		scrollPane_2.setViewportView(listEnfPaciente);

		btnNewButton = new JButton("Agregar Otra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tam = c.getEnfermedades().size();
				agregarNuevaEnfermedad agre = new agregarNuevaEnfermedad();
				agre.setVisible(true);
				if(tam != c.getEnfermedades().size()){
					EnfermedadesRegistradas.addElement(CMF.getInstancia().getEnfermedades().get(CMF.getInstancia().getEnfermedades().size()-1).getNombre_Enf());
					listRegistradas.setModel(EnfermedadesRegistradas);
				}
			}
		});
		btnNewButton.setBounds(33, 165, 112, 23);
		panel_1.add(btnNewButton);
		
		JFrame frame = new JFrame();
		frame.setBounds(230, 68, 200, 50);
		contentPanel.add(frame);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00F1adir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(Annadir_Paciente.this, "Desea registrar el paciente en el consultorio",
								"Registrar Paciente", 0) == 0)
						{
						boolean datoincorrecto = false;
						boolean carnetincorrecto = false;
						String nombre = textField.getText();
						String ID = textField_1.getText();
						String direc = direcc.getText();
						boolean mujerembarazada = rdbtnEmbarazada.isSelected();
						int edad = (Integer) spinner.getValue();
						String sexo = (String) comboBox.getSelectedItem();
						ArrayList<Enfermedad> enfermedadespac = new ArrayList<Enfermedad>(); 

						if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
							lblNombre.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblNombre.setForeground(Color.BLACK);
						if(!CMF.getInstancia().ValidarCarnet(ID)){
							label.setForeground(Color.RED);
							carnetincorrecto = true;
						}
						else
							label.setForeground(Color.BLACK);
						if(direc.replaceAll(" ", "").equalsIgnoreCase("")){
							lblDireccin.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblDireccin.setForeground(Color.BLACK);

						if(datoincorrecto){
							if(!carnetincorrecto)
								JOptionPane.showMessageDialog(Annadir_Paciente.this,"No pueden estar vac�os los campos se�alados en rojo","Error en los datos", 0);
							else
								JOptionPane.showMessageDialog(Annadir_Paciente.this,"No pueden estar vac�os los campos se�alados en rojo y el carn� no es v�lido","Error en los datos", 0);
						}
						else
							if(carnetincorrecto)
								JOptionPane.showMessageDialog(Annadir_Paciente.this,"El carn� no es v�lido","Error en los datos", 0);
							else{
								for(int i = 0;i < EnfermedadesDelPaciente.size();i++){
									Enfermedad f = new Enfermedad(EnfermedadesDelPaciente.get(i).toString());
									enfermedadespac.add(f);
								}
								if(c.annadirPaciente(nombre, ID, direc,edad,sexo,mujerembarazada,enfermedadespac)){
									JOptionPane.showMessageDialog(Annadir_Paciente.this, "Paciente A�adido Exitosamente.","Paciente A�adido",-1);

									Annadir_Paciente.this.dispose();
								}
								else{
									JOptionPane.showMessageDialog(Annadir_Paciente.this, "El paciente ya existe.","Error en los datos", 0);
								}

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
						Annadir_Paciente.this.dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarListaconEnfermedadesDisponibles();
	}
	public Annadir_Paciente(String ID) {

		setModal(true);
		setResizable(false);
		setTitle("A\u00F1adir Paciente");
		setBounds(100, 100, 489, 493);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Annadir_Paciente.class.getResource("/Images/Add User Male_96px.png")));
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 453, 199);
		contentPanel.add(panel);

		JLabel lblEdad = new JLabel("Edad:");

		spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(((String)comboBox.getSelectedItem()).equals("Femenino") && ((Integer)spinner.getValue()) >= 14){
					rdbtnEmbarazada.setEnabled(true);
				}
				else{
					rdbtnEmbarazada.setEnabled(false);
				}
			}
		});
		spinner.setModel(new SpinnerNumberModel(0, 0, 125, 1));

		JLabel lblSexo = new JLabel("Sexo:");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));

		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setAlignmentX(Component.CENTER_ALIGNMENT);

		label = new JLabel("Identificaci\u00F3n:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));

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
		textField.setColumns(10);

		lblNombre = new JLabel("Nombre:");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		direcc = new JTextArea();
		direcc.setLineWrap(true);
		scrollPane.setViewportView(direcc);

		textField_1 = new JTextFieldMejorado();
		textField_1.setEnabled(false);
		textField_1.setText(ID);

		rdbtnEmbarazada = new JCheckBox("Embarazada");
		rdbtnEmbarazada.setEnabled(false);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(4)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addGap(46)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addGap(47)
																.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
																.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
																.addComponent(rdbtnEmbarazada, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
																.addGap(29)
																.addComponent(lblEdad, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
																.addGap(10)
																.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
																.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
																		.addGroup(gl_panel.createSequentialGroup()
																				.addGap(24)
																				.addComponent(lblDireccin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
																				.addGap(3)
																				.addComponent(scrollPane))
																				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
																						.addGap(30)
																						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																								.addGroup(gl_panel.createSequentialGroup()
																										.addGap(63)
																										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE))
																										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))))
																										.addContainerGap(70, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(3)
										.addComponent(lblNombre)))
										.addGap(14)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panel.createSequentialGroup()
																.addGap(17)
																.addComponent(lblDireccin))
																.addGroup(gl_panel.createSequentialGroup()
																		.addGap(12)
																		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
																		.addGap(8)
																		.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																				.addGroup(gl_panel.createSequentialGroup()
																						.addGap(3)
																						.addComponent(lblSexo))
																						.addGroup(gl_panel.createSequentialGroup()
																								.addGap(3)
																								.addComponent(lblEdad))
																								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																								.addGap(9)
																								.addComponent(rdbtnEmbarazada)
																								.addContainerGap())
				);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enfermedades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 221, 453, 199);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		Agregar = new JButton("Agregar");
		Agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listRegistradas.getSelectedValue()!=null){
					EnfermedadesDelPaciente.addElement(listRegistradas.getSelectedValue());
					EnfermedadesRegistradas.removeElement(listRegistradas.getSelectedValue());
					listRegistradas.setModel(EnfermedadesRegistradas);
					listEnfPaciente.setModel(EnfermedadesDelPaciente);
				}
			}
		});
		Agregar.setEnabled(false);
		Agregar.setBounds(182, 47, 89, 23);
		panel_1.add(Agregar);

		Eliminar = new JButton("Eliminar");
		Eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEnfPaciente.getSelectedValue()!=null){
					EnfermedadesRegistradas.addElement(listEnfPaciente.getSelectedValue());
					EnfermedadesDelPaciente.removeElement(listEnfPaciente.getSelectedValue());
					listEnfPaciente.setModel(EnfermedadesDelPaciente);
					listRegistradas.setModel(EnfermedadesRegistradas);

					actualizar();
				}
			}
		});
		Eliminar.setEnabled(false);
		Eliminar.setBounds(182, 85, 89, 23);
		panel_1.add(Eliminar);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 150, 133);
		panel_1.add(scrollPane_1);

		listRegistradas = new JList();
		listRegistradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listRegistradas.getSelectedValue() !=null)
					Agregar.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(listRegistradas);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(293, 22, 150, 133);
		panel_1.add(scrollPane_2);

		listEnfPaciente = new JList();
		listEnfPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEnfPaciente.getSelectedValue() !=null)
					Eliminar.setEnabled(true);
			}
		});
		scrollPane_2.setViewportView(listEnfPaciente);

		btnNewButton = new JButton("Agregar Otra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tam = c.getEnfermedades().size();
				agregarNuevaEnfermedad agre = new agregarNuevaEnfermedad();
				agre.setVisible(true);
				if(tam != c.getEnfermedades().size()){
					EnfermedadesRegistradas.addElement(CMF.getInstancia().getEnfermedades().get(CMF.getInstancia().getEnfermedades().size()-1).getNombre_Enf());
					listRegistradas.setModel(EnfermedadesRegistradas);
				}
			}
		});
		btnNewButton.setBounds(33, 165, 112, 23);
		panel_1.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("A\u00F1adir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean datoincorrecto = false;
						String nombre = textField.getText();
						String ID = textField_1.getText();
						String direc = direcc.getText();
						boolean mujerembarazada = rdbtnEmbarazada.isSelected();
						int edad = (Integer) spinner.getValue();
						String sexo = (String) comboBox.getSelectedItem();
						ArrayList<Enfermedad> enfermedadespac = new ArrayList<Enfermedad>(); 

						if(nombre.replaceAll(" ", "").equalsIgnoreCase("")){
							lblNombre.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblNombre.setForeground(Color.BLACK);
						if(ID.replaceAll(" ", "").equalsIgnoreCase("")){
							label.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							label.setForeground(Color.BLACK);
						if(direc.replaceAll(" ", "").equalsIgnoreCase("")){
							lblDireccin.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblDireccin.setForeground(Color.BLACK);

						if(datoincorrecto)
							JOptionPane.showMessageDialog(Annadir_Paciente.this,"No pueden estar vac�os los campos se�alados en rojo","Error en los datos", 0);
						else{
							for(int i = 0;i < EnfermedadesDelPaciente.size();i++){
								Enfermedad f = new Enfermedad(EnfermedadesDelPaciente.get(i).toString());
								enfermedadespac.add(f);
							}
							if(c.annadirPaciente(nombre, ID, direc,edad,sexo,mujerembarazada,enfermedadespac)){
								JOptionPane.showMessageDialog(Annadir_Paciente.this, "Paciente A�adido Exitosamente.","Paciente A�adido",-1);

								Annadir_Paciente.this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(Annadir_Paciente.this, "El paciente ya existe.","Error en los datos", 0);
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
						Annadir_Paciente.this.dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarListaconEnfermedadesDisponibles();
	}
	public void actualizar(){
		listRegistradas.setModel(EnfermedadesRegistradas);

	}
	public void cargarListaconEnfermedadesDisponibles(){
		for(Enfermedad enf:c.getEnfermedades()){
			EnfermedadesRegistradas.addElement(enf.getNombre_Enf());
		}
		listRegistradas.setModel(EnfermedadesRegistradas);

		EnfermedadesDelPaciente = new DefaultListModel();
		listEnfPaciente.setModel(EnfermedadesDelPaciente);
	}
}

