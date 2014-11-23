public class Exemplar {

	private int codigo;

	private boolean status;
	
	private Emprestimo emprestimo;
	
	private Material material;
	
	public Exemplar(int codigo, Material material) {
		this.codigo = codigo;
		this.material = material;
		this.status = true;
	}

	public int getCodigo() {
		return codigo;
	}

	public boolean getStatus() {
		return status;
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
	
	public void emprestarExemplar(Emprestimo emp) {
		this.emprestimo = emp;
		setStatus(false);
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
