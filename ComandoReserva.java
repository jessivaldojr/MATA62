public class ComandoReserva implements Comando {

	private Biblioteca biblioteca;

	public ComandoReserva(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}

	public String executa(String[] arg) {

		if(arg.length == 2) {
			int codUsuario = Integer.parseInt(arg[0]);
			int codMaterial = Integer.parseInt(arg[1]);
	
			return biblioteca.reserva(codUsuario, codMaterial);
		}
		
		return "Erro! Número inválido de argumentos" + System.getProperty("line.separator");
	}


}
