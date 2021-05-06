package myPackage;

import myPackage.db.Customer;
import myPackage.db.Transact;
import myPackage.db.catalogue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes=bankingapplication.class)
@AutoConfigureMockMvc
public class controllersTest extends AbstractMapping{

    @Autowired
    MockMvc mvc;

    @Test
    public void findAllTest() throws Exception {
        String uri = "/customers";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Customer[] custlist = super.mapFromJson(content, Customer[].class);
        assertTrue(custlist.length >= 0);
    }

    @Test
    public void insertTest() throws Exception {
        String uri = "/insert";
        Customer e1=new Customer(4,"AA","anything",99999);
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Inserted");
    }

    @Test
    public void deleteTest2() throws Exception {
        String uri = "/delete/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Record Deleted");
    }

    @Test
    public void deleteTest() throws Exception {
        String uri = "/delete/2";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Could not find customer"));
    }

    @Test
    public void updateTest() throws Exception {
        String uri = "/update/6";
        Customer e1=new Customer(6,"BB","Cobra",9090);
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("Could not find customer"));
    }

    @Test
    public void updateTest2() throws Exception {
        String uri = "/update/3";
        Customer e1=new Customer(3,"BB","Cobra",900999);
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Record Updated");
    }


    //test for transactions

    @Test
    public void debitTest1() throws Exception {
        String uri = "/debit/1";
        int e1=200;
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transact a = super.mapFromJson(content, Transact.class);
        assertEquals(200, a.getTransferbalance());
    }

    @Test
    public void creditTest1() throws Exception {
        String uri = "/credit/3";
        int e1=200;
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transact a = super.mapFromJson(content, Transact.class);
        assertEquals(200, a.getTransferbalance());
    }

    @Test
    public void transferTest1() throws Exception {
        String uri = "/transfer/1/3";
        double e1=888.8;
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transact[] a = super.mapFromJson(content, Transact[].class);
        assertEquals(2,a.length);
    }

    @Test
    public void allTransactionTest1() throws Exception {
        String uri = "/allTransactions";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transact[] a = super.mapFromJson(content, Transact[].class);
        assertTrue(a.length==2);
    }

    @Test
    public void allTransactionByIdTest1() throws Exception {
        String uri = "/allTransactionsByAccid/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Transact[] a = super.mapFromJson(content, Transact[].class);
        assertTrue(a.length==2);
    }

    @Test
    public void transferTest2() throws Exception {
        String uri = "/transfer/1/3";
        double e1=5000.8;
        String inputJson = super.mapToJson(e1);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertTrue(content.contains("exceeds the funds present in this account or limit for transaction exceeded"));
    }


    //for cache
    @Test
    public void cacheTest() throws Exception {
        String uri = "/Catalogue/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        catalogue cl = super.mapFromJson(content, catalogue.class);
        assertEquals("No",cl.getCreditcard());
        assertEquals("No",cl.getInvestment());
        assertEquals("Yes-Home",cl.getLoan());
    }

}