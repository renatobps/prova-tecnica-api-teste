package br.com.sicredi.test.runner;


import br.com.sicredi.test.model.Simulacao;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static br.com.sicredi.test.utils.Utils.getProperties;

public class TestJunit {

    Simulacao simulacao = new Simulacao();

    public TestJunit() throws Exception {
    }

    @Test
    public void createSimulacao() throws Exception {

        simulacao.criarSimulacao(
                "Renato",
                "97093232133",
                "email@email.com",
                1200.00,
                3,
                true
                    );
        Assert.assertEquals(201, simulacao.getResponse().getStatusCode());

    }
    @Test
    public void consultarSimulacaoCPF(){
        simulacao.consultarSimulacaoCPF(getProperties("cpf"));
        Assert.assertEquals(200, simulacao.getResponse().getStatusCode());
    }
    @Test
    public void consultarSimulacoes(){
        simulacao.consultarSimulacoes();
        List<String> lista = simulacao.getResponse().jsonPath().getList("cpf");
        Integer index = lista.indexOf(getProperties("cpf"));
        Assert.assertEquals(getProperties("cpf"), simulacao.getResponse().jsonPath().get("cpf["+index+"]"));
        Assert.assertEquals(200, simulacao.getResponse().getStatusCode());
    }
}