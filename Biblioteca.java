import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class Biblioteca {

	private static Biblioteca biblioteca;

	private Collection<Usuario> usuarios = new Vector<Usuario>();

	private Collection<Material> materiais = new Vector<Material>();

	private final String fimDeLinha = System.getProperty("line.separator");
	
	private Biblioteca() {
		//Singleton
	}
	
	public static Biblioteca obeterBiblioteca() {
		
		if(biblioteca == null) {
			biblioteca = new Biblioteca();
		}
			
		return biblioteca;	
	}
	
	public void addUsuario(String nome, int codigo, ClasseDeUsuario c) {	
		usuarios.add(new Usuario(nome, codigo, c));
	}
	
	public void addCD(int codigo, String titulo, String autor, String[] faixa, int ano) {
		materiais.add(new CD(codigo, titulo, autor, faixa, ano));
	}
	
	public void addDVD(int codigo, String titulo, String[] autor, short regiao, int ano) {
		materiais.add(new DVD( codigo, titulo,  autor, regiao, ano));
	}
	
	public void addLivro(int codigo, String titulo, String editora, String[] autores, String edicao, int ano) {
		materiais.add(new Livro(codigo, titulo, editora, autores, edicao, ano));
	}
	
	public void addRevista(int codigo, String titulo, String edicao, String mesPublicacao, int ano) {
		materiais.add(new Revista(codigo, titulo, edicao, mesPublicacao, ano));
	}
	
	public boolean addExemplar(int codigoMaterial, int codigoExemplar) {
		Material m = getMaterialPeloCodigo(codigoMaterial);
	
		if(m != null){
			m.addExemplar(codigoExemplar);
			return true;
		}
	
		return false;	
	}
	
	private Material getMaterialPeloCodigo(int codigo) {
		
		Iterator<Material> iterator = materiais.iterator();
		
		while(iterator.hasNext()) {
			
			Material cada = (Material) iterator.next();
			
			if(cada.getCodigo() == codigo) {
				
				return cada;
				
			}
		}
		
		return null;	
	}
	
	private Usuario getUsuarioPeloCodigo(int codigo) {
		
		Iterator<Usuario> iterator = usuarios.iterator();
		
		while(iterator.hasNext()) {
			
			Usuario cada =  (Usuario) iterator.next();
			
			if(cada.getCodigo() == codigo) {
				
				return cada;
				
			}
		}
		
		return null;	
 	}
	
	public String emprestimo(int codigoUsuario, int codigoMaterial) {
				
		Usuario usuario = getUsuarioPeloCodigo(codigoUsuario);
		
		Material material = getMaterialPeloCodigo(codigoMaterial);
		
		if(usuario == null) {
			
			return "Usuário inexistente." + fimDeLinha;
		}
		
		if(material == null) {
			
			return "Material inexistente." + fimDeLinha;
		}
		
		return usuario.realizaEmprestimo(material);
	}

	public String devolucao(int codigoUsuario, int codigoMaterial) {
		
		Usuario user = getUsuarioPeloCodigo(codigoUsuario);
		
		if(user == null)
			return "Erro. Usuário inexistente." + fimDeLinha;
		
		String mensagem = user.devolucao(codigoMaterial);
		
		if(mensagem == null) {
			
			Material material = getMaterialPeloCodigo(codigoMaterial);
			
			mensagem += "Erro na devolução. Usuário " + user.getNome() + " não possui empréstimo em aberto do material: " + 
						material.getTitulo() + fimDeLinha;
		}
		
		return mensagem;
	}

	public String reserva(int codigoUsuario, int codigoMaterial) {
		
		String mensagem;
		
		Usuario usuario = getUsuarioPeloCodigo(codigoUsuario);
		
		Material material = getMaterialPeloCodigo(codigoMaterial);
		
		if(usuario == null) {
			
			return "Usuário inexistente." + fimDeLinha;
		}
		
		if(usuario.getTotalReservas() == 3) {
			return "Erro! Usuário: " + usuario.getNome() + " já atingiu o número limite de " +
																"3 reservas" + fimDeLinha; 
		}
		
		mensagem = "Usuário: " + usuario.getNome() + fimDeLinha;
		
		if(material == null) {
			
			return "Material inexistente." + fimDeLinha;
		}
		
		mensagem += "Material: " + material.getTitulo() + fimDeLinha;
		
		material.novaReserva(new Date(System.currentTimeMillis()), usuario);
		
		return "Reserva realizada com sucesso!" + fimDeLinha + mensagem;
	}

	public String consultaMaterial(int codigo) {
		
		String consulta = "Consulta de Material" + fimDeLinha;
		Material m = getMaterialPeloCodigo(codigo);	
		
		if (m != null) {
			
			consulta = "Título: " + m.getTitulo() + fimDeLinha;
				
			consulta += "Usuários com reservas:" + fimDeLinha;
			consulta += m.listagemReservas();
						
			consulta += "Exemplares:" +fimDeLinha;
			consulta += m.listagemExemplares() + fimDeLinha;
			
			return consulta;
		}
		
		return "Código do material inválido" + System.getProperty("line.separator");
	}

	public String consultaUsuario(int codigo) {

		String consulta = "Consulta de Usuário" + fimDeLinha;
		Usuario user = getUsuarioPeloCodigo(codigo);
		
		if(user != null) {
			
			consulta += "Empréstimos realizados: " + fimDeLinha;
			consulta += user.listagemEmprestimos() + fimDeLinha;
			
			consulta += "Reservas Efetuadas: " + fimDeLinha;
			consulta += user.listagemReservas();
			
			return consulta;
 			
		}
		
		return "Erro! Código do usuário inválido" + fimDeLinha;
	}


}
