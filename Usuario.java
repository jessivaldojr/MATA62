import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

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
	
	public abstract Date calculaDataDevolucao(Date dataEmprestimo);

	public abstract boolean emprestimoPermitido(Exemplar e);
	
}
