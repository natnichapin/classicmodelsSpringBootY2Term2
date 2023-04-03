package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
}
