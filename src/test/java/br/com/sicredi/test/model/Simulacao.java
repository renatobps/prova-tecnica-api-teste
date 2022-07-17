package br.com.sicredi.test.model;


import br.com.sicredi.test.restAssured.RESTMethods;
import br.com.sicredi.test.utils.Utils;
import io.restassured.response.Response;
import org.json.JSONObject;


import java.math.BigInteger;
import java.util.List;

import static br.com.sicredi.test.restAssured.UtilsREST.readJsonSimpleDemo;
import static br.com.sicredi.test.utils.Urls.URL_LOCAL;
import static br.com.sicredi.test.utils.Utils.*;


public class Simulacao {
    Response response;
    JSONObject obj =  readJsonSimpleDemo("src/test/resources/json/simulacao.json");
    public Simulacao() throws Exception {
    }

    public void criarSimulacao(String nome, String cpf, String email, Double valor, int parcelas, Boolean seguro) throws Exception {

        SimulacaoMap.initHeader();

        obj.put("nome", nome);
        obj.put("cpf", cpf);
        obj.put("email", email);
        obj.put("valor", valor);
        obj.put("parcelas", parcelas);
        obj.put("seguro", seguro);

        response = RESTMethods.executePost(URL_LOCAL + "api/v1/simulacoes", obj.toString(), SimulacaoMap.getHeader(), SimulacaoMap.getParams());
       if(RESTMethods.getResponseCode() == 201){
           setProperties("cpf", response.jsonPath().get("cpf"));
           setProperties("id", response.jsonPath().get("id").toString());
       }

    }


    public void consultarSimulacaoCPF(String cpf) {
        SimulacaoMap.initHeader();
        response = RESTMethods.executeGetpathParams(URL_LOCAL + "api/v1/simulacoes/"+cpf+"", SimulacaoMap.getHeader(), SimulacaoMap.getParams());

    }
    public void consultarSimulacoes() {
        SimulacaoMap.initHeader();
        response = RESTMethods.executeGetpathParams(URL_LOCAL + "api/v1/simulacoes", SimulacaoMap.getHeader(), SimulacaoMap.getParams());
        List<String> lista = response.jsonPath().getList("cpf");
        Integer index = lista.indexOf(getProperties("cpf"));
    }


    public Response getResponse() {
        return response;
    }
}
