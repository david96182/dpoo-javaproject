package logica;

import java.util.Date;

public class TrabajadorMedico {

	private String nombre;
	private String ID;
	private Date fechaealtaCMF;
	
	
	public TrabajadorMedico(String nombre, String iD, Date fechaealtaCMF) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.fechaealtaCMF = fechaealtaCMF;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Date getFechaealtaCMF() {
		return fechaealtaCMF;
	}
	public void setFechaealtaCMF(Date fechaealtaCMF) {
		this.fechaealtaCMF = fechaealtaCMF;
	}
	
	
}
