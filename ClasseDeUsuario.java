import java.util.Date;


public interface ClasseDeUsuario {
	
	public abstract String realizaEmprestimo(Material m, Usuario usuario);
	public abstract Date calculaDataDevolucao(Date dataEmprestimo);
	
}
