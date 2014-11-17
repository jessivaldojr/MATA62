import java.util.Date;

public class AlunoPosGraduacao extends Usuario {

	public AlunoPosGraduacao(String nome, int id) {
		super(nome, id);
	}

	public Date calculaDataDevolucao(Date dataEmprestimo) {
		return null;
	}

	public boolean emprestimoPermitido(Exemplar e) {
		return false;
	}

}
