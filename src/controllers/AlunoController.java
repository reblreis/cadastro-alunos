package controllers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	// método para executar o fluxo de cadastro de um cliente no banco de dados

	public void cadastrarAluno() {

		try {

			System.out.println("\nCADASTRO DE ALUNOS: \n");

			Aluno aluno = new Aluno();
			Scanner scanner = new Scanner(System.in);

			System.out.print("NOME DO ALUNO........: ");
			aluno.setNome(scanner.nextLine());

			System.out.print("MATRICULA DO ALUNO...: ");
			aluno.setMatricula(scanner.nextLine());

			System.out.print("CPF DO ALUNO.........: ");
			aluno.setCpf(scanner.nextLine());

			AlunoRepository alunoRepository = new AlunoRepository();
			alunoRepository.create(aluno);

			System.out.println("\nALUNO CADASTRADO COM SUCESSO!");

		}

		catch (Exception e) {
			System.out.println("\nFALHA AO CADASTRAR O CLIENTE");
			e.printStackTrace();
		}
	}
}
