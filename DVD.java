public class DVD extends Material {

	private String[] autor;

	private short regiao;

	private short anoPublicacao; 

	public DVD(int codigo, String[] autor, short regiao, 
											short anoPublicacao) {
		super(codigo);
		this.autor = autor;
		this.regiao = regiao;
		this.anoPublicacao = anoPublicacao;
	}

	public String[] getAutor() {
		return autor;
	}

	public short getRegiao() {
		return regiao;
	}

	public short getAnoPublicacao() {
		return anoPublicacao;
	}
	

}
