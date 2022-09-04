package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import helper.EstacionamentoHelper;

import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatotempoSimples = new SimpleDateFormat("kk:ss");
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
					//String nome, int ocupacaoMax, int vagasDisp, boolean vinteQuatro, Date aberturEst, Date fechamentoEst, 
		           // Date inicioNoturno, Date fimNoturno, int descontoSeguro, int descontoHora, float comissaoEst,
		           // float precoFraq, float precoDiaria, float precoNoturno, float precoMensalista
					JOptionPane.showMessageDialog(null,"----Cadastro de Estacionamento----");
					String nomeEst = JOptionPane.showInputDialog("nome do estacionamento:");
					
					String ocupacaoMax1 = JOptionPane.showInputDialog("Ocupação Maxima:");
					int ocupacaoMax = Integer.parseInt(ocupacaoMax1);
					int vagasDisp = ocupacaoMax;
					
					boolean vinteQuatro = true;
					String aberturaEst1 = "00:00"; 
					Date aberturaEst = formatotempoSimples.parse(aberturaEst1);
					String fechamentoEst1 = "00:00";
					Date fechamentoEst = formatotempoSimples.parse(fechamentoEst1);
					
					String vinte4 = JOptionPane.showInputDialog("Funciona 24h? sim : não");
					if(vinte4 == "não") {
						vinteQuatro = false;
						aberturaEst1 = JOptionPane.showInputDialog("Horario de Abertura:\n No formato hh:mm"); 
						aberturaEst = formatotempoSimples.parse(aberturaEst1);
						
						fechamentoEst1 = JOptionPane.showInputDialog("Horario de Fechamento:\n No formato hh:mm"); 
						fechamentoEst = formatotempoSimples.parse(fechamentoEst1);
						
						
					} else {
						vinteQuatro = true;
					}
					
					// Horario de Inicio do Noturno:
					String inicioNoturno1 = JOptionPane.showInputDialog("Inicio do Horario Noturno\n (00:00 - 23:59) No formato hh:mm"); 
					Date inicioNoturno = formatotempoSimples.parse(inicioNoturno1);
					
					//Horario de fim do Noturno:
					String fimNoturno1 = JOptionPane.showInputDialog("Final do Horario Noturno\n (00:00 - 23:59) No formato hh:mm"); 
					Date fimNoturno = formatotempoSimples.parse(fimNoturno1);
					
					//Desconto da Seguradora
					String descontoSeguro1 = JOptionPane.showInputDialog("Desconto da seguradora:"); 
					int descontoSeguro = Integer.parseInt(descontoSeguro1);
					
					//Desconto da Hora
					String descontoHora1 = JOptionPane.showInputDialog("Desconto(em %) ao completar 1h:"); 
					int descontoHora = Integer.parseInt(descontoHora1);
					
					//comissão
					String comissaoEst1 = JOptionPane.showInputDialog("comissao(em %) do Estacionamento (tipo float(Exemplo: 20.0) )"); 
					float comissaoEst = Float.parseFloat(comissaoEst1);
					
					// preço da Fração
					String precoFraq1 = JOptionPane.showInputDialog("Preço da fração(15%) da Hora: (tipo float(Exemplo: 20.0))"); 
					float precoFraq = Float.parseFloat(precoFraq1);
					
					//preço da Diaria Diurna
					String precoDiaria1 = JOptionPane.showInputDialog("Preço da Diaria diurna: (tipo float(Exemplo: 20.0))"); 
					float precoDiaria = Float.parseFloat(precoDiaria1);
					
					//preço da Diaria noturna
					String precoNoturna1 = JOptionPane.showInputDialog("Preço da Diaria noturna: (tipo float(Exemplo: 20.0))"); 
					float precoNoturno = Float.parseFloat(precoNoturna1);
					
					//preço da Diaria noturna
					String precoMensalidade1 = JOptionPane.showInputDialog("Preço da Mensalidade: (tipo float(Exemplo: 20.0))"); 
					float precoMensalidade = Float.parseFloat(precoMensalidade1);
					
					EstacionamentoHelper.CadastrarEstacionamento(nomeEst, ocupacaoMax, vagasDisp, vinteQuatro, aberturaEst, fechamentoEst, inicioNoturno, fimNoturno, descontoSeguro, descontoHora, comissaoEst, precoFraq, precoDiaria, precoNoturno, precoMensalidade);
					break;
				}
				case 2: {
					
					break;
				}
				case 3: {
					
					break;
				}
				case 4: {
					
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
