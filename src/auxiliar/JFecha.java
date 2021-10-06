package auxiliar;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;

public class JFecha extends JLabel {

	private static final long serialVersionUID = -7765211006244185348L;

	public JFecha() {
		Date fechaSys = new Date();
		DateFormat formatoFecha= DateFormat.getDateInstance();
		String fecha = formatoFecha.format(fechaSys);
		this.setText(fecha);
	}
}
