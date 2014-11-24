public class AlunoGraduacao extends RegraDeEmprestimo {

	@Override
	public StatusRegraEmprestimo verificaRegrasDeEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		String msg = new String("");
		
		if(usuario.estaDevedor()) {
			
			msg = "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
																" está em débito" + fimDeLinha;
			
			return new StatusRegraEmprestimo(false, msg);
		}
		
		if(usuario.getTotalEmprestimosEmAberto() >= 3) {
			
			msg = "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
					" Já possui número máximo de 3 empréstimos!" + fimDeLinha; 
			
			return new StatusRegraEmprestimo(false, msg);
		}
		
		Reserva r = usuario.getReservaPeloCodigoMaterial(m.getCodigo()); 
		
		if(r != null) {
			usuario.removerReserva(r);
			m.removerReserva(r);
			
			msg = "Reserva Finalizada!" + fimDeLinha + 
			" Emprestimo Concedido!" + fimDeLinha;
			
			return new StatusRegraEmprestimo(true, msg);
		}
		else if(!m.possuiExemplaresSemReserva()) {
			msg = "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
			". Não Existem exemplares disponíveis para empréstimo!" + fimDeLinha;
			
			return new StatusRegraEmprestimo(false, msg);
		}	
		
		msg = " Emprestimo Concedido!" + fimDeLinha;
		
		return new StatusRegraEmprestimo(true, msg);
		
	}
	
	@Override
	public int totalDiasPermitidoEmprestimo() {
		return 1;
	}

}
