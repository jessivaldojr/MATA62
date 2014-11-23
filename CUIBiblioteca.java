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
			String[] args = new String[c.length - 1]; 
			
			System.arraycopy(c, 1, args, 0, c.length - 1);
			
			return comando.executa(args);
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
			
			if(cmds.length >= 2) {				
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
		
		comandos.put("emp", new ComandoEmprestimo());
		comandos.put("dev", new ComandoDevolucao());
		comandos.put("res", new ComandoReserva());
		comandos.put("mat", new ComandoConsultaMaterial());
		comandos.put("usu", new ComandoConsultaUsuario());
		
	}
	
	private void initBiblioteca() {
		
		biblioteca.addUsuario("João da Silva", 123, new AlunoGraduacao());
		biblioteca.addUsuario("Luiz Fernando Rodrigues", 456, new AlunoPosGraduacao());
		biblioteca.addUsuario("Pedro Paulo", 789, new AlunoGraduacao());
		biblioteca.addUsuario("Carlos Lucena", 100, new Professor());
		
		String[] autores0 = {"Ian Sommervile"};
		biblioteca.addLivro(100,"Engenharia de Software", "Addison Wesley",autores0, "6a", 2000);
		biblioteca.addExemplar(100, 1);
		biblioteca.addExemplar(100, 2);
		
		String[] autores = {"Grady Booch", "James Rumbaugh", "Ivar Jacobson"};
		biblioteca.addLivro(101,"UML - Guia do Usuário", "Campus", autores ,  "7a", 2000);
		biblioteca.addExemplar(101,  3);
		
		
		biblioteca.addRevista(200,"IEEE Transactions on Software Engineering", "53", "Setembro",  2006);
		biblioteca.addExemplar(200,  4);
		
		biblioteca.addRevista(201,"IEEE Transactions on Software Engineering", "54", "Outubro", 2006);
		biblioteca.addExemplar(201,  5);
		
		
		String[] faixas = {"Rehab", "You Know I'm No Good", "Me & Mr Jones"};
		biblioteca.addCD(300, "Back to Black", "Amy Winehouse", faixas, 2006);
		biblioteca.addExemplar(300,  6);
		biblioteca.addExemplar(300,  7);
		
		String[] faixas1 = {"Longe", "Invejoso", "Envelhecer"};
		biblioteca.addCD(301, "Iê Iê Iê", "Arnaldo Antunes", faixas1, 2009);
		
		String[] autores1 = {"Harrison Ford", "Cate Blanchett"};
		biblioteca.addDVD(400, "Indiana Jones and the Kingdom of the Crystal Skull", autores1, (short) 4, 2008);
		biblioteca.addExemplar(400,  8);
		biblioteca.addExemplar(400,  9);
		
		String[] autores2 = {"William Hurt", "Tim Blake Nelson"};
		biblioteca.addDVD(401, "Incredible Hulk", autores2, (short) 4, 2008);
		
	}
	

}
