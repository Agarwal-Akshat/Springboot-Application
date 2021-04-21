package bankingdbTest;

import bankingdb.db.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class controllersTest extends AbstractMapping {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

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
        assertEquals(200, status);
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
        assertEquals(400, status);
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
        assertEquals(400, status);
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


}