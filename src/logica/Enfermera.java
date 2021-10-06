package logica;

import java.util.Date;


public class Enfermera extends TrabajadorMedico{

	private boolean licenciatura;
	private int annosExperiencia;
	
	public Enfermera(String nombre, String iD,Date fechaealtaCMF,
			boolean licenciatura, int annosExperiencia) {
		super(nombre, iD, fechaealtaCMF);
		this.licenciatura = licenciatura;
		this.annosExperiencia = annosExperiencia;
	}
	public int getAnnosExperiencia() {
		return annosExperiencia;
	}
	public void setAnnosExperiencia(int annosExperiencia) {
		this.annosExperiencia = annosExperiencia;
	}
	public boolean isLicenciatura() {
		return licenciatura;
	}
	public void setLicenciatura(boolean licenciatura) {
		this.licenciatura = licenciatura;
	}
}
