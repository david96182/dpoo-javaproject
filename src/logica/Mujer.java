package logica;

import java.util.Date;

public class Mujer extends Paciente{

	private Date UltPruebaCit;
	private boolean embarazada;

	public Mujer(String nombre, String iD, String direccion,
			long numeroHC,Date UltPruebaCit,int edad,String sexo) {
		super(nombre, iD, direccion, numeroHC,edad,sexo);
		this.UltPruebaCit = UltPruebaCit;
	}

	public Date getUltPruebaCit() {
		return UltPruebaCit;
	}

	public void setUltPruebaCit(Date ultPruebaCit) {
		UltPruebaCit = ultPruebaCit;
	}

	public boolean isEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}
	
}
