package model;
import java.util.*;

public abstract class Acesso {
	
	protected String placa;
	protected Date entrada;
	protected Date saida;
	protected boolean seguro;
	protected float valorTotal;
	

	public Acesso( String placa , Date entrada , Date saida ) {
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
	}
	

	public void atualizaNumVagas() {
		//A fazer
	}
	public float setValorTotal(Date entrada, Date saida, boolean seguro) {
		// A Fazer
		return valorTotal;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
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
