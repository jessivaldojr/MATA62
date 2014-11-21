import java.util.Calendar;
import java.util.Date;

public class Professor implements ClasseDeUsuario {

	@Override
	public Date calculaDataDevolucao(Date dataEmprestimo) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DATE,4);
        return cal.getTime();
	}


	@Override
	public String realizaEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		if(usuario.estaDevedor()) {
			return "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
																" está em débito" + fimDeLinha; 
		}
		
		Reserva r = usuario.getReservaPeloCodigoMaterial(m.getCodigo()); 
		Date d = new Date(System.currentTimeMillis());
		
		String msg = "Empréstimo realizado com sucesso! " + fimDeLinha + 
				 	 "Usuário: " + usuario.getNome() + fimDeLinha +
				 	 "Título: " + m.getTitulo() + fimDeLinha;
		
		if(r != null) {
			usuario.removerReserva(r);
			m.removerReserva(r);
			
			return msg;
		}
		
		usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
			
		return msg;
	}

}
