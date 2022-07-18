package br.com.sicredi.test.gherkin.stepsDefinitions.regrasSimulcao;

import br.com.sicredi.test.model.Simulacao;
import br.com.sicredi.test.restAssured.RESTMethods;
import br.com.sicredi.test.utils.Utils;
import io.cucumber.java.en.Then;


import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidarNaoCaracterEspeciaisCPFSteps {

    Simulacao simulacao =  new Simulacao();

    public ValidarNaoCaracterEspeciaisCPFSteps() throws Exception {
    }

    @Then("no body do response o campo cpf deve caracter especiais")
    public void no_body_do_response_o_campo_cpf_deve_caracter_especiais() {

        assertTrue(RESTMethods.key("cpf").matches("[0-9]*"));
        simulacao.excluirSimulacao(Integer.parseInt(getProperties("id")));

        }
    }
