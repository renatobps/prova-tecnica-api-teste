package br.com.sicredi.test.gherkin.stepsDefinitions;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.junit.Assert.assertEquals;

public class ExcluirSimulacaoSteps {
    Simulacao simulacao = new Simulacao();

    public ExcluirSimulacaoSteps() throws Exception {
    }

    @Given("que execute o endpoint para excluir simulacao por cpf inserindo o cpf {string}")
    public void que_execute_o_endpoint_para_excluir_simulacao_por_cpf_inserindo_o_cpf(String cpf) {
        simulacao.excluirSimulacao(cpf);
    }

}
