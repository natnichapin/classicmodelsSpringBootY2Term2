package sit.int204.classicmodels.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodels.Models.Customer;
import sit.int204.classicmodels.Repositories.CustomerRepository;
import sit.int204.classicmodels.dtos.SimpleCustomerDTO;


import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Customer getCustomerById(Integer customerId) {
        return repository.findById(customerId).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Customer id "+ customerId+ "Does Not Exist !!!"));
    }

    public List<Customer> getCustomers(){
       return repository.findAll();

    }
    public Page<Customer> getCustomerWithPagination(int page, int size){
        return repository.findAll(PageRequest.of(page,size));
    }

    public Customer authenticationTest(String username ,String password)  {
        Customer customer = repository.findByCustomerName(username) ;
        try{
            if(customer==null){
                throw new AuthenticationException() ;
            }
            BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),customer.getPassword());
            if(!result.verified){
                throw  new AuthenticationException() ;
            }
        return customer ;
        }
     catch (AuthenticationException e) {  //จับจากตรงที่ try
            //ทำแบบนี้แปลว่า โยนError ตั้งแต่ตรงนี้
            //เกิดข้อผิดพลาดเพราะพยายามโยน Error อื่นที่ มี AuthenticationException  เป็น เหตุ
         //ถ้าโยน Authen มันไม่ได้อยู่ใน Runtime
           throw new RuntimeException("Login failed , Please try again ",e);
        }
    }


    }
