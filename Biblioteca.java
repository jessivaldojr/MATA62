import java.util.Collection;
import java.util.Vector;

public class Biblioteca {

	private static Biblioteca biblioteca;

	private Collection<Usuario> usuario = new Vector<Usuario>();

	private Collection<Material> material = new Vector<Material>();

	private Biblioteca() {
		//Singleton
	}
	
	public static Biblioteca obeterBiblioteca() {
		
		if(biblioteca == null) {
			biblioteca = new Biblioteca();
		}
			
		return biblioteca;
		
	}
	
	public void addAlunoGraduacao(String nome, int id) {
		
		usuario.add(new AlunoGraduacao(nome, id));
		
	}
	
	public void addAlunoPosGraduacao(String nome, int id) {
		
		usuario.add(new AlunoPosGraduacao(nome, id));
		
	}
	
	public void addProfessor(String nome, int id) {
		
		usuario.add(new Professor(nome, id));
		
	}
	
	public void addLivro(int codigo) {
		
		material.add(new Livro(codigo, ));
		
	}
	
	public boolean addExemplar() {
		
		//TODO
		
	}
	
	public String emprestimo() {
		return null;
	}

	public String devolucao() {
		return null;
	}

	public String consulta() {
		return null;
	}

	public String reserva() {
		return null;
	}

	public String consultaMaterial() {
		return null;
	}

	public String consultaUsuario() {
		return null;
	}

	public static Biblioteca obterInstancia() {
		return null;
	}

}
