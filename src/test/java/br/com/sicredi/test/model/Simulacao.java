package br.com.sicredi.test.model;


import br.com.sicredi.test.restAssured.RESTMethods;
import br.com.sicredi.test.utils.Utils;
import io.restassured.response.Response;
import org.json.JSONObject;


import java.math.BigInteger;

import static br.com.sicredi.test.restAssured.UtilsREST.readJsonSimpleDemo;
import static br.com.sicredi.test.utils.Urls.URL_LOCAL;
import static br.com.sicredi.test.utils.Utils.getJson;


public class Simulacao {
    Response response;

    public Simulacao() throws Exception {
    }

    public void criarSimulacao(String nome, String cpf, String email, Double valor, int parcelas, Boolean seguro) throws Exception {
        JSONObject obj = readJsonSimpleDemo("src/test/resources/json/simulacao.json");
        SimulacaoMap.initHeader();

        getJson().put("nome", nome);
        getJson().put("cpf", cpf);
        getJson().put("email", email);
        getJson().put("valor", valor);
        getJson().put("parcelas", parcelas);
        getJson().put("seguro", seguro);


        response = RESTMethods.executePost(URL_LOCAL + "api/v1/simulacoes", obj.toString(), SimulacaoMap.getHeader(), SimulacaoMap.getParams());
    }


    public void consultarSimulaca() {
        SimulacaoMap.initHeader();
        response = RESTMethods.executeGetpathParams(URL_LOCAL + "api/v1/simulacoes/97093236015", SimulacaoMap.getHeader(), SimulacaoMap.getParams());

    }

    public static JSONObject getJson() throws Exception {
        return readJsonSimpleDemo("src/test/resources/json/simulacao.json");
    }

    public Response getResponse() {
        return response;
    }
}
