package helper;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import model.*;
import java.lang.Math;
import javax.swing.JOptionPane;

public class AcessoHelper {

	private static ArrayList<Acesso> acessoLista;
	
	public static void CadastrarAcessoPadrao() {

		Acesso acessoPadrao = new Padrao();
		acessoLista = new ArrayList<Acesso>();
		acessoLista.add(acessoPadrao);
		
		String placa = JOptionPane.showInputDialog("Qual a placa do carro:");
		acessoPadrao.setPlaca(placa);

		String temSeguro = JOptionPane.showInputDialog("Veiculo tem seguro? sim : nao");
		if(temSeguro == "nao"){
			acessoPadrao.setSeguro(false);
		} else if(temSeguro == "sim"){
			acessoPadrao.setSeguro(true);
		}

		String entradaStr = JOptionPane.showInputDialog("Data de Entrada (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime entrada1 = LocalDateTime.parse(entradaStr, Menu.getDataCompleta());
		acessoPadrao.setEntrada(entrada1);

		String saidaStr = JOptionPane.showInputDialog("data de saida (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime saida1 = LocalDateTime.parse(saidaStr, Menu.getDataCompleta());
		acessoPadrao.setSaida(saida1);

		String estStr = JOptionPane.showInputDialog("Estacionamento vinculado(nome):");
		Estacionamento est = EstacionamentoHelper.buscarEst(estStr);


		LocalTime entrada = entrada1.toLocalTime();
		LocalTime saida = saida1.toLocalTime();
		

		Duration noveHoras = Duration.ofHours(9);
		//calcular tempo de permanencia

		//se for somente diurna
		if(entrada.isAfter(est.getFimNoturno()) && saida.isBefore(est.getInicioNoturno())){
			Duration duracao = Duration.between(entrada, saida);

			//menor que nove horas:
			if(duracao.compareTo(noveHoras) < 0){
				int totalDeFracoes = Math.round(duracao.toMinutes() / 15 );
				acessoPadrao.setValorTotal( est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = (totalDeFracoes / 4);
					float desconto = horaInteira * (est.getPrecoFrac() * 4) * (est.getDescontoHora() / 100);
					acessoPadrao.setValorTotal((est.getPrecoFrac() * totalDeFracoes) - desconto);
				}
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}else{
				acessoPadrao.setValorTotal(est.getPrecoDiaria());
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}
		}

		//se for somente Noturno
		else if(entrada.isAfter(est.getInicioNoturno()) && saida.isBefore(est.getFimNoturno()) ){
			acessoPadrao.setValorTotal(est.getPrecoNoturno() * est.getPrecoDiaria());
			if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
			}
		}

		//diurna + noturna
		else if(entrada.isBefore(est.getInicioNoturno()) && saida.isAfter(est.getInicioNoturno()) && saida.isBefore(est.getFimNoturno())){
			Duration permanenciaAntesNoturno = Duration.between(entrada, est.getInicioNoturno());
			//menor que nove horas:
			if(permanenciaAntesNoturno.compareTo(noveHoras) < 0){
				int totalDeFracoes = Math.round(permanenciaAntesNoturno.toMinutes() / 15 );
				acessoPadrao.setValorTotal( est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (est.getPrecoFrac() * 4) * (est.getDescontoHora() / 100);
					acessoPadrao.setValorTotal((est.getPrecoFrac() * totalDeFracoes) - desconto + est.getPrecoNoturno());
				}
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}else{
				acessoPadrao.setValorTotal(est.getPrecoDiaria() + est.getPrecoNoturno());
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}
		}
		//noturna + diurna
		else if(entrada.isAfter(est.getInicioNoturno()) && saida.isAfter(est.getFimNoturno())){
			Duration permanenciaDepoisNoturno = Duration.between(est.getFimNoturno(), saida);
			//menor que nove horas:
			if(permanenciaDepoisNoturno.compareTo(noveHoras) < 0){
				int totalDeFracoes = Math.round(permanenciaDepoisNoturno.toMinutes() / 15 );
				acessoPadrao.setValorTotal( est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (est.getPrecoFrac() * 4) * (est.getDescontoHora() / 100);
					acessoPadrao.setValorTotal((est.getPrecoFrac() * totalDeFracoes) - desconto + est.getPrecoNoturno());
				}
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}else{
				acessoPadrao.setValorTotal(est.getPrecoDiaria() + est.getPrecoNoturno());
				if(acessoPadrao.isSeguro()){
					acessoPadrao.setValorTotal((est.getDescontoSeguro() / 100) * acessoPadrao.getValorTotal());
				}
			}
		}
		acessoPadrao.setValorComissao(acessoPadrao.getValorTotal() * (est.getComissaoEst() / 100));
		JOptionPane.showMessageDialog(null,"Acesso Padrao\nValor total: R$ " + acessoPadrao.getValorTotal());
	}

	public static void CadastrarAcessoEvento() {
		
		String placa = JOptionPane.showInputDialog("Qual a placa do carro:");

		String entradaStr = JOptionPane.showInputDialog("Data de Entrada (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime entrada = LocalDateTime.parse(entradaStr, Menu.getDataCompleta());

		String saidaStr = JOptionPane.showInputDialog("data de saida (no formato dd/MM/yyyy HH:mm)");
		LocalDateTime saida = LocalDateTime.parse(saidaStr, Menu.getDataCompleta());

		String estStr = JOptionPane.showInputDialog("Estacionamento vinculado(nome):");
		Estacionamento est = EstacionamentoHelper.buscarEst(estStr);

		String eventoStr = JOptionPane.showInputDialog("Nome do Evento:");
		Evento evento = EventoHelper.buscarevento(eventoStr);

		Acesso acessoEvento = new AcessoEvento(placa, entrada, saida, est, evento);
		
		Duration noveHoras = Duration.ofHours(9);
		//calcular tempo de permanencia

		//se for somente Evento
		if(entrada.isAfter(evento.getDataEvento()) && saida.isBefore(evento.getFimEvento()) ){
			acessoEvento.setValorTotal(est.getPrecoNoturno() * est.getPrecoDiaria());
			if(acessoEvento.isSeguro()){
					acessoEvento.setValorTotal((est.getDescontoSeguro() / 100) * acessoEvento.getValorTotal());
			}
		}

		//diurna + evento
		else if(entrada.isBefore(evento.getDataEvento()) && saida.isAfter(evento.getDataEvento()) && saida.isBefore(evento.getFimEvento())){
			Duration permanenciaAntesNoturno = Duration.between(entrada, est.getInicioNoturno());
			//menor que nove horas:
			if(permanenciaAntesNoturno.compareTo(noveHoras) < 0){
				int totalDeFracoes = Math.round(permanenciaAntesNoturno.toMinutes() / 15 );
				acessoEvento.setValorTotal( est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (est.getPrecoFrac() * 4) * (est.getDescontoHora() / 100);
					acessoEvento.setValorTotal((est.getPrecoFrac() * totalDeFracoes) - desconto + evento.getValor());
				}
				if(acessoEvento.isSeguro()){
					acessoEvento.setValorTotal((est.getDescontoSeguro() / 100) * acessoEvento.getValorTotal());
				}
			}else{
				acessoEvento.setValorTotal(est.getPrecoDiaria() + evento.getValor());
				if(acessoEvento.isSeguro()){
					acessoEvento.setValorTotal((est.getDescontoSeguro() / 100) * acessoEvento.getValorTotal());
				}
			}
		}
		//evento + diurna
		else if(entrada.isAfter(evento.getDataEvento()) && saida.isAfter(evento.getFimEvento())){
			Duration permanenciaDepoisNoturno = Duration.between(est.getFimNoturno(), saida);
			//menor que nove horas:
			if(permanenciaDepoisNoturno.compareTo(noveHoras) < 0){
				int totalDeFracoes = Math.round(permanenciaDepoisNoturno.toMinutes() / 15 );
				acessoEvento.setValorTotal( est.getPrecoFrac() * totalDeFracoes );
				if(totalDeFracoes >= 4){
					int horaInteira = totalDeFracoes / 4;
					float desconto = horaInteira * (est.getPrecoFrac() * 4) * (est.getDescontoHora() / 100);
					acessoEvento.setValorTotal((est.getPrecoFrac() * totalDeFracoes) - desconto + evento.getValor());
				}
				if(acessoEvento.isSeguro()){
					acessoEvento.setValorTotal((est.getDescontoSeguro() / 100) * acessoEvento.getValorTotal());
				}
			}else{
				acessoEvento.setValorTotal(est.getPrecoDiaria() + evento.getValor());
				if(acessoEvento.isSeguro()){
					acessoEvento.setValorTotal((est.getDescontoSeguro() / 100) * acessoEvento.getValorTotal());
				}
			}
		}
		acessoEvento.setValorComissao(acessoEvento.getValorTotal() * (est.getComissaoEst() / 100));
		JOptionPane.showMessageDialog(null,"Acesso Evento\nValor total: R$ " + acessoEvento.getValorTotal());
	}

    public static void CadastrarAcessoMensal(){
        String placa = JOptionPane.showInputDialog(null, "Placa:");
        Mensalista mensal = MensalistaHelper.buscarMensalista(placa);
        if (mensal == null){
			//verificamos se o mensalista ja esta cadastrado
            JOptionPane.showMessageDialog(null, "Mensalista não cadastrado, para cadastrar esse tipo de acesso, voce deve primeiro cadastar um mensalista!");
        } else{
            //mensalista existe, agora devemos ver a data atual de entrada e saida:
			String entradaStr = JOptionPane.showInputDialog("Data de Entrada (no formato dd/MM/yyyy HH:mm)");
			LocalDateTime entrada = LocalDateTime.parse(entradaStr, Menu.getDataCompleta());
	
			String saidaStr = JOptionPane.showInputDialog("data de saida (no formato dd/MM/yyyy HH:mm)");
			LocalDateTime saida = LocalDateTime.parse(saidaStr, Menu.getDataCompleta());
			
			Estacionamento est = mensal.getEstacionamento();

			Acesso acessoMensal = new Mensal(placa, entrada, saida, est);
			Acesso entradaAnterior = buscarAcesso(placa);
			
			acessoLista.add(acessoMensal);

			if (entradaAnterior != null){
				LocalDateTime m = entradaAnterior.getEntrada();
				
				if(entrada.getMonthValue() == m.getMonthValue()){
					JOptionPane.showMessageDialog(null, "Ja pago esse mes!");
				} else{
					JOptionPane.showMessageDialog(null, "valor a pagar:" +est.getPrecoMensalidadea());
					acessoMensal.setValorTotal(est.getPrecoMensalidadea());
				}
			} else {
				JOptionPane.showMessageDialog(null, "valor a pagar:" +est.getPrecoMensalidadea());
				acessoMensal.setValorTotal(est.getPrecoMensalidadea());
			}
			acessoMensal.setValorComissao(acessoMensal.getValorTotal() * (est.getComissaoEst() / 100));
        }
    }

	public static void editarAcesso() {

		Acesso acesso = buscarAcesso(JOptionPane.showInputDialog("Placa do carro:"));

        String editAcesso = ""
		+	"O que deseja editar:\n"
		+	"1)Placa";

        int option = Integer.parseInt(JOptionPane.showInputDialog(editAcesso));
		while(option != 1){
			option = Integer.parseInt(JOptionPane.showInputDialog("Entrada invalida!\n" + editAcesso));
		}
        switch(option){
			case 1:
			acesso.setPlaca(JOptionPane.showInputDialog("Nova Placa"));
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

	public static void deletarAcesso() {
		String delAcessoStr = JOptionPane.showInputDialog("---Apagar Acesso---\nPlaca do Acesso que voce deseja apagar:");
		Acesso delAcesso = AcessoHelper.buscarAcesso(delAcessoStr);	
		acessoLista.remove(delAcesso);
	}

	/*public static ArrayList<Acesso> getAcessoLista() {
		return acessoLista;
	}

	public static void setAcessoLista(ArrayList<Acesso> acessoLista) {
		acessoLista = acessoLista;
	}*/
}
