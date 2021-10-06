package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import logica.CMF;
import logica.Enfermedad;
import logica.ResultadoAnalisis;

public class registrarConsulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	private CMF cmf = CMF.getInstancia();
	private JTextField nombre;
	private JTextField ID;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JLabel lblDireccin;
	private JLabel lblDiagnstico;
	private JLabel lblTratamiento;
	private JScrollPane scrollPane_1;
	private JTextArea diagnostico;
	private JPanel panel_3;
	private JPanel panel_2;
	private JScrollPane scrollPane_2;
	private JTextArea indicaciones;
	private JTextArea tratamiento;
	private JSpinner Edad;
	private JScrollPane scrollPane_3;
	private JTextArea Direccion;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_4;
	private JScrollPane scrollPane_5;
	/**
	 * @wbp.nonvisual location=452,89
	 */
	private final DefaultListModel EnfermedadesDisponibles = new DefaultListModel();
	/**
	 * @wbp.nonvisual location=452,139
	 */
	private DefaultListModel EnfermedadesdelPaciente = new DefaultListModel();
	private JList listEnfermedadesDisponibles;
	private JList listEnfermedadesPaciente;
	private JButton btnNewButtonAgregarENfalPaciente;
	private JButton btnNewButtonEliminarEnfePaciente;
	private JButton btnNewButtonAgregarEnfermedadDisponible;
	/**
	 * @wbp.nonvisual location=472,199
	 */
	private final DefaultListModel AnalisisRegistrados = new DefaultListModel();
	/**
	 * @wbp.nonvisual location=452,259
	 */
	private final DefaultListModel AnalisisporHacerPaciente = new DefaultListModel();
	private JList listAnalisisRegistrados;
	private JList listAnalisisporHacerPaciente;
	private JButton AgregarAnalisis;
	private JButton EliminarAnalisis;
	private JButton AgregarotroAnalisis;
	private JScrollPane scrollPane_8;
	private JScrollPane scrollPane_9;
	private JList listEspecialidadesRegistradas;
	private JList listEspecialidadesaRemitirAlPaciente;
	private JButton AgregarEspecilidadalPaciente;
	private JButton EliminarEspecialidaddelPaciente;
	/**
	 * @wbp.nonvisual location=422,329
	 */
	private final DefaultListModel defaultListModelEspecialidadesRegistradas = new DefaultListModel();
	/**
	 * @wbp.nonvisual location=432,369
	 */
	private final DefaultListModel defaultListModelEspecialidadesAremitirPaciente = new DefaultListModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			registrarConsulta dialog = new registrarConsulta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public registrarConsulta(final String IDpac) {
		setModal(true);
		setTitle("Registrar Consulta");
		setResizable(false);
		setBounds(100, 100, 450, 513);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 424, 429);
		tabbedPane.setName("");
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPanel.add(tabbedPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setToolTipText("Datos del paciente");
		tabbedPane.addTab("Datos del Paciente", null, toolBar, null);

		JPanel panel = new JPanel();
		panel.setEnabled(false);
		panel.setName("Datos Paciente");
		toolBar.add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(22, 25, 56, 14);
		panel.add(lblNewLabel);

		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(87, 22, 288, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		nombre.setText(cmf.getPacientes().get(cmf.posicionPaciente(IDpac)).getNombre());

		lblId = new JLabel("ID:");
		lblId.setBounds(53, 90, 46, 14);
		panel.add(lblId);

		ID = new JTextField();
		ID.setEditable(false);
		ID.setBorder(new LineBorder(new Color(171, 173, 179)));
		ID.setBounds(87, 87, 109, 20);
		panel.add(ID);
		ID.setColumns(10);
		ID.setText(IDpac);
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(43, 133, 56, 14);
		panel.add(lblEdad);

		lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(22, 158, 77, 14);
		panel.add(lblDireccin);

		Edad = new JSpinner();
		Edad.setEnabled(false);
		Edad.setBounds(87, 126, 40, 20);
		panel.add(Edad);
		Edad.setValue(cmf.getPacientes().get(cmf.posicionPaciente(IDpac)).getEdad());

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(87, 158, 290, 40);
		panel.add(scrollPane_3);

		Direccion = new JTextArea();
		scrollPane_3.setViewportView(Direccion);
		Direccion.setEnabled(false);
		Direccion.setLineWrap(true);
		Direccion.setText(cmf.getPacientes().get(cmf.posicionPaciente(IDpac)).getDireccion());

		lblNewLabel_2 = new JLabel("N\u00FAmero HC:");
		lblNewLabel_2.setBounds(10, 56, 77, 14);
		panel.add(lblNewLabel_2);

		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(87, 53, 32, 20);
		panel.add(textField);
		textField.setColumns(10);
		String numerohist = cmf.buscarPorID(IDpac).getNumeroHC() + "";
		textField.setText(numerohist);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Enfermedades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 215, 386, 173);
		panel.add(panel_5);
		panel_5.setLayout(null);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 21, 128, 111);
		panel_5.add(scrollPane_4);

		listEnfermedadesDisponibles = new JList();
		listEnfermedadesDisponibles.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEnfermedadesDisponibles.getSelectedValue() !=null)
					btnNewButtonAgregarENfalPaciente.setEnabled(true);
			}
		});
		scrollPane_4.setViewportView(listEnfermedadesDisponibles);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(248, 21, 128, 111);
		panel_5.add(scrollPane_5);

		listEnfermedadesPaciente = new JList();
		listEnfermedadesPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEnfermedadesPaciente.getSelectedValue() !=null)
					btnNewButtonEliminarEnfePaciente.setEnabled(true);
			}
		});
		scrollPane_5.setViewportView(listEnfermedadesPaciente);

		btnNewButtonAgregarENfalPaciente = new JButton("Agregar");
		btnNewButtonAgregarENfalPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEnfermedadesDisponibles.getSelectedValue() != null){
					EnfermedadesdelPaciente.addElement(listEnfermedadesDisponibles.getSelectedValue());
					EnfermedadesDisponibles.removeElement(listEnfermedadesDisponibles.getSelectedValue());
					listEnfermedadesDisponibles.setModel(EnfermedadesDisponibles);
					listEnfermedadesPaciente.setModel(EnfermedadesdelPaciente);
				}
			}
		});
		btnNewButtonAgregarENfalPaciente.setEnabled(false);
		btnNewButtonAgregarENfalPaciente.setBounds(149, 47, 89, 23);
		panel_5.add(btnNewButtonAgregarENfalPaciente);

		btnNewButtonEliminarEnfePaciente = new JButton("Eliminar");
		btnNewButtonEliminarEnfePaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEnfermedadesPaciente.getSelectedValue() != null){
					EnfermedadesDisponibles.addElement(listEnfermedadesPaciente.getSelectedValue());
					EnfermedadesdelPaciente.removeElement(listEnfermedadesPaciente.getSelectedValue());
					listEnfermedadesDisponibles.setModel(EnfermedadesDisponibles);
					listEnfermedadesPaciente.setModel(EnfermedadesdelPaciente);
					//cmf.eliminarEnfermedad(listEnfermedadesPaciente.getSelectedValue().toString(),IDpac);
				}
			}
		});
		btnNewButtonEliminarEnfePaciente.setEnabled(false);
		btnNewButtonEliminarEnfePaciente.setBounds(149, 91, 89, 23);
		panel_5.add(btnNewButtonEliminarEnfePaciente);

		btnNewButtonAgregarEnfermedadDisponible = new JButton("Agregar Otra");
		btnNewButtonAgregarEnfermedadDisponible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tam = cmf.getEnfermedades().size();
				agregarNuevaEnfermedad nuevaEnf = new agregarNuevaEnfermedad();
				nuevaEnf.setVisible(true);
				if(tam != cmf.getEnfermedades().size()){
					EnfermedadesDisponibles.addElement(CMF.getInstancia().getEnfermedades().get(CMF.getInstancia().getEnfermedades().size()-1).getNombre_Enf());
					listEnfermedadesDisponibles.setModel(EnfermedadesDisponibles);
				}
			}

		});
		btnNewButtonAgregarEnfermedadDisponible.setBounds(20, 143, 111, 23);
		panel_5.add(btnNewButtonAgregarEnfermedadDisponible);

		JToolBar toolBar_1 = new JToolBar();
		tabbedPane.addTab("Datos de la Consulta", null, toolBar_1, null);

		JPanel panel_1 = new JPanel();
		toolBar_1.add(panel_1);
		panel_1.setLayout(null);

		lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setBounds(10, 11, 74, 14);
		panel_1.add(lblDiagnstico);

		lblTratamiento = new JLabel("Tratamiento:");
		lblTratamiento.setBounds(10, 130, 74, 14);
		panel_1.add(lblTratamiento);

		JLabel lblNewLabel_1 = new JLabel("Indicaciones Complementarias:");
		lblNewLabel_1.setBounds(10, 262, 244, 14);
		panel_1.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(40, 36, 356, 89);
		panel_1.add(scrollPane);

		diagnostico = new JTextArea();
		diagnostico.setLineWrap(true);
		scrollPane.setViewportView(diagnostico);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(40, 156, 356, 89);
		panel_1.add(scrollPane_1);

		tratamiento = new JTextArea();
		tratamiento.setLineWrap(true);
		scrollPane_1.setViewportView(tratamiento);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(40, 287, 356, 83);
		panel_1.add(scrollPane_2);

		indicaciones = new JTextArea();
		indicaciones.setLineWrap(true);
		scrollPane_2.setViewportView(indicaciones);

		JToolBar toolBar_2 = new JToolBar();
		tabbedPane.addTab("Remisiones y Análisis", null, toolBar_2, null);

		panel_3 = new JPanel();
		toolBar_2.add(panel_3);
		panel_3.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Remisiones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 11, 386, 164);
		panel_3.add(panel_2);
		
		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 21, 119, 105);
		panel_2.add(scrollPane_8);
		
		listEspecialidadesRegistradas = new JList();
		listEspecialidadesRegistradas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEspecialidadesRegistradas.getSelectedValue() != null)
					AgregarEspecilidadalPaciente.setEnabled(true);
			}
		});
		scrollPane_8.setViewportView(listEspecialidadesRegistradas);
		
		scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(253, 21, 123, 105);
		panel_2.add(scrollPane_9);
		
		listEspecialidadesaRemitirAlPaciente = new JList();
		listEspecialidadesaRemitirAlPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listEspecialidadesaRemitirAlPaciente.getSelectedValue() != null)
					EliminarEspecialidaddelPaciente.setEnabled(true);
			}
		});
		scrollPane_9.setViewportView(listEspecialidadesaRemitirAlPaciente);
		
		AgregarEspecilidadalPaciente = new JButton("Agregar");
		AgregarEspecilidadalPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEspecialidadesRegistradas.getSelectedValue() != null){
					defaultListModelEspecialidadesAremitirPaciente.addElement(listEspecialidadesRegistradas.getSelectedValue());
					defaultListModelEspecialidadesRegistradas.removeElement(listEspecialidadesRegistradas.getSelectedValue());
					listEspecialidadesRegistradas.setModel(defaultListModelEspecialidadesRegistradas);
					listEspecialidadesaRemitirAlPaciente.setModel(defaultListModelEspecialidadesAremitirPaciente);
				}
			}
		});
		AgregarEspecilidadalPaciente.setEnabled(false);
		AgregarEspecilidadalPaciente.setBounds(154, 47, 89, 23);
		panel_2.add(AgregarEspecilidadalPaciente);
		
		EliminarEspecialidaddelPaciente = new JButton("Eliminar");
		EliminarEspecialidaddelPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listEspecialidadesaRemitirAlPaciente.getSelectedValue() != null){
					defaultListModelEspecialidadesRegistradas.addElement(listEspecialidadesaRemitirAlPaciente.getSelectedValue());
					defaultListModelEspecialidadesAremitirPaciente.removeElement(listEspecialidadesaRemitirAlPaciente.getSelectedValue());
					listEspecialidadesRegistradas.setModel(defaultListModelEspecialidadesRegistradas);
					listEspecialidadesaRemitirAlPaciente.setModel(defaultListModelEspecialidadesAremitirPaciente);
				}
			}
		});
		EliminarEspecialidaddelPaciente.setEnabled(false);
		EliminarEspecialidaddelPaciente.setBounds(154, 81, 89, 23);
		panel_2.add(EliminarEspecialidaddelPaciente);
		
		JButton AgregarNuevaEspecialidadd = new JButton("Agregar Otra");
		AgregarNuevaEspecialidadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tam = CMF.getInstancia().getEspecialidadesregistradas().size();
				agregarNuevaEspecialidad nuevaesp = new agregarNuevaEspecialidad();
				nuevaesp.setVisible(true);
				if(tam != CMF.getInstancia().getEspecialidadesregistradas().size()){
					defaultListModelEspecialidadesRegistradas.addElement(CMF.getInstancia().getEspecialidadesregistradas().get(tam));
					listEspecialidadesRegistradas.setModel(defaultListModelEspecialidadesRegistradas);
				}
			}
		});
		AgregarNuevaEspecialidadd.setBounds(10, 130, 119, 23);
		panel_2.add(AgregarNuevaEspecialidadd);

		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "An\u00E1lisis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 186, 386, 175);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 22, 118, 110);
		panel_4.add(scrollPane_6);

		listAnalisisRegistrados = new JList();
		listAnalisisRegistrados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(listAnalisisRegistrados.getSelectedValue() != null){
					AgregarAnalisis.setEnabled(true);
				}
			}
		});
		scrollPane_6.setViewportView(listAnalisisRegistrados);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(258, 22, 118, 110);
		panel_4.add(scrollPane_7);

		listAnalisisporHacerPaciente = new JList();
		listAnalisisporHacerPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(listAnalisisporHacerPaciente.getSelectedValue() != null){
					EliminarAnalisis.setEnabled(true);
				}
			}
		});
		scrollPane_7.setViewportView(listAnalisisporHacerPaciente);

		AgregarAnalisis = new JButton("Agregar");
		AgregarAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listAnalisisRegistrados.getSelectedValue() != null){
					AnalisisporHacerPaciente.addElement(listAnalisisRegistrados.getSelectedValue());
					AnalisisRegistrados.removeElement(listAnalisisRegistrados.getSelectedValue());
					listAnalisisRegistrados.setModel(AnalisisRegistrados);
					listAnalisisporHacerPaciente.setModel(AnalisisporHacerPaciente);
				}
			}
		});
		AgregarAnalisis.setEnabled(false);
		AgregarAnalisis.setBounds(148, 46, 89, 23);
		panel_4.add(AgregarAnalisis);

		EliminarAnalisis = new JButton("Eliminar");
		EliminarAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listAnalisisporHacerPaciente.getSelectedValue() != null){
					AnalisisRegistrados.addElement(listAnalisisporHacerPaciente.getSelectedValue());
					AnalisisporHacerPaciente.removeElement(listAnalisisporHacerPaciente.getSelectedValue());
					listAnalisisRegistrados.setModel(AnalisisRegistrados);
					listAnalisisporHacerPaciente.setModel(AnalisisporHacerPaciente);
				}
			}
		});
		EliminarAnalisis.setEnabled(false);
		EliminarAnalisis.setBounds(148, 80, 89, 23);
		panel_4.add(EliminarAnalisis);

		AgregarotroAnalisis = new JButton("Agregar Otro");
		AgregarotroAnalisis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tam = cmf.getTiposdeanalisis().size();
				agregartipoDeAnalisis agreAnalisis = new agregartipoDeAnalisis();
				agreAnalisis.setVisible(true);
				if(tam != cmf.getTiposdeanalisis().size()){
					AnalisisRegistrados.addElement(cmf.getTiposdeanalisis().get(cmf.getTiposdeanalisis().size()-1));
					listAnalisisRegistrados.setModel(AnalisisRegistrados);
				}
			}
		});
		AgregarotroAnalisis.setBounds(10, 141, 111, 23);
		panel_4.add(AgregarotroAnalisis);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(JOptionPane.showConfirmDialog(registrarConsulta.this, "Desea registrar la consulta",
								"Registrar Consulta", 0) == 0)
						{
						String idpac = ID.getText();
						boolean datoincorrecto = false;
						String diag = diagnostico.getText();
						String trapac = tratamiento.getText();
						String indicpac = indicaciones.getText();
						ArrayList<String> remicion = new ArrayList<String>();
						ArrayList<ResultadoAnalisis> analisis = new ArrayList<ResultadoAnalisis>();

						if(idpac.replaceAll(" ", "").equalsIgnoreCase("")){
							lblId.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblId.setForeground(Color.BLACK);

						if(diag.replaceAll(" ", "").equalsIgnoreCase("")){
							lblDiagnstico.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblDiagnstico.setForeground(Color.BLACK);
						if(trapac.replaceAll(" ", "").equalsIgnoreCase("")){
							lblTratamiento.setForeground(Color.RED);
							datoincorrecto = true;
						}
						else
							lblTratamiento.setForeground(Color.BLACK);
						if(datoincorrecto)
							JOptionPane.showMessageDialog(registrarConsulta.this,"No pueden estar vacíos los campos resaltados en rojo","Error en los datos",2);
						else{
							for(int i = 0;i < defaultListModelEspecialidadesAremitirPaciente.getSize();i++){
								remicion.add(defaultListModelEspecialidadesAremitirPaciente.get(i).toString());
							}
							Calendar r = Calendar.getInstance();
							Date fecha = (Date)r.getTime();
							for(int i = 0;i < AnalisisporHacerPaciente.getSize();i++){
								analisis.add(new ResultadoAnalisis(AnalisisporHacerPaciente.getElementAt(i).toString(),"",fecha ));
							}
							if(cmf.registrarConsulta(idpac, diag, trapac, indicpac,remicion,analisis) == 2){
								JOptionPane.showMessageDialog(registrarConsulta.this, "Consulta Registrada Correctamente.","Consulta Registrada",-1);
								ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
								for(int i = 0;i < EnfermedadesdelPaciente.getSize();i++){
									enfermedades.add(new Enfermedad(EnfermedadesdelPaciente.getElementAt(i).toString()));
								}
								cmf.modificarEnfsPaciente(IDpac, enfermedades);
								registrarConsulta.this.dispose();
							}
							else if(cmf.registrarConsulta( idpac, diag, trapac, indicpac,remicion,analisis) == 0){
								JOptionPane.showMessageDialog(registrarConsulta.this, "El paciente no existe.");
							}
							else if(cmf.registrarConsulta(idpac, diag, trapac, indicpac,remicion,analisis) == 1){
								JOptionPane.showMessageDialog(registrarConsulta.this, "El paciente no tiene una historia clínica.");
							}
						}
					}
					}
					
				});
				okButton.setActionCommand("Registrar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						registrarConsulta.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarListas(IDpac);
		cargarListasAnalisis();
		cargarListaRemisiones();
	}
	public void cargarListas(String IDpac){

		if(cmf.pacienteEnfermo(IDpac) ){
			ArrayList<Enfermedad> aux = cmf.obtenerEnfermedadesdePaciente(IDpac);
			for(int i = 0;i < aux.size();i++){
				EnfermedadesdelPaciente.addElement(aux.get(i).getNombre_Enf());
			}
			listEnfermedadesPaciente.setModel(EnfermedadesdelPaciente);
			ArrayList<Enfermedad> enfdispo = cmf.getEnfermedades();
			for(int i = 0;i < enfdispo.size();i++){
				boolean encontrada = false;
				for(int j = 0;j < aux.size();j++)
					if(enfdispo.get(i).getNombre_Enf().equalsIgnoreCase(aux.get(j).getNombre_Enf())){
						encontrada = true;
					}
				if(!encontrada)
					EnfermedadesDisponibles.addElement(enfdispo.get(i).getNombre_Enf());
			}
			listEnfermedadesDisponibles.setModel(EnfermedadesDisponibles);
		}
		else{
			EnfermedadesdelPaciente = new DefaultListModel();
			listEnfermedadesPaciente.setModel(EnfermedadesdelPaciente);


			ArrayList<Enfermedad> enfdispo = CMF.getInstancia().getEnfermedades();
			for(int i = 0;i < enfdispo.size();i++){
				EnfermedadesDisponibles.addElement(enfdispo.get(i).getNombre_Enf());
			}
			listEnfermedadesDisponibles.setModel(EnfermedadesDisponibles);
		}
	}
	public void cargarListasAnalisis(){
		ArrayList<String> analisis = cmf.getTiposdeanalisis();
		for(int i = 0;i < analisis.size();i++){
			AnalisisRegistrados.addElement(analisis.get(i));
		}
		listAnalisisRegistrados.setModel(AnalisisRegistrados);
	}
	public void cargarListaRemisiones(){
		ArrayList<String> remisiones = CMF.getInstancia().getEspecialidadesregistradas();
		for(int i = 0;i < remisiones.size();i++){
		    defaultListModelEspecialidadesRegistradas.addElement(remisiones.get(i));
		}
		listEspecialidadesRegistradas.setModel(defaultListModelEspecialidadesRegistradas);
	}
}
