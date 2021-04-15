package bankingdb.db;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface bankRepo extends CrudRepository<Customer,Long> {
    //public List<Customer> findById(String id);
    //public boolean existsById(String id);
    //public void deleteById(String id);
    public List<Customer> findByFirstname(String firstname);
}