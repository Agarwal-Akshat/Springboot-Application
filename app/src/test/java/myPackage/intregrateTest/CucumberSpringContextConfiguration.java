package myPackage.intregrateTest;

import myPackage.bankingapplication;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = {bankingapplication.class,RunCucumberTest.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class CucumberSpringContextConfiguration {

}
