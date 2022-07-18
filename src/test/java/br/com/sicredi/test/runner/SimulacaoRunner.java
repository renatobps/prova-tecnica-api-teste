package br.com.sicredi.test.runner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import static io.cucumber.junit.CucumberOptions.SnippetType.UNDERSCORE;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/br/com/sicredi/test/feature"}
        , glue = {"br.com.sicredi.test.gherkin.stepsDefinitions"}
        , plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "rerun:target/rerun.txt"}
        , dryRun = false
        ,snippets = UNDERSCORE
        ,tags = "@Simulacao"

)
public class SimulacaoRunner {
}
