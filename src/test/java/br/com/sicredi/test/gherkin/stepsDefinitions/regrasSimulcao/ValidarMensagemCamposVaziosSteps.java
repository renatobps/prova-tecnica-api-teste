package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class ValidarMensagemCamposVaziosSteps {
    Simulacao simulacao = new Simulacao();

    public ValidarMensagemCamposVaziosSteps() throws Exception {
    }

    @Given("que execute o endpoint para criar simulacao inserindo parcelas {int} e seguro {string}")
    public void que_execute_o_endpoint_para_criar_simulacao_inserindo_parcelas_e_seguro(Integer parcelas, String seguro) throws Exception {
        simulacao.regrasCriarSimulacao(
                parcelas,
                seguro
        );
    }
    @Then("no body do response deve ter as mensagem de erro {string}, {string}, {string}, {string}")
    public  void no_body_do_response_deve_ter_as_mensagem_de_erro(String mensagemValor, String mensagemCPF, String mensagemNome, String mensagemEmail) {
        assertEquals(mensagemValor, RESTMethods.key("erros.valor"));
        assertEquals(mensagemCPF, RESTMethods.key("erros.cpf"));
        assertEquals(mensagemNome, RESTMethods.key("erros.nome"));
        assertEquals(mensagemEmail, RESTMethods.key("erros.email"));
    }

}
