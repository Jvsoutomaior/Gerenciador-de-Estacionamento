package helper;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDateTime;

import model.Estacionamento;
import model.Evento;
import javax.swing.JOptionPane;
import model.Menu;

public class EventoHelper{
	
	private static ArrayList<Evento> eventoLista;
	
	public static void CadastrarEvento() {
        String nomeEvento = JOptionPane.showInputDialog("---Cadastro de Evento---\nNome do Evento:");
        String valorEvento1 = JOptionPane.showInputDialog("Valor:");
        float valorEvento = Float.parseFloat(valorEvento1);
        String inicioEvento1 = JOptionPane.showInputDialog("Inicio do Evento: no formato dd/MM/yyyy HH:mm");
        LocalDateTime inicioEvento = LocalDateTime.parse(inicioEvento1, Menu.getDataCompleta() );
        String fimEvento1 = JOptionPane.showInputDialog("Fim do Evento: no formato dd/MM/yyyy HH:mm");
        LocalDateTime fimEvento = LocalDateTime.parse(fimEvento1, Menu.getDataCompleta() );
        String estEvt1 = JOptionPane.showInputDialog("Estacionamento Vinculado(nome do Estacionamento):");
        Estacionamento estEvt = EstacionamentoHelper.buscarEst(estEvt1);
		
		Evento evento = new Evento(nomeEvento, valorEvento, inicioEvento, fimEvento, estEvt);
        eventoLista = new ArrayList<Evento>();
		eventoLista.add(evento);
	}

    public static void editarEvento() {

		Evento evento = buscarevento(JOptionPane.showInputDialog("Nome do Estacionamento"));

        String editEvt = ""
		+	"O que deseja editar:\n"
		+   "1)Nome do Evento\n"
		+	"2)Valor\n"
		+	"3)inicio do Evento\n"
		+	"4)Fim do Evento\n";

        int option = Integer.parseInt(JOptionPane.showInputDialog(editEvt));
        while(option < 1 || option > 4){
			option = Integer.parseInt(JOptionPane.showInputDialog("Entrada invalida!\n" + editEvt));
		}
        switch(option){
            case 1:
                evento.setNome(JOptionPane.showInputDialog("Novo nome:"));
                break;
            case 2:
                evento.setValor(Integer.parseInt(JOptionPane.showInputDialog("Novo Valor:")));
                break;
            case 3:
                evento.setDataEvento(LocalDateTime.parse(JOptionPane.showInputDialog("Novo horario de inicio do evento:\n(no formato: dd/MM/yyyy HH:mm)"), Menu.getDataCompleta()));
                break;
            case 4:
                evento.setFimEvento(LocalDateTime.parse(JOptionPane.showInputDialog("Novo horario de termino do evento:\n (no formato: dd/MM/yyyy HH:mm)"), Menu.getDataCompleta()));
                break;
        }

    }
	
	public static Evento buscarevento (String nome) {
		Evento resposta = null; 
		
		for (Evento e: eventoLista) {
			if (e.getNome().equalsIgnoreCase(nome))
				resposta = e;
		}
		
		return resposta;
	}

    public static void delEvt() {
		String delEvt = JOptionPane.showInputDialog("---Apagar Evento---\nNome do Evento que voce deseja apagar:");
		Evento delevt = EventoHelper.buscarevento(delEvt);	
		eventoLista.remove(delevt);
	}

	public static ArrayList<Evento> getEventoLista() {
		return eventoLista;
	}

	public static void setEventoLista(ArrayList<Evento> eventoLista) {
		eventoLista = eventoLista;
	}
	
}
