package myPackage;


import myPackage.db.Customer;
import myPackage.db.bankRepo;
import myPackage.errorhandle.customerNotFoundException;
import myPackage.services.Serv;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes= bankingapplication.class)
public class restTest {

    @Autowired
    Serv servTest;

    @MockBean
    bankRepo repoTest;

    @Test
    public void insertTester(){
        Customer e1=new Customer(4,"AA","anything",99999);
        Mockito.when(repoTest.save(e1)).thenReturn(e1);
        assertEquals("Inserted",servTest.insert(e1));
    }

    @Disabled
    @Test
    public void updateTester1(){
        Customer e1=new Customer(6,"BB","Cobra",9090);
        Mockito.when(repoTest.save(e1)).thenReturn(e1);
        assertEquals("Record Updated",servTest.update(6,e1));

    }

    @Disabled
    @Test
    public void updateTester2() throws customerNotFoundException{
        Customer e1=new Customer(3,"BB","Cobra",900999);
        Mockito.when(repoTest.save(e1)).thenThrow(new customerNotFoundException("Error: Could not find customer id:3 so record not updated"){});
        assertTrue(servTest.update(3,e1).contains("Error: Could not find"));

    }
}
