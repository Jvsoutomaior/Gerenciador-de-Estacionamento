package helper;
import java.util.ArrayList;
import java.time.LocalTime;
import model.Estacionamento;
import model.Menu;

import javax.swing.JOptionPane;

public class EstacionamentoHelper{
	
	private static ArrayList<Estacionamento> estLista;

	public static void CadastrarEstacionamento(){
				JOptionPane.showMessageDialog(null,"----Cadastro de Estacionamento----");
				String nomeEst = JOptionPane.showInputDialog("nome do estacionamento:");
				
				String ocupacaoMax1 = JOptionPane.showInputDialog("Ocupacao Maxima:");
				int ocupacaoMax = Integer.parseInt(ocupacaoMax1);
				int vagasDisp = ocupacaoMax;
				
				boolean vinteQuatro = true;
				String aberturaEst1 = "00:00";
				LocalTime aberturaEst = LocalTime.parse(aberturaEst1, Menu.getHorario());
				String fechamentoEst1 = "00:00";
				LocalTime fechamentoEst = LocalTime.parse(fechamentoEst1, Menu.getHorario());
				
				
				String vinte4 = JOptionPane.showInputDialog("Funciona 24h? sim : nao");
				if(vinte4 == "nao") {
					vinteQuatro = false;
					aberturaEst1 = JOptionPane.showInputDialog("Horario de Abertura:\n No formato hh:mm");
					aberturaEst = LocalTime.parse(aberturaEst1, Menu.getHorario());
					
					fechamentoEst1 = JOptionPane.showInputDialog("Horario de Fechamento:\n No formato hh:mm");
					fechamentoEst = LocalTime.parse(fechamentoEst1, Menu.getHorario());
					//fechamentoEst = formatotempoSimples.parse(fechamentoEst1);
					
					
				} else {
					vinteQuatro = true;
				}
				
				// Horario de Inicio do Noturno:
				String inicioNoturno1 = JOptionPane.showInputDialog("Inicio do Horario Noturno\n (00:00 - 23:59) No formato hh:mm");
				LocalTime inicioNoturno = LocalTime.parse(inicioNoturno1, Menu.getHorario());
				//Date inicioNoturno = formatotempoSimples.parse(inicioNoturno1);
				
				//Horario de fim do Noturno:
				String fimNoturno1 = JOptionPane.showInputDialog("Final do Horario Noturno\n (00:00 - 23:59) No formato hh:mm");
				LocalTime fimNoturno = LocalTime.parse(fimNoturno1, Menu.getHorario());
				//Date fimNoturno = formatotempoSimples.parse(fimNoturno1);
				
				//Desconto da Seguradora
				String descontoSeguro1 = JOptionPane.showInputDialog("Desconto(em %) da seguradora:"); 
				int descontoSeguro = Integer.parseInt(descontoSeguro1);
				
				//Desconto da Hora
				String descontoHora1 = JOptionPane.showInputDialog("Desconto(em %) ao completar 1h:"); 
				int descontoHora = Integer.parseInt(descontoHora1);
				
				//comiss�o
				String comissaoEst1 = JOptionPane.showInputDialog("comissao(em %) do Estacionamento (tipo float(Exemplo: 20.0) )"); 
				float comissaoEst = Float.parseFloat(comissaoEst1);
				
				// pre�o da Fra��o
				String precoFraq1 = JOptionPane.showInputDialog("Preco da fracao da Hora (15 min): (tipo float(Exemplo: 20.0))"); 
				float precoFraq = Float.parseFloat(precoFraq1);
				
				//pre�o da Diaria Diurna
				String precoDiaria1 = JOptionPane.showInputDialog("Preco da Diaria diurna: (tipo float(Exemplo: 20.0))"); 
				float precoDiaria = Float.parseFloat(precoDiaria1);
				
				//pre�o da Diaria noturna
				String precoNoturna1 = JOptionPane.showInputDialog("Porcentagem da Diaria noturna: (tipo float(Exemplo: 20.0))"); 
				float precoNoturno = Float.parseFloat(precoNoturna1);
				
				//pre�o da Diaria noturna
				String precoMensalidade1 = JOptionPane.showInputDialog("Preco da Mensalidade: (tipo float(Exemplo: 20.0))"); 
				float precoMensalidade = Float.parseFloat(precoMensalidade1);
		estLista = new ArrayList<Estacionamento>();
		
		Estacionamento est = new Estacionamento(nomeEst, ocupacaoMax, vagasDisp, vinteQuatro, aberturaEst, fechamentoEst, inicioNoturno, fimNoturno, descontoSeguro, descontoHora, comissaoEst, precoFraq, precoDiaria, precoNoturno, precoMensalidade);
		estLista.add(est);
	}

	public static void editarEst(){
		String nomeEst = JOptionPane.showInputDialog("Nome do Estacionamento");
		Estacionamento estEdit = buscarEst(nomeEst);

		String menuEstacionamento = ""
		+	"O que deseja editar:\n"
		+   "1) Nome do estacionamento\n"
		+	"2) Ocupacao Maxima\n"
		+	"3) Horario de funcionamento\n"
		+	"4) Horario noturno\n"
		+	"5) Desconto do seguro\n"
		+	"6) Desconto da Hora\n"
		+	"7) Comissao do estacionamento\n"
		+	"8) Preco da Fracao\n"
		+	"9) Preco da Diaria\n"
		+	"10) Preco do Noturno\n"
		+	"11) Preco da Mensalidade\n";
        int optionEstacionamento = Integer.parseInt(JOptionPane.showInputDialog(menuEstacionamento));
		while(optionEstacionamento < 1 || optionEstacionamento > 11){
			optionEstacionamento = Integer.parseInt(JOptionPane.showInputDialog("Entrada invalida!\n" + menuEstacionamento));
		}
		switch(optionEstacionamento){
			case 1:
				String novoNome = JOptionPane.showInputDialog("Novo Nome:");
				estEdit.setNome(novoNome);
			
				break;
			case 2:
				String strNovaOcupacaoMax = JOptionPane.showInputDialog("Nova ocupacao maxima:");
				int novaOcupacaoMax = Integer.parseInt(strNovaOcupacaoMax);
				estEdit.setOcupacaoMax(novaOcupacaoMax);

				break;
			case 3:
				estEdit.setAberturaEst(LocalTime.parse(JOptionPane.showInputDialog("Novo horario abertura\n(00:00 - 23:59) No formato hh:mm:"), Menu.getHorario()));
				estEdit.setFechamentoEst(LocalTime.parse(JOptionPane.showInputDialog("Novo horario fechamento\n(00:00 - 23:59) No formato hh:mm:"), Menu.getHorario()));

				break;
			case 4:
				estEdit.setInicioNoturno(LocalTime.parse(JOptionPane.showInputDialog("Novo horario comeco noturno\n(00:00 - 23:59) No formato hh:mm:"), Menu.getHorario()));
				estEdit.setFimNoturno(LocalTime.parse(JOptionPane.showInputDialog("Novo horario fim noturno\n(00:00 - 23:59) No formato hh:mm:"), Menu.getHorario()));

				break;
			case 5:
				String strNovoDescontoSeguro = JOptionPane.showInputDialog("Novo desconto seguro:");
				int novoDescontoSeguro = Integer.parseInt(strNovoDescontoSeguro);
				estEdit.setDescontoSeguro(novoDescontoSeguro);

				break;
			case 6:
				String strNovoDescontoHora = JOptionPane.showInputDialog("Novo valor desconto hora:");
				int novoDescontoHora = Integer.parseInt(strNovoDescontoHora);
				estEdit.setDescontoHora(novoDescontoHora);

				break;
			case 7:
				String strNovaComissao = JOptionPane.showInputDialog("Nova comissao:");
				float novaComissao = Float.parseFloat(strNovaComissao);
				estEdit.setComissaoEst(novaComissao);

				break;
			case 8:
				String strNovoPrecoFracao = JOptionPane.showInputDialog("Novo preco fracao:");
				float novoPrecoFracao = Float.parseFloat(strNovoPrecoFracao);
				estEdit.setPrecoFrac(novoPrecoFracao);

				break;
			case 9:
				String strNovoPrecoDiaria = JOptionPane.showInputDialog("Novo preco diaria:");
				float novoPrecoDiaria = Float.parseFloat(strNovoPrecoDiaria);
				estEdit.setPrecoDiaria(novoPrecoDiaria);

				break;
			case 10:
				String strNovoPrecoNoturno = JOptionPane.showInputDialog("Novo preco noturno:");
				float novoPrecoNoturno = Float.parseFloat(strNovoPrecoNoturno);
				estEdit.setPrecoNoturno(novoPrecoNoturno);

				break;
			case 11:
				String strNovoPrecoMensalidade = JOptionPane.showInputDialog("Novo preco mensalidade:");
				float novoPrecoMensalidade = Float.parseFloat(strNovoPrecoMensalidade);
				estEdit.setPrecoMensalidade(novoPrecoMensalidade);

				break;
		}
	}

	public static void delEst() {
		String delEst = JOptionPane.showInputDialog("---Apagar Estacionamento---\nNome do Estacionamento que voce deseja apagar:");
		Estacionamento delest = EstacionamentoHelper.buscarEst(delEst);	
		estLista.remove(delest);
	}

	public static Estacionamento buscarEst (String nome) {
		Estacionamento resposta = null; 
		
		for (Estacionamento e: estLista) {
			if (e.getNome().equalsIgnoreCase(nome))
				resposta = e;
		}
		
		return resposta;
	}



	public static ArrayList<Estacionamento> getEstLista() {
		return estLista;
	}

	public static void setEstLista(ArrayList<Estacionamento> estLista) {
		estLista = estLista;
	}
	
}
