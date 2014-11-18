public class Livro extends Material {

	private String editora;

	private String autor;

	private String edicao;

	private short ano;

	public Livro(int codigo, String editora, String autor, 
										String edicao, short ano) {
		super(codigo);
		this.editora = editora;
		this.autor = autor;
		this.edicao = edicao;
		this.ano = ano;
	}

	public String getEditora() {
		return editora;
	}

	public String getAutor() {
		return autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public short getAno() {
		return ano;
	}
	

}
