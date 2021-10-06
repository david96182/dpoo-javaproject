package logica;

import java.util.Date;
import java.util.ArrayList;
//import java.util.Calendar;

public class Hoja_Cargo {
	private ArrayList<String> nombrePacientes;
	private ArrayList<Integer> edad;
	private ArrayList<String> direccionPaciente;
	private Date dia;
	private ArrayList<String> diagnosticoPaciente;

	public Hoja_Cargo(Date dia){
		nombrePacientes = new ArrayList<String>();
		edad = new ArrayList<Integer>();
		direccionPaciente = new ArrayList<String>();
		diagnosticoPaciente = new ArrayList<String>();
		this.dia = dia;

	}

	public ArrayList<String> getNombrePacientes() {
		return nombrePacientes;
	}

	public ArrayList<Integer> getEdad() {
		return edad;
	}

	public ArrayList<String> getDireccionPaciente() {
		return direccionPaciente;
	}

	public ArrayList<String> getDiagnosticoPaciente() {
		return diagnosticoPaciente;
	}

	public Date getDia(){
		return dia;
	}

	public void setDia(Date dia){
		this.dia = dia;
	}
	//registrar visita de un paciente
	public void annadirVisita(String nombre,int edad,String direccion, String diagnostico){
			this.nombrePacientes.add(nombre);
			this.edad.add(edad);
			this.direccionPaciente.add(direccion);
			this.diagnosticoPaciente.add(diagnostico);
		
		
	}
}
