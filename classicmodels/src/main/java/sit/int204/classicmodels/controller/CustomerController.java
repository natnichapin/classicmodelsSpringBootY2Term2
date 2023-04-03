package sit.int204.classicmodels.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.int204.classicmodels.Models.Customer;
import sit.int204.classicmodels.dtos.PageDto;
import sit.int204.classicmodels.dtos.SimpleCustomerDTO;
//import sit.int204.classicmodels.execeptions.ErrorResponse;
import sit.int204.classicmodels.services.CustomerService;
import sit.int204.classicmodels.utils.ListMapper;


import javax.naming.AuthenticationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService service ;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper ;


    @GetMapping("/{customerId}")
    public SimpleCustomerDTO getSimpleCustomerById(@PathVariable Integer customerId) {
        return modelMapper.map(service.getCustomerById(customerId), SimpleCustomerDTO.class);
    }

    @GetMapping("")
    public List<SimpleCustomerDTO> getCustomers(){
        List<Customer> CustomerList = service.getCustomers();
        //มีแบบที่ไม่ใช้ functional programing ด้วยแต่ต้อง loop เอง
//       return CustomerList.stream().map(c->modelMapper.map(c,SimpleCustomerDTO.class)).collect(Collectors.toList());
    //เขียน mapper ให้ใช้งานร่วมกันได้ทั้ง app เรียกใช้ method ที่เขียนทิ้งเอาไว้แล้ว
        //ใช้ method map list
        return listMapper.mapList(CustomerList,SimpleCustomerDTO.class,modelMapper) ;
    }
    @GetMapping("/pages")
    public PageDto<SimpleCustomerDTO> getCustomersWithPagination(){
        Page<Customer> CustomerList = service.getCustomerWithPagination(0,5) ;
        return listMapper.toPageDTO(CustomerList,SimpleCustomerDTO.class,modelMapper) ;
    }

    @GetMapping ("/Login")
    public SimpleCustomerDTO getCustomersLogin(@RequestParam String username ,@RequestParam  String password) throws Exception {
        Customer customer = service.authenticationTest(username,password);
        return modelMapper.map(customer,SimpleCustomerDTO.class) ;
    }



//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<ErrorResponse> handlerAuthentication(RuntimeException e, WebRequest request){
//        ErrorResponse er = new ErrorResponse
//                 (HttpStatus.UNAUTHORIZED.value(),e.getMessage(),request.getDescription(false).substring(4));
//        er.addValidationError("field1","error1");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(er) ;
//    }




}
