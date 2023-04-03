package sit.int204.classicmodels.dtos;

//import lombok.Getter;
import lombok.Getter;
import lombok.Setter;

//ฟิลด์ไม่มีอยู่จริงแค่ ไปดึง method getter มาใข้
@Setter
@Getter
public class SimpleEmployeeDTO {
    private String lastName;
    private String firstName;
    public String getName() {
        return firstName + " "+ lastName;
    }
}
