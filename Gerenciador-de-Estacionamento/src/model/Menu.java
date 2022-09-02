package model;
import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
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

}package model;
import javax.swing.JOptionPane;

public class Menu {

	public static void main(String[] args) {
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
