package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ValidarCPFExistenteSteps {
    Simulacao simulacao = new Simulacao();

    public ValidarCPFExistenteSteps() throws Exception {
    }

    @Then("no body do response deve ter mensagem de erro de cpf {string}")
    public void no_body_do_response_deve_ter_mensagem_de_erro_de_cpf(String mensagem) {
        assertEquals(mensagem, RESTMethods.key("mensagem"));
    }
}
