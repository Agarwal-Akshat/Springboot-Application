package bankingdb.controllers;

import bankingdb.db.TranService;
import bankingdb.db.Transact;
import bankingdb.errorhandle.accountFundsExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller2 {
    @Autowired
    TranService db2;

    @GetMapping("/debit/{accid}")
    Transact debit(@PathVariable long accid,@RequestBody int amount){
        if(db2.debit(accid,amount)==null){
            throw new accountFundsExceededException("the amount: "+amount+" exceeds the funds present in this account");
        }
        return db2.debit(accid,amount);
    }

    @GetMapping("/credit/{id}")
    Transact credit(@PathVariable long id, @RequestBody int amount){
        return db2.credit(id,amount);
    }

    @GetMapping("/transfer/{id1}/{id2}")
    List<Transact> transfer(@PathVariable("id1") long id1, @PathVariable("id2") long id2, @RequestBody int amount){
        if(db2.debit(id1,amount)==null){
            throw new accountFundsExceededException("the amount: "+amount+" exceeds the funds present in this account");
        }
        return db2.transfer(id1,id2,amount);
    }

    @GetMapping("/allTransactions")
    @ResponseBody
    Iterable<Transact> findalltrans(){
        return db2.findAllTransaction();
    }

    @GetMapping("/allTransactionsByAccid/{accid}")
    List<Transact> transactionById(@PathVariable long accid){
        return db2.findAllTransactionByAccid(accid);
    }
}
