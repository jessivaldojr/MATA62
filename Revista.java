public class Revista extends Material {

	private String edicao;
	
	private String mes;

	public Revista(int codigo, String titulo, String edicao, String mesPublicacao, int anoPublicacao) {
		super(codigo, titulo, anoPublicacao);
		this.edicao = edicao;
		this.mes = mesPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public String getMesPublicacao() {
		return mes;
	}
	
}
