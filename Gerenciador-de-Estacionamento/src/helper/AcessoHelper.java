package helper;
import java.util.ArrayList;
import java.time.LocalDateTime;
import model.Acesso;
import model.Estacionamento;
import model.Menu;

public class AcessoHelper {

	private static ArrayList<Acesso> AcessoLista;
	
	public static void CadastrarAcesso(String placa , LocalDateTime entrada , LocalDateTime saida) {
		

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
		if(entrada < Menu.est.getInicioNoturno() )
		
	}

}
