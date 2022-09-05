package model;

import java.time.LocalDateTime;

public class Noturno extends Acesso{
	
	public Noturno(String placa, LocalDateTime entrada, LocalDateTime saida) {
		super(placa, entrada, saida);
	}
	
}