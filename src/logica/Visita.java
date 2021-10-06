package logica;

import java.util.ArrayList;
import java.util.Date;

public class Visita {

	private Date fecha;
	private String diagnostico;
	private String tratamiento;
	private String indicacionesComp;
	private ArrayList<String> remicion;
	
	public Visita(Date fecha, String diagnostico, String tratamiento,
			String indicacionesCom,ArrayList<String> remicion) {
		super();
		this.fecha = fecha;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.indicacionesComp = indicacionesCom;
		this.remicion = remicion;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public String getIndicacionesCom() {
		return indicacionesComp;
	}

	public void setIndicacionesCom(String indicacionesCom) {
		this.indicacionesComp = indicacionesCom;
	}

	public ArrayList<String> getRemicion() {
		return remicion;
	}
    public void annadirRemicion(String remicion) {
		this.remicion.add(remicion);
	}
	
}
