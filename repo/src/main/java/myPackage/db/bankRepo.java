package myPackage.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface bankRepo extends CrudRepository<Customer,Long> {
    //public List<myPackage.db.Customer> findById(String id);
    //public boolean existsById(String id);
    //public void deleteById(String id);
    public List<Customer> findByFirstname(String firstname);
}