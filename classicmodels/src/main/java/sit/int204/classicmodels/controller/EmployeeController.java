package sit.int204.classicmodels.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.Models.Employee;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.dtos.EmployeeDTO;
import sit.int204.classicmodels.services.EmployeeService;
import sit.int204.classicmodels.utils.ListMapper;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service ;
    @Autowired private ModelMapper modelMapper;
    @Autowired private ListMapper listMapper;

    @PostMapping("/1")
    public Employee create(@RequestBody EmployeeDTO newEmployee) {
        Employee e = modelMapper.map(newEmployee, Employee.class);
        return service.save (e);
    }

    @GetMapping("")
    public List<EmployeeDTO> getEmployee() {
        List<Employee> employees = service.getAllEmployee() ;
        return  listMapper.mapList(employees,EmployeeDTO.class,modelMapper) ;
    }

    @GetMapping("/{employeeNumber}")
    public Employee getEmployee(@PathVariable Integer employeeNumber){
        return  service.getEmployee(employeeNumber);
    }
    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @DeleteMapping("/{employeeNumber}")
    public void delete(@PathVariable int employeeNumber) {
        service.deleteEmployee(employeeNumber);
    }
//เวลาใช้ตัวแปร ควรใช้ Interger ดีกว่า int แต่ จริงๆสมัยนี้ก็มี Auto Boxing แล้ว แต่ Rest มักจะต้องการ Class มากกว่า
    @PutMapping("/{employeeNumber}")
    public Employee updateEmployee(@RequestBody Employee employee ,@PathVariable Integer employeeNumber){
        return  service.updateEmployee(employeeNumber,employee);
    }
    @GetMapping("/{employeeNumber}/office")
    public Office getEmployeeOffice(@PathVariable Integer employeeNumber){
        return  service.getEmployeeOffice(employeeNumber) ;
    }

    @GetMapping("/{employeeNumber}/manager")
    public Employee getEmployeeManager(@PathVariable Integer employeeNumber){
       return   service.getLeaderEmployee(employeeNumber);
    }

//อัพเดท employee ใน office
    //หัวหน้า employee คนนี้คือใคร

}
