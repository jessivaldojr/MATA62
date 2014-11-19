public class ComandoConsultaMaterial implements Comando {

	private Biblioteca biblioteca;

		
	public ComandoConsultaMaterial(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}


	public String executa(String[] arg) {
		
		int c = Integer.getInteger(arg[0]);
		String r = biblioteca.consultaMaterial(c);
		
		String erro = "Código do material inválido" + System.getProperty("line.separator"); 
		
		if(r == null) 
			return erro;
		
		return r;
		
	}

}
