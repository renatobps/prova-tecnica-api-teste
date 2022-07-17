package br.com.sicredi.test.runner;


import br.com.sicredi.test.model.Simulacao;
import org.junit.Assert;
import org.junit.Test;

public class TestJunit {

    Simulacao simulacao = new Simulacao();

    public TestJunit() throws Exception {
    }

    @Test
    public void createSimulacao() throws Exception {

        simulacao.criarSimulacao(
                "Renato",
                "97093236010",
                "email@email.com",
                1200.00,
                3,
                true
                    );
        Assert.assertEquals(201, simulacao.getResponse().getStatusCode());

    }
    @Test
    public void consultarSimulacaoCPF(){
        simulacao.consultarSimulaca();
        Assert.assertEquals(200, simulacao.getResponse().getStatusCode());
    }
}