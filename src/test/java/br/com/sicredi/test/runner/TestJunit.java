package br.com.sicredi.test.runner;


import br.com.sicredi.test.model.Simulacao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static br.com.sicredi.test.utils.Utils.getProperties;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestJunit {

    Simulacao simulacao = new Simulacao();

    public TestJunit() throws Exception {
    }

    @Test
    @Order(1)
    public void criarSimulacao() throws Exception {

        simulacao.criarSimulacao(
                "Renato",
                "97093231111",
                "email@email.com",
                1200.00,
                3,
                "true"
                    );
        assertEquals(201, simulacao.getResponse().getStatusCode());

    }
    @Test
    @Order(2)
    public void consultarSimulacaoCPF(){
        simulacao.consultarSimulacaoCPF(getProperties("cpf"));
        assertEquals(200, simulacao.getResponse().getStatusCode());
        assertEquals(simulacao.getResponse().jsonPath().get("cpf"), getProperties("cpf"));
        assertEquals(simulacao.getResponse().jsonPath().get("nome"),"Renato bento");

    }
    @Test
    @Order(3)
    public void consultarSimulacoes(){
        simulacao.consultarSimulacoes();

        List<String> lista = simulacao.getResponse().jsonPath().getList("cpf");
        Integer index = lista.indexOf(getProperties("cpf"));
        assertEquals(getProperties("cpf"), simulacao.getResponse().jsonPath().get("cpf["+index+"]"));
        assertThat(simulacao.getResponse().jsonPath().getList("cpf"), hasItem(getProperties("cpf")));
        assertEquals(200, simulacao.getResponse().getStatusCode());
    }
    @Test
    @Order(4)
    public void atualiarSimulacao() throws Exception {

        simulacao.atualizarSimulacao(
                "Renato bento",
                "97093232100",
                "email@email.com",
                1200.00,
                2,
                "true"
        );
        assertEquals(200, simulacao.getResponse().getStatusCode());
    }

    @Test
    @Order(5)
    public void excluirSimulacao() {
        simulacao.excluirSimulacao(getProperties("cpf"));
        assertEquals(200, simulacao.getResponse().getStatusCode());

    }
    @Test
    @Order(6)
    public void consultarRestricaoCPF(){
        simulacao.consultarRestricaoCPF(getProperties("cpfRestrito"));
        assertEquals(200, simulacao.getResponse().getStatusCode());
        assertEquals("O CPF "+getProperties("cpfRestrito")+" tem problema", simulacao.getResponse().jsonPath().get("mensagem"));
    }
    }