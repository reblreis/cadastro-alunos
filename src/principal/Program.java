package principal;

import controllers.AlunoController;

public class Program {

	public static void main(String[] args) {

		AlunoController alunoController = new AlunoController();
		alunoController.cadastrarAluno();
	}
}
