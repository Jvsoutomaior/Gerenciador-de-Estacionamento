package model;
import java.time.LocalDateTime;

public class AcessoEvento extends Acesso{

    private Evento evento;

    public AcessoEvento(String placa , LocalDateTime entrada , LocalDateTime saida,Estacionamento estacionamento, Evento evento){
        super(placa, entrada, saida, estacionamento);
        this.evento = evento;
    }
    public AcessoEvento(){
        super();
    }
    
}
