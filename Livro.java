public class Livro extends Material {
	
	private String editora;

	private String[] autor;

	private String edicao;

	public Livro(int codigo, String titulo, String editora, String[] autores, String edicao, int ano) {
		super(codigo, titulo, ano);
		this.editora = editora;
		this.autor = autores;
		this.edicao = edicao;
	}

	public String getEditora() {
		return editora;
	}

	public String[] getAutores() {
		return autor;
	}

	public String getEdicao() {
		return edicao;
	}

	@Override
	public String getTipo(){	
		return this.getClass().getName();
	}

}
