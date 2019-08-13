package br.com.ViaCep;

import br.com.Dao.Select;

public class App {
	public static void main(String[] args) {

		Select conexao = new Select();
		System.out.println(conexao.coletarInformacoes());
	}
}
