package bankingdb.db;

import javax.persistence.*;

@Table(name="Transactions")
@Entity
public class Transact {
    private @Id @GeneratedValue long tranid;
    private @Column long accid;
    private @Column int transferbalance;
    private @Column boolean inout;

    public Transact(){}

    public Transact(long accid,long tranId,int transferBalance,boolean InOut) {
        this.setAccid(accid);
        this.setTranId(tranId);
        this.setTransferBalance(transferBalance);
        this.setInOut(InOut);
    }


    public long getTranId() {
        return tranid;
    }

    public void setTranId(long tranid) {
        this.tranid = tranid;
    }

    public long getAccid() {
        return accid;
    }

    public void setAccid(long accid) {
        this.accid = accid;
    }

    public int getTransferBalance() {
        return transferbalance;
    }

    public void setTransferBalance(int transferbalance) {
        this.transferbalance = transferbalance;
    }

    public boolean getInOut() {
        return inout;
    }

    public void setInOut(boolean inout) {
        this.inout = inout;
    }
}
