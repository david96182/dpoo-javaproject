package logica;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;


public class CMF {

	private int numero;
	private String nombrePoliclinico;
	private String nombreDirPol;
	private Medico medicoF;
	private Enfermera enfermera;

	private ArrayList<Enfermedad> enfermedades;
	private ArrayList<String> tiposdeanalisis;
	private ArrayList<Vacunacion> vacunas;
	private ArrayList<String> especialidadesregistradas;
	private ArrayList<Paciente> mayores;
	
	private ArrayList<Paciente> pacientes;
	private ArrayList<ArrayList<Hoja_Cargo>> hojas_Cargo;
	private ArrayList<Historia_Clinica> historiasClinicas;
	private ArrayList<Mujer> mujeresEmbarazadas;
	private ArrayList<Ninno> ninnos;
	private ArrayList<Paciente> pendResultado;
	private static CMF conf = null;

	public static CMF getInstancia()
	{
		if(conf == null)
		{
			conf = new CMF();
		}
		return conf;
	}
	private CMF() 
	{
		this.pendResultado = new ArrayList<Paciente>();
		this.mayores = new ArrayList<Paciente>();
	}

	public ArrayList<String> getEspecialidadesregistradas() {
		return especialidadesregistradas;
	}
	public void setEspecialidadesregistradas(
			ArrayList<String> especialidadesregistradas) {
		this.especialidadesregistradas = especialidadesregistradas;
	}
	public ArrayList<String> getTiposdeanalisis() {
		return tiposdeanalisis;
	}
	public void setTiposdeanalisis(ArrayList<String> tiposdeanalisis) {
		this.tiposdeanalisis = tiposdeanalisis;
	}
	public ArrayList<Mujer> getMujeresEmbarazadas() {
		return this.mujeresEmbarazadas;
	}

	public ArrayList<Paciente> getPendResultado() {
		return pendResultado;
	}

	public void setPendResultado(ArrayList<Paciente> pendResultado) {
		this.pendResultado = pendResultado;
	}

	public void setPacientes(ArrayList<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void setHojas_Cargo(ArrayList<ArrayList<Hoja_Cargo>> hojas_Cargo) {
		this.hojas_Cargo = hojas_Cargo;
	}

	public void setMujeresEmbarazadas(ArrayList<Mujer> mujeresEmbarazadas) {
		this.mujeresEmbarazadas = mujeresEmbarazadas;
	}

	public void setNinnos(ArrayList<Ninno> ninnos) {
		this.ninnos = ninnos;
	}



	public void setEnfermedades(ArrayList<Enfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}

	public ArrayList<Enfermedad> getEnfermedades(){
		return this.enfermedades;
	}
	public ArrayList<Paciente> getPacientes() {
		return pacientes;
	}
	public ArrayList<Historia_Clinica> getHistoriasClinicas() {
		return historiasClinicas;
	}
	public void setHistoriasClinicas(ArrayList<Historia_Clinica> historiasClinicas) {
		this.historiasClinicas = historiasClinicas;
	}
	public ArrayList<Ninno> getNinnos() {
		return ninnos;
	}
	public ArrayList<Paciente> getPacientePresultado(){
		return this.pendResultado;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombrePoliclinico() {
		return nombrePoliclinico;
	}

	public void setNombrePoliclinico(String nombrePoliclinico) {
		this.nombrePoliclinico = nombrePoliclinico;
	}

	public String getNombreDirPol() {
		return nombreDirPol;
	}

	public void setNombreDirPol(String nombreDirPol) {
		this.nombreDirPol = nombreDirPol;
	}
	public Medico getMedicoF() {
		return medicoF;
	}
	public void setMedicoF(Medico medicoF) {
		this.medicoF = medicoF;
	}
	public Enfermera getEnfermera() {
		return enfermera;
	}
	public void setEnfermera(Enfermera enfermera) {
		this.enfermera = enfermera;
	}
	public ArrayList<ArrayList<Hoja_Cargo>> getHojas_Cargo() {
		return hojas_Cargo;
	}
	public ArrayList<Vacunacion> getVacunas() {
		return vacunas;
	}
	public void setVacunas(ArrayList<Vacunacion> vacunas) {
		this.vacunas = vacunas;
	}
	public ArrayList<Paciente> getMayores() {
		return mayores;
	}
	public void setMayores(ArrayList<Paciente> mayores) {
		this.mayores = mayores;
	}
	/////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////
	//por ciento que representan los enfermos con una enfermedad
	public float obtenerPorcientoconEnfermedad(String nombre) throws Exception{
		float porciento = 0;
		int cant = obtenerPacientescEnf(nombre).size();
		try{porciento = ((cant*100)/pacientes.size());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		return porciento;
	}
	//saber por ciento que representan las embarazadas en el consultorio
	public float obtenerPorcientoEmbarazadas(){
		float porciento = 0;
		try{porciento = ((mujeresEmbarazadas.size()*100)/pacientes.size());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
		}
		return porciento;
	}
	//registrar nueva especialidad
	public boolean registrarEspecialidad(String nombre)
	{
		boolean registrado = true;
		for(int i = 0;i < especialidadesregistradas.size();i++){
			if(especialidadesregistradas.get(i).equalsIgnoreCase(nombre))
				registrado = false;
		}
		if(registrado){
			especialidadesregistradas.add(nombre);
		}
		return registrado;
	}
	//registrar nueva vacuna
	public boolean registrarVacuna(String nombre)
	{
		boolean registrado = true;
		for(int i = 0;i < vacunas.size();i++){
			if(vacunas.get(i).getNombreVacuna().equalsIgnoreCase(nombre))
				registrado = false;
		}
		if(registrado){
			vacunas.add(new Vacunacion(nombre));
		}
		return registrado;
	}
	//dado un dia obtener la hoja de cargo
	public Hoja_Cargo obtenerHojaCargoDunDia(String dia){
		Hoja_Cargo hoja = null;   
		for(int i = 0;i < hojas_Cargo.size();i++){
			for(int j = 0;j < hojas_Cargo.get(i).size();j++){
				DateFormat formatofecha = DateFormat.getDateInstance();
				String fecha = formatofecha.format(hojas_Cargo.get(i).get(j).getDia());
				if(fecha.equals(dia)){
					hoja = hojas_Cargo.get(i).get(j);
				}
			}
		}
		return hoja;
	}
	//saber si un paciente tiene alguna enfermedad cualquiera
	public boolean pacienteEnfermo(String idpac){
		boolean enfermo = true;
		int pospac = posicionPaciente(idpac);
		if(!pacientes.get(pospac).estaEnfermo()){//solucion parcial aumentar en 1
			enfermo = false;
		}
		return enfermo;
	}
	//obtener las enfermedades de un paciente
	public ArrayList<Enfermedad> obtenerEnfermedadesdePaciente(String idpac){
		int pospsc = posicionPaciente(idpac);
		return pacientes.get(pospsc).getEnfermedades();

	}
	//registrar nuevo analisis en el consultorio
	public boolean registrarAnalisis(String nombre){
		boolean registrado = true;
		for(int i = 0;i < tiposdeanalisis.size();i++){
			if(tiposdeanalisis.get(i).equalsIgnoreCase(nombre)){
				registrado = false;
			}
		}
		if(registrado){
			tiposdeanalisis.add(nombre);
		}
		return registrado;
	}

	//registrar nueva enfermedad en el consultorio
	public boolean registrarEnfermedad(String nombre){
		boolean creada = true;
		for(Enfermedad enf:enfermedades){
			if(enf.getNombre_Enf().equalsIgnoreCase(nombre)){
				creada = false;
			}
		}
		if(creada){
			Enfermedad enf = new Enfermedad(nombre);
			enfermedades.add(enf);
		}
		return creada;
	}
	//eliminar paciente de lista pendientes por resultado
	public void eliminarDpendientes(String id){
		for(int i = 0;i < pendResultado.size();i++){
			if(pendResultado.get(i).getID().equals(id))
				pendResultado.remove(i);
		}
	}

	//annadir resultado del analisis de un paciente teniendo el numero de hist cl y el nombre del analisis
	public void agregarResultado(int numhc,String nombre, String resultado){
		int poshc = obtenerposHistClinica(numhc);
		Calendar r = Calendar.getInstance();
		Date fecha = (Date)r.getTime();
		historiasClinicas.get(poshc).agregarResultadoAnalisis(nombre ,fecha, resultado);
		if(historiasClinicas.get(poshc).obtenerResultadosPendientes().isEmpty()){
			eliminarDpendientes(historiasClinicas.get(poshc).getIdPaciente());
		}
	}
	//obtener los resultados pendientes de un paciente dado el numero de HC
	public ArrayList<ResultadoAnalisis> obtenerListadoAnalisPendPac(long numhc){
		Historia_Clinica hc = buscarHistoriaClinica(numhc);
		ArrayList<ResultadoAnalisis> pend = hc.obtenerResultadosPendientes();
		return pend;
	}
	//obtener un paciente dado el ID
	public Paciente buscarPorID(String Id)
	{
		Paciente buscado = null;
		for (int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).getID().equals(Id))
			{
				buscado = pacientes.get(i);
				i = pacientes.size();
			}
		}

		return buscado;
	}
	//obtener hoja de cargo del dia
	public Hoja_Cargo obtenerHcargoDia(){
		return hojas_Cargo.get(hojas_Cargo.size()-1).get(hojas_Cargo.get(hojas_Cargo.size()-1).size()-1);
	}
	//regisrar consulta
	public int registrarConsulta(String id,String diag,String trata,
			String indicpac,ArrayList<String> remicion, ArrayList<ResultadoAnalisis> analisis){
		int pospac = posicionPaciente(id);
		int result = -1;
		if(!(existePaciente(id)))
			result = 0;
		else if(!(tieneHistClinica(id)))
			result = 1;
		else
		{
			long numerohc = pacientes.get(posicionPaciente(id)).getNumeroHC();
			registrarHojaCargo(pacientes.get(pospac).getNombre(),pacientes.get(pospac).getEdad(),
					pacientes.get(pospac).getDireccion(), diag);
			registrarVisitaHistClinica(numerohc,diag, trata, indicpac, remicion,analisis);
			if(!analisis.isEmpty()){
				if(!pendientePorResultado(id)){
					pendResultado.add(pacientes.get(pospac));
				}
			}
			result = 2;
		}

		return result;
	}
	//saber si un paciente esta pendiente de resultado
	public boolean pendientePorResultado(String ID){
		boolean pendiente = false;
		for(Paciente p:pendResultado){
			if(p.getID().equals(ID)){
				pendiente = true;
			}
		}
		return pendiente;
	}
	//regitrar visita en hist clinica
	public void registrarVisitaHistClinica(long numerohc,String diagnostico,
			String tratamiento,String indicaciones,ArrayList<String> remicion,ArrayList<ResultadoAnalisis> analisis){
		Calendar r = Calendar.getInstance();
		Date fecha = (Date)r.getTime();
		historiasClinicas.get(obtenerposHistClinica(numerohc)).agregarNuevaVisita(fecha, diagnostico, tratamiento, indicaciones, remicion,analisis);
	}

	//registrar datos en hoja de cargo
	public void registrarHojaCargo(String nombre,int edad,String direcc,String diagnostico){
		hojas_Cargo.get(hojas_Cargo.size()-1).get(hojas_Cargo.get(hojas_Cargo.size()-1).size()-1).annadirVisita(nombre, edad, direcc, diagnostico);
	}

	//agregar enf a un paciente
	public boolean agregarEnfermedad(String nombre,String ID){
		boolean agregada = false;
		int pos = posicionPaciente(ID);
		long numhc = pacientes.get(pos).getNumeroHC();
		int poshc = obtenerposHistClinica(numhc);
		if(!(pacientes.get(pos).tieneEnfermedad(nombre))){
			pacientes.get(pos).annadirEnfermedad(new Enfermedad(nombre));
			historiasClinicas.get(poshc).agregarEnfermedad(new Enfermedad(nombre));
			agregada = true;
		}
		return agregada;
	}

	//saber si un paciente tiene una enfermedad dada
	public boolean tieneEnfermedadPaciente(String nombre, String id){
		boolean tiene = false;
		int pospac = posicionPaciente(id);
		if(pacientes.get(pospac).tieneEnfermedad(nombre)){
			tiene = true;
		}
		return tiene;
	}
	//modificar enfermedades de un paciente
	public void modificarEnfsPaciente(String id, ArrayList<Enfermedad> enfe){
		int pospac = posicionPaciente(id);
		int poshc = obtenerposHistClinica(pacientes.get(pospac).getNumeroHC());
		historiasClinicas.get(poshc).setEnfermedades(enfe);
		pacientes.get(pospac).setEnfermedades(enfe);
	}

	//eliminar enfermedad a un paciente
	public boolean eliminarEnfermedad(String nombre, String id){
		boolean eliminada = false;
		int pospac = posicionPaciente(id);
		if(tieneEnfermedadPaciente(nombre, id)){
			pacientes.get(pospac).eliminarEnfermedad(new Enfermedad(nombre));
		}
		return eliminada;
	}
	//agregar hist clinica
	public void agregarHist(Historia_Clinica hc){
		this.historiasClinicas.add(hc);
	}

	//obtiene la posicion de la historia clinica de un paciente
	public int obtenerposHistClinica(long numeroHC){
		int pos = 0;
		for(int i = 0;i < historiasClinicas.size();i++)
			if(historiasClinicas.get(i).getNumero() == numeroHC)
				pos = i;
		return pos;
	}

	//Comprueba si un paciente ya existe
	public boolean existePaciente(String ID){
		boolean resultado = false;
		for(Paciente p:pacientes)
			if(p.getID().equals(ID))
				resultado = true;

		return resultado;
	}

	//annade un nuevo paciente
	public boolean annadirPaciente(String nombre, String iD, String direccion,int edad,String sexo,boolean mujerembarazada,
			ArrayList<Enfermedad> enferdad){
		boolean annadido = false;
		int numeroHC = 0;
		if(!existePaciente(iD)){
			if(historiasClinicas.isEmpty()){
				numeroHC = 1;
			}else
				numeroHC = historiasClinicas.get(historiasClinicas.size()-1).getNumero()+1;
			if(edad < 1){
				Ninno p = new Ninno(nombre, iD, direccion, numeroHC, edad, sexo);
				pacientes.add(p);
				p.setEnfermedades(enferdad);
				ninnos.add(p);
			}
			else if(sexo.equalsIgnoreCase("Femenino")){
				Mujer p = new Mujer(nombre, iD, direccion, numeroHC,null,edad,sexo);
				pacientes.add(p);
				if(mujerembarazada){
					mujeresEmbarazadas.add(p);
					p.setEnfermedades(enferdad);
				}
			}
			else{
				Paciente p = new Paciente(nombre, iD, direccion, numeroHC, edad, sexo);
				p.setEnfermedades(enferdad);
				pacientes.add(p);
			}
			annadido = true;
			Historia_Clinica hc = new Historia_Clinica(nombre, iD, numeroHC);
			hc.setEnfermedades(enferdad);
			agregarHist(hc);
		}
		return annadido;
	}

	//anade mujer embarazada
	public boolean ponermujerEmbarazada(String ID){
		boolean anadido = false;
		int pos = posicionPaciente(ID);
		if(!((Mujer) pacientes.get(pos)).isEmbarazada()){
			((Mujer) pacientes.get(pos)).setEmbarazada(true);
			anadido = true;
			mujeresEmbarazadas.add((Mujer)(pacientes.get(pos)));
		}
		return anadido;
	}
	//quita mujer embarazada
	public boolean quitarMujerEmbarazada(String ID){
		boolean quitada = false;
		int pos = posicionPaciente(ID);
		if(((Mujer) pacientes.get(pos)).isEmbarazada()){
			((Mujer) pacientes.get(pos)).setEmbarazada(false);
			quitada = false;
			mujeresEmbarazadas.remove(posEmbarazada(ID));
		}
		return quitada;
	}
	//devuelve la posicion de una embarazada en la lista de embarazadas
	public int posEmbarazada(String ID){
		int pos = -1;
		for(int i = 0;i < mujeresEmbarazadas.size();i++){
			if(mujeresEmbarazadas.get(i).getID().equalsIgnoreCase(ID))
				pos = i;
		}
		return pos;
	}
	//devuelve la posicion de un paciente en la lista de pacientes
	public int posicionPaciente(String id){
		int pos = -1;
		for(int i = 0;i < pacientes.size();i++){
			if(pacientes.get(i).getID().equals(id)){
				pos = i;
			}
		}
		return pos; 
	}
	//elimina un paciente de la lista de pacientes
		public boolean eliminarPaciente(int i){
			boolean eliminado = false;
			long numhc = pacientes.get(i).getNumeroHC();
			int poshc = obtenerposHistClinica(numhc);
			historiasClinicas.remove(poshc);
			
			if(pacientes.get(i) instanceof Ninno)
			{
				for (int j = 0; j < ninnos.size(); j++)
				{
					if(ninnos.get(j).getNumeroHC() == numhc)
						ninnos.remove(j);
				}
			}
			if(pacientes.get(i) instanceof Mujer)
			{
				for (int j = 0; j < mujeresEmbarazadas.size(); j++)
				{
					if(mujeresEmbarazadas.get(j).getNumeroHC() == numhc)
						mujeresEmbarazadas.remove(j);
				}
			}
				
			pacientes.remove(i);
			eliminado = true;
		
			return eliminado;
		}

	//devuelve un listado de los pacientes pendientes por resultados de analisis
	public ArrayList<Paciente> listadoPendientesResultadosAnalisis(){
		ArrayList<Paciente> pendientes = new ArrayList<Paciente>();
		for(int i = 0;i < historiasClinicas.size() ;i++){
			if(!historiasClinicas.get(i).obtenerResultadosPendientes().isEmpty())
				pendientes.add(pacientes.get(posicionPaciente(historiasClinicas.get(i).getIdPaciente())));
		}
		return pendientes;
	}

	//obtener los pacientes con una enfermedad
	public ArrayList<Paciente> obtenerPacientescEnf(String enf){
		ArrayList<Paciente> pacientesenfermos = new ArrayList<Paciente>();
		for(int i = 0;i < pacientes.size();i++){
			if(pacientes.get(i).tieneEnfermedad(enf))
				pacientesenfermos.add(pacientes.get(i));
		}
		return pacientesenfermos;
	}

	//obtener pacientes sanos
	public ArrayList<Paciente> obtenerPacientesSanos(){
		ArrayList<Paciente> sanos = new ArrayList<Paciente>();
		for(Paciente p:pacientes){
			if(p.getEnfermedades().isEmpty())
				sanos.add(p);
		}
		return sanos;
	}

	//saber si un paciente tiene historia clinica
	public boolean tieneHistClinica(String ID){
		boolean tiene = false;
		for(Historia_Clinica hc : historiasClinicas){
			if(hc.getIdPaciente().equalsIgnoreCase(ID))
				tiene = true;
		}
		return tiene;
	}

	//crear la hoja del dia
	public boolean crearHojaCargo()
	{
		Calendar fecha = Calendar.getInstance();
		boolean estacreada = buscarHojaCargo(fecha);
		if(!estacreada)
		{
			Hoja_Cargo hojaDia = new Hoja_Cargo(fecha.getTime());
			hojas_Cargo.get(hojas_Cargo.size()-1).add(hojaDia);
		}
		return estacreada;	
	}

	//buscar la hoja de cargo del dia para no crear otra
	public boolean buscarHojaCargo(Calendar fecha)
	{
		boolean esta = false;
		if(!hojas_Cargo.isEmpty())
		{
			Hoja_Cargo ultima = obtenerHcargoDia();
			Calendar aux = new GregorianCalendar();
			aux.setTime(ultima.getDia());
			int difernecia = getDiasCalendario(aux, fecha);
			if(difernecia == 0)
				esta = true;
		}
		return esta;
	}


	//buscar Historia Clinica del Paciente
	public Historia_Clinica buscarHistoriaClinica(long numero)
	{
		Historia_Clinica result = null;
		for (Historia_Clinica hist : historiasClinicas)
		{
			if(hist.getNumero() == numero)
				result = hist;
		}
		return result;
	}
	// listado de pacientes enfermos
	public ArrayList<Paciente> getPacientesEnfermos()
	{
		ArrayList<Paciente> enfermos = new ArrayList<Paciente>();
		for (Paciente pac : pacientes)
		{
			ArrayList<Enfermedad> aux = pac.getEnfermedades();
			if(!aux.isEmpty())
				enfermos.add(pac);
		}
		return enfermos;
	}

	//Actualizar el registro general 
	public void act_RegistroGeneral()
	{
		for (Paciente pac : pacientes)
		{
			int dif = edadActual(pac);
			if(pac.getEdad() == 0 || pac.getEdad() == 1)
			{
				if(dif > 1)
					ninnos.remove(pac);
			}
			pac.setEdad(pac.getEdad() +dif);//pac.getEdad() + 
		}
	}
	// revertir la fecha de nacimiento
	public String Reverse(String fecha)
	{
		ArrayList<Integer> aux = new ArrayList<Integer>();
		for (int i = 0; i < fecha.length(); i++)
		{
			int n = fecha.charAt(i) - '0';
			aux.add(n);
		}
		Object [] res = aux.toArray();
		for (int i = 0, j = 1, k = res.length-1; i < 2; i++, j--,k--)
		{
			int temp = (Integer)res[k];
			res[k] = res[j];
			res[j] = temp;
		}
		return res.toString();
	}
	//buscar paciente por #Historia Clinica
	public Paciente buscarNumeroHC(long num)
	{
		Paciente buscado = null;
		for (int i = 0; i < pacientes.size(); i++)
		{
			if(pacientes.get(i).getNumeroHC() == num)
			{
				buscado = pacientes.get(i);
				i = pacientes.size();
			}
		}
		return buscado;
	}
	//cambiar fecha prueba citologica de la mujer embarazada
	public boolean cambiarFechaPruebaCit(Paciente p,long num)
	{
		
		boolean cambio = false;
    	Mujer m = (Mujer)p;
    	Date ultima = m.getUltPruebaCit();
    	Calendar fechaActual = GregorianCalendar.getInstance();
    	Date fechaMaq = fechaActual.getTime();
    	
    	if(ultima.compareTo(fechaMaq) != 0) 
    	{
    		cambio = true;
    		((Mujer)p).setUltPruebaCit(fechaMaq);
    	}
    	return cambio;
	}

	//cambiar a mujer embarazada
	public void cambiarAEmbarazadas(Paciente pac)
	{
		//int pos = posicionPaciente(pac.getID());
		Mujer m = (Mujer)pac;
		if(!m.isEmbarazada())
		{
			m.setEmbarazada(true);
			mujeresEmbarazadas.add(m);
		}
	}
	//eliminar el embarazo de una mujer
	public void eliminarEmbarazo(Paciente pac)
	{
		Mujer m = (Mujer)pac;
		int pos = buscarEmbarazada(m);
		mujeresEmbarazadas.remove(pos);
		((Mujer)pac).setEmbarazada(false);
	}
	// buscar poscicion de embarazada
	public int buscarEmbarazada(Mujer m)
	{
		int pos = 0;
		for (int i = 0; i < mujeresEmbarazadas.size(); i++) 
		{
			if(mujeresEmbarazadas.get(i).equals(m))
			{
				pos = i;
				i = mujeresEmbarazadas.size();
			}
		}
		return pos;

	}
	//agregar vacuna a un paciente
	public boolean agregarVacuna(String Id, String nombreVacuna)
	{
		boolean puesta = false;
		int pos = posicionPaciente(Id);
		int poshc = obtenerposHistClinica(pacientes.get(pos).getNumeroHC());
		Calendar r = Calendar.getInstance();
		Date fecha = (Date)r.getTime();
		if(historiasClinicas.get(poshc).registrarVacunacion(fecha, nombreVacuna))
			puesta = true;
		return puesta;
	}
	//obtener la edad actual del paciente
	public int edadActual(Paciente pac) 
	{
		int ano = 0;
		int mes = 0;
		int dia = 0;

		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaNac = new GregorianCalendar();
		String fechaAux = pac.getID().substring(0,6);
		char[] cad = fechaAux.toCharArray();

		if(pac.getEdad() < 100)
		{
			if(cad[0] == '0')
			{
				ano = 2000;
				ano += (cad[1] - '0');
			}
			if(cad[0] != '0')
			{
				ano = 1900;
				ano += (cad[0] - '0')*10;
				ano += (cad[1] - '0');
			}
			if(cad[2] == '1')
			{
				mes = 10;
				mes += cad[3] - '0';
			}
			if(cad[2] == '0')
				mes = cad[3] - '0';
			if(cad[4] == '0')
				dia = cad[5] - '0';
			if(cad[2] != '0')
			{
				dia = (cad[4] - '0')*10;
				dia += cad[5] - '0';
			}
			fechaNac.set(ano,mes,dia);
		}
		else
		{
			ano = 1800;
			ano += (cad[0] - '0') * 10 + (cad[0] - '0');

			if(cad[2] == '1')
			{
				mes = 10;
				mes += cad[3] - '0';
			}
			if(cad[2] == '0')
				mes = cad[3] - '0';
			if(cad[4] == '0')
				dia = cad[5] - '0';
			if(cad[2] != '0')
			{
				dia = (cad[4] - '0')*10;
				dia += cad[5] - '0';
			}
			fechaNac.set(ano,mes,dia);
		}

		int dif = getDiasCalendario(fechaNac, fechaActual);
		return dif/365;
	}  
	//metodo que devuelve bien la diferencia de dos fechas en annos
	@SuppressWarnings("deprecation")
	public int getDiasCalendario(Calendar fechaInicial,Calendar fechaFinal)
	{
		int diffDays=0;
		if(fechaFinal.before(fechaInicial) || fechaInicial.equals(fechaFinal))		
			diffDays=0;
		else
		{
			if(fechaFinal.getTime().getMonth()+1 == fechaInicial.getTime().getMonth())
			{
				String s = fechaInicial.getTime().toString();
				int dia = 0;
				if(s.charAt(8) != '0')
					dia = 10 + (s.charAt(9) - '0');
				else
					dia = s.charAt(9) - '0';

				String temp = fechaFinal.getTime().toString();
				int dia2 = 0;
				if(s.charAt(8) != '0')
					dia2 = 10 + (temp.charAt(9) - '0');
				else
					dia2 = temp.charAt(9) - '0';
				if(dia - dia2 < 0)
					diffDays += 365;
			}

			while(fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal))
			{
				diffDays++;
				fechaInicial.add(Calendar.DATE, 1);
			}
		}

		return diffDays==0?0:diffDays-1;
	}
	public boolean ValidarCarnet(String carnet)
    {
    	boolean valido = false;
    	if(carnet.length() == 11)
    	{		
    		int mes = (carnet.charAt(2) - '0' * 10) + (carnet.charAt(3) - '0');
	    	if(carnet.charAt(2) == '0' && carnet.charAt(3) != '0')
	    	{
	    		if(carnet.charAt(3) == '2')
	    		{
		    		if((carnet.charAt(4) - '0') < 3)
		    		{
		    			if(carnet.charAt(4) == '2' && (carnet.charAt(5) - '0') <= 8)
		    				valido = true;
		    			if(carnet.charAt(4) == '0' || carnet.charAt(4) == '1')
		    				valido = true;
		    		}
	    		}
	    		else
	    		{
	    			if((carnet.charAt(4) - '0') <= 3)
		    		{
	    				mes = (carnet.charAt(2) - '0' * 10) + (carnet.charAt(3) - '0');
	    				if(carnet.charAt(4) == '3')
	    				{
		    				if((mes <= 7 && mes % 2 != 0) || (mes > 7 && mes < 10 && mes % 2 == 0))
		    				{
		    					if(carnet.charAt(5) == '0' || carnet.charAt(5) == '1')
		    						valido = true;
		    				}
		    				else
		    				{
		    					if(mes > 10 && mes <= 12 && mes % 2 == 0)
		    					{
		    						if(carnet.charAt(5) == '0' || carnet.charAt(5) == '1')
			    						valido = true;
		    					}
		    					else
		    					{
		    						if(carnet.charAt(5) == '0')
			    						valido = true;
		    					}
		    				}
	    				}
	    				if(carnet.charAt(4) == '1' || carnet.charAt(4) == '2')
	    					valido = true;
	    				if(carnet.charAt(4) == '0' && carnet.charAt(5) != '0')
	    					valido = true;
		    		}
	    		}
	    	}
	    	if(carnet.charAt(2) == '1' && (carnet.charAt(3) - '0') < 3)
	    	{
	    		if((carnet.charAt(4) - '0') <= 3)
	    		{
    				mes = (carnet.charAt(2) - '0' * 10) + (carnet.charAt(3) - '0');
    				if(carnet.charAt(4) == '3')
    				{
	    				if((mes <= 7 && mes % 2 != 0) || (mes > 7 && mes < 10 && mes % 2 == 0))
	    				{
	    					if(carnet.charAt(5) == '0' || carnet.charAt(5) == '1')
	    						valido = true;
	    				}
	    				else
	    				{
	    					if(mes > 10 && mes <= 12 && mes % 2 == 0)
	    					{
	    						if(carnet.charAt(5) == '0' || carnet.charAt(5) == '1')
		    						valido = true;
	    					}
	    					else
	    					{
	    						if(carnet.charAt(5) == '0')
		    						valido = true;
	    					}
	    				}
    				}
    				if(carnet.charAt(4) == '1' || carnet.charAt(4) == '2')
    					valido = true;
    				if(carnet.charAt(4) == '0' && carnet.charAt(5) != '0')
    					valido = true;
	    		}
	    	}
    	}
    	
    	
    	return valido;
    }
    
    //pacientes mayores que una edad
    public void Mayores(int edad)
    {
    	mayores.clear();
    	for (Paciente paciente : pacientes)
    	{
			if(paciente.getEdad() > edad)
				mayores.add(paciente);
		}
    }
    
    //por ciento de pacientes enfermo en el policlinico
    public float PorCientoEnfermos()
    {
    	float porciento = 0;
    	int cant = 0;
    	for (Paciente pac : pacientes)
    	{
    		if(pac.getEnfermedades().size() != 0)
    			cant++;
		}
    	
    	if(pacientes.size() != 0)
    		porciento = cant*100 / pacientes.size();
    	return porciento;
    }
    public boolean validarEntrada(String aux)
    {
    	boolean valido = true;
    	for (int i = 0; i < aux.length(); i++)
    	{
    		if(aux.charAt(i) != '0' && aux.charAt(i) != '1' && aux.charAt(i) != '2' && aux.charAt(i) != '0'
    				&& aux.charAt(i) != '4' && aux.charAt(i) != '5' && aux.charAt(i) != '6' && aux.charAt(i) != '7'
    				&& aux.charAt(i) != '8' && aux.charAt(i) != '9')
    		{
    			valido = false;
    			i = aux.length();
    		}
		}
    	return valido;
    }
}
