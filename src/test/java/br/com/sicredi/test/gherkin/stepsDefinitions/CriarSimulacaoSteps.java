package br.com.sicredi.test.gherkin.stepsDefinitions;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;

public class CriarSimulacaoSteps {

    Simulacao simulacao = new Simulacao();

    public CriarSimulacaoSteps() throws Exception {
    }

    @Given("que execute o endpoint para criar simulacao inserindo nome {string}, cpf {string}, email {string}, valor {double},  parcelas {int} e seguro {string}")
    public void que_execute_o_endpoint_para_criar_simulacao_inserindo_nome_cpf_email_valor_parcelas_e_seguro(String nome, String cpf, String email, double valor, int parcelas, String seguro) throws Exception {
        simulacao.criarSimulacao(
                nome,
                cpf,
                email,
                valor,
                parcelas,
                seguro
        );

    }
    @Given("receber o response com o statusCode {string}")
    public void receber_o_response_com_o_status_code(String statusCode)throws Exception {
        assertEquals(statusCode, RESTMethods.getResponseCode().toString());
    }
    @Then("no body do response o campo nome deve ser {string} e cpf {string}")
    public void no_body_do_response_o_campo_nome_deve_ser_e_cpf(String nome, String cpf)throws Exception {
        assertEquals(RESTMethods.key("cpf"), cpf);
        assertEquals(RESTMethods.key("nome"),nome);
    }
}
