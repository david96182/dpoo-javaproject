package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Enfermedad;
import logica.Paciente;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class ListadoPacientesEnfermos extends JFrame {

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
	private JComboBox comboBox;
	/**
	 * @wbp.nonvisual location=551,109
	 */
	private final DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoPacientesEnfermos frame = new ListadoPacientesEnfermos(null);
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
	public ListadoPacientesEnfermos(final Ventana_Medico vent)
	{
		setTitle("Listado de Pacientes con Enfermedad");
		setResizable(false);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(5, 38, 526, 279);
		contentPane.add(scrollPane1);
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ListadoPacientesEnfermos.this.dispose();
				vent.setVisible(true);
			}
		});

		btnVolver.setBounds(442, 328, 89, 23);
		contentPane.add(btnVolver);

		JLabel lblMostrarPacientesCon = new JLabel("Mostrar Pacientes con:");
		lblMostrarPacientesCon.setBounds(10, 11, 161, 14);
		contentPane.add(lblMostrarPacientesCon);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				tablaconCpacientesConunaenf(comboBox.getSelectedItem().toString(), cmf);
				/*TablaconPacientesEnfermos(cmf);
				contentPane.repaint();*/




			}
		});
		comboBox.setBounds(161, 7, 127, 20);
		contentPane.add(comboBox);
		cargarElementosCombox(cmf);
		TablaconPacientesEnfermos(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);

	}
	//cargar comboBox con las enfermedades registradas
	public void cargarElementosCombox(CMF cmf){
		ArrayList<Enfermedad> enfes = cmf.getEnfermedades();
		for(int i = 0;i < enfes.size();i++){
			defaultComboBoxModel.addElement(enfes.get(i).getNombre_Enf());
		}
		comboBox.setModel(defaultComboBoxModel);
	}
	//cargar tabla con los pacientes que poseen cualquier enfermedad
	public void TablaconPacientesEnfermos(CMF cmf){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> pacientesEnfermos = cmf.getPacientesEnfermos();
		for(int i = 0;i < pacientesEnfermos.size();i++){
			Paciente aux = pacientesEnfermos.get(i);
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
	//Cargar tabla con los pacientes con la enfermedad seleccionada
	public void tablaconCpacientesConunaenf(String enfermedad,CMF cmf){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> pacientesEnfermos = cmf.obtenerPacientescEnf(enfermedad);
		for(int i = 0;i < pacientesEnfermos.size();i++){
			Paciente aux = pacientesEnfermos.get(i);
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
}
