package principal;

import java.util.Scanner;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("(1) - CADASTRAR ALUNO");
		System.out.println("(2) - ATUALIZAR ALUNO");
		System.out.println("(3) - EXCLUIR ALUNO");
		System.out.println("(4) - CONSULTAR ALUNO");
		System.out.print("\nENTRE COM A OPÇÃO DESEJADA: ");
		Integer opcao = Integer.parseInt(scanner.nextLine());

		AlunoController alunoController = new AlunoController();
		alunoController.cadastrarAluno();

		switch (opcao) {
		case 1:
			alunoController.cadastrarAluno();
			break;

		case 2:
			alunoController.atualizarAluno();
			break;

		case 3:
			alunoController.excluirAluno();
			break;

		case 4:
			alunoController.consultarAlunos();
			break;

		default:
			System.out.println("\nOPÇÃO INVÁLIDA.");
			break;
		}

	}
}
