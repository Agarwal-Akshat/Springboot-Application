package myPackage.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//using JPA for object relation mapping
@Table(name="Accounts")
@Entity
@ApiModel(description = "Details about the account holding customers")
@JsonPropertyOrder({"id","firstname","secondname","balance"})
public @Data class Customer {

    @ApiModelProperty(notes = "The unique ID by which we identify this customer's account")
    @JsonProperty(value = "Acc_ID")
    private @Id long id;

    @ApiModelProperty(notes = "The first name for this account holding customer")
    private @Column String firstname;

    @ApiModelProperty(notes = "The second name for this account holding customer")
    private @Column String secondname;

    @ApiModelProperty(notes = "The balance currently present in this account")
    private @Column double balance;

    public Customer(){}

    public Customer(long id, String firstname, String secondname, double balance){
        this.id=id;
        this.firstname=firstname;
        this.secondname=secondname;
        this.balance=balance;

    }

}

