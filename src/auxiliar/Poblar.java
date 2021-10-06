package auxiliar;

import logica.*;

import java.util.ArrayList;
import java.util.Date;

public class Poblar {

	@SuppressWarnings("deprecation")
	public static void iniciar(){
		//Especialidades para remision
		String alegista = "Alegista";
		String oculista = "Oculista";
		String ortopedia = "Ortop�dico";
		ArrayList<String> especialidades = new ArrayList<String>();
		especialidades.add(alegista);
		especialidades.add(oculista);
		especialidades.add(ortopedia);
		CMF.getInstancia().setEspecialidadesregistradas(especialidades);
		//Analisis
		ArrayList<String> analisis =new ArrayList<String>();
		analisis.add("Orina");
		analisis.add("Rayos X");
		analisis.add("Sangre");
		CMF.getInstancia().setTiposdeanalisis(analisis);

		//Enfermedades
		Enfermedad sida = new Enfermedad("Sida");
		Enfermedad asma = new Enfermedad("Asma");
		Enfermedad cancer = new Enfermedad("C�ncer");
		Enfermedad hipertension = new Enfermedad("Hipertensi�n");
		Enfermedad diabetes = new Enfermedad("Diabetes");

		ArrayList<Enfermedad> enfs = new ArrayList<Enfermedad>();
		enfs.add(diabetes);
		enfs.add(hipertension);
		enfs.add(cancer);
		enfs.add(asma);
		enfs.add(sida);
		CMF.getInstancia().setEnfermedades(enfs);

		//Vacunas
		ArrayList<Vacunacion> v = new ArrayList<Vacunacion>();
		Vacunacion vac1 = new Vacunacion("Tifuidea");
		Vacunacion vac2 = new Vacunacion("Tetano");
		Vacunacion vac3 = new Vacunacion("Antipoliomel�tica");
		v.add(vac1);
		v.add(vac2);
		v.add(vac3);
		CMF.getInstancia().setVacunas(v);

		//Medico
		Date fecha = new Date("06/2019/01");
		Medico medico = new Medico("Juan Almiro Ramiro", "15236855", "79021586935",fecha);
		//Enfermera
		Enfermera enfermera = new Enfermera("Laura Sanchez Luz", "86123052152",fecha, true,10);
		//Consultorio
		CMF.getInstancia().setNumero(24);
		CMF.getInstancia().setNombreDirPol("Pedro Perez Diaz");
		CMF.getInstancia().setNombrePoliclinico("19 de abril");
		CMF.getInstancia().setMedicoF(medico);
		CMF.getInstancia().setEnfermera(enfermera);

		//***************************Pacientes
		ArrayList<Historia_Clinica> historias = new ArrayList<Historia_Clinica>();
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		ArrayList<Mujer> embarazadas = new ArrayList<Mujer>();
		ArrayList<Ninno> ninnos = new ArrayList<Ninno>();

		//paciente 1
		Paciente pedro = new Paciente("Pedro Luis Gomez Garcia", "70070515723", "Calle 20 e/ 15 y 17", 1,49,"Masculino");
		Historia_Clinica h1 = new Historia_Clinica("Pedro Luis Gomez Garcia", "70070515723", 1);
		pacientes.add(pedro);


		//paciente 2
		Paciente pac2 = new Paciente("Juan Diaz Martinez", "90120456211", "Calle 18 e/ 29 y 48", 2,39,"Masculino");
		Historia_Clinica h2 = new Historia_Clinica("Juan Diaz Martinez", "90120456211", 2);
		h2.getEnfermedades().add(new Enfermedad("sida"));
		pac2.annadirEnfermedad(sida);
		pacientes.add(pac2);


		//paciente 3
		Ninno ni1 = new Ninno("Miguel Izquierdo Urrutia", "08021486354", "Calle 13 e/ 1 y 3", 3,0,"Masculino");
		Historia_Clinica h3 = new Historia_Clinica("Miguel Izquierdo Urrutia", "08021486354", 3);
		pacientes.add(ni1);
		ninnos.add(ni1);

		//paciente 4
		Mujer muj1 = new Mujer("Yania Lopez Robaina", "56124305663", "Calle 23 e/ 18 y 20",4 ,fecha,63,"Femenino");
		Historia_Clinica h4 = new Historia_Clinica("Yania Lopez Robaina", "56124305663", 4);
		pacientes.add(muj1);

		//paciente 5
		Mujer muj2 = new Mujer("Juana Dominguez Perez", "46545454654", "Calle 43 # 168", 5, fecha,73,"Femenino");
		Historia_Clinica h5 = new Historia_Clinica("Juana Dominguez Perez", "46545454654", 5);
		muj2.setEmbarazada(true);
		pacientes.add(muj2);
		embarazadas.add(muj2);


		//paciente 6
		Paciente david = new Paciente("David Puerta", "96072207941", "23 #1365 e/ 18 y 20", 6, 22, "Masculino");
		Historia_Clinica h6 = new Historia_Clinica("David Puerta", "96072207941", 6);
		pacientes.add(david);

		//paciente 7
		Paciente pac7 = new Paciente("Jose Miguel Hernandez", "45011823651", "Calle 34 #12", 7,74, "Masculino");
		Historia_Clinica h7 = new Historia_Clinica("Jose Miguel Hernandez", "45011823651", 7);
		pac7.annadirEnfermedad(diabetes);
		pac7.annadirEnfermedad(hipertension);
		h7.getEnfermedades().add(diabetes);
		h7.getEnfermedades().add(hipertension);
		pacientes.add(pac7);


		//paciente 8
		Mujer pac8 = new Mujer("Manuela Parra Gonzales", "59010123651", "Calle 2 # 26", 8,fecha,60, "Femenino");
		Historia_Clinica h8 = new Historia_Clinica("Manuela Parra Gonzales", "59010123651", 8);
		pac8.annadirEnfermedad(asma);
		h8.getEnfermedades().add(asma);
		pacientes.add(pac8);

		//paciente 9
		Mujer pac9 = new Mujer("Angela Gomez Diaz", "89020778561", "Calle 17 #4", 9,fecha,30, "Femenino");
		pac9.setEmbarazada(true);
		Historia_Clinica h9 = new Historia_Clinica("Angela Gomez Diaz", "89020778561", 9);
		pacientes.add(pac9);
		embarazadas.add(pac9);

		//paciente 10
		Mujer pac10 = new Mujer("Graciela Castro Guevara", "92020558581", "Calle 8 e/ 3 y 5", 10,fecha,27, "Femenino");
		pac10.setEmbarazada(true);
		Historia_Clinica h10 = new Historia_Clinica("Graciela Castro Guevara", "92020558581", 10);
		pacientes.add(pac10);
		embarazadas.add(pac10);

		//paciente 11
		Paciente pac11 = new Paciente("Juan Jose Guerra Paz", "68010878945", "Zapata y 12", 11,51, "Masculino");
		Historia_Clinica h11 = new Historia_Clinica("Juan Jose Guerra Paz", "68010878945", 11);
		pac11.annadirEnfermedad(cancer);
		h11.getEnfermedades().add(cancer);
		pacientes.add(pac11);

		//paciente 12
		Paciente pac12 = new Paciente("Alvaro Martinez", "70010826531", "B e/ 1 y 3", 12,49, "Masculino");
		Historia_Clinica h12 = new Historia_Clinica("Alvaro Martinez", "70010826531", 12);
		pac12.annadirEnfermedad(asma);
		h12.getEnfermedades().add(asma);
		pacientes.add(pac12);

		//paciente 13
		Paciente pac13 = new Paciente("Vicente Frente Fernandez", "80050604582", "G y 23", 13,39, "Masculino");
		Historia_Clinica h13 = new Historia_Clinica("Vicente Frente Fernandez", "80050604582", 13);
		pacientes.add(pac13);

		//paciente 14
		Paciente pac14 = new Paciente("Pablo Rondon Ramirez", "50050604582", "G y 23", 14,39, "Masculino");
		Historia_Clinica h14 = new Historia_Clinica("Pablo Rondon Ramirez", "50050604582", 14);
		pac14.annadirEnfermedad(hipertension);
		h14.getEnfermedades().add(hipertension);
		pacientes.add(pac14);

		//paciente 15
		Paciente pac15 = new Paciente("Pablo Rondon Ramirez", "50050604582", "G y 23", 15,69, "Masculino");
		Historia_Clinica h15 = new Historia_Clinica("Pablo Rondon Ramirez", "50050604582", 15);
		pacientes.add(pac15);

		//paciente 16
		Paciente pac16 = new Paciente("Enrique Hoyos Pozo", "40112315632", "31 y 26", 16,79, "Masculino");
		Historia_Clinica h16 = new Historia_Clinica("Enrique Hoyos Pozo", "40112315632", 16);
		Visita visitapac16 = new Visita(new Date("01/2017/12"), "Esta loco", "Internarse", null, null);
		h16.getVisitas().add(visitapac16);
		Visita visitapac16_2 = new Visita(new Date("01/2017/30"), "Esta loco", "Internarse", null, null);
		h16.getVisitas().add(visitapac16_2);
		pacientes.add(pac16);

		//paciente 17
		Paciente pac17 = new Paciente("Jorge Luis Perez Enriquez", "96112810183", "Fomento #571 / 4ta y 5ta", 17,22, "Masculino");
		Historia_Clinica h17 = new Historia_Clinica("Jorge Luis Perez Enriquez", "96112810183", 17);
		pacientes.add(pac17);

		//paciente 18
		/*Paciente pac18 = new Paciente("Jose Miguel Hernandez", "45011823651", "Calle 34 #12", 18,74, "Masculino");
		Historia_Clinica h18 = new Historia_Clinica("Jose Miguel Hernandez", "45011823651", 18);
		pac18.a�adirEnfermedad(asma);
		pac18.a�adirEnfermedad(diabetes);
		h18.getEnfermedades().add(diabetes);
		h18.getEnfermedades().add(hipertension);
		pacientes.add(pac7);*/

		//Fechas para las hojas de cargo
		Date fecha1 = new Date("06/2019/10");
		Date fecha2 = new Date("06/2019/11");
		Date fecha3 = new Date("06/2019/12");
		Date fecha4 = new Date("06/2019/13");
		Date fecha5 = new Date("06/2019/14");
		Date fecha6 = new Date("06/2019/15");
		Date fecha7 = new Date("06/2019/16");

		//*******************Hojas de Cargo
		ArrayList<ArrayList<Hoja_Cargo>> hojasdecarg = new ArrayList<ArrayList<Hoja_Cargo>>();
		ArrayList<Hoja_Cargo> hoja = new ArrayList<Hoja_Cargo>();

		Hoja_Cargo hoja1 = new Hoja_Cargo(fecha1);
		Hoja_Cargo hoja2 = new Hoja_Cargo(fecha2);
		Hoja_Cargo hoja3 = new Hoja_Cargo(fecha3);
		Hoja_Cargo hoja4 = new Hoja_Cargo(fecha4);
		Hoja_Cargo hoja5 = new Hoja_Cargo(fecha5);
		Hoja_Cargo hoja6 = new Hoja_Cargo(fecha6);
		Hoja_Cargo hoja7 = new Hoja_Cargo(fecha7);

		//Analisis para pasar por parametro a las consultas y remiciones
		ArrayList<String> remiciones = new ArrayList<String>();

		//Rellenar hoja de cargo 1
		hoja1.annadirVisita("Pedro Luis Gomez Garcia", 49, "Calle 20 e/ 15 y 17", "Tiene la garganta inflamada.");
		ArrayList<ResultadoAnalisis> analisispac1hoja1 = new ArrayList<ResultadoAnalisis>();
		ResultadoAnalisis orinapac1hoja1 = new ResultadoAnalisis("Orina", "Calculo en el ri�on", fecha1, fecha2);
		analisispac1hoja1.add(orinapac1hoja1);
		h1.agregarNuevaVisita(fecha1, "Tiene la garganta inflamada.", "Tomar antibioticos", "Hacer reposo", remiciones, analisispac1hoja1);

		//Rellenar hoja de cargo 2

		//Rellenar hoja de cargo 3

		//Rellenar hoja de cargo 4

		//Rellenar hoja de cargo 5

		//Rellenar hoja de cargo 6

		//Rellenar hoja de cargo 7

		//Agregar historia clinicas a la lista de historias clinicas
		historias.add(h1);
		historias.add(h2);
		historias.add(h3);
		historias.add(h4);
		historias.add(h5);
		historias.add(h6);
		historias.add(h7);
		historias.add(h8);
		historias.add(h9);
		historias.add(h10);
		historias.add(h11);
		historias.add(h12);
		historias.add(h13);
		historias.add(h14);
		historias.add(h15);
		historias.add(h16);
		historias.add(h17);

		//Agregar hojas de cargo a la lista de hojas de cargo del consultorio
		hoja.add(hoja1);
		hoja.add(hoja2);
		hoja.add(hoja3);
		hoja.add(hoja4);
		hoja.add(hoja5);
		hoja.add(hoja6);
		hoja.add(hoja7);
		hojasdecarg.add(hoja);

		//Agregar listas al Consultorio
		CMF.getInstancia().setHistoriasClinicas(historias);
		CMF.getInstancia().setMujeresEmbarazadas(embarazadas);
		CMF.getInstancia().setNinnos(ninnos);
		CMF.getInstancia().setPacientes(pacientes);
		CMF.getInstancia().setHojas_Cargo(hojasdecarg);

		//probar la lista de los pacientes con enfermedad
		/*Historia_Clinica his = new Historia_Clinica(pac3.getNombre(), pac3.getID(), pac3.getNumeroHC()); 
			ResultadoAnalisis res = new ResultadoAnalisis("sangre", "hemoglobina baja");
			his.getResultadosAnalisis().add(res);
			cmf.getPacientePresultado().add(pac3);
			cmf.getHistoriasClinicas().add(his);
		 */



	}
}