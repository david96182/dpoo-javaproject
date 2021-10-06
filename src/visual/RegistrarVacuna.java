package visual;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.CMF;
import logica.Paciente;
import logica.Vacunacion;

public class RegistrarVacuna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnAgregarVacunaAl;
	private JLabel lblNombrepac;
	private JLabel lblNumeroHC;
	private JList listVacunasparaponerPaciente;
	private JList listVacunas;
	/**
	 * @wbp.nonvisual location=402,69
	 */
	private DefaultListModel defaultListModelVacunasDispo = new DefaultListModel();
	/**
	 * @wbp.nonvisual location=392,119
	 */
	private DefaultListModel defaultListModelVacunaspalpaciente = new DefaultListModel();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVacuna frame = new RegistrarVacuna(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the dialog.
	 */
	public RegistrarVacuna(final Paciente pac) 
	{
		setTitle("Registrar Vacuna");
		setBounds(100, 100, 448, 405);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 432, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		this.setLocationRelativeTo(null);


		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 322, 432, 33);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane);
		{
			JButton okButton = new JButton("Registrar");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					boolean aceptado = true;
					if(!defaultListModelVacunaspalpaciente.isEmpty())
					{
						for (int i = 0; i < defaultListModelVacunaspalpaciente.size(); i++)
						{
							if(!CMF.getInstancia().agregarVacuna(pac.getID(), defaultListModelVacunaspalpaciente.get(i).toString())){
								JOptionPane.showMessageDialog(RegistrarVacuna.this, "El paciente ya se vacuno en el día de "+defaultListModelVacunaspalpaciente.get(i).toString(),"Vacunación ya registrada en el día",2);
								aceptado = false;
							}
							if(aceptado){
								JOptionPane.showMessageDialog(RegistrarVacuna.this, "Vacunación registrada correctamente","Vacunación registrada",-1);
								RegistrarVacuna.this.dispose();
							}
						}
						RegistrarVacuna.this.dispose();
					}
					else
						JOptionPane.showMessageDialog(RegistrarVacuna.this, "No se ha seleccionado ninguna vacuna","Vacuna no selecionada",2);
				}
			});
			okButton.setActionCommand("OK");
			buttonPane.add(okButton);
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					RegistrarVacuna.this.dispose();
					Ventana_Enfermera enf = new Ventana_Enfermera();
					enf.setVisible(true);
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}

		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(listVacunas.getSelectedValue()!=null){
					defaultListModelVacunaspalpaciente.addElement(listVacunas.getSelectedValue());
					defaultListModelVacunasDispo.removeElement(listVacunas.getSelectedValue());
					listVacunas.setModel(defaultListModelVacunasDispo);
					listVacunasparaponerPaciente.setModel(defaultListModelVacunaspalpaciente);
				}
			}
		});
		btnAgregar.setBounds(169, 170, 89, 23);
		getContentPane().add(btnAgregar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(listVacunasparaponerPaciente.getSelectedValue()!=null){
					defaultListModelVacunasDispo.addElement(listVacunasparaponerPaciente.getSelectedValue());
					defaultListModelVacunaspalpaciente.removeElement(listVacunasparaponerPaciente.getSelectedValue());
					listVacunasparaponerPaciente.setModel(defaultListModelVacunaspalpaciente);
					listVacunas.setModel(defaultListModelVacunasDispo);

				}
			}
		});
		btnEliminar.setBounds(169, 219, 89, 23);
		getContentPane().add(btnEliminar);

		btnAgregarVacunaAl = new JButton("Agregar otra");
		btnAgregarVacunaAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				NuevaVacuna nueva = new NuevaVacuna(RegistrarVacuna.this);
				nueva.setVisible(true);
			}
		});
		btnAgregarVacunaAl.setBounds(10, 288, 149, 23);
		getContentPane().add(btnAgregarVacunaAl);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 12, 412, 95);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(10, 26, 65, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero de Historia Cl\u00EDnica:");
		lblNewLabel_1.setBounds(10, 51, 159, 14);
		panel.add(lblNewLabel_1);

		lblNombrepac = new JLabel(pac.getNombre());
		lblNombrepac.setBounds(85, 26, 306, 14);
		panel.add(lblNombrepac);

		lblNumeroHC = new JLabel(pac.getNumeroHC()+"");
		lblNumeroHC.setBounds(191, 51, 65, 14);
		panel.add(lblNumeroHC);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 149, 147);
		getContentPane().add(scrollPane);

		listVacunas = new JList();
		listVacunas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listVacunas.getSelectedValue() != null)
					btnAgregar.setEnabled(true);
			}
		});
		scrollPane.setViewportView(listVacunas);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(268, 130, 154, 147);
		getContentPane().add(scrollPane_1);

		listVacunasparaponerPaciente = new JList();
		listVacunasparaponerPaciente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(listVacunasparaponerPaciente.getSelectedValue() != null)
					btnEliminar.setEnabled(true);
			}
		});
		scrollPane_1.setViewportView(listVacunasparaponerPaciente);
		cargarListaVacunas();
	}
	public void cargarListaVacunas(){
		defaultListModelVacunasDispo.clear();
		for(Vacunacion v:CMF.getInstancia().getVacunas()){
			if(!defaultListModelVacunaspalpaciente.contains(v.getNombreVacuna()))
				defaultListModelVacunasDispo.addElement(v.getNombreVacuna());
		}

		listVacunas.setModel(defaultListModelVacunasDispo);


		this.repaint();
		listVacunas.paint(getGraphics());
		listVacunas.repaint();
	}


}