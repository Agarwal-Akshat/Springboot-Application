package bankingdb.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import bankingdb.errorhandle.accountFundsExceededException;
import java.util.List;

@Service
public class TranService {
    @Value("${spring.datasource.limitation}")
    private double limitation;

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

    public Transact debit(long accid,double amount) throws accountFundsExceededException{
        //find that customer with account id
        Customer cust=serve.findById(accid);
        //making a new trasaction request of the amount and account id
        Transact t=new Transact(accid,0L,amount,false);
        //changing the balance of customer after transaction
        if(cust.getBalance()<amount || limitation<amount){
            throw new accountFundsExceededException("the amount: "+amount+" exceeds the funds present in this account or limit for transaction exceeded");
        }
        cust.setBalance(cust.getBalance()-amount);

        //update that customers new balance
        serve.update(accid,cust);
        //save the transaction which has been completed
        repo2.save(t);
        return t;
    }

    public Transact credit(long id,double amount){
        Customer cust=serve.findById(id);
        Transact t=new Transact(id,0L,amount,true);
        cust.setBalance(cust.getBalance()+amount);
        serve.update(id,cust);
        repo2.save(t);
        return t;
    }

    public List<Transact> transfer(long id1,long id2,double amount) throws accountFundsExceededException{
        List<Transact> t=new ArrayList<Transact>();
        //for transfer between customers, debit transaction from 1st customer and credit for 2nd for the same amount
        t.add(debit(id1,amount));
        t.add(credit(id2,amount));
        return t;
    }
}
