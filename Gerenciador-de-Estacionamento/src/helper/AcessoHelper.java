package helper;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;
import model.Acesso;
import model.Noturno;
import model.Estacionamento;
import model.FracaoPadrao;
import model.Menu;

public class AcessoHelper {

	private static ArrayList<Acesso> AcessoLista;
	
	public static void CadastrarAcesso(String placa , LocalDateTime entrada , LocalDateTime saida) {
		
		Duration noveHoras = Duration.ofHours(9);
		//calcular tempo de permanencia

		//se for somente diurna
		if(entrada.isAfter(Menu.est.getFimNoturno()) && saida.isBefore(Menu.est.getInicioNoturno())){
			Duration duracao = Duration.between(entrada, saida);

			//menor que nove horas:
			if(duracao.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new FracaoPadrao(placa, entrada, saida);
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * (duracao.toMinutes() / 15 ) );
				if(duracao.toHours() >= 1){

					long dado = ( duracao.toMinutes() / 60 ) * Menu.est.getDescontoHora();

				}
			}

			
		}
		//se for somente Noturno
		else if(entrada.isAfter(Menu.est.getInicioNoturno()) && saida.isBefore(Menu.est.getFimNoturno()) ){
			Acesso acessoNoturno = new Noturno(placa, entrada, saida);
			acessoNoturno.setValorTotal(Menu.est.getPrecoNoturno() * Menu.est.getPrecoDiaria());
		}
		//diurna + noturna
		//se o tempo de permanencia for maior que nove horas e entrar no comeco do noturno

	}
	
	public static Acesso buscarAcesso (String placa) {
		Acesso resposta = null; 
		
		for (Acesso a: AcessoLista) {
			if (a.getPlaca().equalsIgnoreCase(placa))
				resposta = a;
		}
		
		return resposta;
	}

	public static ArrayList<Acesso> getEstLista() {
		return AcessoLista;
	}

	public static void setEstLista(ArrayList<Acesso> acessoLista) {
		AcessoLista = acessoLista;
	}
	
	public void calculateAcessoType(LocalDateTime entrada , LocalDateTime saida){

		
	}

}
