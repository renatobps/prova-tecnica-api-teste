package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import br.com.sicredi.test.utils.Utils;
import io.cucumber.java.en.Then;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.junit.Assert.assertEquals;

public class ValidarMensagemErroCamposSteps {
    Simulacao simulacao = new Simulacao();

    public ValidarMensagemErroCamposSteps() throws Exception {
    }


    @Then("no body do response deve ter mensagem de erro na key {string} {string}")
    public void no_body_do_response_deve_ter_mensagem_de_erro_na_key(String key, String mensagem) {
        assertEquals(mensagem, RESTMethods.key(""+key+""));
        simulacao.excluirSimulacao(Integer.parseInt(getProperties("id")));
    }
}
