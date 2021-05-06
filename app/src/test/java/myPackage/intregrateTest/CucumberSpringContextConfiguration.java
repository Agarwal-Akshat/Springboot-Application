package myPackage.intregrateTest;

import io.cucumber.java.Before;
import myPackage.bankingapplication;
import myPackage.basic.RunIntegrationTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = bankingapplication.class, loader = SpringBootContextLoader.class)
public abstract class CucumberSpringContextConfiguration {

    @Before
    public void setUp() {
    }

}
