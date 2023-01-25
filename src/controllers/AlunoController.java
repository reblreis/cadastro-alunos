package controllers;

import java.util.List;
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

	// método para executar o fluxo de atualização de um cliente no banco de dados

	public void atualizarAluno() {
		try {
			System.out.println("\nATUALIZAÇÃO DE ALUNOS:\n");
			Scanner scanner = new Scanner(System.in);
			System.out.print("INFORME O ID DO ALUNO....: ");
			Integer idAluno = Integer.parseInt(scanner.nextLine());

			// consultando o aluno no banco de dados através do idAluno.
			AlunoRepository alunoRepository = new AlunoRepository();

			Aluno aluno = alunoRepository.findById(idAluno);

			// verificando se o aluno foi encontrado no banco de dados
			if (aluno != null) {

				System.out.print("ALTERE O NOME......: ");

				aluno.setNome(scanner.nextLine());

				System.out.print("ALTERE A MATRICULA.....: ");

				aluno.setMatricula(scanner.nextLine());

				System.out.print("ALTERE O CPF.....: ");

				aluno.setCpf(scanner.nextLine());

				// atualizando o aluno no banco de dados alunoRepository.update(aluno);

				System.out.println("\nALUNO ATUALIZADO COM SUCESSO.");
			} else {
				System.out.println("\nALUNO NÃO ENCONTRADO.");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO ATUALIZAR O ALUNO.");
			e.printStackTrace();
		}
	}

	// método para executar o fluxo de exclusão de um ALUNO no banco de dados

	public void excluirAluno() {
		try {
			System.out.println("\nEXCLUSÃO DE ALUNOS:\n");

			Scanner scanner = new Scanner(System.in);
			System.out.print("INFORME O ID DO ALUNO....: ");
			Integer idAluno = Integer.parseInt(scanner.nextLine());

			// consultando o cliente no banco de dados através do id..

			AlunoRepository alunoRepository = new AlunoRepository();
			Aluno aluno = alunoRepository.findById(idAluno);

			// verificando se o aluno foi encontrado

			if (aluno != null) {
				// excluindo o aluno

				alunoRepository.delete(aluno);

				System.out.println("\nALUNO EXCLUÍDO COM SUCESSO.");
			} else {
				System.out.println("\nALUNO NÃO ENCONTRADO.");
			}

		} catch (Exception e) {
			System.out.println("\nFALHA AO EXCLUIR O ALUNO.");
			e.printStackTrace();
		}
	}

	// método para executar o fluxo de consulta de alunos no banco de dados
	public void consultarAlunos() {
		try {
			System.out.println("\nCONSULTA DE ALUNOS:\n");
			AlunoRepository alunoRepository = new AlunoRepository();
			List<Aluno> lista = alunoRepository.findAll();

			for (Aluno aluno : lista) {
				System.out.println("ID DO ALUNO...: " + aluno.getIdAluno());
				System.out.println("NOME............: " + aluno.getNome());
				System.out.println("MATRICULA...........: " + aluno.getMatricula());
				System.out.println("CPF...........: " + aluno.getCpf());
				System.out.println("...");
			}
		} catch (Exception e) {
			System.out.println("\nFALHA AO CONSULTAR ALUNOS.");
			e.printStackTrace();
		}
	}
}
