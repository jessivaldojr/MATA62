import java.util.Collection;
import java.util.Date;
import java.util.Vector;

public class Material {

	private int codigo;
	
	private String titulo;
	
	private int ano;

	private Collection<Reserva> reserva = new Vector<Reserva>();
	
	private Collection<Exemplar> exemplares = new Vector<Exemplar>();
	
	public Material(int codigo, String titulo, int ano) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.ano = ano;
	}

	public void incluirReserva(Date data, Usuario u ) {

		reserva.add(new Reserva(data,u,this));
		
	}

	public void removerReserva(Reserva r) {

			//TODO
		
		
	}
	
	public void addExemplar(short codigo){
		
		exemplares.add(new Exemplar(codigo));
	}

	public int getCodigo() {
		return codigo;
	}
	
	public int getAno() {
		return ano;
	}
	
}
