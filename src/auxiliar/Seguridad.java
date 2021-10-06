package auxiliar;

public class Seguridad {

	private final String usuarioMedco = "doctor";
	private final String contraMedco = "clinica123";
	private final String usuarioenf = "laurita";
	private final String contraenf = "love";
	
	public boolean accesoMed(String usuario, String contra){
		return this.usuarioMedco.equalsIgnoreCase(usuario) && this.contraMedco.equalsIgnoreCase(contra);
	}
	public boolean accesoEnf(String usuario, String contra){
		return this.usuarioenf.equalsIgnoreCase(usuario) && this.contraenf.equalsIgnoreCase(contra);
	}
	
}
