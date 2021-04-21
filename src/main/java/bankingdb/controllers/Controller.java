package bankingdb.controllers;

import bankingdb.db.Transact;
import bankingdb.db.service;
import bankingdb.db.TranService;
import bankingdb.db.Customer;
import bankingdb.errorhandle.customerNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    service db;
    //@Autowired
    //TranService db2;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Check the Logs to see the output";
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/customers")
    Iterable<Customer> findall(){
        return db.findAll();
    }

    @GetMapping("/customerByName/{name}")
    List<Customer> findbyname(@PathVariable String name){
        return db.findByName(name);
    }

    @GetMapping("/customerById/{id}")
    Customer findbyid(@PathVariable long id){
        return db.findById(id);
    }

    @PostMapping("/insert")
    String insert(@RequestBody Customer cust){
        return db.insert(cust);
    }

    @PutMapping("/update/{id}")
    String update(@PathVariable long id, @RequestBody Customer cust) throws customerNotFoundException{
        return db.update(id,cust);
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable long id) throws customerNotFoundException{
        return db.delete(id);
    }


}
