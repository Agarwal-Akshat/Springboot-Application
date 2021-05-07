package myPackage.basic;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import myPackage.integrationTest.transferHttpClient;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinitions {
    double bal;

    @Autowired
    private transferHttpClient thc;

    @Given("account {int} for whom we have to check balance")
    public void account_for_whom_we_have_to_check_balance(Integer int1){
    bal=thc.custbyid(int1).getBalance();
    }

    @Then("Display the account {double} of the customer")
    public void display_the_account_of_the_customer(Double double1) {
        Assertions.assertEquals(bal,double1);
    }
}