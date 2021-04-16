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
        db.insert(cust);
        return "Inserted";
    }

    @PutMapping("/update/{id}")
    String update(@PathVariable long id, @RequestBody Customer cust){
        Boolean stat=db.update(id,cust);
        if (stat) //means true
            return "Record Updated";
        else
            throw new customerNotFoundException("Could not find customer{id:"+id+"} so record not updated");
    }

    @DeleteMapping("/delete/{id}")
    String delete(@PathVariable long id){
        Boolean stat=db.delete(id);
        if (stat) //means true
            return "Record Deleted";
        else
            throw new customerNotFoundException("Could not find customer{id:"+id+"} so record not deleted");
    }
/*
    @GetMapping("/debit/{id}")
    Transact debit(@PathVariable long id, @RequestBody int amount){
        return db2.debit(id,amount);
    }

    @GetMapping("/credit/{id}")
    Transact credit(@PathVariable long id, @RequestBody int amount){
        return db2.credit(id,amount);
    }

    @GetMapping("/transfer/{id1}{id2}")
    List<Transact> transfer(@PathVariable long id1,@PathVariable long id2, @RequestBody int amount){
        return db2.transfer(id1,id2,amount);
    }

    @GetMapping("/allTransactions")
    @ResponseBody  Iterable<Transact> findalltrans(){
        return db2.findAllTransaction();
    }

    @GetMapping("/allTransactionsById/{id}")
     List<Transact> transactionById(@PathVariable long id){
        return db2.findAllTransactonById(id);
    }*/

}
