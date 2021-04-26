package myPackage.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tranRepo extends CrudRepository<Transact,Long> {
    List<Transact> findByAccid(Long accid);

}
