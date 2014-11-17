import java.util.Date;

public abstract class Usuario {

	private String nome;

	private int id;

	private Reserva[] reserva;

	private Emprestimo[] emprestimoEmAberto;
	
	private Emprestimo[] emprestimoFinalizados;
	
	public Usuario(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public boolean emDebito() {
		return false;
	}

	public abstract Date calculaDataDevolucao(Date dataEmprestimo);

	public abstract boolean emprestimoPermitido(Exemplar e);

	public void incluirReserva(Reserva r) {

	}

	public void removerReserva(Reserva r) {

	}

}
