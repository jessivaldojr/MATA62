public class ComandoDevolucao implements Comando {

	private Biblioteca biblioteca;

	public ComandoDevolucao() {
		this.biblioteca = Biblioteca.obeterBiblioteca();
	}

	public String executa(String[] arg) {
		
		if(arg.length == 2) {
			int codUsuario = Integer.parseInt(arg[0]);
			int codMaterial = Integer.parseInt(arg[1]);
			
			return biblioteca.devolucao(codUsuario, codMaterial);
		}
		
		return "Erro! Número inválido de argumentos" + System.getProperty("line.separator");
	}

}
