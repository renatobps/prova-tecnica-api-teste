package br.com.sicredi.test.gherkin.stepsDefinitions;

import br.com.sicredi.test.model.Simulacao;
import io.cucumber.java.en.Given;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.junit.Assert.assertEquals;

public class ConsultarSimulacaoCPFSteps {
    Simulacao simulacao = new Simulacao();

    public ConsultarSimulacaoCPFSteps() throws Exception {
    }

    @Given("que execute o endpoint para consultar simulacao por cpf inserindo o cpf {string}")
    public void que_execute_o_endpoint_para_consultar_simulacao_por_cpf_inserindo_o_cpf(String cpf ) {
        simulacao.consultarSimulacaoCPF(cpf);

    }
}
