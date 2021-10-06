package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import logica.Historia_Clinica;

public class VerConsulta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea diagnostico;
	private JTextArea tratamiento;
	private JTextArea indicaciones;

	/**
	 * Launch the application.
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		try {
			VerConsulta dialog = new VerConsulta(null,(Integer) null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerConsulta(Historia_Clinica hc,int pos) {
		setResizable(false);
		setModal(true);
		DateFormat formatofecha = DateFormat.getDateInstance();
		String fecha = formatofecha.format(hc.getVisitas().get(pos).getFecha());
		setTitle("Consulta del día "+ fecha);
		setBounds(100, 100, 471, 448);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblDiagnstico = new JLabel("Diagn\u00F3stico:");
		lblDiagnstico.setBounds(20, 11, 109, 14);
		contentPanel.add(lblDiagnstico);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(30, 36, 415, 83);
		contentPanel.add(scrollPane);
		
		diagnostico = new JTextArea();
		diagnostico.setEditable(false);
		diagnostico.setText(hc.getVisitas().get(pos).getDiagnostico());
		scrollPane.setViewportView(diagnostico);
		
		JLabel lblTratamiento = new JLabel("Tratamiento:");
		lblTratamiento.setBounds(20, 130, 144, 14);
		contentPanel.add(lblTratamiento);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(30, 155, 415, 83);
		contentPanel.add(scrollPane_1);
		
		tratamiento = new JTextArea();
		tratamiento.setEditable(false);
		tratamiento.setText(hc.getVisitas().get(pos).getTratamiento());
		scrollPane_1.setViewportView(tratamiento);
		
		JLabel lblIndicacionesComplementarias = new JLabel("Indicaciones complementarias:");
		lblIndicacionesComplementarias.setBounds(20, 249, 218, 14);
		contentPanel.add(lblIndicacionesComplementarias);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(30, 274, 415, 83);
		contentPanel.add(scrollPane_2);
		
		indicaciones = new JTextArea();
		indicaciones.setEditable(false);
		indicaciones.setText(hc.getVisitas().get(pos).getIndicacionesCom());
		scrollPane_2.setViewportView(indicaciones);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Volver");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VerConsulta.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
