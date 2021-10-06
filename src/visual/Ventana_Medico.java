package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
import java.awt.Font;


public class Ventana_Medico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CMF cmf = CMF.getInstancia();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Medico frame = new Ventana_Medico();
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
	public Ventana_Medico() {

		setTitle("CMF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Medico.class.getResource("/Images/Clinic_50px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 413);
		this.setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);


		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);

		JMenuItem mntmSalir = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(Ventana_Medico.this, "Desea cerrar sesi�n",
						"Cerrar Sesi�n", 0) == 0)
				{
					Ventana_Medico.this.setVisible(false);
					Autenticar aut = new Autenticar();
					aut.setVisible(true);
				}
			}
		});

		JMenu mnNuevo = new JMenu("Nuevo");
		mnNewMenu.add(mnNuevo);

		JMenuItem mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.setMnemonic('P');
		mntmPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Annadir_Paciente add = new Annadir_Paciente();
				add.setVisible(true);
			}
		});
		mnNuevo.add(mntmPaciente);

		JMenuItem mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarPacienteParaConsulta bus = new buscarPacienteParaConsulta();
				bus.setVisible(true);

			}
		});
		mnNuevo.add(mntmConsulta);

		JMenuItem mntmHojaDeCargo = new JMenuItem("Hoja de Cargo");
		mntmHojaDeCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				boolean creada =  cmf.crearHojaCargo();
				if(creada)
					JOptionPane.showMessageDialog(Ventana_Medico.this, "Ya esta creada la hoja de cargo del d�a","Hoja de Cargo ya Existe",0);
				else
					JOptionPane.showMessageDialog(Ventana_Medico.this, "Hoja de Cargo del d�a creada correctamente.","Hoja de cargo creada",-1);

			}
		});
		mnNuevo.add(mntmHojaDeCargo);
		mnNewMenu.add(mntmSalir);

		JMenu mnNewMenu_1 = new JMenu("Ver");
		menuBar.add(mnNewMenu_1);

		JMenu mnReportes = new JMenu("Listados");
		mnNewMenu_1.add(mnReportes);

		JMenuItem mntmListadoDePacientes = new JMenuItem("Listado de Pacientes");
		mntmListadoDePacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPacientes listap = new ListaPacientes(Ventana_Medico.this);
				listap.setVisible(true);
			}
		});
		mnReportes.add(mntmListadoDePacientes);

		JMenuItem mntmListadoDeEmbarazadas = new JMenuItem("Listado de Embarazadas");
		mntmListadoDeEmbarazadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadoEmbarazada listap = new ListadoEmbarazada(Ventana_Medico.this);
				listap.setVisible(true);
			}
		});
		mnReportes.add(mntmListadoDeEmbarazadas);

		JMenuItem mntmListadoDeNios = new JMenuItem("Listado de Ni\u00F1os");
		mntmListadoDeNios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ListadoNinnos listaninnos = new ListadoNinnos(Ventana_Medico.this);
				listaninnos.setVisible(true);
			}
		});
		mnReportes.add(mntmListadoDeNios);

		JMenuItem mntmListadoDePacientes_1 = new JMenuItem("Listado de Pacientes con Enfermedad");
		mntmListadoDePacientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ListadoPacientesEnfermos enfermos = new ListadoPacientesEnfermos(Ventana_Medico.this);;
				enfermos.setVisible(true);
			}
		});
		mnReportes.add(mntmListadoDePacientes_1);

		JMenu mnNewMenu_2 = new JMenu("Hoja de Cargo");
		mnReportes.add(mnNewMenu_2);

		JMenuItem mntmHojaDeCargo_1 = new JMenuItem("Hoja de Cargo del d\u00EDa");
		mnNewMenu_2.add(mntmHojaDeCargo_1);
		mntmHojaDeCargo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HojadeCargodelDia hoja = new HojadeCargodelDia(Ventana_Medico.this);
				hoja.setVisible(true);
			}
		});

		JMenuItem mntmListadoDeHojas = new JMenuItem("Listado de Hojas de Cargo");
		mnNewMenu_2.add(mntmListadoDeHojas);
		mntmListadoDeHojas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadodeHojasdeCargo listhojascargo = new ListadodeHojasdeCargo(Ventana_Medico.this);
				listhojascargo.setVisible(true);
			}
		});

		JMenu mnReportes_1 = new JMenu("Reportes");
		mnNewMenu_1.add(mnReportes_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Por ciento de mujeres embarazadas");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reportePorcientoMujeresEmbarazadas reporte = new reportePorcientoMujeresEmbarazadas();
				reporte.setVisible(true);
			}
		});
		mnReportes_1.add(mntmNewMenuItem);

		JMenuItem mntmPorCientoDe = new JMenuItem("Por ciento de enfermos por enfermedad");
		mntmPorCientoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				porcientoEnfermosporEnfermedad porc = new porcientoEnfermosporEnfermedad();
				porc.setVisible(true);
			}
		});
		mnReportes_1.add(mntmPorCientoDe);
		
		JMenuItem mntmPacientesMayoresQue = new JMenuItem("Pacientes Mayores que una edad");
		mntmPacientesMayoresQue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						JOptionPane.showMessageDialog(Ventana_Medico.this, "Debe ingresar n�meros","Error",2);
				}
			}
		});
		mnReportes_1.add(mntmPacientesMayoresQue);
		
		JMenuItem mntmPorCientoDe_1 = new JMenuItem("Por ciento de Pacientes Enfermos");
		mntmPorCientoDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String porciento = cmf.PorCientoEnfermos() + "";
				String mensaje = "El porciento de pacientes enfermos del consultorio m�dico es" + " " + porciento + "%";
				JOptionPane.showMessageDialog(Ventana_Medico.this, mensaje, "Porciento de Enfermos del CMF", -1);
			}
		});
		mnReportes_1.add(mntmPorCientoDe_1);

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

		JMenuItem mntmCrditos = new JMenuItem("Cr\u00E9ditos");
		mntmCrditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creditos cred = new Creditos();
				cred.setVisible(true);
			}
		});
		mnAcercaDe.add(mntmCrditos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Ventana_Medico.class.getResource("/Images/blue_geometic_cubes_4k-HD.jpg")));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 288, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
	}
}
