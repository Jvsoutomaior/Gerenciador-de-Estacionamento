package helper;
import java.util.ArrayList;
import java.util.Date;
import model.Acesso;

public class AcessoHelper {
	
	private static ArrayList<Acesso> acessoLista;
	
	public static void CadastrarAcesso(String placa , Date entrada , Date saida) {
		Acesso acesso = new Acesso(placa, entrada, saida);
		
	}
	
	public void calculateAcessoType(Date entrada , Date saida){
		
		
	}

}
