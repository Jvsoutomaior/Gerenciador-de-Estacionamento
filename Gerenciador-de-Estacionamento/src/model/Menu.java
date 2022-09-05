package model;
import java.text.ParseException;
import java.time.LocalTime;

import helper.EstacionamentoHelper;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;

public class Menu {

	public static Estacionamento est;

	public static void main(String[] args) throws ParseException {
		DateTimeFormatter dataCompleta = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		DateTimeFormatter horario = DateTimeFormatter.ofPattern("HH:mm");
		int option = 0;
		String menu = "";
		//Estacionamento
		
		menu += "1) Adicionar Estacionamento\n";
		menu += "2) Editar Estacionamento\n";
		menu += "3) pesquisar Estacionamento\n";
		menu += "4) Excluir Estacionamento\n";
		//Evento (so pode existir se exixtir um estacionamento)
		menu += "5) Adicionar Evento\n";
		menu += "6) Editar Evento\n";
		menu += "7) Pesquisar Evento\n";
		menu += "8) Excluir Evento\n";
		//Acesso (so pode ser acessado se existir um estacionamento)
		menu += "9) Adicionar Acesso\n";
		menu += "10) Editar Acesso\n";
		menu += "11) Pesquisar Acesso\n";
		menu += "12) Excluir Acesso\n";
		menu += "13) Encerrar Programa\n";

		
		while(option != 13) {
			String strOption = JOptionPane.showInputDialog(menu);
            option = Integer.parseInt(strOption);
			
			switch(option){
				case 1: {
					JOptionPane.showMessageDialog(null,"----Cadastro de Estacionamento----");
					String nomeEst = JOptionPane.showInputDialog("nome do estacionamento:");
					
					String ocupacaoMax1 = JOptionPane.showInputDialog("Ocupação Maxima:");
					int ocupacaoMax = Integer.parseInt(ocupacaoMax1);
					int vagasDisp = ocupacaoMax;
					
					boolean vinteQuatro = true;
					String aberturaEst1 = "00:00";
					LocalTime aberturaEst = LocalTime.parse(aberturaEst1, horario);
					//Date aberturaEst = formatotempoSimples.parse(aberturaEst1);
					String fechamentoEst1 = "00:00";
					LocalTime fechamentoEst = LocalTime.parse(fechamentoEst1, horario);
					//Date fechamentoEst = formatotempoSimples.parse(fechamentoEst1);
					
					
					String vinte4 = JOptionPane.showInputDialog("Funciona 24h? sim : nao");
					if(vinte4 == "nao") {
						vinteQuatro = false;
						aberturaEst1 = JOptionPane.showInputDialog("Horario de Abertura:\n No formato hh:mm");
						aberturaEst = LocalTime.parse(aberturaEst1, horario);
						//aberturaEst = formatotempoSimples.parse(aberturaEst1);
						
						fechamentoEst1 = JOptionPane.showInputDialog("Horario de Fechamento:\n No formato hh:mm");
						fechamentoEst = LocalTime.parse(fechamentoEst1, horario);
						//fechamentoEst = formatotempoSimples.parse(fechamentoEst1);
						
						
					} else {
						vinteQuatro = true;
					}
					
					// Horario de Inicio do Noturno:
					String inicioNoturno1 = JOptionPane.showInputDialog("Inicio do Horario Noturno\n (00:00 - 23:59) No formato hh:mm");
					LocalTime inicioNoturno = LocalTime.parse(inicioNoturno1, horario);
					//Date inicioNoturno = formatotempoSimples.parse(inicioNoturno1);
					
					//Horario de fim do Noturno:
					String fimNoturno1 = JOptionPane.showInputDialog("Final do Horario Noturno\n (00:00 - 23:59) No formato hh:mm");
					LocalTime fimNoturno = LocalTime.parse(fimNoturno1, horario);
					//Date fimNoturno = formatotempoSimples.parse(fimNoturno1);
					
					//Desconto da Seguradora
					String descontoSeguro1 = JOptionPane.showInputDialog("Desconto da seguradora:"); 
					int descontoSeguro = Integer.parseInt(descontoSeguro1);
					
					//Desconto da Hora
					String descontoHora1 = JOptionPane.showInputDialog("Desconto(em %) ao completar 1h:"); 
					int descontoHora = Integer.parseInt(descontoHora1);
					
					//comiss�o
					String comissaoEst1 = JOptionPane.showInputDialog("comissao(em %) do Estacionamento (tipo float(Exemplo: 20.0) )"); 
					float comissaoEst = Float.parseFloat(comissaoEst1);
					
					// pre�o da Fra��o
					String precoFraq1 = JOptionPane.showInputDialog("Pre�o da fra��o(15%) da Hora: (tipo float(Exemplo: 20.0))"); 
					float precoFraq = Float.parseFloat(precoFraq1);
					
					//pre�o da Diaria Diurna
					String precoDiaria1 = JOptionPane.showInputDialog("Pre�o da Diaria diurna: (tipo float(Exemplo: 20.0))"); 
					float precoDiaria = Float.parseFloat(precoDiaria1);
					
					//pre�o da Diaria noturna
					String precoNoturna1 = JOptionPane.showInputDialog("Porcentagem da Diaria noturna: (tipo float(Exemplo: 20.0))"); 
					float precoNoturno = Float.parseFloat(precoNoturna1);
					
					//pre�o da Diaria noturna
					String precoMensalidade1 = JOptionPane.showInputDialog("Pre�o da Mensalidade: (tipo float(Exemplo: 20.0))"); 
					float precoMensalidade = Float.parseFloat(precoMensalidade1);
					
					EstacionamentoHelper.CadastrarEstacionamento(nomeEst, ocupacaoMax, vagasDisp, vinteQuatro, aberturaEst, fechamentoEst, inicioNoturno, fimNoturno, descontoSeguro, descontoHora, comissaoEst, precoFraq, precoDiaria, precoNoturno, precoMensalidade);
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					
					String est = JOptionPane.showInputDialog("Nome do Estacionamento:");
					EstacionamentoHelper.buscarEst(est);
					
					break;
				}
				case 4: {
					
					String delEst = JOptionPane.showInputDialog("---Apagar Estacionamento---\nNome do Estacionamento que voce deseja apagar:");
					Estacionamento delest = EstacionamentoHelper.buscarEst(delEst);	
					EstacionamentoHelper.getEstLista().remove(delest);
					
					break;
				}
				case 5: {
					
					break;
				}
				case 6: {
					
					break;
				}
				case 7: {
					
					break;
				}
				case 8: {
					
					break;
				}
				case 9: {
					//Acesso
					//placa, entrada, saida, seguro, valortotal
					JOptionPane.showMessageDialog(null,"Acesso");
					String ests = JOptionPane.showInputDialog("A qual estacionamento esse Acesso está vinculado?");
					est = EstacionamentoHelper.buscarEst(ests);

					String optionA = JOptionPane.showInputDialog("Qual o tipo de Acesso:\n1)Acesso Padrão\n2)Acesso por evento\n3)Acesso Mensalista");
					//1) padrão
					String placa = JOptionPane.showInputDialog("Qual a placa do carro:");

					String entrada1A = JOptionPane.showInputDialog("Hoario de Entrada\n (00:00 - 23:59) No formato hh:mm");
					LocalTime entradaA = LocalTime.parse(entrada1A, horario);

					String saida1A = JOptionPane.showInputDialog("Hoario de Entrada\n (00:00 - 23:59) No formato hh:mm");
					LocalTime saidaA = LocalTime.parse(saida1A, horario);

					


					//2) por evento
					//3) mensalista

					
					
					break;
				}
				case 10: {
					
					break;
				}
				case 11: {
					
					break;
				}
				case 12: {
					
					break;
				}
				case 13: {
					JOptionPane.showMessageDialog(null, "Encerrando...");
					break;
				}
				default: 
                    JOptionPane.showMessageDialog(null, "Entrada invalida!\n");
			}
			
		}

	}

}
