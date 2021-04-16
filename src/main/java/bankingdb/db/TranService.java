package bankingdb.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TranService {
    @Autowired
    tranRepo repo2;
    @Autowired
    private service serve;

    public Iterable<Transact> findAllTransaction(){
        return repo2.findAll();
    }

    public List<Transact> findAllTransactionByAccid(long accid){
        return repo2.findByAccid(accid);
    }

    public Transact debit(long accid,int amount){
        Customer cust=serve.findById(accid);
        Transact t=new Transact(accid,0L,amount,false);
        cust.setBalance(cust.getBalance()-amount);
        serve.update(accid,cust);
        repo2.save(t);
        return t;
    }

    public Transact credit(long id,int amount){
        Customer cust=serve.findById(id);
        Transact t=new Transact(id,0L,amount,true);
        cust.setBalance(cust.getBalance()+amount);
        serve.update(id,cust);
        repo2.save(t);
        return t;
    }

    public List<Transact> transfer(long id1,long id2,int amount){
        List<Transact> t=new ArrayList<Transact>();
        t.add(debit(id1,amount));
        t.add(credit(id2,amount));
        return t;
    }
}
