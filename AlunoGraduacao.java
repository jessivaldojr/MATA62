import java.util.Date;

public class AlunoGraduacao extends Usuario {

	public AlunoGraduacao(String nome, int id) {
		super(nome, id);
	}

	public Date calculaDataDevolucao(Date dataEmprestimo) {
		return null;
	}

	public boolean emprestimoPermitido(Exemplar e) {
		return false;
	}

}
