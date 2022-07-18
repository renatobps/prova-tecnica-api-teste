package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import io.cucumber.java.en.Given;

public class ValidarMenagemSimulacaoExclusaoSteps {

    Simulacao simulacao =  new Simulacao();

    public ValidarMenagemSimulacaoExclusaoSteps() throws Exception {
    }


    @Given("que execute o endpoint para excluir simulacao inserindo o id inexistente")
    public void que_execute_o_endpoint_para_excluir_simulacao_inserindo_o_id_inexistente() {
       simulacao.excluirSimulacao(25415545);
    }

}
