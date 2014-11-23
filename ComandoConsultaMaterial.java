public class ComandoConsultaMaterial implements Comando {

	private Biblioteca biblioteca;

		
	public ComandoConsultaMaterial() {
		this.biblioteca = Biblioteca.obeterBiblioteca();
	}


	public String executa(String[] arg) {
		
		if(arg.length == 1) {
			
			int c = Integer.parseInt(arg[0]);
			
			return biblioteca.consultaMaterial(c);
			
		}
		
		return "Erro! Número inválido de argumentos" + System.getProperty("line.separator");
		
	}

}
