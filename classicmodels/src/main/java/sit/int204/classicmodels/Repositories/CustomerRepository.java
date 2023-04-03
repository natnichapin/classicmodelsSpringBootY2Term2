package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.Models.Customer;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.Models.Product;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByCustomerName(String customerName) ;


}
