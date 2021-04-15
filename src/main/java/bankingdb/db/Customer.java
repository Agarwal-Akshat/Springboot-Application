package bankingdb.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//using JPA for object relation mapping
@Table(name="Accounts")
@Entity
public class Customer {
    private @Id long id;
    private @Column String firstname;
    private @Column String secondname;
    private @Column int balance;

    public Customer(){}

    public Customer(long id, String firstname, String secondname, int balance){
        this.id=id;
        this.firstname=firstname;
        this.secondname=secondname;
        this.balance=balance;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname +
                ", secondname=" + secondname +
                ", balance=" + balance+'}';
    }

}

