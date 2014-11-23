public class DVD extends Material {

	private String[] autor;

	private short regiao;

	public DVD(int codigo, String titulo, String[] autor, short regiao, int anoPublicacao) {
		super(codigo, titulo, anoPublicacao);
		this.autor = autor;
		this.regiao = regiao;
	}

	public String[] getAutor() {
		return autor;
	}

	public short getRegiao() {
		return regiao;
	}

	@Override
	public  String getTipo(){
		
		return this.getClass().getName();
	}
}
