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
	
	public String getTituloMaterial() {
		
		return material.getTitulo();
	}
	
	public int getCodigoMaterial() {
		
		return material.getCodigo();
	}
	
	public String getTipoMaterial() {
		
		return material.getTipo();
	}
	
	public void devolverExemplar() {
		
		emprestimo = null;
		setStatus(true);
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
