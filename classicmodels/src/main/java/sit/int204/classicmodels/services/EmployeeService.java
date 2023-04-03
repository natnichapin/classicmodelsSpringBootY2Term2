package sit.int204.classicmodels.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import sit.int204.classicmodels.Models.Employee;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.Repositories.EmployeeRepository;
import sit.int204.classicmodels.Repositories.OfficeRepository;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository ;
    @Autowired
    private OfficeRepository officeRepository;

    public Employee save(Employee employee) {
        return repository.saveAndFlush(employee);
    }
    public List<Employee> getAllEmployee () {
        return  repository.findAll();
    }

    public Employee getEmployee (Integer employeeNumber){
        return repository.findById(employeeNumber).orElseThrow(()->new RuntimeException(employeeNumber+ "does not exits !!!"));
    }

    public Employee createEmployee(Employee employee) {
        return  repository.saveAndFlush(employee) ;
    }

    public void deleteEmployee(Integer employeeNumber){
        repository.deleteById(employeeNumber);
    }
//    "id": 1165,
//        "lastName": "Jennings",
//        "firstName": "Leslie",
//        "extension": "x3291",
//        "email": "ljennings@classicmodelcars.com",
//        "jobTitle": "Sales Rep"
    public Employee updateEmployee(Integer employeeNumber,Employee employee){
        Employee existEmployee = repository.findById(employeeNumber).orElseThrow(
                ()->new ResourceAccessException(employeeNumber + "does not exist !!!"));

        existEmployee.setLastName(employee.getLastName());
        existEmployee.setFirstName(employee.getFirstName());
        existEmployee.setExtension(employee.getExtension());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setJobTitle(employee.getJobTitle());
        return  repository.saveAndFlush(existEmployee);
        //obj เป็น null ID มัน SET ไม่ได้
        //ทำ เพิ่ม employee คนนี้อยู่ office ไหน
    }

    public Office getEmployeeOffice(Integer employeeNumber){
        Employee exitsEmployee = repository.findById(employeeNumber).orElseThrow(
                ()->new ResourceAccessException(employeeNumber + "does not exist !!!")); ;
        return exitsEmployee.getOffice();
    }

    public Employee getLeaderEmployee(Integer employeeNumber){
        Employee targetEmployee = repository.findById(employeeNumber).orElseThrow(
                ()->new ResourceAccessException(employeeNumber + "does not exist !!!")) ;
        return targetEmployee.getEmployees();

    }



}
