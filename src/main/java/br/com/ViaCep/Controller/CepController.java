package br.com.ViaCep.Controller;

import org.json.JSONObject;

import br.com.ViaCep.Bean.CepBean;

public class CepController {
	
	public CepBean trataCep(String info) {
		CepBean bean = new CepBean();
		JSONObject json;
		
		try {
			json = new JSONObject(info);
			bean.setCep(json.getString("cep"));
			bean.setLogradouro(json.getString("logradouro"));
			bean.setComplemento(json.getString("complemento"));
			bean.setBairro(json.getString("bairro"));
			bean.setLocalidade(json.getString("localidade"));
			bean.setUf(json.getString("uf"));
			bean.setUnidade(json.getString("unidade"));
			bean.setIbge(json.getString("ibge"));
			bean.setGia(json.getString("gia"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}

}
