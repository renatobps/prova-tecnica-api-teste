package br.com.sicredi.test.gherkin.stepsDefinitions.simulacao;

import br.com.sicredi.test.model.Simulacao;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

public class AtualizarSimulacaoSteps {
Simulacao simulacao = new Simulacao();

    public AtualizarSimulacaoSteps() throws Exception {
    }

    @Given("que execute o endpoint para atualizar simulacao inserindo nome {string}, cpf {string}, email {string}, valor {double},  parcelas {int} e seguro {string}")
    public void que_execute_o_endpoint_para_atualizar_simulacao_inserindo_nome_cpf_email_valor_parcelas_e_seguro(String nome, String cpf, String email, double valor, int parcelas, String seguro) throws Exception  {
        simulacao.atualizarSimulacao(
                nome,
                cpf,
                email,
                valor,
                parcelas,
                seguro
        );
    }
    @Then("no body do response o campo nome deve ser {string}, cpf {string}, email {string}")
    public void no_body_do_response_o_campo_nome_deve_ser_cpf_email(String nome, String cpf, String email) {
        assertEquals(nome, simulacao.getResponse().jsonPath().get("nome"));
        assertEquals(cpf, simulacao.getResponse().jsonPath().get("cpf"));
        assertEquals(email, simulacao.getResponse().jsonPath().get("email"));

    }
}
