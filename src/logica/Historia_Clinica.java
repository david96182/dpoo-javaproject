package logica;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Historia_Clinica {

	private String nombrePaciente;
	private String idPaciente;
	private int numero;
	private ArrayList<ResultadoAnalisis> resultadosAnalisis;
	private ArrayList<Visita> visitas;
	ArrayList<Enfermedad> enfermedades;
	private ArrayList<Vacunacion> vacunaciones;

	public Historia_Clinica(String nombrePaciente, String idPaciente, int numero) {
		super();
		this.nombrePaciente = nombrePaciente;
		this.idPaciente = idPaciente;
		this.numero = numero;
		this.resultadosAnalisis = new ArrayList<ResultadoAnalisis>();
		this.visitas = new ArrayList<Visita>();
		this.enfermedades = new ArrayList<Enfermedad>();
		this.vacunaciones = new ArrayList<Vacunacion>();
	}
	//////     SETTERS       AND       GETTERS
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public ArrayList<ResultadoAnalisis> getResultadosAnalisis() {
		return resultadosAnalisis;
	}
	public ArrayList<Visita> getVisitas() {
		return visitas;
	}

	public ArrayList<Vacunacion> getVacunaciones() {
		return vacunaciones;
	}
	public void setVacunaciones(ArrayList<Vacunacion> vacunaciones) {
		this.vacunaciones = vacunaciones;
	}
	public void setResultadosAnalisis(
			ArrayList<ResultadoAnalisis> resultadosAnalisis) {
		this.resultadosAnalisis = resultadosAnalisis;
	}

	//METODOSSSSSSSSSSSSSSSSSSSS APARTE DE LOS SET AND GET
	public Visita obtenerUltimaVisita(){
		Visita v;
		v = visitas.get(visitas.size()-1);
		return v;
	}
	//obtiene el resultado del último análisis de un paciente
	public ResultadoAnalisis obtenerUltimoResAnalisis(){
		ResultadoAnalisis ra;
		ra = resultadosAnalisis.get(resultadosAnalisis.size()-1);
		return ra;

	}

	public void agregarNuevaVisita(Date fecha,String diagnostico,String tratamiento,String indicaciones,ArrayList<String> remicion,
			ArrayList<ResultadoAnalisis> analisis){
		Visita v = new Visita(fecha, diagnostico, tratamiento, indicaciones,remicion);
		this.visitas.add(v);
		for(int i = 0;i < analisis.size();i++){
			resultadosAnalisis.add(analisis.get(i));
		}
	}

	public void agregarResultadoAnalisis(String nombre, Date fecha, String resultado){
		for(int i = 0;i < resultadosAnalisis.size();i++){
			if(resultadosAnalisis.get(i).getNombreAnalisis().equalsIgnoreCase(nombre))
				if(resultadosAnalisis.get(i).getResultado().isEmpty()){
					resultadosAnalisis.get(i).setResultado(resultado);
					resultadosAnalisis.get(i).setDiaResultado(fecha);
				}
		}
	}

	public ArrayList<ResultadoAnalisis> obtenerResultadosPendientes(){
		ArrayList<ResultadoAnalisis> pendientes = new ArrayList<ResultadoAnalisis>();
		for(int i = 0;i < resultadosAnalisis.size();i++){
			if(resultadosAnalisis.get(i).getResultado().isEmpty()){
				pendientes.add(resultadosAnalisis.get(i));
			}
		}
		return pendientes;
	}

	public ArrayList<ResultadoAnalisis> obtenerResultadosAnalisis(){
		ArrayList<ResultadoAnalisis> resultados = new ArrayList<ResultadoAnalisis>();
		for(int i = 0;i < resultadosAnalisis.size();i++){
			if(!resultadosAnalisis.get(i).getResultado().isEmpty()){
				resultados.add(resultadosAnalisis.get(i));
			}
		}
		return resultados;
	}
	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	public void setVisitas(ArrayList<Visita> visitas) {
		this.visitas = visitas;
	}
	//registrar una enfermedad del paciente en la historia clinica
	public void agregarEnfermedad(Enfermedad enfermedad) {
		boolean encontrada = false;
		for(int i = 0;i < enfermedades.size();i++){
			if(enfermedades.get(i).getNombre_Enf().equalsIgnoreCase(enfermedad.getNombre_Enf()))
				encontrada = true;
		}
		if(!encontrada){
			enfermedades.add(enfermedad);
		}
	}
	//registrar vacunacion
	public boolean registrarVacunacion(Date diapuesta,String nombre){
		boolean vacunado = true;
		DateFormat formatofecha = DateFormat.getDateInstance();
		String fechapasada = formatofecha.format(diapuesta);
		for(int i = 0;i < vacunaciones.size();i++){
			if(vacunaciones.get(i).getNombreVacuna().equalsIgnoreCase(nombre)){
				String fechaacomparar = formatofecha.format(vacunaciones.get(i).getDiapuesta());
				if(fechapasada.equals(fechaacomparar)){
					vacunado = false;
			}  
		}
	}
	if(vacunado){
		vacunaciones.add(new Vacunacion(nombre,diapuesta));
	}
	return vacunado;
}
	/*//dada una fecha obtener la visita
	public Visita obtenerVisita(String fecha){
		for(int i = 0;i < visitas.size();i++){
			DateFormat formatofecha = DateFormat.getDateInstance();
			String fechavisita = formatofecha.format(visitas.get(i).);
		}
	}*/
}
