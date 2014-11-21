public class Professor extends ClasseDeUsuario {

	@Override
	public StatusRegraEmprestimo verificaRegrasDeEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		String msg;
		
		if(usuario.estaDevedor()) {
			
			msg = "Não foi possível realizar o empréstimo. Usuário: " + usuario.getNome() + 
																" está em débito" + fimDeLinha;
			
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
		
		msg = " Emprestimo Concedido!" + fimDeLinha;
		
		return new StatusRegraEmprestimo(true, msg);
		
	}

	@Override
	public int totalDiasPermitidoEmprestimo() {
		return 4;
	}
	
}
