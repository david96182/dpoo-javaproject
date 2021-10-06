package logica;

import java.util.Date;

public class Vacunacion 
{
	private String nombreVacuna;
	private Date diapuesta;
	
	public Date getDiapuesta() {
		return diapuesta;
	}

	public void setDiapuesta(Date diapuesta) {
		this.diapuesta = diapuesta;
	}

	public Vacunacion(String nombreVacuna, Date diapuesta) {
		super();
		this.nombreVacuna = nombreVacuna;
		this.diapuesta = diapuesta;
	}

	public Vacunacion(String nombreVacuna)
	{
		this.setNombreVacuna(nombreVacuna);				
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}
}

