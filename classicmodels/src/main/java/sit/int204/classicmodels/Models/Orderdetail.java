package sit.int204.classicmodels.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="orderdetails")
public class Orderdetail {


    private int quantityOrdered ;
    private Double priceEach ;
    @Column(name="orderLineNumber")
    private int LineNo ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="productCode")
    private Product product ;
    @Id
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="orderNumber")
    private Order order ;
}
