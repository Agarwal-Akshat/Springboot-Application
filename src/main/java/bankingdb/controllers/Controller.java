package bankingdb.controllers;

import bankingdb.db.Transact;
import bankingdb.db.service;
import bankingdb.db.TranService;
import bankingdb.db.Customer;
import bankingdb.errorhandle.customerNotFoundException;
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

    @GetMapping("/")
    public String home(){
        return "hello working fine";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/findAll")
    @ResponseBody  Iterable<Customer> findall(){
        return db.findAll();
    }

    @GetMapping("/findByName/{name}")
    List<Customer> findbyname(@PathVariable String name){
        return db.findByName(name);
    }

    @GetMapping("/findById/{id}")
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
