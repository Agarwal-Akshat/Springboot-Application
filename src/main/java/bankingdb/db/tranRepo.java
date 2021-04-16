package bankingdb.db;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface tranRepo extends CrudRepository<Transact,Long> {
    List<Transact> findByAccid(Long accid);

}
