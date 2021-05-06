package myPackage.basic;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import myPackage.bankingapplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"},
        features={"src/test/resources/features"},
        extraGlue = "myPackage.intregrateTest")
public class RunIntegrationTest{

}
