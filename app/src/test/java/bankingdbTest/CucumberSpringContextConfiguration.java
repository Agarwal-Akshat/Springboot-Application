package bankingdbTest;

import myPackage.bankingapplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = bankingapplication.class)
public abstract class CucumberSpringContextConfiguration {

}
