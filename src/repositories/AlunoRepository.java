package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	private Connection connection;

	// método para gravar um aluno no banco de dados. VOID NÃO RETORNA NADA! CREATE NÃO VAI LER NADA!

	public void create(Aluno aluno) throws Exception {

		// abrindo conexão com o banco de dados

		Connection connection = ConnectionFactory.createConnection();
	
	// executando um comando SQL no banco de dados para cadastrar o cliente

	PreparedStatement preparedStatement = connection
			.prepareStatement("insert into aluno(nome, matricula, cpf) values (?, ?, ?)");

	// passando os parametros do comando SQL
		preparedStatement.setString(1, aluno.getNome());
		preparedStatement.setString(2, aluno.getMatricula());
		preparedStatement.setString(3, aluno.getCpf());

	// executar o comando SQL e fechar a conexão com o banco de dados
		preparedStatement.execute();
		connection.close();
	}
	
	// método para atualizar os dados de um cliente no banco de dados. VOID NÃO
	// RETORNA NADA! UPDATE NÃO VAI LER NADA!

	public void update(Aluno aluno) throws Exception {
		// TODO
	}

	// método para excluir um cliente no banco de dados. VOID NÃO RETORNA NADA!
	// DELETE NÃO VAI LER NADA!

	public void delete(Aluno aluno) throws Exception {
		// TODO
	}

	// método para retornar todos os clientes cadastrados no banco de dados.
	// TRABALHA COM MUITOS = LISTA DE ALUNOS

	public List<Aluno> findAll() throws Exception {
		// TODO
		return null; // NULL = PROVISÓRIO
	}
}