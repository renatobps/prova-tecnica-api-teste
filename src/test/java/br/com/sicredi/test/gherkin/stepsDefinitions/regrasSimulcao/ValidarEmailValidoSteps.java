package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ValidarEmailValidoSteps {

    Simulacao simulacao = new Simulacao();

    public ValidarEmailValidoSteps() throws Exception {
    }

    @Then("no body do response deve ter as mensagem de erro {string}")
    public void no_body_do_response_deve_ter_as_mensagem_de_erro(String mensagem) {
        assertEquals(mensagem, RESTMethods.key("erros.email"));
    }
}
