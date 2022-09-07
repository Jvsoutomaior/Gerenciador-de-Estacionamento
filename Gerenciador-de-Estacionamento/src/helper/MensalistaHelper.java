package helper;
import java.util.ArrayList;
import model.Mensalista;
import javax.swing.JOptionPane;
import model.Estacionamento;


public class MensalistaHelper {
    //Criar, buscar, editar, deletar 
    private static ArrayList<Mensalista> mensalistas;

    public static void CadastrarMensalista(){
        String placa = JOptionPane.showInputDialog(null, "Placa do Mensalista:");

        String est = JOptionPane.showInputDialog(null, "Estacionamento Vinculado:");
        Estacionamento estacionamento = EstacionamentoHelper.buscarEst(est);

        Mensalista mensal = new Mensalista(placa, estacionamento);
        mensalistas = new ArrayList<Mensalista>();
		mensalistas.add(mensal);
    }
    public static Mensalista buscarMensalista (String placa) {
		Mensalista resposta = null;
		for (Mensalista a: mensalistas) {
			if (a.getPlaca().equalsIgnoreCase(placa))
				resposta = a;
		}
		return resposta;
	}
	public static void deletarMensalista() {
		String delMensalistaStr = JOptionPane.showInputDialog("---Apagar Mensalista---\nPlaca do Mensalista que voce deseja apagar:");
		Mensalista delMensalista = MensalistaHelper.buscarMensalista(delMensalistaStr);	
		mensalistas.remove(delMensalista);
	}
}
