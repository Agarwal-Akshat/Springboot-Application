package bankingdb.controllers;

import bankingdb.db.service;
import bankingdb.db.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    service db;

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
        db.insert(cust);
        return "Inserted";
    }

    @PutMapping("/update/{id}")
    String update(@PathVariable long id, @RequestBody Customer cust){
        Boolean stat=db.update(id,cust);
        if (stat) //means true
            return "Record Updated";
        return "Customer with this id does not exists";
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable long id){
        Boolean stat=db.delete(id);
        if (stat) //means true
            return "Record Deleted";
        return "Customer with this id does not exists";
    }
}
