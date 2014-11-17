public class Revista extends Material {

	private String edicao;

	private short anoPublicacao;

	public Revista(String edicao, short anoPublicacao) {
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
	}

	public String getEdicao() {
		return edicao;
	}

	public short getAnoPublicacao() {
		return anoPublicacao;
	}
	
}
