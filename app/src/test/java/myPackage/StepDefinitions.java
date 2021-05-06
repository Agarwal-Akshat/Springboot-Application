package myPackage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myPackage.services.Serv;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions extends CucumberSpringContextConfiguration {

    long id1,id2;
    double bal1,bal2;


    @Given("^The account (\\d+) who transfers (\\d+.\\d+) to account (\\d+)$")
    public void theAccountIdWhoTransfersAmountToAccountId(long id1, double amount, long id2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        transferHttpClient thc=new transferHttpClient();
        thc.transferMoney(id1,amount,id2);
        id1=this.id1;
        id2=this.id2;
    }

    @When("^The user chooses transfer feature$")
    public void theUserChoosesTransferFeature() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Serv serv = new Serv();
        bal1=serv.findById(id1).getBalance();
        bal2=serv.findById(id2).getBalance();
    }

    @Then("^The new balance for accounts should be (\\d+.\\d+) and (\\d+.\\d+)$")
    public void theNewBalanceForAccountsShouldBeAmountAndAmount(double amount1, double amount2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(bal1,amount1);
        Assertions.assertEquals(bal2,amount2);
    }
}
