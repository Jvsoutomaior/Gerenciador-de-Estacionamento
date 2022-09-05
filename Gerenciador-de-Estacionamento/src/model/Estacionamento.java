package model;
//import java.util.LocalTime;
import java.time.LocalTime;

public class Estacionamento {
    String nome;
    int ocupacaoMax;
    int vagasDisp;
    boolean vinteQuatro;
    LocalTime aberturaEst;
    LocalTime fechamentoEst;
    LocalTime inicioNoturno;
    LocalTime fimNoturno;
    int descontoSeguro;
    int descontoHora;
    float comissaoEst;
    float precoFrac;
    float precoDiaria; 
    float precoNoturno; // Em porcentagem da diaria diurna
    float precoMensalidade;

    public Estacionamento (String nome, int ocupacaoMax, int vagasDisp, boolean vinteQuatro, LocalTime aberturaEst, LocalTime fechamentoEst, 
                                LocalTime inicioNoturno, LocalTime fimNoturno, int descontoSeguro, int descontoHora, float comissaoEst,
                                float precoFraq, float precoDiaria, float precoNoturno, float precoMensalidade){
        this.nome = nome;
        this.ocupacaoMax = ocupacaoMax;
        this.vagasDisp = vagasDisp;
        this.vinteQuatro = vinteQuatro;
        this.aberturaEst = aberturaEst;
        this.fechamentoEst = fechamentoEst;
        this.inicioNoturno = inicioNoturno;
        this.fimNoturno = fimNoturno;
        this.descontoSeguro = descontoSeguro;
        this.descontoHora = descontoHora;
        this.comissaoEst = comissaoEst;
        this.precoFrac = precoFraq;
        this.precoDiaria = precoDiaria;
        this.precoNoturno = precoNoturno;
        this.precoMensalidade = precoMensalidade;
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getOcupacaoMax() {
		return ocupacaoMax;
	}

	public void setOcupacaoMax(int ocupacaoMax) {
		this.ocupacaoMax = ocupacaoMax;
	}

	public int getVagasDisp() {
		return vagasDisp;
	}

	public void setVagasDisp(int vagasDisp) {
		this.vagasDisp = vagasDisp;
	}

	public boolean isVinteQuatro() {
		return vinteQuatro;
	}

	public void setVinteQuatro(boolean vinteQuatro) {
		this.vinteQuatro = vinteQuatro;
	}

	public LocalTime getAberturaEst() {
		return aberturaEst;
	}

	public void setAberturaEst(LocalTime aberturaEst) {
		this.aberturaEst = aberturaEst;
	}

	public LocalTime getFechamentoEst() {
		return fechamentoEst;
	}

	public void setFechamentoEst(LocalTime fechamentoEst) {
		this.fechamentoEst = fechamentoEst;
	}

	public LocalTime getInicioNoturno() {
		return inicioNoturno;
	}

	public void setInicioNoturno(LocalTime inicioNoturno) {
		this.inicioNoturno = inicioNoturno;
	}

	public LocalTime getFimNoturno() {
		return fimNoturno;
	}

	public void setFimNoturno(LocalTime fimNoturno) {
		this.fimNoturno = fimNoturno;
	}

	public int getDescontoSeguro() {
		return descontoSeguro;
	}

	public void setDescontoSeguro(int descontoSeguro) {
		this.descontoSeguro = descontoSeguro;
	}

	public int getDescontoHora() {
		return descontoHora;
	}

	public void setDescontoHora(int descontoHora) {
		this.descontoHora = descontoHora;
	}

	public float getComissaoEst() {
		return comissaoEst;
	}

	public void setComissaoEst(float comissaoEst) {
		this.comissaoEst = comissaoEst;
	}

	public float getPrecoFrac() {
		return precoFrac;
	}

	public void setPrecoFrac(float precoFrac) {
		this.precoFrac = precoFrac;
	}

	public float getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(float precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public float getPrecoNoturno() {
		return precoNoturno;
	}

	public void setPrecoNoturno(float precoNoturno) {
		this.precoNoturno = precoNoturno;
	}

	public float getPrecoMensalidadea() {
		return precoMensalidade;
	}

	public void setPrecoMensalidade(float precoMensalidade) {
		this.precoMensalidade = precoMensalidade;
	}
  
}