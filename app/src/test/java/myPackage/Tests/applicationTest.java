package myPackage.Tests;

import myPackage.bankingapplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = bankingapplication.class)
public class applicationTest {

    @Test
    void contextLoads() {
    }
}