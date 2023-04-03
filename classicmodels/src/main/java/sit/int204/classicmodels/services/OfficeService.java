package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.ResourceAccessException;
import sit.int204.classicmodels.Models.Employee;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.Repositories.EmployeeRepository;
import sit.int204.classicmodels.Repositories.OfficeRepository;
import sit.int204.classicmodels.execeptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OfficeService {
    //เวลา ตั้งชื่อตัวแปร ควรเป็นตัวเล็กนำหน้า
    @Autowired
    private OfficeRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository ;

    public List<Office> getAllOffices(){
        return  repository.findAll();
    }
    public Office getOffice (String officeCode){
        return  repository.findById(officeCode).orElseThrow(
                ()->new ResourceNotFoundException(officeCode + "does not exits !!!"){

                }
        );
    }
//    public Office addNewOffice(Office newOffice) {
//        return repository.a (newOffice);
//    }

    public Office createOffice(Office office){
        return repository.saveAndFlush(office);
    }
    public void deleteOffice(String officeCode) {
        //optimize จากของเก่าที่คอมเม้นให้ดีขึ้น
        Office office = getOffice(officeCode);
//        repository.findById(officeCode).orElseThrow(()->
//                new RuntimeException(officeCode + " does not exist !!!"));
        repository.deleteById(officeCode);

    }
    // ส่วน Update ในไสลด์ ?? ใช้ไม่ได้
//    public Office update(String officeCode , Office updateOffice) {
//        Office office = repository.findById(officeCode).map(o->mapOffice(o, updateOffice))
//                .orElseThrow( ()->new RuntimeException(officeCode+ " does not exist !!!"));
//        return repository.saveAndFlush(office);
//    }
    public Office updateOffice(String officeCode,Office office){
        Office existOffice = repository.findById(officeCode).orElseThrow(
                ()->new ResourceAccessException(officeCode + "does not exist !!!"));
        existOffice.setCity(office.getCity());
        existOffice.setPhone(office.getPhone());
        existOffice.setAddressLine1(office.getAddressLine1());
        existOffice.setAddressLine2(office.getAddressLine2());
        existOffice.setState(office.getState());
        existOffice.setCountry(office.getCountry() );
        existOffice.setPostalCode(office.getPostalCode());
        existOffice.setTerritory(office.getTerritory());
        return  repository.saveAndFlush(existOffice);
    }
//ใช้ Set แทน List ได้ แต่ Default ปกติใช้ List but whatever u use which type not different
//Except you use set it will represent only data that not duplicate แต่ไม่เออเร่อนะ
    public Set<Employee> getOfficeEmployee(String officeCode){
      Office office = getOffice(officeCode);
      return office.getEmployees();
    }

    public  Employee AddNewEmployee(String officeCode,Employee employee) {
        Office existOffice = repository.findById(officeCode).orElseThrow(  //Optional จะทำให้แม้ไม่เจอ ก็ null ได้  //หรือเขียน orElse(null) คือรีเทิน null ไม่จำเป็น ต้อง throw
                //if(e.. == null ) เพื่อเช็ค แล้ว throw แบบยืดเยื้อ
                 ()->new ResourceAccessException(officeCode + "does not exist !!!"));
        employee.setOffice(existOffice);
        return employeeRepository.saveAndFlush(employee);


    }




//    public Office addNewOffice(Office newOffice){
//        return  service.create(newOffice);
//    }
}
