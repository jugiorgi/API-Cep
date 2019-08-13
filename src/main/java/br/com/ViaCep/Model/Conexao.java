package br.com.ViaCep.Model;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

public class Conexao {
	
	public String consultaCep(String cep) {
		String retorno = "";
		String url = "http://viacep.com.br/ws/"+cep+"/json/";
		try {
			
			HttpClient http = HttpClientBuilder.create().build();
			HttpGet get = new HttpGet(url);
			HttpResponse response = http.execute(get);
			retorno = new BasicResponseHandler().handleResponse(response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
