package model;
import java.time.LocalDateTime;

public class Mensalista {
    
    private String placa;
    private boolean jaPagoMes;
    private Estacionamento estacionamento;

	public Mensalista(String placa, Estacionamento estacionamento) {
        this.placa = placa;
        this.estacionamento = estacionamento;
	}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isJaPagoMes() {
        return jaPagoMes;
    }

    public void setJaPagoMes(boolean jaPagoMes) {
        this.jaPagoMes = jaPagoMes;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }
    
}