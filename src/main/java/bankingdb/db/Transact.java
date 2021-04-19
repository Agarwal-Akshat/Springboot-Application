package bankingdb.db;

import lombok.Data;

import javax.persistence.*;

@Table(name="Transactions")
@Entity
public @Data class Transact {
    private @Id @GeneratedValue long tranid;
    private @Column long accid;
    private @Column double transferbalance;
    private @Column boolean inout;

    public Transact(){}

    public Transact(long accid,long tranId,double transferBalance,boolean InOut) {
        this.accid=accid;
        this.tranid=tranId;
        this.transferbalance=transferBalance;
        this.inout=InOut;
    }


}
