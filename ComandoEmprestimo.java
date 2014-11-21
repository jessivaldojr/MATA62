public class ComandoEmprestimo implements Comando {

	private Biblioteca biblioteca;

	public ComandoEmprestimo() {
		this.biblioteca = Biblioteca.obeterBiblioteca();
	}

	public String executa(String[] arg) {
		
		if(arg.length == 2) {
			int codUsuario = Integer.parseInt(arg[0]);
			int codMaterial = Integer.parseInt(arg[1]);
			
			return biblioteca.emprestimo(codUsuario, codMaterial);
		}
		
		return "Erro! Número inválido de argumentos" + System.getProperty("line.separator");
	}

}
