import java.util.Date;

public class AlunoGraduacao implements ClasseDeUsuario {

	public Date calculaDataDevolucao(Date dataEmprestimo) {
		//TODO
		return null;
	}

	@Override
	public String realizaEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		if(usuario.estaDevedor()) {
			return "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
																" está em débito" + fimDeLinha; 
		}
		
		if(usuario.getTotalEmprestimosEmAberto() < 3) {
			return "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
					" Já possui número máximo de 3 empréstimos!" + fimDeLinha; 
		}
		
		Reserva r = usuario.getReservaPeloCodigoMaterial(m.getCodigo()); 
		Date d = new Date(System.currentTimeMillis());
		
		if(r != null) {
			usuario.removerReserva(r);
			m.removerReserva(r);
			
			usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
		}
		else if(m.exemplaresSemReserva()) {
			usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
		}
			
		return null;
	}

}
