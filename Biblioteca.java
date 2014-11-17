public class Biblioteca {

	private static Biblioteca biblioteca;

	private Usuario[] usuario;

	private Material[] material;

	private Biblioteca() {
		//Singleton
	}
	
	public static Biblioteca obeterBiblioteca() {
		
		if(biblioteca == null) {
			biblioteca = new Biblioteca();
		}
			
		return biblioteca;
		
	}
	
	
	
	public String emprestimo() {
		return null;
	}

	public String devolucao() {
		return null;
	}

	public String consulta() {
		return null;
	}

	public String reserva() {
		return null;
	}

	public String consultaMaterial() {
		return null;
	}

	public String consultaUsuario() {
		return null;
	}

	public static Biblioteca obterInstancia() {
		return null;
	}

}
