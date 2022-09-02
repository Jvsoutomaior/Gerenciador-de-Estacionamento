package model;
import java.util.Date;

public class Evento {
	
	private String nome;
	private float valor;
	private Date dataEvento;
	private Date fimEvento;
	
	public Evento(String nome, float valor, Date dataEvento, Date fimEvento) {
		this.nome = nome;
		this.valor = valor;
		this.dataEvento = dataEvento;
		this.fimEvento = fimEvento;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Date getFimEvento() {
		return fimEvento;
	}
	public void setFimEvento(Date fimEvento) {
		this.fimEvento = fimEvento;
	}
	
}
