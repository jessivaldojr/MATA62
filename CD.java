public class CD extends Material {

	private String[] autor;

	private String[] faixa;

	private short anoPublicacao;

	public CD(int codigo, String[] autor, String[] faixa, 
											short anoPublicacao) {
		super(codigo);
		this.autor = autor;
		this.faixa = faixa;
		this.anoPublicacao = anoPublicacao;
	}

	public String[] getAutor() {
		return autor;
	}

	public String[] getFaixa() {
		return faixa;
	}

	public short getAnoPublicacao() {
		return anoPublicacao;
	}
	
}
