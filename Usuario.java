import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.spi.RegisterableService;

public abstract class Usuario {

	private String nome;

	private int id;

	private Collection<Reserva> reservas = new Vector<Reserva>();

	private Collection<Emprestimo> emprestimosEmAberto = new Vector<Emprestimo>();
	
	private Collection<Emprestimo> emprestimosFinalizados = new Vector<Emprestimo>();
	
	public Usuario(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public boolean emDebito() {
		return false;
	}

	public void incluirReserva(Reserva r) {
		reservas.add(r);
	}

	public void removerReserva(Reserva r) {
		reservas.remove(r);
	}

	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public Emprestimo getEmprestimoPeloCodigoExemplar(int codigo) {
		
		Iterator<Emprestimo> iterator = emprestimosEmAberto.iterator();
		
		while(iterator.hasNext()){
			
			Emprestimo cada = (Emprestimo) iterator.next();
			
			if(cada.getCodigoExemplar() == codigo) {
				return cada;
				
			}
		}
		
		return null;
		
	}
	
	public Emprestimo getEmprestimoPeloCodigoMaterial(int codigo) {
		
		Iterator<Emprestimo> iterator = emprestimosEmAberto.iterator();
		
		while(iterator.hasNext()){
			
			Emprestimo cada = (Emprestimo) iterator.next();
			
			if(cada.getCodigoMaterial() == codigo) {
				
				return cada;
			}
		}
		
		return null;
		
	}
	
	public Reserva getReservaPeloCodigoMaterial(int codigo) {
		
		Iterator<Reserva> iterator = reservas.iterator();
		
		while(iterator.hasNext()){
			
			Reserva cada = (Reserva) iterator.next();
			
			if(cada.getCodigoMaterial() == codigo) {
				return cada;
				
			}
		}
		
		return null;
		
	}
	
	public String listagemReservas() {
		
		final String fimDeLinha = System.getProperty("line.separator");
		String lista = "";
		
		if(reservas.isEmpty()) {
			
			return lista += "Usuário não possui reservas cadastradas." + fimDeLinha;
					
		}
		
		Iterator<Reserva> iterator = reservas.iterator();
		
		while(iterator.hasNext()) {
			
			Reserva cada = (Reserva) iterator.next();
			
			lista += "Título: " + cada.getTituloMaterial() + fimDeLinha;
			lista += "Data da solicitação:" + cada.getData().toString() + fimDeLinha;
			
		}
		
		return lista;
	}
	
	public String listagemEmprestimos() {
		
		final String fimDeLinha = System.getProperty("line.separator");
		String lista = "";
		
		if (emprestimosFinalizados.isEmpty() && emprestimosEmAberto.isEmpty()) {
			
			lista += "Este usuário não possui empréstimos cadastrados" + fimDeLinha;
			
		}
		else {
			
			if (!emprestimosFinalizados.isEmpty()) {
				
				Iterator<Emprestimo> iterator = emprestimosFinalizados.iterator();
				Emprestimo cada;
				
				while( iterator.hasNext() ) {
					
					cada = (Emprestimo) iterator.next();
				
					lista += "Título: " + cada.getTituloMaterial() + fimDeLinha;
					lista += "Tipo: " + cada.getTipoMaterial() + fimDeLinha;
					lista += "Data do Emprestimo: " + cada.getDataEmprestimo().toString() + fimDeLinha;
					lista += "Status: finalizado" + fimDeLinha;
					lista += "Data de Devolução: " + cada.getDataDevolucao().toString() + fimDeLinha;
					
				}

			}
			
			if (!emprestimosEmAberto.isEmpty()) {
				
				Iterator<Emprestimo> iterator = emprestimosEmAberto.iterator();
				Emprestimo cada;
				
				while( iterator.hasNext() ) {
					
					cada = (Emprestimo) iterator.next();
					
					lista += "Título: " + cada.getTituloMaterial() + fimDeLinha;
					lista += "Tipo: " + cada.getTipoMaterial() + fimDeLinha;
					lista += "Data do Emprestimo: " + cada.getDataEmprestimo().toString() + fimDeLinha;
					lista += "Status: em curso" + fimDeLinha;
					lista += "Data de Devolução Prevista: " + cada.getDataDevolucaoPrevista().toString() + fimDeLinha;
					
				}
			}
		}
		
			
			return lista;		
	}
	
	public String devolucao(int codigo) {
		
		final String fimDeLinha = System.getProperty("line.separator");
		
		Emprestimo emprestimo = getEmprestimoPeloCodigoMaterial(codigo);
		
		if(emprestimo != null) {
			
			emprestimosEmAberto.remove(emprestimo);
			
			emprestimo.setDataDevolucao(new Date());
			emprestimo.devolverExemplar();
			
			emprestimosFinalizados.add(emprestimo);
			
			return "Devolução efetuada com sucesso. " + fimDeLinha + 
					"Usuário: " + getNome() + fimDeLinha + 
					"Material devolvido: " + emprestimo.getTituloMaterial() + fimDeLinha;
					
		}
		
		return null;
		
	}
	
	public abstract Date calculaDataDevolucao(Date dataEmprestimo);

	public abstract boolean emprestimoPermitido(Exemplar e);
	
}
