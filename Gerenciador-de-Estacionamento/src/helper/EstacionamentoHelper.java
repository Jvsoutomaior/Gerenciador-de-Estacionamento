package helper;
import java.util.ArrayList;
import java.time.LocalTime;
import model.Estacionamento;

public class EstacionamentoHelper{
	
	private static ArrayList<Estacionamento> EstLista;
	
	public static void CadastrarEstacionamento(String nome, int ocupacaoMax, int vagasDisp, boolean vinteQuatro, LocalTime aberturaEst, LocalTime fechamentoEst, 
            LocalTime inicioNoturno, LocalTime fimNoturno, int descontoSeguro, int descontoHora, float comissaoEst,
            float precoFraq, float precoDiaria, float precoNoturno, float precoMensalidade) {
		
		Estacionamento est = new Estacionamento(nome, ocupacaoMax, vagasDisp, vinteQuatro, aberturaEst, fechamentoEst, inicioNoturno, fimNoturno, descontoSeguro, descontoHora, comissaoEst, precoFraq, precoDiaria, precoNoturno, precoMensalidade);
		EstLista.add(est);
	}
	
	public static Estacionamento buscarEst (String nome) {
		Estacionamento resposta = null; 
		
		for (Estacionamento e: EstLista) {
			if (e.getNome().equalsIgnoreCase(nome))
				resposta = e;
		}
		
		return resposta;
	}

	public static ArrayList<Estacionamento> getEstLista() {
		return EstLista;
	}

	public static void setEstLista(ArrayList<Estacionamento> estLista) {
		EstLista = estLista;
	}
	
}
