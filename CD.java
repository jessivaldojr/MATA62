public class CD extends Material {

	private String autor;

	private String[] faixa;

	public CD(int codigo, String titulo, String autor, String[] faixa, int anoPublicacao) {
		super(codigo, titulo, anoPublicacao);
		this.autor = autor;
		this.faixa = faixa;
	}

	public String getAutor() {
		return autor;
	}

	public String[] getFaixa() {
		return faixa;
	}	
	
	@Override
	public  String getTipo(){
		
		return CD.class.getName();
	}
	
}
