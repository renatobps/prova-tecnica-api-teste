package br.com.sicredi.test.gherkin.stepsDefinitions;

import br.com.sicredi.test.model.Simulacao;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;

public class ConsultarSimulacoesSteps {

    Simulacao simulacao = new Simulacao();

    public ConsultarSimulacoesSteps() throws Exception {
    }

    @Given("que execute o endpoint para consultar simulacoes")
    public void que_execute_o_endpoint_para_consultar_simulacoes() {
        simulacao.consultarSimulacoes();
    }
    @Then("no body do response na lista de cpfs deve ter o cpf {string}")
    public void no_body_do_response_na_lista_de_cpfs_deve_ter_o_cpf(String cpf) {
        List<String> lista = simulacao.getResponse().jsonPath().getList("cpf");
        Integer index = lista.indexOf(cpf);

        assertEquals(cpf, simulacao.getResponse().jsonPath().get("cpf["+index+"]"));
        assertThat(simulacao.getResponse().jsonPath().getList("cpf"), hasItem(cpf));
    }
}
