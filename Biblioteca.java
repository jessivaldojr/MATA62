import java.util.Collection;
import java.util.Iterator;
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
	
	public void addCD(int codigo, String titulo, String autor, String[] faixa, int ano) {
		
		material.add(new CD(codigo, titulo, autor, faixa, ano));
		
	}
	
	public void addDVD(int codigo, String titulo, String[] autor, short regiao, int ano) {
		
		material.add(new DVD( codigo, titulo,  autor, regiao, ano));
		
	}
	
	public void addLivro(int codigo, String titulo, String editora, String[] autores, String edicao, int ano) {
		
		material.add(new Livro(codigo, titulo, editora, autores, edicao, ano));
		
	}
	
	public void addRevista(int codigo, String titulo, String edicao, String mesPublicacao, int ano) {
		
		material.add(new Revista(codigo, titulo, edicao, mesPublicacao, ano));
		
	}
	
	public boolean addExemplar(int codigoMaterial, short codigoExemplar) {
		
		Material aux = getMaterialPeloCodigo(codigoMaterial);
		
		if(aux != null){
			
			aux.addExemplar(codigoExemplar);
			return true;
			
		}
		
		return false;
		
	}
	
	public Material getMaterialPeloCodigo(int codigo) {
		
		Iterator<Material> iterator = material.iterator();
		
		while(iterator.hasNext()){
			
			Material cada = (Material) iterator.next();
			
			if(cada.getCodigo() == codigo) {
				return cada;
				
			}
		}
		
		return null;
		
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

	public String consultaMaterial(int codigo) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		String consulta = "Consulta de Material" + fimDeLinha;
		Material m = getMaterialPeloCodigo(codigo);	
		
		if (m != null) {
			
			consulta = "Título: " + m.getTitulo() + fimDeLinha;
				
			consulta += "Usuários com reservas:" + fimDeLinha;
			consulta += m.listagemUsuariosComReservas();
						
			consulta += "Exemplares:" +fimDeLinha;
			consulta += m.listagemExemplares() + fimDeLinha;
			
			return consulta;
		}
		
		return null;
	}

	public String consultaUsuario() {
		return null;
	}

	public static Biblioteca obterInstancia() {
		return null;
	}

}
