package br.com.sicredi.test.gherkin.stepsDefinitions.simulacao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.junit.Assert.assertEquals;

public class ConsultarRestricaoCPFSteps {
    Simulacao simulacao = new Simulacao();

    public ConsultarRestricaoCPFSteps() throws Exception {
    }

    @Given("que execute o endpoint para consultar restricao inserindo o cpf {string}")
    public void que_execute_o_endpoint_para_consultar_restricao_inserindo_o_cpf(String string) {
        simulacao.consultarRestricaoCPF(getProperties("cpfRestrito"));


    }
    @Then("no body do response o campo mensagem deve ter a mensagem {string}")
    public void no_body_do_response_o_campo_mensagem_deve_ter_a_mensagem(String mensagem) {
        assertEquals(mensagem, RESTMethods.key("mensagem"));
    }
}
