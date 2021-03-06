package myPackage.services;

import myPackage.db.Customer;
import myPackage.db.bankRepo;
import myPackage.errorhandle.customerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serv {
    @Autowired
    bankRepo repo;


    public String insert(Customer cust){
        repo.save(cust);
        return "Inserted";
    }
    public Iterable<Customer> findAll(){
        return repo.findAll();
    }

    public List<Customer> findByName(String name){
        return repo.findByFirstname(name);
    }

    public Customer findById(long id){
        return repo.findById(id).get();
    }

    public String update(long id,Customer cust) throws customerNotFoundException{
        if (repo.existsById(id)) {
            repo.deleteById(id);
            repo.save(cust);
            return "Record Updated";
        }
        else
            throw new customerNotFoundException("Error: Could not find customer{id:"+id+"} so record not updated");
    }

    public String delete(long id) throws customerNotFoundException{
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Record Deleted";
        }
        else
            throw new customerNotFoundException("Error: Could not find customer{id:"+id+"} so record not deleted");
    }

}
