package logica;

import java.util.Date;

public class ResultadoAnalisis {

	private Date diaMandado;
	private Date diaResultado;
	private String nombreAnalisis;
	private String Resultado;
	
	
	public Date getDiaMandado() {
		return diaMandado;
	}
	
	public Date getDiaResultado() {
		return diaResultado;
	}
	
	public void setDiaMandado(Date diaMandado) {
		this.diaMandado = diaMandado;
	}
	
	public void setDiaResultado(Date diaResultado) {
		this.diaResultado = diaResultado;
	}
	
	public ResultadoAnalisis(String nombre,String resultado, Date fechaMandado){
		this.nombreAnalisis = nombre;
		this.diaMandado = fechaMandado;
		this.Resultado = resultado;
	}
	
	public ResultadoAnalisis(String nombreAnalisis, String resultado,Date diamand,Date diaRes) {
		super();
		this.nombreAnalisis = nombreAnalisis;
		this.Resultado = resultado;
		this.diaMandado = diamand;
		this.diaResultado = diaRes;
	}
	
	public ResultadoAnalisis(String nombreAnalisis, String resultado){
		this.nombreAnalisis = nombreAnalisis;
		this.Resultado = resultado;
	}
	///Set              and                   GET
	public String getNombreAnalisis() {
		return nombreAnalisis;
	}
	
	public void setNombreAnalisis(String nombreAnalisis) {
		this.nombreAnalisis = nombreAnalisis;
	}
	
	public String getResultado() {
		return Resultado;
	}
	
	public void setResultado(String resultado) {
		Resultado = resultado;
	}
}
