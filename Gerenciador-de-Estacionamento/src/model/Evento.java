package model;
import java.time.LocalDateTime;

public class Evento {
	
	private String nome;
	private float valor;
	private LocalDateTime dataEvento;
	private LocalDateTime fimEvento;
	private Estacionamento estacionamento;
	
	public Evento(String nome, float valor, LocalDateTime dataEvento, LocalDateTime fimEvento, Estacionamento estacionamento) {
		this.nome = nome;
		this.valor = valor;
		this.dataEvento = dataEvento;
		this.fimEvento = fimEvento;
		this.estacionamento = estacionamento;
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
	public LocalDateTime getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDateTime dataEvento) {
		this.dataEvento = dataEvento;
	}
	public LocalDateTime getFimEvento() {
		return fimEvento;
	}
	public void setFimEvento(LocalDateTime fimEvento) {
		this.fimEvento = fimEvento;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}
	
}
