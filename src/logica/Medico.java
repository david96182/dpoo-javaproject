package logica;

import java.util.Date;


public class Medico extends TrabajadorMedico{

	private String numeroMed;
	
	public Medico(String nombre, String numeroMed, String iD,Date fecha) {
		super(nombre,iD,fecha);
		this.numeroMed = numeroMed;
	}
	public String getNumeroMed() {
		return numeroMed;
	}
	public void setNumeroMed(String numeroMed) {
		this.numeroMed = numeroMed;
	}

}
