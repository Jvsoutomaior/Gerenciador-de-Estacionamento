package model;

public class Menu {

	public static void main(String[] args) {
		int x = 10;
		while(x != 0) {
			//cadastro , atualização, pesquisa, remoção
			//Estacionamento, Evento, Acesso
			
			//Estacionamento
			System.out.println("1: Adicionar Estacionamento");
			System.out.println("2: Editar Estacionamento");
			System.out.println("3: pesquisar Estacionamento");
			System.out.println("4: Excluir Estacionamento");
			
			
			//Evento (so pode existir se exixtir um estacionamento)
			System.out.println("5: Adicionar Evento");
			System.out.println("6: Editar Evento");
			System.out.println("7: pesquisar Evento");
			System.out.println("8: Excluir Evento");
			
			//Acesso (so pode ser acessado se existir um estacionamento)
			System.out.println("9: Adicionar Acesso");
			System.out.println("10: Editar Acesso");
			System.out.println("11: pesquisar Acesso");
			System.out.println("12: Excluir Acesso");
			
			System.out.print("0: Encerrar Programa");
			
			
			
			
		}

	}

}
