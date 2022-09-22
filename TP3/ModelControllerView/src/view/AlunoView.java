package view;
import controller.AlunoControl;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;

public class AlunoView {
	
	public static void main(String[] args) {
	
	JFrame frame = new JFrame();
	
	JLabel novoAluno = new JLabel("Cadastrar Aluno");
	novoAluno.setBounds(160, 10, 200, 50);
	novoAluno.setFont(new Font("Tahoma", Font.BOLD , 20));
	
    JLabel labelNome = new JLabel("Nome:");  
    labelNome.setBounds(40, 100, 100, 40);
	labelNome.setFont(new Font("Comic Sans MS", Font.PLAIN , 20));
	
	JTextField textfieldNome = new JTextField();
	textfieldNome.setColumns(10);
	textfieldNome.setBounds(140, 120, 286, 20);
	
    JLabel labelCurso = new JLabel("Curso:");
    labelCurso.setBounds(40, 150, 100, 40);
    labelCurso.setFont(new Font("Comic Sans MS", Font.PLAIN , 20));
    
	JTextField textfieldCurso = new JTextField();
	textfieldCurso.setColumns(10);
	textfieldCurso.setBounds(140, 164, 286, 20);
	
    JLabel labelMatricula = new JLabel("Matricula:");
    labelMatricula.setBounds(40, 200, 150, 40);
    labelMatricula.setFont(new Font("Comic Sans MS", Font.PLAIN , 20));
    
	JTextField textfieldMat = new JTextField();
	textfieldMat.setColumns(10);
	textfieldMat.setBounds(140, 212, 286, 20);
	
    JLabel labelEmail = new JLabel("Email:");
    labelEmail.setBounds(40, 250, 100, 40);
    labelEmail.setFont(new Font("Comic Sans MS", Font.PLAIN , 20));
    
	JTextField textfieldEmail = new JTextField();
	textfieldEmail.setColumns(10);
	textfieldEmail.setBounds(140, 256, 286, 20);
    
	JButton butao = new JButton("Cadastrar");
	butao.setBounds(190, 400, 90, 30);
	
	JButton butao2 = new JButton("Mostrar Aluno");
	butao2.setBounds(300, 400, 120, 30);
	
	butao.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String nome = textfieldNome.getText();
			String curso = textfieldCurso.getText();
			int matricula = Integer.parseInt(textfieldMat.getText());
			String email = textfieldEmail.getText();
			
			AlunoControl.AlunoControll(nome, curso, matricula, email);
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
		}
	});
	
	butao2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, AlunoControl.alunoStr );
		}
	});
	       
	
	frame.add(labelNome);
	frame.add(labelCurso);
	frame.add(novoAluno);
	frame.add(labelMatricula);
	frame.add(labelEmail);
	frame.add(textfieldNome);
	frame.add(textfieldCurso);
	frame.add(textfieldMat);
	frame.add(textfieldEmail);
	frame.add(butao);
	frame.add(butao2);
	
	
	frame.setSize(500,500);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
		
	}
	

}
