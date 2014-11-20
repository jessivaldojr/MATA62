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


	
	private String executaComando(String[] c) {
		
		comando = (Comando) comandos.get(c[0]);
		
		if(comando != null) {
			return comando.executa(//como pegar o resto da string);
		}
		
		return "Comando Inválido" + System.getProperty("line,separator");
		
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String entrada;
	
		String[] cmds;
		
		final String fimDeLinha = System.getProperty("line.separator");
		String msg = "Entre o Comando no seguinte formato:" + fimDeLinha + 
				"<Comando> <arg0> [<arg1>] [<arg2>] ..." + fimDeLinha +
				"Ou diqite 'q' para sair" + fimDeLinha;
		
		cui = new CUIBiblioteca();
		
		cui.initBiblioteca();
		cui.initComandos();
		
		System.out.println("Bem-Vindo ao Sistema de Bibliotecas");
		
		System.out.println(msg);
		entrada = scan.nextLine();
		
		while(!entrada.equals("q")) {
			
			cmds = entrada.split(" ");
			
			if(cmds.length > 2) {
				String t = cui.executaComando(cmds);
				System.out.println(t);
			}
			else
				System.out.println("Erro! Número inválido de argumentos");
			
			System.out.println(msg);
			entrada = scan.nextLine();
			
		}
		
		scan.close();
				
	}

	private void initComandos() {
		
		comandos.put("emp", new ComandoEmprestimo(biblioteca));
		comandos.put("dev", new ComandoDevolucao(biblioteca));
		comandos.put("res", new ComandoReserva(biblioteca));
		comandos.put("mat", new ComandoConsultaMaterial(biblioteca));
		comandos.put("usu", new ComandoConsultaUsuario(biblioteca));
		
	}
	
	private void initBiblioteca() {
		
		String[] autores0 = {"Ian Sommervile"};
		biblioteca.addLivro(100,"Engenharia de Software", "Addison Wesley",autores0, "6a", 2000);
		biblioteca.addExemplar(100,(short) 1);
		biblioteca.addExemplar(100,(short) 2);
		
		String[] autores = {"Grady Booch", "James Rumbaugh", "Ivar Jacobson"};
		biblioteca.addLivro(101,"UML - Guia do Usuário", "Campus", autores ,  "7a", 2000);
		biblioteca.addExemplar(101, (short) 3);
		
		
		biblioteca.addRevista(200,"IEEE Transactions on Software Engineering", "53", "Setembro",  2006);
		biblioteca.addExemplar(200, (short) 4);
		
		biblioteca.addRevista(201,"IEEE Transactions on Software Engineering", "54", "Outubro", 2006);
		biblioteca.addExemplar(201, (short) 5);
		
		
		String[] faixas = {"Rehab", "You Know I'm No Good", "Me & Mr Jones"};
		biblioteca.addCD(300, "Back to Black", "Amy Winehouse", faixas, 2006);
		biblioteca.addExemplar(300, (short) 6);
		biblioteca.addExemplar(300, (short) 7);
		
		String[] faixas1 = {"Longe", "Invejoso", "Envelhecer"};
		biblioteca.addCD(301, "Iê Iê Iê", "Arnaldo Antunes", faixas1, 2009);
		
		String[] autores1 = {"Harrison Ford", "Cate Blanchett"};
		biblioteca.addDVD(400, "Indiana Jones and the Kingdom of the Crystal Skull", autores1, (short) 4, 2008);
		biblioteca.addExemplar(400, (short) 8);
		biblioteca.addExemplar(400, (short) 9);
		
		String[] autores2 = {"William Hurt", "Tim Blake Nelson"};
		biblioteca.addDVD(401, "Incredible Hulk", autores2, (short) 4, 2008);
		
	}
	

}
