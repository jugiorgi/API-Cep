package br.com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import br.com.ViaCep.Bean.CepBean;
import br.com.ViaCep.Controller.CepController;
import br.com.ViaCep.Model.Conexao;

public class Insert {
	
	public boolean inserirCep(String cep) {
		CepController cepController = new CepController();
		Conexao consultaCep = new Conexao();
		CepBean bean = new CepBean(); 
		boolean isInserido = false;
		
		
		try {
			bean = cepController.trataCep(consultaCep.consultaCep(cep));
			String connectionUrl = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=CEP;user=teste;password=123456;";
			Connection con = DriverManager.getConnection(connectionUrl);
			String SQL = "INSERT INTO dbo.CEP ([CEP], [LOGRADOURO], [COMPLEMENTO], [BAIRRO], [LOCALIDADE], [UF], [UNIDADE], [IBGE], [GIA]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, bean.getCep());
			ps.setString(2, bean.getLogradouro());
			ps.setString(3, bean.getComplemento());
			ps.setString(4, bean.getBairro());
			ps.setString(5, bean.getLocalidade());
			ps.setString(6, bean.getUf());
			ps.setString(7, bean.getUnidade());
			ps.setString(8, bean.getIbge());
			ps.setString(9, bean.getGia());
			ps.executeUpdate(); 
			
			isInserido = true;
			
		} catch (Exception e) {
			isInserido = false;
			e.printStackTrace();
		}
		
		return isInserido;
	}

}
