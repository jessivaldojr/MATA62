import java.util.Collection;
import java.util.Date;
import java.util.Vector;

public class Material {

	private int codigo;

	private Collection<Reserva> reserva = new Vector<Reserva>();
	
	public Material(int codigo) {
		this.codigo = codigo;
	}

	public void incluirReserva(Date data, Usuario u ) {

		reserva.add(new Reserva(data,u,this));
		
	}

	public void removerReserva(Reserva r) {

			//TODO
		
		
	}

	public short getCodigo() {
		return codigo;
	}
	
}
