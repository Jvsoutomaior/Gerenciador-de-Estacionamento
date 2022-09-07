package model;
import java.time.LocalDateTime;

public class AcessoEvento extends Acesso{

    private Evento evento;

    public AcessoEvento(String placa , LocalDateTime entrada , LocalDateTime saida, Evento evento){
        super(placa, entrada, saida);
        this.evento = evento;
    }
    
}
