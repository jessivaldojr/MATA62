public class Exemplar {

	private short codigo;

	private boolean status;
	
	private Emprestimo emprestimo;
	
	private Material material;
	
	public Exemplar(short codigo) {
		this.codigo = codigo;
		this.status = true;
	}

	public short getCodigo() {
		return codigo;
	}

	public boolean isStatus() {
		return status;
	}

	public String getStatus() {
		if (status)
			return "Disponível";
		return "Emprestado";
	}
	
	public String getNomeUsuario() {
		if (status)
			return null;
		return emprestimo.getNomeUsuario();
	}
	 
	public String getDataEmprestimo() {
		return emprestimo.getDataEmprestimo().toString();
	}

	public String getDataDevolucaoPrevista() {
		return emprestimo.getDataDevolucaoPrevista().toString();
	}
	
	public Material getMaterial() {
		return material;
	}
	
}
