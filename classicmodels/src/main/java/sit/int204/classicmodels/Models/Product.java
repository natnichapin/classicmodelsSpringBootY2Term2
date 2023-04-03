package sit.int204.classicmodels.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Product {
    @Id
    private String productCode ;
    private String productName ;
    private String productDescription ;
    private String productVendor ;
    private String productLine ;
    private String productScale ;
    private String quantityInStock ;
    private Double buyPrice ;

   //ฟิลด์ชื่อไม่ตรง
    @Column(name= "MSRP")
    private Double price ;
    public String getImageUrl(){
        return  productCode+".jpg";
    }
}
