import java.util.Calendar;
import java.util.Date;

public abstract class ClasseDeUsuario {
	
	public String realizaEmprestimo(Material m, Usuario usuario) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		Date d = new Date(System.currentTimeMillis());
		StatusRegraEmprestimo s;
		String msg = null;
		
		s = verificaRegrasDeEmprestimo(m, usuario);
		msg += s.getMensagem();
		
		if(s.isStatus()) {
			msg = "Usuário: " + usuario.getNome() + fimDeLinha +
			 "Título: " + m.getTitulo() + fimDeLinha;
			
			usuario.addEmprestimo(new Emprestimo(d, calculaDataDevolucao(d),usuario,m.getExemplarDisponivel()));
			
			msg += "Empréstimo realizado com sucesso! " + fimDeLinha;
			
		}
		
		return msg;
	}
	
	public Date calculaDataDevolucao(Date dataEmprestimo) {
		Calendar cal = Calendar.getInstance();
        cal.setTime(dataEmprestimo);
        cal.add(Calendar.DATE,totalDiasPermitidoEmprestimo());
        return cal.getTime();
	}
	
	public abstract int totalDiasPermitidoEmprestimo();
	
	public abstract StatusRegraEmprestimo verificaRegrasDeEmprestimo(Material m, Usuario usuario);
	
}
