import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

public abstract class Material {

	private final String fimDeLinha = System.getProperty("line.separator");
	
	private int codigo;
	
	private String titulo;
	
	private int ano;
	
	private int numeroDeReservas;

	private Collection<Reserva> reservas = new Vector<Reserva>();
	
	private Collection<Exemplar> exemplares = new Vector<Exemplar>();
	
	public Material(int codigo, String titulo, int ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
		this.numeroDeReservas = 0;
	}

	public void novaReserva(Date data, Usuario u ) {
		reservas.add(new Reserva(data,u,this));
		numeroDeReservas++;
	}

	public void removerReserva(Reserva r) {
			reservas.remove(r);
			numeroDeReservas--;
	}
	
	public void addExemplar(int codigo){
		exemplares.add(new Exemplar(codigo, this));
	}
	
	public boolean possuiExemplaresSemReserva() {
		return (numeroDeReservas < exemplares.size());
	}
	
	public boolean possuiExemplaresParaEmprestimo() {
		
		Iterator<Exemplar> iterator = exemplares.iterator();
		
		while(iterator.hasNext()){
			
			Exemplar cada = (Exemplar) iterator.next();
			
			if(cada.getStatus()) {
				return true;		
			}
		}
		
		return false;
	}
	
	public Exemplar getExemplarPeloCodigo(int codigo) {
		
		Iterator<Exemplar> iterator = exemplares.iterator();
		
		while(iterator.hasNext()){
			
			Exemplar cada = (Exemplar) iterator.next();
			
			if(cada.getCodigo() == codigo) {
				return cada;
				
			}
		}
		
		return null;
	}
	
	public String listagemReservas() {
		
		String lista = "";
		
		if (numeroDeReservas>0) {
			
			Iterator<Reserva> iterator = reservas.iterator();
			Reserva cada;
			
			while( iterator.hasNext() ) {
				
				cada = (Reserva) iterator.next();
				lista += cada.getNomeUsuario() + ". Data da Reserva: "+ cada.getData().toString() + "." + fimDeLinha;
				
			}
			
		}
		else {
			lista += "Não existem reservas cadastradas para este Material" + fimDeLinha;
		}		
		
		return lista;		
	}
	
	public String listagemExemplares() {

		String lista = "";
		
		Iterator<Exemplar> iterator = exemplares.iterator();
		Exemplar cada;
		
		while( iterator.hasNext() ) {
			
			cada = (Exemplar) iterator.next();
			lista += "Código de exemplar: " + cada.getCodigo() + fimDeLinha;
			lista += cada.getStatus() + fimDeLinha;
			if(!cada.getStatus()) {
				lista += "Usuario: " + cada.getNomeUsuario() + fimDeLinha;
				lista += "Data do Emprestimo: " + cada.getDataEmprestimo() + fimDeLinha;
				lista += "Data de Devolução Prevista: " + cada.getDataDevolucaoPrevista() + fimDeLinha;
			}
			
		}
		
		return lista;
	}
	
	public Exemplar getExemplarDisponivel() {
		
		Iterator<Exemplar> iterator = exemplares.iterator();
		Exemplar cada;
		
		while( iterator.hasNext() ) {
			
			cada = (Exemplar) iterator.next();
			if(cada.getStatus()) {
				return cada;
			}
			
		}
		
		return null;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public abstract String getTipo();
}
