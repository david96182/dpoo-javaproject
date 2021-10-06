package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Enfermedad;
import logica.Paciente;


public class RegistrarEnfermedades extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	private JScrollPane scrollPane_1;
	private long numhcpac = 0;
	private CMF cmf = CMF.getInstancia();
	
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEnfermedades frame = new RegistrarEnfermedades(null);
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
	public RegistrarEnfermedades(String IDpac) 
	{
		setTitle("Enfermedades");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 394, 91);
		panel.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 11, 58, 14);
		panel.add(lblNombre);
		
		JTextFieldMejorado nombre = new JTextFieldMejorado();
		nombre.setEditable(false);
		nombre.setBounds(78, 8, 204, 20);
		panel.add(nombre);
		nombre.setText(cmf.getPacientes().get(cmf.posicionPaciente(IDpac)).getNombre());
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(47, 42, 46, 14);
		panel.add(lblId);
		
		JTextFieldMejorado ID = new JTextFieldMejorado();
		ID.setEditable(false);
		ID.setBounds(78, 39, 124, 20);
		panel.add(ID);
		ID.setColumns(10);
        ID.setText(IDpac);
		
		JLabel lblNumeroHc = new JLabel("Numero HC:");
		lblNumeroHc.setBounds(247, 42, 72, 14);
		panel.add(lblNumeroHc);
		
		JTextFieldMejorado numeroHC = new JTextFieldMejorado();
		numeroHC.setEditable(false);
		numeroHC.setBounds(323, 39, 46, 20);
		panel.add(numeroHC);
		numeroHC.setColumns(10);
		String numerohist = cmf.buscarPorID(IDpac).getNumeroHC() + "";
		numhcpac = cmf.buscarPorID(IDpac).getNumeroHC();
		numeroHC.setText(numerohist);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(10, 82, 58, 14);
		panel.add(lblDireccin);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(78, 70, 293, 40);
		panel.add(scrollPane_1);
		
		JTextArea direccion = new JTextArea();
		direccion.setLineWrap(true);
		direccion.setEnabled(false);
		scrollPane_1.setViewportView(direccion);
		direccion.setText(cmf.getPacientes().get(cmf.posicionPaciente(IDpac)).getDireccion());
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegistrarEnfermedades.this.dispose();
			}
		});
		btnVolver.setBounds(335, 257, 89, 23);
		contentPane.add(btnVolver);
		
		JButton btnQuitarEnfermedad = new JButton("Quitar Enfermedad");
		btnQuitarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		btnQuitarEnfermedad.setBounds(174, 257, 151, 23);
		contentPane.add(btnQuitarEnfermedad);
		
		JButton btnAgregarEnfermedad = new JButton("Agregar Enfermedad");
		btnAgregarEnfermedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAgregarEnfermedad.setBounds(10, 257, 154, 23);
		contentPane.add(btnAgregarEnfermedad);
		this.setLocationRelativeTo(null);
		
		TablaNombreDeEnfermedades(cmf);
		contentPane.repaint();
	}
	
	public void TablaNombreDeEnfermedades(CMF cmf)
	{	
		ArrayList<Object> nombre = new ArrayList<Object>();
		scrollPane_1.setVisible(true);

		Paciente pac = cmf.buscarNumeroHC(numhcpac);
		ArrayList<Enfermedad> enfermedades = pac.getEnfermedades();

		for (Enfermedad enf : enfermedades)
		{
			nombre.add(enf.getNombre_Enf());
		}

		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nombre",nombre.toArray());
		table_1.setModel(defaultTableModel);
		contentPane.repaint();
	}
}
