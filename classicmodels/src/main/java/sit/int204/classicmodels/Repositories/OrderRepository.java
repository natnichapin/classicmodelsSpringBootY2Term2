package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.Models.Office;
import sit.int204.classicmodels.Models.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
