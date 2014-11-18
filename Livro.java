public class Livro extends Material {
	
	private String editora;

	private String[] autores;

	private String edicao;

	public Livro(int codigo, String titulo, String editora, String[] autores, String edicao, int ano) {
		super(codigo, titulo, ano);
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public String[] getAutores() {
		return autores;
	}

	public String getEdicao() {
		return edicao;
	}


}
