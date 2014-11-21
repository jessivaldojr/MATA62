import java.util.Calendar;
import java.util.Date;

public class AlunoGraduacao implements ClasseDeUsuario {

	@Override
	public Date calculaDataDevolucao(Date dataEmprestimo) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
	}

	@Override
	public String realizaEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		if(usuario.estaDevedor()) {
			return "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
																" está em débito" + fimDeLinha; 
		}
		
		if(usuario.getTotalEmprestimosEmAberto() > 3) {
			return "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
					" Já possui número máximo de 3 empréstimos!" + fimDeLinha; 
		}
		
		Reserva r = usuario.getReservaPeloCodigoMaterial(m.getCodigo()); 
		Date d = new Date(System.currentTimeMillis());
		
		String msg = "Empréstimo realizado com sucesso! " + fimDeLinha + 
					 "Usuário: " + usuario.getNome() + fimDeLinha +
					 "Título: " + m.getTitulo() + fimDeLinha;
		
		if(r != null) {
			usuario.removerReserva(r);
			m.removerReserva(r);
			
			usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
			
			return msg;
		}
		else if(m.possuiExemplaresSemReserva()) {
			usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
			
			return msg;
		}
			
		return null;
	}

}
