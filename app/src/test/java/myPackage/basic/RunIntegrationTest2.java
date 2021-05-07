package myPackage.basic;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        features={"src/test/resources/features/transferBalance"},
        extraGlue = "myPackage.integrationTest")
public class RunIntegrationTest2 {

}
