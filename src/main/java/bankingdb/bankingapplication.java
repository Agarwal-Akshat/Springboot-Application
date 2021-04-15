package bankingdb;

import bankingdb.controllers.Controller;
import bankingdb.db.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class bankingapplication {

    public static void main(String[] args) {
        SpringApplication.run(bankingapplication.class, args);
    }

}
