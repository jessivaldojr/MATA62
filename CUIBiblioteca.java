import java.util.*;

public class CUIBiblioteca {

	private static CUIBiblioteca cui;
	
	private Comando comando;

	private HashMap<String, Comando> comandos = new HashMap<String, Comando>();
	
	private Biblioteca biblioteca;
	
	public CUIBiblioteca() {
		initComandos();
		this.biblioteca = Biblioteca.obeterBiblioteca();
	}


	
	private void executaComando(String arg) {
		
		comando = (Comando) comandos.get(arg);
		
		comando.executa(parametros);
		
	}
	
	public static void main(String[] args) {

		cui = new CUIBiblioteca();
		
		cui.initBiblioteca();
		cui.initComandos();
		
		
		
	}

	private void initComandos() {
		
		comandos.put("emp", new ComandoEmprestimo(biblioteca));
		comandos.put("dev", new ComandoDevolucao(biblioteca));
		comandos.put("res", new ComandoReserva(biblioteca));
		comandos.put("mat", new ComandoConsultaMaterial(biblioteca));
		comandos.put("usu", new ComandoConsultaUsuario(biblioteca));
		
	}
	
	private void initBiblioteca() {
		
		
		
	}
	

}
