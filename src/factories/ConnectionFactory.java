package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// método para criar e retorar conexão com o banco de dados

	public static Connection createConnection() throws Exception {

		// parâmetros para conexão com o banco de dados

		String driver = "org.postgresql.Driver";
		String server = "jdbc:postgresql://localhost:5432/bd_exercicio05"; //jdbc = conexta os projetos com o banco de dados
		String user = "postgres";
		String password = "coti";

		// Carregando o driver JDBC para conexão com o PostGreSQL

		Class.forName(driver);

		// fazendo a conexão com o banco de dados, utilizando o caminho do banco,
		// usuário e senha de administrador

		return DriverManager.getConnection(server, user, password);
	}
}
