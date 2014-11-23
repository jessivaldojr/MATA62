
public class StatusRegraEmprestimo {

	private boolean status;
	private String mensagem;
	
	public StatusRegraEmprestimo(boolean status, String mensagem) {
		this.status = status;
	}
	
	public boolean isStatus() {
		return status;
	}
	public String getMensagem() {
		return mensagem;
	}

}
