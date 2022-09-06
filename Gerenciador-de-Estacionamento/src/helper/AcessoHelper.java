package helper;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.Duration;
import model.Acesso;
import model.Diaria;
import model.Noturno;
import model.Estacionamento;
import model.FracaoPadrao;
import model.Menu;
import java.lang.Math;

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
				int totalDeFracoes = Math.round(duracao.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = (totalDeFracoes / 4);
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto);
				}
			}else{
				Acesso acessoDiurno = new Diaria(placa, entrada, saida);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria());
			}
		}

		//se for somente Noturno
		else if(entrada.isAfter(Menu.est.getInicioNoturno()) && saida.isBefore(Menu.est.getFimNoturno()) ){
			Acesso acessoNoturno = new Noturno(placa, entrada, saida);
			acessoNoturno.setValorTotal(Menu.est.getPrecoNoturno() * Menu.est.getPrecoDiaria());
		}

		//diurna + noturna
		else if(entrada.isBefore(Menu.est.getInicioNoturno()) && saida.isAfter(Menu.est.getInicioNoturno()) && saida.isBefore(Menu.est.getFimNoturno())){
			Duration permanenciaAntesNoturno = Duration.between(entrada, Menu.est.getInicioNoturno());
			//menor que nove horas:
			if(permanenciaAntesNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new FracaoPadrao(placa, entrada, saida);
				Acesso acessoNoturno = new Noturno(placa, entrada, saida);
				int totalDeFracoes = Math.round(permanenciaAntesNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.est.getPrecoNoturno());
				}
			}else{
				Acesso acessoDiurno = new Diaria(placa, entrada, saida);
				Acesso acessoNoturno = new Noturno(placa, entrada, saida);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.est.getPrecoNoturno());
			}
		}
		//noturna + diurna
		else if(entrada.isAfter(Menu.est.getInicioNoturno()) && saida.isAfter(Menu.est.getFimNoturno())){
			Duration permanenciaDepoisNoturno = Duration.between(Menu.est.getFimNoturno(), saida);
			//menor que nove horas:
			if(permanenciaDepoisNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new FracaoPadrao(placa, entrada, saida);
				Acesso acessoNoturno = new Noturno(placa, entrada, saida);
				int totalDeFracoes = Math.round(permanenciaDepoisNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.est.getPrecoNoturno());
				}
			}else{
				Acesso acessoDiurno = new Diaria(placa, entrada, saida);
				Acesso acessoNoturno = new Noturno(placa, entrada, saida);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.est.getPrecoNoturno());
			}
		}

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
