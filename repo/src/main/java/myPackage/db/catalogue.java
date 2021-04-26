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

@Table(name="Catalogue")
@Entity
@ApiModel(description = "Catalogue detailing different product provided ")
@JsonPropertyOrder({"custid","creditcard","investment","loan","FD"})
public @Data class catalogue {

    @ApiModelProperty(notes = "The account id for which we are seeing these products")
    private @Id long custid;

    @ApiModelProperty(notes = "Whether they have credit card or not, and what card if they have")
    private @Column String creditcard;

    @ApiModelProperty(notes = "Whether they have invested in stocks")
    private @Column String investment;

    @ApiModelProperty(notes = "Whether they have taken loans, and what loans")
    private @Column String loan;

    @ApiModelProperty(notes = "Whether that have FDs and the tenure of their biggest FD")
    private @Column String FD;


    public catalogue(){}

    public catalogue(long custid,String creditcard,String investment, String loan, String FD){
        this.custid=custid;
        this.creditcard=creditcard;
        this.investment=investment;
        this.loan=loan;
        this.FD=FD;
    }
}
