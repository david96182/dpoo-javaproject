package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logica.CMF;

public class RegistrarResultados extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea resultadotextarea;
    private CMF cmf = CMF.getInstancia();
    private JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("null")
			RegistrarResultados dialog = new RegistrarResultados((Long) null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrarResultados(long numhistcl,final String analisis) {
		setResizable(false);
		final int numhc = (int) numhistcl;
		setTitle("Registrar Resultados An\u00E1lisis");
		setModal(true);
		setBounds(100, 100, 348, 404);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 312, 111);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 48, 54, 14);
		panel.add(lblNombre);
		
		JLabel lblNmeroDeHistoria = new JLabel("Historia Cl\u00EDnica #");
		lblNmeroDeHistoria.setBounds(10, 22, 138, 14);
		panel.add(lblNmeroDeHistoria);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(37, 73, 46, 14);
		panel.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel(cmf.buscarHistoriaClinica(numhistcl).getNombrePaciente());
		lblNewLabel_1.setBounds(74, 48, 178, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel(cmf.buscarHistoriaClinica(numhistcl).getIdPaciente());
		lblNewLabel_2.setBounds(74, 73, 128, 14);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3 = new JLabel(""+numhc);
		lblNewLabel_3.setBounds(107, 22, 74, 14);
		panel.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 161, 312, 160);
		contentPanel.add(scrollPane);
		
		resultadotextarea = new JTextArea();
		resultadotextarea.setLineWrap(true);
		scrollPane.setViewportView(resultadotextarea);
		
		JLabel lblNewLabel = new JLabel("Registrar Resultados de An\u00E1lisis de "+ analisis);
		lblNewLabel.setBounds(10, 136, 274, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String resultado = resultadotextarea.getText();
						if(resultado.isEmpty()){
							JOptionPane.showMessageDialog(RegistrarResultados.this, "Debe introducirse el resultado para poder registrarlo","Error en los datos",0);
						}
						else{
							cmf.agregarResultado(numhc, analisis, resultado);
							JOptionPane.showMessageDialog(RegistrarResultados.this, "Resultado registrado con éxito","Resultado de análisis registrado",-1);
							RegistrarResultados.this.dispose();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						RegistrarResultados.this.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
