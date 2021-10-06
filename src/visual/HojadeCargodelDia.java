package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Hoja_Cargo;
import auxiliar.JFecha;

public class HojadeCargodelDia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private CMF cmf = CMF.getInstancia();
	private boolean nombre = true;
	private boolean edad = true;
	private boolean direcion = true;
	/**
	 * @wbp.nonvisual location=507,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HojadeCargodelDia frame = new HojadeCargodelDia(null);
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
	public HojadeCargodelDia(final Ventana_Medico vent) {
		
		setTitle("Hoja de Cargo del d\u00EDa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblFecha = new JLabel("Fecha:");
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HojadeCargodelDia.this.dispose();
				vent.setVisible(true);
			}
		});
		
		JFecha fchjun = new JFecha();
		DateFormat formatofecha = DateFormat.getDateInstance();
		String fecha = formatofecha.format(cmf.obtenerHcargoDia().getDia());
		fchjun.setText(fecha);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(fchjun, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(418)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblFecha))
						.addComponent(fchjun, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
		
		cargarTablaconHojadeCargo(cmf);
		contentPane.repaint();
		this.setLocationRelativeTo(null);
	}
	public void cargarTablaconHojadeCargo(CMF cmf){
		Hoja_Cargo c = cmf.obtenerHcargoDia();
		ArrayList<String> nombrepac = c.getNombrePacientes();
		ArrayList<Integer> edadpac = c.getEdad();
		ArrayList<String> direccpac = c.getDireccionPaciente();
		ArrayList<String> diagpac = c.getDiagnosticoPaciente();
		
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Nombre",nombrepac.toArray());
		if(nombre)
			defaultTableModel.addColumn("Edad",edadpac.toArray());
		if(edad)
			defaultTableModel.addColumn("Direccion",direccpac.toArray());
		if(direcion)
			defaultTableModel.addColumn("Diagnostico",diagpac.toArray());
		table.setModel(defaultTableModel);
		
	}
}