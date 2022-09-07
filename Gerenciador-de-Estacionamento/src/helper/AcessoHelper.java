package helper;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import model.Acesso;
import model.Padrao;
import model.Menu;
import java.lang.Math;
import javax.swing.JOptionPane;

public class AcessoHelper {

	private static ArrayList<Acesso> acessoLista;
	
	public static void CadastrarAcessoPadrao() {
		
		String placa = JOptionPane.showInputDialog("Qual a placa do carro:");

		String temSeguro = JOptionPane.showInputDialog("Veiculo tem seguro? sim : nao");
		if(temSeguro == "nao"){
			
		}

		String entradaStr = JOptionPane.showInputDialog("Data de Entrada (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime entrada1 = LocalDateTime.parse(entradaStr, Menu.getDataCompleta());

		String saidaStr = JOptionPane.showInputDialog("data de saida (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime saida1 = LocalDateTime.parse(saidaStr, Menu.getDataCompleta());


		
		LocalTime entrada = entrada1.toLocalTime();
		LocalTime saida = saida1.toLocalTime();
		

		Duration noveHoras = Duration.ofHours(9);
		//calcular tempo de permanencia

		//se for somente diurna
		if(entrada.isAfter(Menu.est.getFimNoturno()) && saida.isBefore(Menu.est.getInicioNoturno())){
			Duration duracao = Duration.between(entrada, saida);

			//menor que nove horas:
			if(duracao.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new Padrao(placa, entrada1, saida1);
				int totalDeFracoes = Math.round(duracao.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = (totalDeFracoes / 4);
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto);
				}
			}else{
				Acesso acessoDiurno = new Padrao(placa, entrada1, saida1);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria());
			}
		}

		//se for somente Noturno
		else if(entrada.isAfter(Menu.est.getInicioNoturno()) && saida.isBefore(Menu.est.getFimNoturno()) ){
			Acesso acessoNoturno = new Padrao(placa, entrada1, saida1);
			acessoNoturno.setValorTotal(Menu.est.getPrecoNoturno() * Menu.est.getPrecoDiaria());
		}

		//diurna + noturna
		else if(entrada.isBefore(Menu.est.getInicioNoturno()) && saida.isAfter(Menu.est.getInicioNoturno()) && saida.isBefore(Menu.est.getFimNoturno())){
			Duration permanenciaAntesNoturno = Duration.between(entrada, Menu.est.getInicioNoturno());
			//menor que nove horas:
			if(permanenciaAntesNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new Padrao(placa, entrada1, saida1);
				int totalDeFracoes = Math.round(permanenciaAntesNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.est.getPrecoNoturno());
				}
			}else{
				Acesso acessoDiurno = new Padrao(placa, entrada1, saida1);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.est.getPrecoNoturno());
			}
		}
		//noturna + diurna
		else if(entrada.isAfter(Menu.est.getInicioNoturno()) && saida.isAfter(Menu.est.getFimNoturno())){
			Duration permanenciaDepoisNoturno = Duration.between(Menu.est.getFimNoturno(), saida);
			//menor que nove horas:
			if(permanenciaDepoisNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new Padrao(placa, entrada1, saida1);
				int totalDeFracoes = Math.round(permanenciaDepoisNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.est.getPrecoNoturno());
				}
			}else{
				Acesso acessoDiurno = new Padrao(placa, entrada1, saida1);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.est.getPrecoNoturno());
			}
		}
	}

	public static void CadastrarAcessoEvento() {
		
		String placa = JOptionPane.showInputDialog("Qual a placa do carro:");

		String entradaStr = JOptionPane.showInputDialog("Data de Entrada (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime entrada = LocalDateTime.parse(entradaStr, Menu.getDataCompleta());

		String saidaStr = JOptionPane.showInputDialog("data de saida (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime saida = LocalDateTime.parse(saidaStr, Menu.getDataCompleta());
		
		Duration noveHoras = Duration.ofHours(9);
		//calcular tempo de permanencia

		//se for somente Evento
		if(entrada.isAfter(Menu.evt.getDataEvento()) && saida.isBefore(Menu.evt.getFimEvento()) ){
			Acesso acessoNoturno = new Padrao(placa, entrada, saida);
			acessoNoturno.setValorTotal(Menu.est.getPrecoNoturno() * Menu.est.getPrecoDiaria());
		}

		//diurna + evento
		else if(entrada.isBefore(Menu.evt.getDataEvento()) && saida.isAfter(Menu.evt.getDataEvento()) && saida.isBefore(Menu.evt.getFimEvento())){
			Duration permanenciaAntesNoturno = Duration.between(entrada, Menu.est.getInicioNoturno());
			//menor que nove horas:
			if(permanenciaAntesNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new Padrao(placa, entrada, saida);
				int totalDeFracoes = Math.round(permanenciaAntesNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.evt.getValor());
				}
			}else{
				Acesso acessoDiurno = new Padrao(placa, entrada, saida);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.evt.getValor());
			}
		}
		//evento + diurna
		else if(entrada.isAfter(Menu.evt.getDataEvento()) && saida.isAfter(Menu.evt.getFimEvento())){
			Duration permanenciaDepoisNoturno = Duration.between(Menu.est.getFimNoturno(), saida);
			//menor que nove horas:
			if(permanenciaDepoisNoturno.compareTo(noveHoras) < 0){
				Acesso acessoFracao = new Padrao(placa, entrada, saida);
				int totalDeFracoes = Math.round(permanenciaDepoisNoturno.toMinutes() / 15 );
				acessoFracao.setValorTotal( Menu.est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (Menu.est.getPrecoFrac() * 4) * (Menu.est.getDescontoHora() / 100);
					acessoFracao.setValorTotal((Menu.est.getPrecoFrac() * totalDeFracoes) - desconto + Menu.evt.getValor());
				}
			}else{
				Acesso acessoDiurno = new Padrao(placa, entrada, saida);
				acessoDiurno.setValorTotal(Menu.est.getPrecoDiaria() + Menu.evt.getValor());
			}
		}
	}

	public static void editarAcesso() {

		Acesso acesso = buscarAcesso(JOptionPane.showInputDialog("Placa do carro:"));

        String editAcesso = ""
		+	"O que deseja editar:\n"
		+	"1)Placa"
		+   "2)Horario de entrada\n"
		+	"3)Horario de saida\n";

        int option = Integer.parseInt(JOptionPane.showInputDialog(editAcesso));
		while(option < 1 || option > 3){
			option = Integer.parseInt(JOptionPane.showInputDialog("Entrada invalida!\n" + editAcesso));
		}
        switch(option){
			case 1:
			acesso.setPlaca(JOptionPane.showInputDialog("Nova Placa"));
				break;
            case 2:
                acesso.setEntrada(LocalDateTime.parse(JOptionPane.showInputDialog("Novo horario entrada:\n(no formato: dd/MM/yyyy HH:mm)"), Menu.getDataCompleta()));
                break;
            case 3:
                acesso.setSaida(LocalDateTime.parse(JOptionPane.showInputDialog("Novo horario saida:\n(no formato: dd/MM/yyyy HH:mm)"), Menu.getDataCompleta()));
                break;
            default:
                JOptionPane.showMessageDialog(null, "Entrada invalida!\n");
                option = Integer.parseInt(JOptionPane.showInputDialog(editAcesso));    
        }

    }
	
	public static Acesso buscarAcesso (String placa) {
		Acesso resposta = null; 
		
		for (Acesso a: acessoLista) {
			if (a.getPlaca().equalsIgnoreCase(placa))
				resposta = a;
		}
		
		return resposta;
	}

	public static ArrayList<Acesso> getAcessoLista() {
		return acessoLista;
	}

	public static void setAcessoLista(ArrayList<Acesso> acessoLista) {
		acessoLista = acessoLista;
	}
}
