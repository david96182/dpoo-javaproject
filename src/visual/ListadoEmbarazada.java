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
import logica.Mujer;
import logica.Paciente;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListadoEmbarazada extends JFrame {

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
	private JTextFieldMejorado IDPaciente;
	private JButton btnBuscar;

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
	public ListadoEmbarazada(final Ventana_Medico vent) {
		setTitle("Listado de Embarazadas");
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 261);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);


		scrollPane1 = new JScrollPane();
		scrollPane1.setToolTipText("f");
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEmbarazada.this.dispose();
			}
		});

		JLabel lblBusquedaPorCarnet = new JLabel("Busqueda por carnet: ");

		IDPaciente = new JTextFieldMejorado();
		IDPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) || IDPaciente.getText().length()>10) 
				{
					getToolkit().beep();
					e.consume();

				}
				if(e.getKeyChar()== KeyEvent.VK_ENTER)
					btnBuscar.doClick();
			}
		});
		IDPaciente.setLimite(11);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(!CMF.getInstancia().ValidarCarnet(IDPaciente.getText())){
					JOptionPane.showMessageDialog(ListadoEmbarazada.this, "Carné No Válido","Carné Incorrecto",0);
				}
				else{
					Paciente aux = cmf.buscarPorID(IDPaciente.getText());

					if(aux == null)
						JOptionPane.showMessageDialog(ListadoEmbarazada.this,"No se encuentra ninguna embarazada registrado con ese número de carné","Paciente no encontrado",2);
					else
					{
						if(aux instanceof Mujer){
							if(((Mujer) aux).isEmbarazada()){
								cargarTablaconPaciente(cmf, aux);
								contentPane.repaint();
							}
							else JOptionPane.showMessageDialog(ListadoEmbarazada.this,"No se encuentra ninguna embarazada registrado con ese número de carné","Paciente no encontrado",2);
						}
						else 
							JOptionPane.showMessageDialog(ListadoEmbarazada.this,"No se encuentra ninguna embarazada registrado con ese número de carné","Paciente no encontrado",2);
					}
				}
			}
		});

		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				TabladeEmbarazadas(cmf);
				contentPane.repaint();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblBusquedaPorCarnet, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(IDPaciente, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
					.addGap(50)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnMostrarTodos, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(422, Short.MAX_VALUE)
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(lblBusquedaPorCarnet))
								.addComponent(IDPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnBuscar)
						.addComponent(btnMostrarTodos))
					.addGap(10)
					.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVolver)
					.addGap(5))
		);
		contentPane.setLayout(gl_contentPane);

		if(!vent.isEnabled())
		{
			JButton btnQuitarDeEmbarazadas = new JButton("Quitar de embarazadas");
			btnQuitarDeEmbarazadas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(table_1.getSelectedRow() != -1)
					{
						if(JOptionPane.showConfirmDialog(ListadoEmbarazada.this, "Desea cambiar el estado de una mujer embarazada", "Eliminar embarazo", 0) == 0)
						{
							int fila = table_1.getSelectedRow();
							long hc = (Long)table_1.getValueAt(fila, 0); 
							Paciente p = cmf.buscarNumeroHC(hc);
							cmf.eliminarEmbarazo(p);
							JOptionPane.showMessageDialog(ListadoEmbarazada.this, "Embarazo eliminado correctamente","Embarazo Eliminado",-1);
							TabladeEmbarazadas(cmf);
							contentPane.repaint();
						}
					}
					else
						JOptionPane.showMessageDialog(ListadoEmbarazada.this, "Debe seleccionar a un paciente","Paciente no seleccionado",2);
				}
			});
			btnQuitarDeEmbarazadas.setBounds(220, 328, 180, 23);
			contentPane.add(btnQuitarDeEmbarazadas);
		}

		TabladeEmbarazadas(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}
	public void TabladeEmbarazadas(CMF cmf){
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Mujer> embarazadas = cmf.getMujeresEmbarazadas();
		for(int i = 0;i < embarazadas.size();i++)
		{
			numhc.add(embarazadas.get(i).getNumeroHC());
			if(idpaciente)
				id.add(embarazadas.get(i).getID());
			if(nombre)
				nombrepac.add(embarazadas.get(i).getNombre());
			if(direcion)
				direccionpac.add(embarazadas.get(i).getDireccion());

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

	public void cargarTablaconPaciente(CMF cmf,Paciente aux)
	{
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
