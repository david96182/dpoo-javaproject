package visual;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import logica.ResultadoAnalisis;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Pacientes_ResultadosPendientes extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private boolean idpaciente = true;
	private boolean nombre = true;
	private boolean direcion = true;
	private long numhcpac = 0;
	private boolean nombreAnalisis = true;
	private CMF cmf = CMF.getInstancia();

	/**
	 * @wbp.nonvisual location=568,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private DefaultTableModel defaultTableModel2 = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane1;
	private JButton btnVolver;
	private JScrollPane scrollPane2;
	private JTable table2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pacientes_ResultadosPendientes frame = new Pacientes_ResultadosPendientes(null);
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
	public Pacientes_ResultadosPendientes(final Ventana_Enfermera vent) 
	{
		setTitle("Pacientes pendientes por resultados de an\u00E1lisis");
		getContentPane().setLayout(null);		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		scrollPane1 = new JScrollPane();
		scrollPane1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table_1.getRowCount() > 0)
				{
					int selecro = table_1.getSelectedRow();
					if(selecro != -1)
					{
					Pacientes_ResultadosPendientes.this.numhcpac = (Long) Pacientes_ResultadosPendientes.this.table_1.getValueAt(selecro, 0);
					Pacientes_ResultadosPendientes.this.TablaNombreResultados(numhcpac);
					}
					else
					{
						JOptionPane.showMessageDialog(Pacientes_ResultadosPendientes.this, "No hay paciente seleccionado","Paciente no seleccionado",2);
					}
				}
			}
		});
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Pacientes_ResultadosPendientes.this.dispose();
				vent.setVisible(true);
			}
		});

		scrollPane2 = new JScrollPane();

		table2 = new JTable();
		scrollPane2.setViewportView(table2);
		contentPane.setLayout(null);
		
		JButton btnRegistrarResultado = new JButton("Registrar resultado");
		btnRegistrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table_1.getSelectedRow()>=0 && table2.getSelectedRow() == -1){
					JOptionPane.showMessageDialog(Pacientes_ResultadosPendientes.this, "No se ha seleccionado resultado para registrar","Resultado no sellecionado",2);
				}
				else if(table_1.getSelectedRow()== -1){
					JOptionPane.showMessageDialog(Pacientes_ResultadosPendientes.this, "No se ha seleccionado un paciente","Paciente no seleccionado",2);
				}
				else{
					int row = table_1.getSelectedRow();
					long numhistcl = (Long) table_1.getValueAt(row, 0);
					int rowresult = table2.getSelectedRow();
					String analisis = (String) table2.getValueAt(rowresult, 0);
					RegistrarResultados regist = new RegistrarResultados(numhistcl,analisis);
					regist.setVisible(true);
					
				}
			}
		});
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaResultadosPendientes(cmf);
				contentPane.repaint();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
					.addGap(5))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(124)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnRegistrarResultado, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
						.addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnRegistrarResultado)
						.addComponent(btnVolver))
					.addGap(6))
		);
		contentPane.setLayout(gl_contentPane);

		TablaResultadosPendientes(cmf);

		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}

	// Tabla con Pacientes pendientes a resultados 
	public void TablaResultadosPendientes(CMF cmf)
	{
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> pendientes = cmf.getPacientePresultado();
		for (Paciente paciente : pendientes)
		{
			numhc.add(paciente.getNumeroHC());
			if(idpaciente)
				id.add(paciente.getID());
			if(nombre)
				nombrepac.add(paciente.getNombre());
			if(direcion)
				direccionpac.add(paciente.getDireccion());
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

	public void TablaNombreResultados(long numhc)
	{

		if(numhc >= 0)
		{
			ArrayList<ResultadoAnalisis> resulpendientes = cmf.obtenerListadoAnalisPendPac(numhc);
			scrollPane2.setVisible(nombreAnalisis);
			if(nombreAnalisis)
			{		
				ArrayList<Object> aux = new ArrayList<Object>();			

				for (int j = 0; j < resulpendientes.size(); j++) 
				{
					aux.add(resulpendientes.get(j).getNombreAnalisis());

				}
				defaultTableModel2 = new DefaultTableModel();
				defaultTableModel2.addColumn("Analisis Pendientes", aux.toArray());

				table2.setModel(defaultTableModel2);

			}
			contentPane.repaint();	
		}
		else{
			JOptionPane.showMessageDialog(Pacientes_ResultadosPendientes.this, "No se selecciono ningún paciente","Paciente no seleccionado",2);
		}
	}
}
