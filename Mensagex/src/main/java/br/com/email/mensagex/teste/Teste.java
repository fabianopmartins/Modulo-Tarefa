package br.com.email.mensagex.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) throws SQLException {
	
		Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensagex?serverTimezone=UTC", "root", "fp305305");
	
		System.out.println("Conectado!");
		conexao.close();
	}
	
}