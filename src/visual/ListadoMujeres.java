package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Mujer;
import logica.Paciente;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ListadoMujeres extends JFrame {

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

	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane1;
	private JLabel lblBusquedaPorId;
	private JButton btnBuscar;
	private JButton btnMostrarTodas;
	private JTextFieldMejorado campo;
	private JButton btnRegistrarPruebaCitolgica;
	private JButton btnAgregarAEmbarazadas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoMujeres frame = new ListadoMujeres(null);
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
	public ListadoMujeres(final Ventana_Enfermera ventE) {
		setTitle("Listado de Mujeres");
		getContentPane().setLayout(null);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		scrollPane1 = new JScrollPane();
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ListadoMujeres.this.dispose();
				ventE.setVisible(true);
			}
		});

		lblBusquedaPorId = new JLabel("Busqueda por ID:");

		btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				campo.setText("");
			}
		});
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!CMF.getInstancia().ValidarCarnet(campo.getText())){
					JOptionPane.showMessageDialog(ListadoMujeres.this, "Carné No Válido","Carné Incorrecto",0);
				}
				else{
					Paciente pac = cmf.buscarPorID(campo.getText()); 
					if(pac == null)
						JOptionPane.showMessageDialog(ListadoMujeres.this,"No se encuentra mujer registrada con ese número de carné","Paciente no encontrado",2);
					else
					{
						if(pac instanceof Mujer){
							cargarMujer(pac,pac.getID());
							btnAgregarAEmbarazadas.setVisible(true);
							btnRegistrarPruebaCitolgica.setVisible(true);
							contentPane.repaint();
						}
						else
							JOptionPane.showMessageDialog(ListadoMujeres.this,"No se encuentra mujer registrada con ese número de carné","Paciente no encontrado",2);
					}
				}
			}
		});

		btnMostrarTodas = new JButton("Mostrar Todas");
		btnMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarAEmbarazadas.setVisible(false);
				btnRegistrarPruebaCitolgica.setVisible(false);
				cargarTablaMujeres(cmf);
				contentPane.repaint();
			}
		});

		campo = new JTextFieldMejorado();
		campo.setLimite(11);

		btnRegistrarPruebaCitolgica = new JButton("Registrar Prueba Citol\u00F3gica");
		btnRegistrarPruebaCitolgica.setVisible(false);
		btnRegistrarPruebaCitolgica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(table_1.getSelectedRow() != -1)
				{
					if(JOptionPane.showConfirmDialog(ListadoMujeres.this, "Desea registar la fecha de la prueba citológica ", "Registro de Prueba", 0) == 0)
					{
						long hc = (Long)table_1.getValueAt(0, 0); 
						Paciente p = cmf.buscarNumeroHC(hc);
						if(cmf.cambiarFechaPruebaCit(p,hc))
							JOptionPane.showMessageDialog(ListadoMujeres.this, "Prueba citológica registrada satisfactoriamente","Prueba Registrada",-1);
						else
							JOptionPane.showMessageDialog(ListadoMujeres.this, "Ya se registro la prueba citológica","Ya registrada",0);
					}
				}
				else
					JOptionPane.showMessageDialog(ListadoMujeres.this, "No hay paciente seleccionado","Error",0);
			}
		});

		btnAgregarAEmbarazadas = new JButton("Agregar a embarazadas");
		btnAgregarAEmbarazadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(table_1.getSelectedRow() != -1)
				{
					if(JOptionPane.showConfirmDialog(ListadoMujeres.this, "Desea agregar a mujeres embarazadas ", "Agragar a mujeres embarazadas", 0) == 0)
					{
						long hc = (Long)table_1.getValueAt(0, 0); 
						Paciente p = cmf.buscarNumeroHC(hc);
						boolean agreg = cmf.ponermujerEmbarazada(p.getID());
						if(agreg)
							JOptionPane.showMessageDialog(ListadoMujeres.this, "Agregada satisfactoriamente","Embarazo Registrado",-1);
						else
							JOptionPane.showMessageDialog(ListadoMujeres.this, "La paciente ya esta embarazada","Paciente Embarazada",2);
					}
				}
				else
					JOptionPane.showMessageDialog(ListadoMujeres.this, "No hay paciente seleccionado","Error",0);
			}

		});
		btnAgregarAEmbarazadas.setVisible(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblBusquedaPorId, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(campo, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(btnMostrarTodas, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(btnAgregarAEmbarazadas, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(btnRegistrarPruebaCitolgica, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblBusquedaPorId))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(campo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnBuscar)
						.addComponent(btnMostrarTodas))
					.addGap(11)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarAEmbarazadas)
						.addComponent(btnRegistrarPruebaCitolgica)
						.addComponent(btnVolver))
					.addGap(3))
		);
		contentPane.setLayout(gl_contentPane);

		cargarTablaMujeres(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}

	public void cargarTablaMujeres(CMF cmf){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> pacientes = cmf.getPacientes();
		for(int i = 0;i < pacientes.size();i++)
		{
			if(pacientes.get(i) instanceof Mujer)
			{
				Paciente aux = pacientes.get(i);		
				numhc.add(aux.getNumeroHC());
				if(idpaciente)
					id.add(aux.getID());
				if(nombre)
					nombrepac.add(aux.getNombre());
				if(direcion)
					direccionpac.add(aux.getDireccion());
			}
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

	public void cargarMujer(Paciente pac,String Id){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();

		if(pac instanceof Mujer)
		{
			numhc.add(pac.getNumeroHC());
			if(idpaciente)
				id.add(pac.getID());
			if(nombre)
				nombrepac.add(pac.getNombre());
			if(direcion)
				direccionpac.add(pac.getDireccion());
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
}