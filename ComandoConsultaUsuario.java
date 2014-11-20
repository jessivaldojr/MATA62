public class ComandoConsultaUsuario implements Comando {

	private Biblioteca biblioteca;

		
	public ComandoConsultaUsuario(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}


	public String executa(String[] arg) {
		
		int c = Integer.getInteger(arg[0]);
		String r = biblioteca.consultaUsuario(c);
		
		String erro = "Código do material inválido" + System.getProperty("line.separator"); 
		
		if(r == null) 
			return erro;
		
		return r;
	}

}
