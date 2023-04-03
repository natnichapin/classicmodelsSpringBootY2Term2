package sit.int204.classicmodels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.Models.Employee;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.services.OfficeService;

import java.util.List;
import java.util.Set;

// บาง Error ถ้าหา Service ไม่เจอ คือ อาจจะลิมเขียน @service

// post man
//post man ไม่มี ใช้ web ต้องติดตั้ง engine ให้เรียก local ได้
//เข้าเว็บคืออยู่ยน Server ไหนไม่รู้บน cloud ใช้ Desktop agent คุย
//ทุกครั้งที่ เขียนโค้ดต้องกดรันใหม่ทุกครั้งเพื่ออัพเดท

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;


    @GetMapping("")
    public List<Office> getOffices() {
        return service.getAllOffices();
    }
    @GetMapping("/{officeCode}")
    public Office getOffice(@PathVariable String officeCode) {
        return service.getOffice(officeCode);
        //ยังไม่ได้เขียนคำสั่งด้านล่างเลยยังใช้ไม่ได้
//                .orElseThrow(
//                ()->{new RuntimeException(officeCode+ " does not exist !!!")});
    }

    @PostMapping("")
    public Office createOffice(@RequestBody Office office){
        return service.createOffice(office);
    }

    @DeleteMapping("/{officeCode}")
    public void delete(@PathVariable String officeCode) {
        service.deleteOffice(officeCode);
    }
//เวลา update จาก postman ไม่ต้องใส่ ID ก็ได้ ใส่เป้น null ไป
    @PutMapping("/{officeCode}")
    public  Office updateOffice(@RequestBody Office office ,@PathVariable String officeCode){
        return service.updateOffice(officeCode,office) ;
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getOfficeEmployee(@PathVariable String officeCode){
        return  service.getOfficeEmployee(officeCode) ;
    }

    @PostMapping("/{officeCode}/employees")
    public Employee addOfficeEmployee(@RequestBody Employee employee,@PathVariable String officeCode){
        return  service.AddNewEmployee(officeCode,employee) ;
    }

}
