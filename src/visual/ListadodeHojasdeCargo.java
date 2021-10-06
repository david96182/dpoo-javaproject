package visual;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.CMF;
import logica.Hoja_Cargo;

public class ListadodeHojasdeCargo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableDias;
	private JTable table_1HojaSeleccionada;
	
	private boolean nombre = true;
	private boolean edad = true;
	private boolean direcion = true;
	/**
	 * @wbp.nonvisual location=602,149
	 */
	private DefaultTableModel Hojadecargodeldiaseleccionado = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListadodeHojasdeCargo frame = new ListadodeHojasdeCargo(null);
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
	public ListadodeHojasdeCargo(final Ventana_Medico vent) {
		setTitle("Listado de Hojas de Cargo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 406);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tableDias.getSelectedRow() > -1){
					int row = tableDias.getSelectedRow();
					String dia = (String) tableDias.getValueAt(row, 0);
					cargarTablasCHojaCargo(dia);
					contentPane.repaint();
				}
				else{
					JOptionPane.showConfirmDialog(ListadodeHojasdeCargo.this, "No se seleciono una fecha para ver la hoja de cargo de ese día","Día no seleccionado",2);
				}
			}
		});

		tableDias = new JTable();
		scrollPane.setViewportView(tableDias);
		JScrollPane scrollPane_1 = new JScrollPane();
		
		table_1HojaSeleccionada = new JTable();
		scrollPane_1.setViewportView(table_1HojaSeleccionada);
        
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListadodeHojasdeCargo.this.dispose();
				vent.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGap(7)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addContainerGap(524, Short.MAX_VALUE)
												.addComponent(btnVolver)))
												.addGap(8))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(7)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnVolver)
								.addGap(10))
				);
		contentPane.setLayout(gl_contentPane);
		cargartablaCondias();
		contentPane.repaint();
	}
	public void cargartablaCondias(){
		ArrayList<ArrayList<Hoja_Cargo>> hojascargo = CMF.getInstancia().getHojas_Cargo();
		ArrayList<Object> fechas = new ArrayList<Object>();
		for(int i = 0;i < hojascargo.size();i++){
			ArrayList<Hoja_Cargo> aux = hojascargo.get(i);
			for(int j = 0;j < aux.size();j++){
				DateFormat formatofecha = DateFormat.getDateInstance();
				String fecha = formatofecha.format(aux.get(j).getDia());
				fechas.add(fecha);
			}

		}
		DefaultTableModel fechasdeHojasdeCargo = new DefaultTableModel();
		fechasdeHojasdeCargo.addColumn("Fecha",fechas.toArray());
		tableDias.setModel(fechasdeHojasdeCargo);
	}
	public void cargarTablasCHojaCargo(String dia){
		Hoja_Cargo c = CMF.getInstancia().obtenerHojaCargoDunDia(dia);
		ArrayList<String> nombrepac = c.getNombrePacientes();
		ArrayList<Integer> edadpac = c.getEdad();
		ArrayList<String> direccpac = c.getDireccionPaciente();
		ArrayList<String> diagpac = c.getDiagnosticoPaciente();
		
		Hojadecargodeldiaseleccionado = new DefaultTableModel();
		Hojadecargodeldiaseleccionado.addColumn("Nombre",nombrepac.toArray());
		if(nombre)
			Hojadecargodeldiaseleccionado.addColumn("Edad",edadpac.toArray());
		if(edad)
			Hojadecargodeldiaseleccionado.addColumn("Direccion",direccpac.toArray());
		if(direcion)
			Hojadecargodeldiaseleccionado.addColumn("Diagnostico",diagpac.toArray());
		table_1HojaSeleccionada.setModel(Hojadecargodeldiaseleccionado);
	}
}
