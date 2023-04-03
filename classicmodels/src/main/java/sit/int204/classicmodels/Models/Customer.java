package sit.int204.classicmodels.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customerNumber")
    private  Integer id;
    private  String customerName ;
    private String contactLastName ;
    private String contactFirstName ;
    private String phone ;
    private  String addressLine1 ;
    private String addressLine2;
    private String city ;
    private String state ;
    private String postalCode ;
    private String country ;
    private String role ;
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber")
    private Employee salesRepEmployee ;
    private Double creditLimit ;
    private String password ;


//    ตอน sout ได้ ดึงค่ามาจาก method toString

}
