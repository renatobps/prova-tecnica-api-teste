package br.com.sicredi.test.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        SimulacaoRunner.class,
        ValidarRegrasSimulacaoRunner.class

})

public class Runner {
}
