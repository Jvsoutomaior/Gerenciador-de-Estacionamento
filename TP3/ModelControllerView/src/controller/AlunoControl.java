package controller;
import model.Aluno;

public abstract class AlunoControl {
	
	public static String alunoStr = null;
	
	public static void AlunoControll(String nomeCompleto, String curso, int matricula, String email) {
		
		Aluno aluno = new Aluno(nomeCompleto, curso, matricula, email);
		alunoStr = aluno.toString();
	}
	
}