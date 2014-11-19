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

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public Material getMaterial() {
		return material;
	}
	
}
