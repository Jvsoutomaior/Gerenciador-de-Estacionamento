package model;
import java.util.Date;

public class Estacionamento {
    int idEst;
    int ocupacaoMax;
    int vagasDisp;
    boolean vinteQuatro;
    Date aberturaEst;
    Date fechamentoEst;
    Date inicioNoturno;
    Date fimNoturno;
    int descontoSeguro;
    int descontoHora;
    float comissaoEst;
    float precoFrac;
    float precoDiaria; 
    float precoNoturno;
    float precoMensalista;

    public void estacionamento (int idEst, int ocupacaoMax, int vagasDisp, boolean vinteQuatro, Date aberturEst, Date fechamentoEst, 
                                Date inicioNoturno, Date fimNoturno, int descontoSeguro, int descontoHora, float comissaoEst,
                                float precoFraq, float precoDiaria, float precoNoturno, float precoMensalista){
        this.idEst = idEst;
        this.ocupacaoMax = ocupacaoMax;
        this.vagasDisp = vagasDisp;
        this.vinteQuatro = vinteQuatro;
        this.aberturaEst = aberturEst;
        this.fechamentoEst = fechamentoEst;
        this.inicioNoturno = inicioNoturno;
        this.fimNoturno = fimNoturno;
        this.descontoSeguro = descontoSeguro;
        this.descontoHora = descontoHora;
        this.comissaoEst = comissaoEst;
        this.precoFrac = precoFraq;
        this.precoDiaria = precoDiaria;
        this.precoNoturno = precoNoturno;
        this.precoMensalista = precoMensalista;
    }

	public int getIdEst() {
		return idEst;
	}

	public void setIdEst(int idEst) {
		this.idEst = idEst;
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

	public Date getAberturaEst() {
		return aberturaEst;
	}

	public void setAberturaEst(Date aberturaEst) {
		this.aberturaEst = aberturaEst;
	}

	public Date getFechamentoEst() {
		return fechamentoEst;
	}

	public void setFechamentoEst(Date fechamentoEst) {
		this.fechamentoEst = fechamentoEst;
	}

	public Date getInicioNoturno() {
		return inicioNoturno;
	}

	public void setInicioNoturno(Date inicioNoturno) {
		this.inicioNoturno = inicioNoturno;
	}

	public Date getFimNoturno() {
		return fimNoturno;
	}

	public void setFimNoturno(Date fimNoturno) {
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

	public float getPrecoMensalista() {
		return precoMensalista;
	}

	public void setPrecoMensalista(float precoMensalista) {
		this.precoMensalista = precoMensalista;
	}
  
}