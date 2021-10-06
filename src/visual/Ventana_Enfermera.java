package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.CMF;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;


public class Ventana_Enfermera extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	protected CMF cmf = CMF.getInstancia() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Enfermera frame = new Ventana_Enfermera();
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
	public Ventana_Enfermera()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Enfermera.class.getResource("/Images/Clinic_50px.png")));
		setTitle("CMF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 436);
		this.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);

		JMenu mnEliminar = new JMenu("Eliminar");
		mnArchivo.add(mnEliminar);

		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				EliminarPaciente pe = new EliminarPaciente(Ventana_Enfermera.this);
				pe.setVisible(true);
			}
		});
		mnEliminar.add(mntmPaciente);

		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(Ventana_Enfermera.this, "Desea cerrar sesi�n",
						"Cerrar Sesi�n", 0) == 0)
				{
					Ventana_Enfermera.this.setVisible(false);
					Autenticar aut = new Autenticar();
					aut.setVisible(true);
				}
			}
		});

		JMenu mnVacunar = new JMenu("Vacunar");
		mnArchivo.add(mnVacunar);

		JMenuItem mntmPaciente_1 = new JMenuItem("Paciente");
		mntmPaciente_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				BuscarParaVacunar busc = new BuscarParaVacunar();
				busc.setVisible(true);
			}
		});
		mnVacunar.add(mntmPaciente_1);

		JMenu mnOpciones = new JMenu("Actualizar");
		mnArchivo.add(mnOpciones);

		JMenuItem mntmActualizar = new JMenuItem("Actualizar Resultados de An\u00E1lisis");
		mntmActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Pacientes_ResultadosPendientes listaPendeientes = new Pacientes_ResultadosPendientes(Ventana_Enfermera.this);
				listaPendeientes.setVisible(true);
			}
		});
		mnOpciones.add(mntmActualizar);

		JMenuItem mntmActualizarRegistroGeneral = new JMenuItem("Actualizar Registro General");
		mntmActualizarRegistroGeneral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cmf.act_RegistroGeneral();
				JOptionPane.showMessageDialog(Ventana_Enfermera.this, "Se han actualizado correctamente los datos del consultorio","Registro General Actualizado",-1);
			}
		});
		mnOpciones.add(mntmActualizarRegistroGeneral);
		mnArchivo.add(mntmCerrarSesion);

		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);

		JMenu mnListados = new JMenu("Listados");
		mnVer.add(mnListados);

		JMenuItem mntmListadoPacientes = new JMenuItem("Listado Pacientes");
		mntmListadoPacientes.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)
			{
				Ventana_Medico m = new Ventana_Medico();
				ListaPacientes pacinetes = new ListaPacientes(m);
				pacinetes.setVisible(true);
				pacinetes.cargarTablaPacientes(cmf);
				contentPane.repaint();
				m.disable();
			}
		});
		mnListados.add(mntmListadoPacientes);

		JMenuItem mntmListadoDeMujeres = new JMenuItem("Listado de Mujeres");
		mntmListadoDeMujeres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoMujeres muj = new ListadoMujeres(Ventana_Enfermera.this);
				muj.setVisible(true);
			}
		});
		mnListados.add(mntmListadoDeMujeres);

		JMenuItem mntmListadoDeMujeres_1 = new JMenuItem("Listado de Mujeres Embarazadas");
		mntmListadoDeMujeres_1.addActionListener(new ActionListener() 
		{
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Medico med = new Ventana_Medico();
				med.disable();
				ListadoEmbarazada embarazadas = new ListadoEmbarazada(med);
				embarazadas.setVisible(true);
				embarazadas.TabladeEmbarazadas(cmf);
				contentPane.repaint();	
			}
		});
		mnListados.add(mntmListadoDeMujeres_1);

		JMenuItem mntmListadoDeNios = new JMenuItem("Listado de Ni\u00F1os");
		mntmListadoDeNios.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) 
			{
				Ventana_Medico m = new Ventana_Medico();
				ListadoNinnos ninnos = new ListadoNinnos(m);
				ninnos.setVisible(true);
				ninnos.TablaNinnos(cmf);
				contentPane.repaint();
				m.disable();
			}
		});
		mnListados.add(mntmListadoDeNios);

		JMenu mnReportes = new JMenu("Reportes");
		mnVer.add(mnReportes);

		JMenuItem mntmPacientesMayoresQue = new JMenuItem("Pacientes Mayores que una edad");
		mntmPacientesMayoresQue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String aux = JOptionPane.showInputDialog("Introduce la edad a comparar");
				if(aux != null && !aux.isEmpty())
				{
					boolean valido = CMF.getInstancia().validarEntrada(aux);
					if(valido)
					{
					int edad = Integer.parseInt(aux.toString());
					cmf.Mayores(edad);
					ListaMayoresQueEdad may = new ListaMayoresQueEdad(edad);
					may.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(Ventana_Enfermera.this, "Debe ingresar n�meros","Error",2);
				}
			}
		});
		
		JMenuItem mntmPorCientoDe_1 = new JMenuItem("Por ciento de mujeres embarazadas");
		mntmPorCientoDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportePorcientoMujeresEmbarazadas reporte = new reportePorcientoMujeresEmbarazadas();
				reporte.setVisible(true);
			}
		});
		mnReportes.add(mntmPorCientoDe_1);
		
		JMenuItem mntmPorCientoDe_2 = new JMenuItem("Por ciento de enfermos por enfermedad");
		mntmPorCientoDe_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				porcientoEnfermosporEnfermedad porc = new porcientoEnfermosporEnfermedad();
				porc.setVisible(true);
			}
		});
		mnReportes.add(mntmPorCientoDe_2);
		mnReportes.add(mntmPacientesMayoresQue);

		JMenuItem mntmPorCientoDe = new JMenuItem("Por ciento de Pacientes Enfermos ");
		mntmPorCientoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String porciento = cmf.PorCientoEnfermos() + "";
				String mensaje = "El porciento de pacientes enfermos del consultorio m�dico es" + " " + porciento + "%";
				JOptionPane.showMessageDialog(Ventana_Enfermera.this, mensaje, "Porciento de Enfermos del CMF", -1);
			}
		});
		mnReportes.add(mntmPorCientoDe);

		JMenu mnAcercaDe = new JMenu("Acerca de");
		menuBar.add(mnAcercaDe);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayuda aud = new Ayuda();
				aud.setVisible(true);
			}
		});
		mnAcercaDe.add(mntmAyuda);

		JMenuItem mntmCreditos = new JMenuItem("Cr\u00E9ditos");
		mntmCreditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creditos cred = new Creditos();
				cred.setVisible(true);
			}
		});
		mnAcercaDe.add(mntmCreditos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Ventana_Enfermera.class.getResource("/Images/blue_geometic_cubes_4k-HD.jpg")));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 424, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 253, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
	}
}