package myPackage.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name="Transactions")
@Entity
@ApiModel(description = "Details about the transaction done by account holding customer")
@JsonPropertyOrder({"tranid","accid","transferbalance","inout"})
public @Getter
@Setter
class Transact {


    @ApiModelProperty(notes = "The unique ID by which we identify this transaction")
    @JsonProperty(value = "tran_id")
    private @Id @GeneratedValue long tranid;

    @ApiModelProperty(notes = "Account ID unique to each customer on which the transaction has taken place")
    private @Column long accid;

    @ApiModelProperty(notes = "The amount which has been credited/debited during transaction")
    private @Column double transferbalance;

    @ApiModelProperty(notes = "Boolean value, true means credited and false means debited")
    private @Column boolean inout;

    public Transact(){}

    public Transact(long accid,long tranId,double transferBalance,boolean InOut) {
        this.accid=accid;
        this.tranid=tranId;
        this.transferbalance=transferBalance;
        this.inout=InOut;
    }


}
