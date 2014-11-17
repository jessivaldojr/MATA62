import java.util.Date;

public class Professor extends Usuario {
	
	public Professor(String nome, int id) {
		super(nome, id);
	}

	public Date calculaDataDevolucao(Date dataEmprestimo) {
		return null;
	}

	public boolean emprestimoPermitido(Exemplar e) {
		return false;
	}

}
