package sit.int204.classicmodels.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.Models.Office;

public interface OfficeRepository extends JpaRepository<Office,String> {
}
