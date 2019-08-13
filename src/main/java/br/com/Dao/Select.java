package br.com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select {

	public String coletarInformacoes() {
		String resposta = "";

		try {
			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=CEP;user=teste;password=123456;";

			Connection con = DriverManager.getConnection(connectionUrl);
			Statement stmt = con.createStatement();
			String SQL = "SELECT * FROM dbo.CEP";
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.println("CEP: " + rs.getString("CEP"));
				System.out.println("LOGRADOURO: " + rs.getString("LOGRADOURO"));
				System.out.println("COMPLEMENTO: " + rs.getString("COMPLEMENTO"));
				System.out.println("BAIRRO: " + rs.getString("BAIRRO"));
				System.out.println("LOCALIDADE: " + rs.getString("LOCALIDADE"));
				System.out.println("UF: " + rs.getString("UF"));
				System.out.println("=============================================");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resposta;
	}
}
