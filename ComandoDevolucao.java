public class ComandoDevolucao implements Comando {

	private Biblioteca biblioteca;

	public ComandoDevolucao(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String executa(String[] arg) {
		
		int codUsuario = Integer.getInteger(arg[0]);
		int codMaterial = Integer.getInteger(arg[1]);
		String r = biblioteca.devolucao(codUsuario, codMaterial);
		
		String erro = "Código do material inválido" + System.getProperty("line.separator"); 
		
		if(r == null) 
			return erro;
		
		return r;
	}

}
