package myPackage.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface catalogueRepo extends CrudRepository<catalogue,Long> {
    public catalogue findByCustid(Long custid);
}
