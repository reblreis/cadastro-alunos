package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	private Connection connection;

	// método para gravar um aluno no banco de dados. VOID NÃO RETORNA NADA! CREATE
	// NÃO VAI LER NADA!

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

	// método para atualizar os dados de um aluno no banco de dados. VOID NÃO
	// RETORNA NADA! UPDATE NÃO VAI LER NADA!

	public void update(Aluno aluno) throws Exception {
		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para atualizar o aluno
		PreparedStatement preparedStatement = connection
				.prepareStatement("update aluno set nome=?, matricula=?, cpf=?, where idaluno=?");

		// passando os parametros do comando SQL
		preparedStatement.setString(1, aluno.getNome());
		preparedStatement.setString(2, aluno.getMatricula());
		preparedStatement.setString(3, aluno.getCpf());
		preparedStatement.setInt(4, aluno.getIdAluno());

		// executar o comando SQL e fechar a conexão com o banco de dados
		preparedStatement.execute();
		connection.close();

	}

	// método para excluir um aluno no banco de dados. VOID NÃO RETORNA NADA! DELETE
	// NÃO VAI LER NADA!

	public void delete(Aluno aluno) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco de dados para excluir o cliente
		PreparedStatement preparedStatement = connection.prepareStatement("delete from aluno where idaluno=?");

		// passando os parametros do comando SQL
		preparedStatement.setInt(1, aluno.getIdAluno());

		// executar o comando SQL e fechar a conexão com o banco de dados
		preparedStatement.execute();
		connection.close();

	}

	// método para retornar todos os alunos cadastrados no banco de dados.
	// TRABALHA COM MUITOS = LISTA DE ALUNOS

	public List<Aluno> findAll() throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// executando um comando SQL no banco
		// de dados para consultar os clientes
		PreparedStatement preparedStatement = connection.prepareStatement("select * from aluno");

		// ler e armazenar os registros obtidos do banco de dados
		ResultSet resultSet = preparedStatement.executeQuery();

		// declarando uma lista de clientes vazia
		List<Aluno> lista = new ArrayList<Aluno>();

		// percorrendo cada registro obtido do banco de dados
		while (resultSet.next()) {

			Aluno aluno = new Aluno();

			aluno.setIdAluno(resultSet.getInt("idaluno"));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));

			lista.add(aluno); // adicionar o cliente na lista
		}

		// fechando a conexão com o banco de dados
		connection.close();

		// retornando a lista
		return lista;

		// return null; NULL = PROVISÓRIO
	}

	// método para retornar 1 aluno cadastrados no banco de dados através do ID
	public Aluno findById(Integer idAluno) throws Exception {

		// abrindo conexão com o banco de dados
		Connection connection = ConnectionFactory.createConnection();

		// de dados para consultar 1 aluno através do ID
		PreparedStatement preparedStatement = connection.prepareStatement("select * from aluno where idaluno=?");
		preparedStatement.setInt(1, idAluno);

		// ler e armazenar os registros obtidos do banco de dados
		ResultSet resultSet = preparedStatement.executeQuery();

		// criando um objeto Aluno vazio
		Aluno aluno = null;

		// verificando se algum aluno foi encontrado no banco de dados
		if (resultSet.next()) {
			aluno = new Aluno();

			aluno.setIdAluno(resultSet.getInt("idaluno"));
			aluno.setNome(resultSet.getString("nome"));
			aluno.setMatricula(resultSet.getString("matricula"));
			aluno.setCpf(resultSet.getString("cpf"));
		}

		// fechando a conexão com o banco de dados
		connection.close();

		// retornando o aluno
		return aluno;
	}

}