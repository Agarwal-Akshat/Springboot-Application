package myPackage.integrationTest;


import myPackage.db.Customer;
import myPackage.db.Transact;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;


@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class transferHttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String TRANSFER_ENDPOINT = "/transfer";
    private final String CUSTOMER_ENDPOINT = "/customerById";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String tranferEndpoint(long id1,long id2) {
        return SERVER_URL + ":" + port + TRANSFER_ENDPOINT+"/"+String.valueOf(id1)+"/"+String.valueOf(id2);
    }

    public Transact[] transferMoney(long id1, double amount, long id2) {

        return restTemplate.postForEntity(tranferEndpoint(id1,id2),amount,Transact[].class).getBody();
    }

    private String customerEndpoint(long id1) {
        return SERVER_URL + ":" + port + CUSTOMER_ENDPOINT+"/"+String.valueOf(id1);
    }

    public Customer custbyid(long id1) {

        return restTemplate.getForEntity(customerEndpoint(id1),Customer.class).getBody();
    }
}
