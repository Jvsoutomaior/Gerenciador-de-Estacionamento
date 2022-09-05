package helper;
import java.util.ArrayList;
import java.util.Date;
import model.Acesso;
import model.Estacionamento;

public class AcessoHelper {
	
	private static ArrayList<Acesso> AcessoLista;
	
	public static void CadastrarAcesso(String placa , Date entrada , Date saida) {
		Acesso acesso = new Acesso(placa, entrada, saida);
		AcessoLista.add(acesso);
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
	
	public void calculateAcessoType(Date entrada , Date saida){
		
		
	}

}
