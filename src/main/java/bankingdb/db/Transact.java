package bankingdb.db;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name="Transactions")
@Entity
@ApiModel(description = "Details about the transaction done by account holding customer")
public @Data class Transact {

    @ApiModelProperty(notes = "The unique ID by which we identify this transaction")
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
