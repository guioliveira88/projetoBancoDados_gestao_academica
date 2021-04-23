package br.com.tabelaprojeto.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectionFactory {

	//nome do usuario mysql
	private static final String USERNAME = "root";
   // Senha do banco
	private static final String PASSWORD = "";
	//C	AMINHO DO BANCO DE DADOS,PORTA
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/tabelasprojeto";
	
	/*
	 * Conex�o com o banco de dados
	 */
	public static Connection createConnectiontoMySQL() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Cria conex�o com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//recuperar a conex�o com o banco de dados
		Connection con = createConnectiontoMySQL();
		// Testar se  a conex�o � nula
		if (con != null) {
			System.err.println("Conex�o obtida com sucesso!");
			con.close();
		}
	}
}
