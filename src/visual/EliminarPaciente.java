package visual;

import java.awt.Dialog.ModalExclusionType;
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
import logica.Paciente;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class EliminarPaciente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private boolean idpaciente = true;
	private boolean nombre = true;
	private boolean direcion = true;
	/**
	 * @wbp.nonvisual location=568,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane1;
	Ventana_Enfermera n;
	CMF c;
	private JButton btnEliminar;
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
	public EliminarPaciente(Ventana_Enfermera vent) {
		setTitle("Eliminar Paciente");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		c = CMF.getInstancia();
		n = vent;
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		scrollPane1 = new JScrollPane();
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EliminarPaciente.this.dispose();
				n.setVisible(true);
			}
		});

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(table_1.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(EliminarPaciente.this, "Debe seleccionar a un paciente para poder eliminarlo","Paciente no seleccionado",2);
				else
					if(JOptionPane.showConfirmDialog(EliminarPaciente.this, "Desea eliminar el paciente", "Eliminar Paciente", 0) == 0)
					{
						int indice = table_1.getSelectedRow();
						c.eliminarPaciente(indice);
						cargarTablaconPacientes(c);
						
						contentPane.repaint();
						JOptionPane.showMessageDialog(EliminarPaciente.this, "Paciente eliminado correctamente","Paciente eliminado",-1);
						
					}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(324)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEliminar)
						.addComponent(btnVolver))
					.addGap(3))
		);
		contentPane.setLayout(gl_contentPane);

		cargarTablaconPacientes(c);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}
	public void cargarTablaconPacientes(CMF cmf){
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
}

