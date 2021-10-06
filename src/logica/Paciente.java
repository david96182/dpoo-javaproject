package logica;

import java.util.ArrayList;

public class Paciente {

	private String nombre;
	private String ID;
	private int edad;
	private String sexo;
	private String direccion;
	private long numeroHC;
	private ArrayList<Enfermedad> enfermedades;
	
	
	public void setEnfermedades(ArrayList<Enfermedad> enfermedadespax) {
		/*for(int i = 0;i < enfermedades.size();i++){
			this.enfermedades.add(enfermedadespax.get(i));       <====== asi no sirve
		}*/
		this.enfermedades = enfermedadespax;
	}
	public ArrayList<Enfermedad> getEnfermedades() {
		return enfermedades;
	}
	//saber si esta enfermo
	public boolean estaEnfermo(){
		boolean enfermo = true;
		if(enfermedades.isEmpty())
			enfermo = false;
		return enfermo;
	}
	//saber si el paciente a�atiene una enfermedad
	public boolean tieneEnfermedad(String enf){
		boolean tiene = false;
		for(int i = 0;i < enfermedades.size();i++)
			if(enfermedades.get(i).getNombre_Enf().equalsIgnoreCase(enf))
				tiene = true;
		return tiene;
	}
	
	//Adicionarle una nueva enfermedad al paciente
	public boolean annadirEnfermedad(Enfermedad enfermedad){
		boolean annadida = false;
		if(!tieneEnfermedad(enfermedad)){
			enfermedades.add(enfermedad);
			annadida = true;
		}
		return annadida;
	}
	
	//Buscar si el paciente ya tiene una enfermedad dada esta
	public boolean tieneEnfermedad(Enfermedad enfermedad){
		boolean tiene = false;
		for(int i = 0;i < enfermedades.size();i++)
			if(enfermedades.get(i).getNombre_Enf().equalsIgnoreCase(enfermedad.getNombre_Enf()))
				tiene = true;
	    return tiene;
	}
	
	// eliminar enfermedad a un paciente en caso de que se cure de dicha
	public boolean eliminarEnfermedad(Enfermedad enfermedad){
		boolean eliminada = false;
		if(tieneEnfermedad(enfermedad)){
			for(int i = 0; i < enfermedades.size();i++)
				if(enfermedades.get(i).getNombre_Enf().equalsIgnoreCase(enfermedad.getNombre_Enf())){
					enfermedades.remove(i);
					eliminada = true;
				}
					
		}
			
		return eliminada;
	}

	//Constructor
	public Paciente(String nombre, String iD, String direccion, long numeroHC,int edad,String sexo) {
		super();
		this.nombre = nombre;
		ID = iD;
		this.edad = edad;
		this.direccion = direccion;
		this.numeroHC = numeroHC;
		this.enfermedades = new ArrayList<Enfermedad>();
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public long getNumeroHC() {
		return numeroHC;
	}
	public void setNumeroHC(long numeroHC) {
		this.numeroHC = numeroHC;
	}
	public String getNombre() {
		return nombre;
	}
	public String getID() {
		return ID;
	}
	public int getEdad() {
		return edad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getsexo(){
		String sexo;
		int aux = ID.charAt(9) - '0';
		if(aux % 2 == 0)
			sexo = "M";
		else
			sexo = "F";
		return sexo;
	}

}
