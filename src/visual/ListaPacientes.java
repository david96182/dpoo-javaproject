package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Historia_Clinica;
import logica.Paciente;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class ListaPacientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private CMF cmf = CMF.getInstancia();
	private boolean idpaciente = true;
	private boolean nombre = true;
	private boolean direcion = true;
	/**
	 * @wbp.nonvisual location=568,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane1;
	private JLabel lblBuscar;
	private JTextFieldMejorado textFieldMejorado;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPacientes frame = new ListaPacientes(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaPacientes(final Ventana_Medico vent) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPacientes.class.getResource("/Images/User Menu Male_96px.png")));
		setTitle("Listado de Pacientes");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		scrollPane1 = new JScrollPane();
		table_1 = new JTable();
		table_1.setDragEnabled(true);
		scrollPane1.setViewportView(table_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(vent.isEnabled())
				{
					ListaPacientes.this.dispose();
					vent.setVisible(true);
				}
				else
				{
					ListaPacientes.this.dispose();
				}
			}
		});

		JButton btnVerHistoriaClnica = new JButton("Ver Historia Cl\u00EDnica");
		btnVerHistoriaClnica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table_1.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(ListaPacientes.this, "Debe seleccionar a un paciente para ver su historia clínica","Paciente no seleccionado",2);
				else
					if(JOptionPane.showConfirmDialog(ListaPacientes.this, "Desea ver la Historia Clínica del paciente",
							"Ver Historia Clinica", 0) == 0)
					{
						int fila = table_1.getSelectedRow();
						Object indice = table_1.getValueAt(fila, 0);
						long ind = (Long) indice;
						Historia_Clinica hc = cmf.buscarHistoriaClinica(ind);
						HistoriaClinica hist = new HistoriaClinica(ListaPacientes.this,hc);	
						hist.setVisible(true);
						textFieldMejorado.setText("");

					}
			}
		});

		lblBuscar = new JLabel("Busqueda por ID:");

		textFieldMejorado = new JTextFieldMejorado();
		textFieldMejorado.setLimite(11);

		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				textFieldMejorado.setText("");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(!CMF.getInstancia().ValidarCarnet(textFieldMejorado.getText())){
					JOptionPane.showMessageDialog(ListaPacientes.this, "Carné No Válido","Carné Incorrecto",0);
				}
				else{
					Paciente aux = cmf.buscarPorID(textFieldMejorado.getText());

					if(aux == null)
						JOptionPane.showMessageDialog(ListaPacientes.this,"No se encuentra ningún paciente registrado con ese número de carné","Paciente no encontrado",2);
					else
					{
						cargarTablaconPaciente(cmf, aux);
						contentPane.repaint();
					}
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Mostrar Todos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				cargarTablaPacientes(cmf);
				contentPane.repaint();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(5)
						.addComponent(lblBuscar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGap(47)
						.addComponent(textFieldMejorado, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(5)
								.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap(271, Short.MAX_VALUE)
										.addComponent(btnVerHistoriaClnica, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
										.addGap(24)
										.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGap(5))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(4)
										.addComponent(lblBuscar))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGap(1)
												.addComponent(textFieldMejorado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnNewButton)
												.addComponent(btnNewButton_1))
												.addGap(6)
												.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
												.addGap(11)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(btnVerHistoriaClnica)
														.addComponent(btnVolver))
														.addGap(6))
				);
		contentPane.setLayout(gl_contentPane);


		cargarTablaPacientes(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}
	public void cargarTablaPacientes(CMF cmf)
	{
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> pacientes = cmf.getPacientes();
		for(int i = 0;i < pacientes.size();i++){
			Paciente aux = pacientes.get(i);
			numhc.add(aux.getNumeroHC());
			if(idpaciente)
				id.add(aux.getID());
			if(nombre)
				nombrepac.add(aux.getNombre());
			if(direcion)
				direccionpac.add(aux.getDireccion());
		}
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Numero HC",numhc.toArray());
		if(idpaciente)
			defaultTableModel.addColumn("ID",id.toArray());
		if(nombre)
			defaultTableModel.addColumn("Nombre",nombrepac.toArray());
		if(direcion)
			defaultTableModel.addColumn("Direccion",direccionpac.toArray());
		table_1.setModel(defaultTableModel);


	}
	public void cargarTablaconPaciente(CMF cmf,Paciente aux){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();

		numhc.add(aux.getNumeroHC());
		if(idpaciente)
			id.add(aux.getID());
		if(nombre)
			nombrepac.add(aux.getNombre());
		if(direcion)
			direccionpac.add(aux.getDireccion());

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Numero HC",numhc.toArray());
		if(idpaciente)
			defaultTableModel.addColumn("ID",id.toArray());
		if(nombre)
			defaultTableModel.addColumn("Nombre",nombrepac.toArray());
		if(direcion)
			defaultTableModel.addColumn("Direccion",direccionpac.toArray());
		table_1.setModel(defaultTableModel);


	}
}