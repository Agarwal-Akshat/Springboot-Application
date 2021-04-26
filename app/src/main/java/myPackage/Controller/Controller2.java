package myPackage.Controller;

import myPackage.db.Transact;
import myPackage.errorhandle.accountFundsExceededException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import myPackage.services.TranService;

import java.util.List;

@RestController
public class Controller2 {
    @Autowired
    TranService db2;


    @ApiOperation(value = "Enables to debit money from the account who's id is given",
            notes = "Debit money through body into a particular account",
            response = Transact.class)
    @PostMapping("/debit/{accid}")
    Transact debit(@PathVariable long accid, @RequestBody double amount) throws accountFundsExceededException {
        return db2.debit(accid,amount);
    }


    @ApiOperation(value = "Enables to credit money into the account who's id is given",
            notes = "Credit money through body into a particular account",
            response = Transact.class)
    @PostMapping("/credit/{id}")
    Transact credit(@PathVariable long id, @RequestBody double amount){
        return db2.credit(id,amount);
    }


    @ApiOperation(value = "Enables to transfer of funds between 2 customers by giving 2 ids as params and amount",
            notes = "List of 2 transactions one for debit and other for credit",
            response = Transact.class,
            responseContainer = "List")
    @PostMapping("/transfer/{id1}/{id2}")
    List<Transact> transfer(@PathVariable("id1") long id1, @PathVariable("id2") long id2, @RequestBody double amount) throws accountFundsExceededException{
        return db2.transfer(id1,id2,amount);
    }


    @ApiOperation(value = "List of all the transactions that has taken place till now",
            notes = "List of all the transactions that has taken place till now",
            response = Transact.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
    @GetMapping("/allTransactions")
    Iterable<Transact> findalltrans(){
        return db2.findAllTransaction();
    }


    @ApiOperation(value = "List of all the transactions completed by the account whos ID is used as param",
            notes = "List of all the transactions completed by a specific account",
            response = Transact.class,
            responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Server error"),
            @ApiResponse(code = 200, message = "Successful retrieval")})
    @GetMapping("/allTransactionsByAccid/{accid}")
    List<Transact> transactionById(@PathVariable long accid){
        return db2.findAllTransactionByAccid(accid);
    }
}
