package model;
import java.time.LocalDateTime;

public abstract class Acesso {

	protected String placa;
	protected LocalDateTime entrada;
	protected LocalDateTime saida;
	protected boolean seguro;
	protected float valorTotal;
	
	public Acesso( String placa , LocalDateTime entrada , LocalDateTime saida ) {
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
	}
	

	public float setValorTotal(LocalDateTime entrada, LocalDateTime saida, boolean seguro) {
		return valorTotal;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public LocalDateTime getEntrada() {
		return entrada;
	}
	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}
	public LocalDateTime getSaida() {
		return saida;
	}
	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	public boolean isSeguro() {
		return seguro;
	}
	public void setSeguro(boolean seguro) {
		this.seguro = seguro;
	}
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}
