import java.util.Date;

public abstract class Emprestimo {

	private Date dataEmprestimo;

	private Date dataDevolucao;

	private Date dataDevolucaoPrevista;

	private Usuario usuario;

	private Exemplar exemplar;

	public Emprestimo(Date dataEmprestimo, Date dataDevolucaoPrevista,
			Usuario usuario, Exemplar exemplar) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.dataDevolucao = null;
		this.usuario = usuario;
		this.exemplar = exemplar;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getNomeUsuario() {
		return usuario.getNome();
	}

	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public int getCodigoExemplar() {
		return exemplar.getCodigo();
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}	
	
}
