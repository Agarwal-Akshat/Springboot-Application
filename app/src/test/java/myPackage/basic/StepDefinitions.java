package myPackage.basic;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import myPackage.intregrateTest.transferHttpClient;
import myPackage.services.Serv;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class StepDefinitions {

    int id1,id2;
    double bal1,bal2;

    @Autowired
    private transferHttpClient thc;


    @Given("^account (\\d+) who transfers (\\d+.\\d+) to account (\\d+)$")
    public void accountWhoTransfersToAccount(int id1, double amount, int id2) throws Throwable {
        thc.transferMoney(id1,amount,id2);
        bal1=thc.custbyid(id1).getBalance();
        bal2=thc.custbyid(id2).getBalance();

    }

    @When("^user chooses transfer feature$")
    public void userChoosesTransferFeature() throws Throwable {
    }

    @Then("^new balance for accounts should be (\\d+.\\d+) and (\\d+.\\d+)$")
    public void newBalanceForAccountsShouldBeAnd(double amount1, double amount2) throws Throwable {
        Assertions.assertEquals(bal1,amount1);
        Assertions.assertEquals(bal2,amount2);

    }
}
