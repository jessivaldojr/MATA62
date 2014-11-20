public class ComandoEmprestimo implements Comando {

	private Biblioteca biblioteca;

	public ComandoEmprestimo(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String executa(String[] arg) {
		
		if(arg.length == 2) {
			int codUsuario = Integer.getInteger(arg[0]);
			int codMaterial = Integer.getInteger(arg[1]);
			
			return biblioteca.emprestimo(codUsuario, codMaterial);
		}
		
		return "Erro! Número inválido de argumentos" + System.getProperty("line.separator");
	}

}
