package model;
import java.time.LocalDateTime;
import java.util.Date;

public class Diaria extends Acesso{

	public Diaria(String placa, LocalDateTime entrada, LocalDateTime saida) {
		super(placa, entrada, saida);
	}

}
