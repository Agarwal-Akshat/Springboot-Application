package bankingdb.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class service {
    @Autowired
    bankRepo repo;

    public void insert(Customer cust){
        repo.save(cust);
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

    public Boolean update(long id,Customer cust){
        if (repo.existsById(id)) {
            repo.save(cust);
            return true;
        }
        else
            return false;
    }
    public Boolean delete(long id){
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        else
            return false;
    }

}
