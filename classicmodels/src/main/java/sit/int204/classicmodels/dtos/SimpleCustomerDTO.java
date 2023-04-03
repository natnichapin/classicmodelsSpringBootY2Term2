package sit.int204.classicmodels.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCustomerDTO {
    private String customerName;
    private String phone;
    private String city;
    private String country;

    @JsonIgnore
    private SimpleEmployeeDTO sales ;
//    Private ไม่สามารถเข้าถึงได้ แค่ใช้ getter แทน filed ได้
    public String getSalesPerson(){
        return sales==null?"-":sales.getName();
    }

//    private String salesRepEmployeeFirstName;
//    private String salesRepEmployeeLastName;


//    @JsonIgnore
//    private SimpleEmployeeDTO sales;
//    public String getSalesPerson() {
//        return sales == null ? "-" : sales.getName();
//    }
}
