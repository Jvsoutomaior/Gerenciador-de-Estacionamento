package model;
import java.time.LocalDateTime;

public class Mensal extends Acesso{

	public Mensal(String placa,LocalDateTime entrada,LocalDateTime saida, Estacionamento estacionamento) {
		super(placa, entrada, saida, estacionamento);
	}

}
