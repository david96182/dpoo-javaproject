package visual;

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
import logica.Paciente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ListaMayoresQueEdad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
    private CMF cmf = CMF.getInstancia();
	private boolean idpaciente = true;
	private boolean nombre = true;
	private boolean direcion = true;
	private JTable table_1;
	private JTextFieldMejorado textFieldMejorado;
	/**
	 * @wbp.nonvisual location=47,349
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JButton btnBuscar;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaMayoresQueEdad frame = new ListaMayoresQueEdad();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	
	/**
	 * Create the frame.
	 */
	public ListaMayoresQueEdad(int edad) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 500, 261);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ListaMayoresQueEdad.this.dispose();
			}
		});
		btnVolver.setBounds(421, 308, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblBusquedaPorCarnet = new JLabel("Busqueda por carné:");
		lblBusquedaPorCarnet.setBounds(10, 11, 118, 14);
		contentPane.add(lblBusquedaPorCarnet);
		
		textFieldMejorado = new JTextFieldMejorado();
		textFieldMejorado.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) || textFieldMejorado.getText().length()>10) 
				{
					getToolkit().beep();
					e.consume();

				}
				if(e.getKeyChar()== KeyEvent.VK_ENTER)
					btnBuscar.doClick();
			}
		});
		textFieldMejorado.setLimite(11);
		textFieldMejorado.setBounds(143, 8, 108, 20);
		contentPane.add(textFieldMejorado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Paciente aux = cmf.buscarPorID(textFieldMejorado.getText());
				if(textFieldMejorado.getText().equals(""))
					JOptionPane.showMessageDialog(ListaMayoresQueEdad.this, "No puede estar vacío el campo de ID","Error en los datos",2);
				else
					if(aux == null)
						JOptionPane.showMessageDialog(ListaMayoresQueEdad.this,"No hay un paciente registrado con ese carné","Paciente no encontrado",2);
					else
					{
						cargarTablaconPaciente(cmf, aux);
						contentPane.repaint();
					}
			}
		});
		btnBuscar.setBounds(274, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnMostrarTodos = new JButton("Mostrar Todos");
		btnMostrarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cargarTablaPacientes();
				contentPane.repaint();
			}
		});
		btnMostrarTodos.setBounds(397, 7, 113, 23);
		contentPane.add(btnMostrarTodos);
		
		cargarTablaPacientes();
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}
	
	public void cargarTablaPacientes()
	{
		ArrayList<Object> numhc = new ArrayList<Object>();
		ArrayList<Object> id = new ArrayList<Object>();
		ArrayList<Object> nombrepac = new ArrayList<Object>();
		ArrayList<Object> direccionpac = new ArrayList<Object>();
		ArrayList<Paciente> mayores = cmf.getMayores();
		for(int i = 0;i < mayores.size();i++){
			Paciente aux = mayores.get(i);
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
