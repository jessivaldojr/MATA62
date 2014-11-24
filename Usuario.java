import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public class Usuario {

	private final String fimDeLinha = System.getProperty("line.separator");
	
	private String nome;

	private int codigo;

	private RegraDeEmprestimo regra;
	
	private Collection reservas = new Vector();

	protected Collection emprestimosEmAberto = new Vector();
	
	private Collection emprestimosFinalizados = new Vector();
	
	public Usuario(String nome, int codigo, RegraDeEmprestimo regra) {
		this.nome = nome;
		this.codigo = codigo;
		this.regra = regra;
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

	public int getCodigo() {
		return codigo;
	}

	public int getTotalReservas() {
		return reservas.size();
	}
	
	public int getTotalEmprestimosEmAberto() {
		return emprestimosEmAberto.size();
	}
	
	public void addEmprestimo(Emprestimo e) {
		emprestimosEmAberto.add(e);
	}
	
	public Emprestimo getEmprestimoPeloCodigoExemplar(int codigo) {
		
		Iterator iterator = emprestimosEmAberto.iterator();
		
		while(iterator.hasNext()){
			
			Emprestimo cada = (Emprestimo) iterator.next();
			
			if(cada.getCodigoExemplar() == codigo) {
				return cada;
				
			}
		}
		
		return null;
	}
	
	public Emprestimo getEmprestimoPeloCodigoMaterial(int codigo) {
		
		Iterator iterator = emprestimosEmAberto.iterator();
		
		while(iterator.hasNext()){
			
			Emprestimo cada = (Emprestimo) iterator.next();
			
			if(cada.getCodigoMaterial() == codigo) {
				
				return cada;
			}
		}
		
		return null;	
	}
	
	public Reserva getReservaPeloCodigoMaterial(int codigo) {
		
		Iterator iterator = reservas.iterator();
		
		while(iterator.hasNext()){
			
			Reserva cada = (Reserva) iterator.next();
			
			if(cada.getCodigoMaterial() == codigo) {
				return cada;
			}
		}
		
		return null;
	}
	
	public String listagemReservas() {
		
		String lista = "";
		
		if(reservas.isEmpty()) {
			
			return lista += "Usuário não possui reservas cadastradas." + fimDeLinha;
					
		}
		
		Iterator iterator = reservas.iterator();
		
		while(iterator.hasNext()) {
			
			Reserva cada = (Reserva) iterator.next();
			
			lista += "Título: " + cada.getTituloMaterial() + fimDeLinha;
			lista += "Data da solicitação:" + cada.getData().toString() + fimDeLinha;
			
		}
		
		return lista;
	}
	
	public String listagemEmprestimos() {
		
		String lista = "";
		
		if (emprestimosFinalizados.isEmpty() && emprestimosEmAberto.isEmpty()) {
			
			lista += "Este usuário não possui empréstimos cadastrados" + fimDeLinha;
			
		}
		else {
			
			if (!emprestimosFinalizados.isEmpty()) {
		
				Iterator iterator = emprestimosFinalizados.iterator();
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

				Iterator iterator = emprestimosEmAberto.iterator();
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
	
	public String devolucao(int codigoMaterial) {
		
		Emprestimo emprestimo = getEmprestimoPeloCodigoMaterial(codigoMaterial);
		
		if(emprestimo != null) {
			
			emprestimosEmAberto.remove(emprestimo);
			
			emprestimo.setDataDevolucao(new Date(System.currentTimeMillis()));
			
			emprestimo.devolverExemplar();
			
			emprestimosFinalizados.add(emprestimo);
			
			return "Devolução efetuada com sucesso. " + fimDeLinha + 
					"Usuário: " + getNome() + fimDeLinha + 
					"Material devolvido: " + emprestimo.getTituloMaterial() + fimDeLinha;
					
		}
		
		return null;
		
	}
	
	public boolean estaDevedor() {
		Iterator iterator = emprestimosEmAberto.iterator();
		Emprestimo cada;
		
		while( iterator.hasNext() ) {
			
			cada = (Emprestimo) iterator.next();
			if(cada.getDataDevolucaoPrevista().before(new Date(System.currentTimeMillis()))) {
				return true;
			}
		}
		
		return false;
	}
	
	public String realizaEmprestimo(Material m) {
		
		if(!m.possuiExemplaresParaEmprestimo()) {
			return "Não foi possível realizar o empréstimo. " + m.getTitulo() + ": Não há exemplares disponíveis."
																				+ fimDeLinha;
		}
		
		return regra.realizaEmprestimo(m, this);
	}

	public boolean possuiReserva( Material m) {
		
		Iterator iterator = reservas.iterator();
		Reserva cada;
		
		while( iterator.hasNext() ) {
			
			cada = (Reserva) iterator.next();
			if(cada.comparaMaterial(m)) {
				return true;
			}
		}
		
		return false;
	}
}
