package bankingdb.db;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//using JPA for object relation mapping
@Table(name="Accounts")
@Entity
public @Data class Customer {
    private @Id long id;
    private @Column String firstname;
    private @Column String secondname;
    private @Column double balance;

    public Customer(){}

    public Customer(long id, String firstname, String secondname, double balance){
        this.id=id;
        this.firstname=firstname;
        this.secondname=secondname;
        this.balance=balance;

    }

}

