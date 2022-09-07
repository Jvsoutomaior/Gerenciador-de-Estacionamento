package model;
import java.text.ParseException;
import helper.EventoHelper;
import helper.MensalistaHelper;
import helper.AcessoHelper;
import helper.EstacionamentoHelper;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;

public class Menu {

	public static DateTimeFormatter dataCompleta;
	public static DateTimeFormatter horario;

	public static void main(String[] args) throws ParseException {
		dataCompleta = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		horario = DateTimeFormatter.ofPattern("HH:mm");
		
		int option = 0;
		String menu = ""
		+ "1) Adicionar Estacionamento\n"
		+ "2) Editar Estacionamento\n"
		+ "3) pesquisar Estacionamento\n"
		+ "4) Excluir Estacionamento\n"
		+ "5) Adicionar Evento\n"
		+ "6) Editar Evento\n"
		+ "7) Pesquisar Evento\n"
		+ "8) Excluir Evento\n"
		+ "9) Adicionar Acesso\n"
		+ "10) Editar Acesso\n"
		+ "11) Pesquisar Acesso\n"
		+ "12) Excluir Acesso\n"
		+ "13) Cadastrar Mensalista\n"
		+ "14) Encerrar Programa";

		while(option != 14) {
            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch(option){
				case 1: {
					EstacionamentoHelper.CadastrarEstacionamento();
					break;
				}
				case 2: {
					EstacionamentoHelper.editarEst();
					break;
				}
				case 3: {
					String est = JOptionPane.showInputDialog("Nome do Estacionamento:");
					EstacionamentoHelper.buscarEst(est);
					break;
				}
				case 4: {
					//Deletar Estacionamento
					EstacionamentoHelper.delEst();
					break;
				}
				case 5: {
					//Adicionar Evento
					EventoHelper.CadastrarEvento();
					break;
				}
				case 6: {
					//Editar Evento
					EventoHelper.editarEvento();
					break;
				}
				case 7: {
					//pesquisar Evento
					String buscarEvento = JOptionPane.showInputDialog("Nome do Evento:");
					EventoHelper.buscarevento(buscarEvento);
					break;
				}
				case 8: {
					//Excluir Evento
					EventoHelper.delEvt();
					break;
				}
				case 9: {
					//cadastar Acesso
					JOptionPane.showMessageDialog(null,"Acesso");

					String strOptionA = JOptionPane.showInputDialog("Qual o tipo de Acesso:\n1)Acesso Padrão\n2)Acesso por evento\n3)Acesso Mensalista");
					int optionA = Integer.parseInt(strOptionA);
					while(optionA != 1 && optionA != 2 && optionA != 3){
						strOptionA = JOptionPane.showInputDialog("Entrada invalida!\nQual o tipo de Acesso:\n1)Acesso Padrão\n2)Acesso por evento\n3)Acesso Mensalista");
						optionA = Integer.parseInt(strOptionA);
					}
					
					switch (optionA) {
						case 1:
							AcessoHelper.CadastrarAcessoPadrao();
							break;
						case 2:
							AcessoHelper.CadastrarAcessoEvento();
						case 3:
							AcessoHelper.CadastrarAcessoMensal();
							break;
					}
					
					break;
				}
				case 10: {
					//Editar Acesso
					AcessoHelper.editarAcesso();
					break;
				}
				case 11: {
					//Pesquisa Acesso
					String buscarAcesso = JOptionPane.showInputDialog("Nome do Evento:");
					AcessoHelper.buscarAcesso(buscarAcesso);
					break;
				}
				case 12: {
					//Deletar Acesso
					AcessoHelper.deletarAcesso();
					break;
				}
				case 13: {
					//Cadastrar Mensalista
					MensalistaHelper.CadastrarMensalista();
					break;
				}
				case 14: {
					JOptionPane.showMessageDialog(null, "Encerrando...");
					break;
				}
				default: 
                    JOptionPane.showMessageDialog(null, "Entrada invalida!\n");
			}
			
		}

	}

	public static DateTimeFormatter getHorario() {
		return horario;
	}

	public static DateTimeFormatter getDataCompleta() {
		return dataCompleta;
	}

	
}
