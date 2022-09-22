package model;

public class Aluno {
	
	String nomeCompleto;
	String curso;
	int matricula;
	String email;

	public Aluno(String nomeCompleto, String curso, int matricula, String email){
		this.nomeCompleto = nomeCompleto;
		this.curso = curso;
		this.matricula = matricula;
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		String imprimi = 
		"Nome: "+ this.nomeCompleto +"\n"+
        "Curso: "+ this.curso +"\n"+
        "Matricula: " + Integer.toString(this.matricula) +"\n"+
        "Email: "+ this.email +"";
		return imprimi;
	}
	
	

}
