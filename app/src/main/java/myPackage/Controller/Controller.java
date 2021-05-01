package myPackage.Controller;

import io.swagger.annotations.Api;
import myPackage.db.Customer;
import myPackage.db.catalogue;
import myPackage.errorhandle.customerNotFoundException;
import myPackage.services.Serv;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import myPackage.services.cataServ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Endpoints for customer's Account", description = "Endpoints for customer's Account")
@RestController
public class Controller {

    @Autowired
    Serv db;

    @Autowired
    cataServ cserv;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @ApiOperation(value = "This method is used for logs.", hidden = true)
    @RequestMapping("/log")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Check the Logs to see the output";
    }


    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gives details of all current account holding customers",
            notes = "List of all customers",
            response = Customer.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
    @GetMapping("/customers")
    Iterable<Customer> findall(){
        return db.findAll();
    }


    @ApiOperation(value = "Gives details of all current account holding customers by their first name",
            notes = "List of customers with that first name",
            response = Customer.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
    @GetMapping("/customerByName/{name}")
    List<Customer> findbyname(@PathVariable String name){
        return db.findByName(name);
    }


    @ApiOperation(value = "Gives details of the particular account having that unique account ID",
            notes = "myPackage.db.Customer details having that particular account",
            response = Customer.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
    @GetMapping("/customerById/{id}")
    Customer findbyid(@PathVariable long id){
        return db.findById(id);
    }


    @ApiOperation(value = "Add a new account/customer",
            notes = "Adds a new customer",
            response = String.class)
    @PostMapping("/insert")
    String insert(@RequestBody Customer cust){
        return db.insert(cust);
    }


    @ApiOperation(value = "Modifies details of existing customer/account by giving their unique account ID as param",
            notes = "Modifies details of existing customer/account",
            response = String.class)
    @PutMapping("/update/{id}")
    String update(@PathVariable long id, @RequestBody Customer cust) throws customerNotFoundException{
        return db.update(id,cust);
    }


    @ApiOperation(value = "Deletes details of existing customer/account by giving their unique account ID as param",
            notes = "Deletes details of existing customer/account",
            response = String.class)
    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable long id) throws customerNotFoundException{
        return db.delete(id);
    }


    @GetMapping("/Catalogue/{id}")
    catalogue findbycustId(@PathVariable long id){
        return cserv.findByCustId(id);
    }




}
