package visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logica.Enfermedad;
import logica.Historia_Clinica;
import logica.ResultadoAnalisis;
import logica.Vacunacion;
import logica.Visita;

public class HistoriaClinica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JToolBar toolBar;
	private JToolBar toolBar_1;
	private JTabbedPane tabbedPane;
	private JLabel lblHistoriaClinica;
	private JLabel lblId;
	private JLabel paraelnombre;
	private JLabel paraelID;
	private boolean fecha = true;
	private boolean resu = true;
	private boolean nombree = true;
	private boolean fecharesultadoo = true;
	private boolean nombredelavacuna = true;
	/**
	 * @wbp.nonvisual location=567,59
	 */
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	private JScrollPane scrollPane;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	/**
	 * @wbp.nonvisual location=557,109
	 */
	private DefaultTableModel defaultTableModel_1 = new DefaultTableModel();
	/**
	 * @wbp.nonvisual location=592,159
	 */
	private final DefaultListModel Enfermedades = new DefaultListModel();
	private JList listEnfermedades;
	private JButton btnVerConsulta;
	private JToolBar toolBar_2;
	private JScrollPane scrollPane_3;
	/**
	 * @wbp.nonvisual location=547,219
	 */
	private DefaultTableModel defaultTableModelVacunaciones = new DefaultTableModel();
	private JTable Vacunaciones;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoriaClinica frame = new HistoriaClinica(null,null);
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
	public HistoriaClinica(final ListaPacientes lista,final Historia_Clinica hc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HistoriaClinica.class.getResource("/Images/icons8_Treatment_64.png")));
		this.setLocationRelativeTo(null);
		setTitle("Historia Clinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoriaClinica.this.dispose();
				lista.setVisible(true);
			}
		});
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.setLocationRelativeTo(null);

		JLabel lblNombre = new JLabel("Nombre:");

		lblId = new JLabel("ID:");

		paraelnombre = new JLabel(hc.getNombrePaciente());

		paraelID = new JLabel(hc.getIdPaciente());

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos M\u00E9dicos", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		toolBar = new JToolBar();
		toolBar.setToolTipText("Consultas");
		toolBar.setAutoscrolls(true);
		toolBar.setName("Visitas");
		tabbedPane.addTab("Consultas", null, toolBar, null);

		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(table.getSelectedRow() != -1){
					btnVerConsulta.setEnabled(true);
				}
			}
		});
		toolBar.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		toolBar_1 = new JToolBar();
		toolBar_1.setName("An\u00E1lisis");
		tabbedPane.addTab("Análisis", null, toolBar_1, null);

		scrollPane_1 = new JScrollPane();
		
		toolBar_1.add(scrollPane_1);

		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

		lblHistoriaClinica = new JLabel("Historia Clinica # ");
		lblHistoriaClinica.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText((new Integer(hc.getNumero())).toString() );
		
		btnVerConsulta = new JButton("Ver Consulta");
		btnVerConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerConsulta vercon = new VerConsulta(hc,table.getSelectedRow());
				vercon.setVisible(true);
			}
		});
		btnVerConsulta.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHistoriaClinica, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(7)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnVerConsulta, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGap(16))))
					.addGap(4))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHistoriaClinica)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnVerConsulta)))
		);
		
		JLabel lblEnfermedades = new JLabel("Enfermedades:");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		listEnfermedades = new JList();
		scrollPane_2.setViewportView(listEnfermedades);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(272)
							.addComponent(lblEnfermedades, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(paraelID, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(paraelnombre, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNombre)
					.addGap(11)
					.addComponent(lblId))
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblEnfermedades)
					.addGap(6)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addComponent(paraelID))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(paraelnombre))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(4)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
					.addGap(12))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(7)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addGap(4))
		);
		
		toolBar_2 = new JToolBar();
		tabbedPane.addTab("Vacunaciones", null, toolBar_2, null);
		
		scrollPane_3 = new JScrollPane();
		toolBar_2.add(scrollPane_3);
		
		Vacunaciones = new JTable();
		scrollPane_3.setViewportView(Vacunaciones);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		cargarListaEnfermedades(hc);
		cargarTablaconVisitas(hc);
		cargarTablaconResultadosAnalisis(hc);
		cargarTabladeVacunas(hc);
		contentPane.repaint();
	}

	public void cargarTablaconVisitas(Historia_Clinica hc){
		ArrayList<Object> num = new ArrayList<Object>();
		ArrayList<Object> fechas = new ArrayList<Object>();
		ArrayList<Visita> visitas = hc.getVisitas();
		int numb = 1;
		for(int i = 0;i < visitas.size();i++){
			Visita aux = visitas.get(i);
			numb = i +1;
			num.add(numb);
			if(fecha){
				DateFormat formatofecha = DateFormat.getDateInstance();
				String fecha = formatofecha.format(aux.getFecha());
				fechas.add(fecha);
			}
		}
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Numero",num.toArray());
		if(fecha)
			defaultTableModel.addColumn("Fecha",fechas.toArray());
		table.setModel(defaultTableModel);
	}
	///////////////////////////////////agregar fechas
	public void cargarTablaconResultadosAnalisis(Historia_Clinica hc){
		ArrayList<Object> fechamandado = new ArrayList<Object>();
		ArrayList<Object> nombre = new ArrayList<Object>();
		ArrayList<Object> resultado = new ArrayList<Object>();
		ArrayList<Object> fecharesultado = new ArrayList<Object>();
		ArrayList<ResultadoAnalisis> resultados = hc.obtenerResultadosAnalisis();
		for(int i = 0;i < resultados.size();i++){
			ResultadoAnalisis aux = resultados.get(i);
			DateFormat formatofecha = DateFormat.getDateInstance();
			String fecha = formatofecha.format(aux.getDiaMandado());
			fechamandado.add(fecha);
			if(nombree)
				nombre.add(aux.getNombreAnalisis());
			if(resu){
				resultado.add(aux.getResultado());
			}
			if(fecharesultadoo){
				String fechares = formatofecha.format(aux.getDiaResultado());
				fecharesultado.add(fechares);
			}
				
		}
		defaultTableModel_1 = new DefaultTableModel();
		defaultTableModel_1.addColumn("Fecha Expedido", fechamandado.toArray());
		if(nombree)
			defaultTableModel_1.addColumn("Tipo",nombre.toArray());
		if(resu)
			defaultTableModel_1.addColumn("Resultado",resultado.toArray());
		if(fecharesultadoo)
			defaultTableModel_1.addColumn("Fecha Resultado", fecharesultado.toArray());
		table_1.setModel(defaultTableModel_1);
	}
	public void cargarListaEnfermedades(Historia_Clinica hc){
		for(Enfermedad enf:hc.getEnfermedades()){
			Enfermedades.addElement(enf.getNombre_Enf());
		}
		listEnfermedades.setModel(Enfermedades);
		
	}
	public void cargarTabladeVacunas(Historia_Clinica hc){
		ArrayList<Object> fechas = new ArrayList<Object>();
		ArrayList<Object> nombrevacuna = new ArrayList<Object>();
		ArrayList<Vacunacion> vacunas = hc.getVacunaciones();
		for(int i = 0;i < vacunas.size();i++){
			Vacunacion aux = vacunas.get(i);
			DateFormat formatofecha = DateFormat.getDateInstance();
			String fecha = formatofecha.format(aux.getDiapuesta());
			fechas.add(fecha);
			if(nombredelavacuna){
				nombrevacuna.add(aux.getNombreVacuna());
			}
		}
		defaultTableModelVacunaciones = new DefaultTableModel();
		defaultTableModelVacunaciones.addColumn("Día",fechas.toArray());
		if(nombredelavacuna)
			defaultTableModelVacunaciones.addColumn("Tipo de Vacuna", nombrevacuna.toArray());
		Vacunaciones.setModel(defaultTableModelVacunaciones);
	}
}