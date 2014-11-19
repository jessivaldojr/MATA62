import java.util.Date;

public class Reserva {

	private Date data;

	private Usuario usuario;

	private Material material;

	public Reserva(Date data, Usuario usuario, Material material) {
		this.data = data;
		this.usuario = usuario;
		this.material = material;
		this.usuario.incluirReserva(this);
	}

	public Date getData() {
		return data;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Material getMaterial() {
		return material;
	}	
	
	public int getCodigoMaterial() {
		return material.getCodigo();
	}	
	
	public String getNomeUsuario() {
		return usuario.getNome();
	}
	
}
