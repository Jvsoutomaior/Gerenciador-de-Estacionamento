package model;
import java.time.LocalDateTime;

public abstract class Acesso {

	protected String placa;
	protected LocalDateTime entrada;
	protected LocalDateTime saida;
	protected boolean seguro;
	protected float valorTotal;
	protected float valorComissao;
	protected Estacionamento estacionamento;
	
	public Acesso( String placa , LocalDateTime entrada , LocalDateTime saida , Estacionamento estacionamento ) {
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
		this.estacionamento = estacionamento;
	}
	public Acesso(){}
	

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
	public float getValorComissao() {
		return valorComissao;
	}
	public void setValorComissao(float valorComissao) {
		this.valorComissao = valorComissao;
	}
	public Estacionamento getEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	

	@Override
	public String toString(){
		String imprimi = 
		"Placa:"+ this.placa +"\n"+
        "Entrada:"+ this.entrada +"\n"+
        "Saida:"+ this.saida +"\n"+
        "Tem seguro?:"+Boolean.toString(this.seguro)+"\n"+
		"Valor Total:"+ Float.toString(this.valorTotal)+"\n"+
		"Estacionamento"+ this.estacionamento.getNome()  +"\n"+
		"Comissao do estacionamento:" + this.valorComissao +"";
		return imprimi;
	}

}
