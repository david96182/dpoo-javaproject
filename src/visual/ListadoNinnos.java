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
import logica.Ninno;
import logica.Paciente;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ListadoNinnos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;


	private boolean idpaciente = true;
	private boolean nombre = true;
	private boolean direcion = true;
	private CMF cmf = CMF.getInstancia();

	/**
	 * @wbp.nonvisual location=568,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane1;
	private JButton btnVolver;
	private JLabel lblBusquedaPorCarnet;
	private JTextFieldMejorado IDPaciente;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadoNinnos frame = new ListadoNinnos(null);
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
	public ListadoNinnos(final Ventana_Medico vent) {
		setTitle("Listado de Ni\u00F1os");

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


		scrollPane1 = new JScrollPane();
		table_1 = new JTable();
		scrollPane1.setViewportView(table_1);

		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ListadoNinnos.this.dispose();
			}
		});

		lblBusquedaPorCarnet = new JLabel("Busqueda por carnet:");

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
					JOptionPane.showMessageDialog(ListadoNinnos.this, "Carn� No V�lido","Carn� Incorrecto",0);
				}
				else
				{
					Paciente pac = cmf.buscarPorID(IDPaciente.getText()); 
					if(pac == null)
						JOptionPane.showMessageDialog(ListadoNinnos.this, "No se encontr� un ni�o con ese n�mero de carn�","Ni�o no encontrado",2);

					else
					{
						if(pac.getEdad() == 0){
							cargarTablaconPaciente(cmf, pac);
							contentPane.repaint();
						}
						else
							JOptionPane.showMessageDialog(ListadoNinnos.this, "No se encontr� un ni�o con ese n�mero de carn�","Ni�o no encontrado",2);
					}
				}
			}
		});

		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				TablaNinnos(cmf);
				contentPane.repaint();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(128)
										.addComponent(IDPaciente, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblBusquedaPorCarnet, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
										.addGap(35)
										.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
										.addGap(39)
										.addComponent(btnMostrarTodos, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
												.addGap(5))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addContainerGap(437, Short.MAX_VALUE)
														.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
														.addGap(5))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(2)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(1)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(IDPaciente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addGap(3)
														.addComponent(lblBusquedaPorCarnet))))
														.addComponent(btnBuscar)
														.addComponent(btnMostrarTodos))
														.addGap(11)
														.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
														.addGap(11)
														.addComponent(btnVolver)
														.addGap(1))
				);
		contentPane.setLayout(gl_contentPane);


		TablaNinnos(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}

	public void TablaNinnos(CMF cmf)
	{
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Ninno> pacientes = cmf.getNinnos();
		for (Ninno ninno : pacientes)
		{	
			numhc.add(ninno.getNumeroHC());
			if(idpaciente)
				id.add(ninno.getID());
			if(nombre)
				nombrepac.add(ninno.getNombre());
			if(direcion)
				direccionpac.add(ninno.getDireccion());
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
