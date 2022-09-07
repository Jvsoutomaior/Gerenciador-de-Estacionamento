package model;
import java.time.LocalDateTime;

public class Padrao extends Acesso{

	public Padrao(String placa, LocalDateTime entrada, LocalDateTime saida, Estacionamento estacionamento) {
		super(placa, entrada, saida, estacionamento);
	}
	public Padrao(){
		super();
	}

}
